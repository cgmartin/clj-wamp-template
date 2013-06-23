(ns {{sanitized-ns}}.websocket
  (:require [clojure.tools.logging :as log]
            [org.httpkit.server :as http-kit]
            [clj-wamp.server :as wamp]))

;; Topic BaseUrls
(def base-url "http://{{sanitized-ns}}")
(def rpc-base-url (str base-url "/rpc#"))
(def evt-base-url (str base-url "/event#"))

(defn rpc-url [path] (str rpc-base-url path))
(defn evt-url [path] (str evt-base-url path))

;; HTTP Kit/WAMP WebSocket handler

(defn- on-open [sess-id]
  (log/info "WAMP client connected [" sess-id "]"))

(defn- on-close [sess-id status]
  (log/info "WAMP client disconnected [" sess-id "] " status))

(defn- on-publish [sess-id topic event exclude include]
  (log/info "WAMP publish:" sess-id topic event exclude include))

(defn- on-before-call [sess-id topic call-id call-params]
  (log/info "WAMP call:" sess-id topic call-id call-params))

(defn wamp-handler
  "Returns a http-kit websocket handler with wamp subprotocol"
  [req]
  (http-kit/with-channel req channel
    (if-not (http-kit/websocket? channel)
      (http-kit/close channel)
      (wamp/http-kit-handler channel
        {:on-open        on-open
         :on-close       on-close
         :on-call        {(rpc-url "echo")  identity
                          (rpc-url "throw") (fn [] (throw (Exception. "An exception")))
                          :on-before        on-before-call}
         :on-subscribe   {(evt-url "chat")  true}
         :on-publish     {(evt-url "chat")  true
                          :on-after         on-publish}}))))


