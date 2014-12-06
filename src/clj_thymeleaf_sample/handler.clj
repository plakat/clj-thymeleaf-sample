(ns clj-thymeleaf-sample.handler
  (:require [compojure.core :refer [defroutes routes]]
            [ring.middleware.resource :refer [wrap-resource]]
            [ring.middleware.file-info :refer [wrap-file-info]]
            [hiccup.middleware :refer [wrap-base-url]]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [clj-thymeleaf-sample.routes.home :refer [home-routes]]))

(defn init []
  (println "clj-thymeleaf-sample is starting"))

(defn destroy []
  (println "clj-thymeleaf-sample is shutting down"))

(defroutes app-routes
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (routes home-routes app-routes)
      (handler/site)
      (wrap-base-url)))
