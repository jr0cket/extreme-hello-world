(ns extreme-hello-world.core
  (:require [ring.adapter.jetty :as jetty]
            [ring.middleware.reload :refer [wrap-reload]]
            [ring.middleware.params :refer [wrap-params]])
  (:gen-class))

(defn hello-world [request]
  (prn request)
  (if (= :get (request :request-method))
    {:status 200 :body "<form method='post' action='/'><input name='name'></input><input type='submit'></input>"}
    {:status 200
     :body (-> request
               :params ,,,
               (get ,,, "name")
               (str ,,, " welcome to our hello work experience"))
     :headers []}))


;; (str "Hello.. " (get (get request :params) "name"))

;; (def littlemap {:name john
;;                 :age 21
;;                 :address {:street "erickson" :postcode "BR2"}})

;; (littlemap :name) ;;=>john
;; (:name littlemap)
;; (:postcode (:address littlemap))

;; (get map key)
;; (get-in map [key key])



(defn -main
  "I don't do a whole lot."
  [port]
  (jetty/run-jetty (-> #'hello-world
                       wrap-params
                       wrap-reload)
                   {:port (Integer. port)}))


;; {key value}
;; {"key" "value"} ;; from the URL
;; {:keyword "value"} ;; common approach in Clojure
;; {:keyword {:key "value"}}
