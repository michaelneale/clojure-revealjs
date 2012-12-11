(ns mywebapp.routes
  (:use compojure.core
        mywebapp.slides)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]))


(defroutes app-routes
  (GET "/" [] (slides-page))
  (GET "/wee1" [] (str "Property: " (System/getProperty "foo1")))
  (GET "/wee2" [] (str "Property: " (System/getProperty "foo2")))
  (route/resources "/")
  (route/not-found "No page"))


(def app
  (handler/site app-routes))
