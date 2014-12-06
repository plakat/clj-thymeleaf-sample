(ns clj-thymeleaf-sample.views.layout
  (:require [hiccup.page :refer [html5 include-css]]))

(defn common [& body]
  (html5
    [:head
     [:title "Welcome to clj-thymeleaf-sample"]
     (include-css "/css/screen.css")]
    [:body body]))
