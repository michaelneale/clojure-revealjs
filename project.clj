(defproject mywebapp "0.1.0-SNAPSHOT"
  :description "Clojure at OSDC"
  :url "http://www.osdc.com.au"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [compojure "1.1.1"]
                 [hiccup "1.0.1"]]


  ;; Your app id here ! account/appname
  :cloudbees-app-id "playground/osdcclojure"

  :plugins [[lein-ring "0.7.3"]
            [lein-cloudbees "1.0.3"]]
  :ring {:handler mywebapp.routes/app}
  :profiles
  {:dev {:dependencies [[ring-mock "0.1.3"]]}})
