(defproject prismatic/schema "1.0.5-SNAPSHOT"
  :description "Clojure(Script) library for declarative data description and validation"
  :url "http://github.com/plumatic/schema"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :profiles {:dev {:dependencies [[org.clojure/clojure "1.7.0"]
                                  [org.clojure/test.check "0.9.0"]
                                  [org.clojure/tools.logging "0.3.1"]
                                  [org.clojure/tools.namespace "0.2.11"]
                                  [spootnik/unilog "0.7.13"]
                                  [com.taoensso/timbre "4.2.1"]
                                  [potemkin "0.4.1"]]
                   :source-paths ["dev"]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0-RC1"]]}})
