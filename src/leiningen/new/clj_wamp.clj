(ns leiningen.new.clj-wamp
  (:use [leiningen.new.templates :only [renderer name-to-path ->files sanitize-ns year]])
  (:require [clojure.java.io :as io]
            [clojure.string :as str]))

(def render (renderer "clj-wamp"))

(defn binary [file]
  (io/input-stream (io/resource(str/join "/" ["leiningen" "new" "clj_wamp" file]))))

(defn clj-wamp
  "FIXME: write documentation"
  [name]
  (let [fs-path        (name-to-path name)
        sanitized-name (sanitize-ns name)
        data {:name         name
              :year         (year)
              :fs-path      fs-path
              :sanitized-ns sanitized-name}]
    (->files data
      ["README.md"                       (render "README.md" data)]
      ["project.clj"                     (render "project.clj" data)]
      ["src/{{fs-path}}/websocket.clj"   (render "websocket.clj" data)]
      ["src/{{fs-path}}/routes.clj"      (render "routes.clj" data)]
      ["src/{{fs-path}}/main.clj"        (render "main.clj" data)]
      ["src/{{fs-path}}/config.clj"      (render "config.clj" data)]
      ["resources/public/index.html"     (render "public/index.html" data)]
      ["resources-dev/config.clj"        (binary "resources_dev/config.clj")]
      ["resources-dev/log4j.properties"  (binary "resources_dev/log4j.properties")])
    (println "Created new clj-wamp project:" sanitized-name)))
