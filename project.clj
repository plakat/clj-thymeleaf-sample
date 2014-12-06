(defproject clj-thymeleaf-sample "0.1.0-SNAPSHOT"
  :description "Sample code for clj-thymeleaf"
  :url "https://github.com/plakat/clj-thymeleaf-sample"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [clj-thymeleaf "0.1.0-SNAPSHOT"]]
  :scm {:name "git"
        :url "https://github.com/plakat/clj-thymeleaf-sample"}
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler clj-thymeleaf-sample.handler/app
         :init clj-thymeleaf-sample.handler/init
         :destroy clj-thymeleaf-sample.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})
