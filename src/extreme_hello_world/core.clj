(ns extreme-hello-world.core
  (:require [ring.adapter.jetty :as jetty])
  (:gen-class))

(defn -main
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))
