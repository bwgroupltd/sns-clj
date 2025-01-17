(defproject audiogum/sns-clj "0.2.1-SNAPSHOT"
  :description "sns fake for clojure forked from https://github.com/Bigsy/sns-clj"
  :url "https://github.com/bwgroupltd/sns-clj"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [integrant "0.8.0"]
                 [org.clojure/tools.logging "1.1.0"]
                 [org.clojure/tools.namespace "1.1.0"]
                 [org.slf4j/slf4j-jdk14 "1.7.30"]
                 [http-kit "2.5.3"]]

  :profiles {:dev {:dependencies [[com.cognitect.aws/api "0.8.630"]
                                  [com.cognitect.aws/endpoints "1.1.12.358"]
                                  [com.cognitect.aws/sns "825.2.1268.0"]
                                  [com.cognitect.aws/sqs "822.2.1109.0"]
                                  [audiogum/elasticmq-clj "0.2.0"]
                                  [cheshire "5.11.0"]]}}

  :release-tasks [["vcs" "assert-committed"]
                  ["change" "version" "leiningen.release/bump-version" "release"]
                  ["vcs" "commit"]
                  ["vcs" "tag" "--no-sign"]
                  ["deploy" "releases"]
                  ["change" "version" "leiningen.release/bump-version" "patch"]
                  ["vcs" "commit"]
                  ["vcs" "push" "origin" "main"]]

  :plugins [[s3-wagon-private "1.3.4"]]

  :repositories {"releases" {:url           "s3p://repo.bowerswilkins.net/releases/"
                             :no-auth       true
                             :sign-releases false}})
