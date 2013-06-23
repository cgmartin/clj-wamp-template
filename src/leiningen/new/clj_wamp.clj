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
  (let [data {:name         name
              :year         (year)
              :fs-path      (name-to-path name)
              :sanitized-ns (sanitize-ns name)}]
    (->files data
      ["README.md"                       (render "README.md" data)]
      ["project.clj"                     (render "project.clj" data)]
      ["src/{{sanitized-ns}}/websocket.clj" (render "websocket.clj" data)]
      ["src/{{sanitized-ns}}/routes.clj"    (render "routes.clj" data)]
      ["src/{{sanitized-ns}}/main.clj"      (render "main.clj" data)]
      ["src/{{sanitized-ns}}/config.clj"    (render "config.clj" data)]
      ["resources/public/index.html"        (render "public/index.html" data)]
      ["resources-dev/config.clj"           (binary "resources_dev/config.clj")]
      ["resources-dev/log4j.properties"     (binary "resources_dev/log4j.properties")])))
