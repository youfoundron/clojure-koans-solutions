(ns koans.09-runtime-polymorphism
  (:require [koan-engine.core :refer :all]))

(defn hello
  ([] "Hello World!")
  ([a] (str "Hello, you silly " a "."))
  ([a & more] (str "Hello to this group: "
                   (apply str
                          (interpose ", " (concat (list a) more)))
                   "!")))

(defmulti diet (fn [x] (:eater x)))
; (defmethod diet :herbivore [a] __)
; (defmethod diet :carnivore [a] __)
; (defmethod diet :default [a] __)
(defmethod diet :herbivore [a] (str (a :name ) " eats veggies."))
(defmethod diet :carnivore [a] (str (a :name) " eats animals."))
(defmethod diet :default [a] (str "I don't know what " (a :name) " eats."))


(meditations
  "Some functions can be used in different ways - with no arguments"
  ; (= __ (hello))
  (= "Hello World!" (hello))

  "With one argument"
  ; (= __ (hello "world"))
  (= "Hello, you silly world." (hello "world"))

  "Or with many arguments"
  ; (= __
  ;    (hello "Peter" "Paul" "Mary"))
  (= "Hello to this group: Peter, Paul, Mary!"
    (hello "Peter" "Paul" "Mary"))

  "Multimethods allow more complex dispatching"
  (= "Bambi eats veggies."
     (diet {:species "deer" :name "Bambi" :age 1 :eater :herbivore}))

  "Animals have different names"
  (= "Thumper eats veggies."
    (diet {:species "rabbit" :name "Thumper" :age 1 :eater :herbivore}))

  "Different methods are used depending on the dispatch function result"
  (= "Simba eats animals."
     (diet {:species "lion" :name "Simba" :age 1 :eater :carnivore}))

  "You may use a default method when no others match"
  (= "I don't know what Rich Hickey eats."
     (diet {:name "Rich Hickey"})))
