(ns clj-thymeleaf-sample.routes.home
  (:require [compojure.core :refer :all]
            [clj-thymeleaf-sample.views.layout :as layout]))

(defn home []
  (layout/common [:h1 "Hello World!"]))

(defroutes home-routes
  (GET "/" [] (home)))
