(ns extreme-hello-world.core
  (:require [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn hello-world [request]
  (println request)
  {:status 200
   :body "Hello World extreme !!"
   :headers []})

(defn -main
  "I don't do a whole lot."
  [port]
  (jetty/run-jetty hello-world
                   {:port (Integer. port)}))
