(ns koans.19-java-interop
  (:require [koan-engine.core :refer :all]))

(meditations
  "You may have done more with Java than you know"
  ; (= __ (class "warfare")) ; hint: try typing (javadoc "warfare") in the REPL
  (= String (class "warfare")) ; hint: try typing (javadoc "warfare") in the REPL

  "The dot signifies easy and direct Java interoperation"
  ; (= __ (.toUpperCase "select * from"))
  (= "SELECT * FROM" (.toUpperCase "select * from"))

  "But instance method calls are very different from normal functions"
  ; (= ["SELECT" "FROM" "WHERE"] (map ___ ["select" "from" "where"]))
  (= ["SELECT" "FROM" "WHERE"] (map #(.toUpperCase %) ["select" "from" "where"]))

  "Constructing might be harder than breaking"
  ; (= 10 (let [latch (java.util.concurrent.CountDownLatch. __)]
  ;         (.getCount latch)))
  (= 10 (let [latch (java.util.concurrent.CountDownLatch. __)]
    (.getCount latch)))

  "Static methods are slashing prices!"
  ; (== __ (Math/pow 2 10)))
  (== 1024 (Math/pow 2 10)))
