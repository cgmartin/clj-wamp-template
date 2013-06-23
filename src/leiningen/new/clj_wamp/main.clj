(ns {{sanitized-ns}}.main
  (:gen-class)
  (:use [clojure.tools.logging :only [info]]
       [clojure.tools.cli :only [cli]]
       [org.httpkit.server :only [run-server]]
       [ring.middleware.reload :only [wrap-reload]]
       [{{sanitized-ns}}.routes :only [app]]))

(defn- to-int [s] (Integer/parseInt s))

(defonce server (atom nil))

(defn start-server [port thread]
  ;; stop it if started, for run -main multi-times in repl
  (when-not (nil? @server) (@server))
  ;; other init staff, like init-db, init-redis, ...
  (reset! server
    (run-server (wrap-reload (app)) {:port   port              ; FIXME optional reload
                                     :thread thread})))

(defn -main [& args]
  (let [[options _ banner]
          (cli args
            ["-p" "--port" "Port to listen"           :default 8080 :parse-fn to-int]
            ["--thread"    "Http worker thread count" :default 4    :parse-fn to-int]
            ["--[no-]help" "Print this help"])]
    (when (:help options) (println banner) (System/exit 0))
        ;; config can be accessed by (cfg :key)
        (start-server (:port options) (:thread options))
        (info (str "server started. listen on 0.0.0.0@" (:port options)))))