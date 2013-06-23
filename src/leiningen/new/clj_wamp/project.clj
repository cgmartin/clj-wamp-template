(defproject {{sanitized-ns}} "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :main {{sanitized-ns}}.main
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/tools.cli "0.2.2"]
                 [org.clojure/tools.logging "0.2.6"]
                 [compojure "1.1.5"]
                 [ring-server "0.2.8"]
                 [http-kit "2.1.2"]
                 [clj-wamp "1.0.0-beta1"]]
  :profiles {:dev {:resource-paths ["resources-dev"]}})