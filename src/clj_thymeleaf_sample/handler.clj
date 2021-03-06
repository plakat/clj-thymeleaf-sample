(ns clj-thymeleaf-sample.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clj-thymeleaf-sample.routes.home :refer [home-routes]]
            [clj-thymeleaf.thymeleaf-wrapper :as thymeleaf-wrapper]
            [clj-thymeleaf.thymeleaf :as thymeleaf]))


;; By this map parameters can be passed to the thymeleaf templating engine.
;; Currently init-template-engine ignores this.
(def thymeleaf-params {})

(defn init []
  (println "clj-thymeleaf-sample is starting")
  (println "initializing template engine")
  ;; initialize templating engine:
  (thymeleaf/init-template-engine thymeleaf-params)
  )

(defn destroy []
  (println "clj-thymeleaf-sample is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes home-routes app-routes)
    (handler/site)
    (wrap-base-url)
    ;; send responses through the thymeleaf wrapper:
    (thymeleaf-wrapper/wrap)))
