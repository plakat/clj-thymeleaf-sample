(ns clj-thymeleaf-sample.routes.home
  (:require [compojure.core :refer :all]
            [clj-thymeleaf-sample.views.layout :as layout]
            [clj-thymeleaf.thymeleaf :as thymeleaf]))

(defn home [params]
  (let [resultmap {:greeting "Hello" :subject "World"}]
    {
      :status 200
      :headers {"Content-Type" "text/html;charset=utf-8"}
      :viewname "helloworld"
      ;; the value of key :data is provided as a data map to the template:
      :data (assoc params
              :result resultmap)
      }
    )
  )

(defroutes home-routes
  (GET "/" [:as {params :params}] (home params)))
