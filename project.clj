(defproject prismatic/schema "1.0.5-SNAPSHOT"
  :description "Clojure(Script) library for declarative data description and validation"
  :url "http://github.com/plumatic/schema"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :profiles {:dev {:dependencies [[org.clojure/clojure "1.7.0"]
                                  [org.clojure/test.check "0.9.0"]
                                  [potemkin "0.4.1"]]
                   :plugins [[codox "0.8.8"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0-RC1"]]}}

  :aliases {"all" ["with-profile" "dev:dev,1.8"]
            "deploy" ["do" "clean," "deploy" "clojars"]
            "test" ["do" "clean," "test"]}

  :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]

  :lein-release {:deploy-via :shell
                 :shell ["lein" "deploy"]}

  :auto-clean false

  :codox {;; :src-uri-mapping {#"target/generated/src/clj" #(str "src/cljx/" % "x")}
          :src-dir-uri "http://github.com/plumatic/schema/blob/master/"
          :src-linenum-anchor-prefix "L"}

  :signing {:gpg-key "66E0BF75"})
