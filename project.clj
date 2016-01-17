(defproject prismatic/schema "1.0.5-SNAPSHOT"
  :description "Clojure(Script) library for declarative data description and validation"
  :url "http://github.com/plumatic/schema"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :profiles {:dev {:dependencies [[org.clojure/clojure "1.7.0"]
                                  [org.clojure/clojurescript "0.0-2760"]
                                  [org.clojure/tools.nrepl "0.2.5"]
                                  [org.clojure/test.check "0.9.0"]
                                  [potemkin "0.4.1"]]
                   :plugins [[codox "0.8.8"]
                             [lein-cljsbuild "1.0.5"]
                             [com.cemerick/clojurescript.test "0.3.1"]]}
             :1.8 {:dependencies [[org.clojure/clojure "1.8.0-RC1"] [org.clojure/clojurescript "0.0-3308"]]}}

  :aliases {"all" ["with-profile" "dev:dev,1.8"]
            "deploy" ["do" "clean," "deploy" "clojars"]
            "test" ["do" "clean," "test," "with-profile" "dev" "cljsbuild" "test"]}

  :jar-exclusions [#"\.cljx|\.swp|\.swo|\.DS_Store"]

  :lein-release {:deploy-via :shell
                 :shell ["lein" "deploy"]}

  :auto-clean false

  :cljsbuild {:test-commands {"unit" ["phantomjs" :runner
                                      "this.literal_js_was_evaluated=true"
                                      "target/unit-test.js"]
                              "unit-no-assert" ["phantomjs" :runner
                                                "this.literal_js_was_evaluated=true"
                                                "target/unit-test-no-assert.js"]}
              :builds
              {:dev {:source-paths ["src"]
                     :compiler {:output-to "target/main.js"
                                :optimizations :whitespace
                                :pretty-print true}}
               :test {:source-paths ["src" "test"]
                      :compiler {:output-to "target/unit-test.js"
                                 :optimizations :whitespace
                                 :pretty-print true}}
               :test-no-assert {:source-paths ["src" "test"]
                                :assert false
                                :compiler {:output-to "target/unit-test-no-assert.js"
                                           :optimizations :whitespace
                                           :pretty-print true}}}}

  :codox {;; :src-uri-mapping {#"target/generated/src/clj" #(str "src/cljx/" % "x")}
          :src-dir-uri "http://github.com/plumatic/schema/blob/master/"
          :src-linenum-anchor-prefix "L"}

  :signing {:gpg-key "66E0BF75"})
