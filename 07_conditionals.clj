(ns koans.07-conditionals
  (:require [koan-engine.core :refer :all]))

(defn explain-defcon-level [exercise-term]
  (case exercise-term
        :fade-out          :you-and-what-army
        :double-take       :call-me-when-its-important
        :round-house       :o-rly
        :fast-pace         :thats-pretty-bad
        :cocked-pistol     :sirens
        :say-what?))

(meditations
  "You will face many decisions"
  ; (= __ (if (false? (= 4 5))
  ;         :a
  ;         :b))
  (= :a (if (false? (= 4 5))
          :a
          :b))

  "Some of them leave you no alternative"
  ; (= __ (if (> 4 3)
  ;         []))
  (= [] (if (> 4 3)
          []))

  "And in such a situation you may have nothing"
  ; (= __ (if (nil? 0)
  ;         [:a :b :c]))
  (= nil (if (nil? 0)
          [:a :b :c]))


  "In others your alternative may be interesting"
  ; (= :glory (if (not (empty? ()))
  ;             :doom
  ;             __))
  (= :glory (if (not (empty? ()))
              :doom
              :glory))

  "You may have a multitude of possible paths"
  ; (let [x 5]
  ;   (= :your-road (cond (= x __) :road-not-taken
  ;                       (= x __) :another-road-not-taken
  ;                       :else __)))
  (let [x 5]
    (= :your-road (cond (= x 3) :road-not-taken
                        (= x 4) :another-road-not-taken
                        :else :your-road)))

  "Or your fate may be sealed"
  ; (= 'doom (if-not (zero? __)
  ;         'doom
  ;         'more-doom))
  (= 'doom (if-not (zero? 1)
          'doom
          'more-doom))

  "In case of emergency, sound the alarms"
  ; (= :sirens
  ;    (explain-defcon-level __))
  (= :sirens
    (explain-defcon-level :cocked-pistol))

  "But admit it when you don't know what to do"
  ; (= __
  ;    (explain-defcon-level :yo-mama)))
  (= :say-what?
    (explain-defcon-level :yo-mama)))
