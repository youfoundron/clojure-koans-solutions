(ns koans.18-datatypes
  (:require [koan-engine.core :refer :all]))

(defrecord Nobel [prize])
(deftype Pulitzer [prize])

(defprotocol Award
  (present [this recipient]))

(defrecord Oscar [category]
  Award
  (present [this recipient]
    (print (str "Congratulations on your "
                (:category this) " Oscar, "
                recipient
                "!"))))

; (deftype Razzie [category]
;   Award
;   (present [this recipient]
;     __))
(deftype Razzie [category]
  Award
  (present [this recipient]
    (print (str "You're really the "
                category ", "
                recipient
                "... sorry."))))

(meditations
  "Holding records is meaningful only when the record is worthy of you"
  ; (= __ (.prize (Nobel. "peace")))
  (= "peace" (.prize (Nobel. "peace")))

  "Types are quite similar"
  ; (= __ (.prize (Pulitzer. "literature")))
  (= "literature" (.prize (Pulitzer. "literature")))

  "Records may be treated like maps"
  ; (= __ (:prize (Nobel. "physics")))
  (= "physics" (:prize (Nobel. "physics")))

  "While types may not"
  ; (= __ (:prize (Pulitzer. "poetry")))
  (= nil (:prize (Pulitzer. "poetry")))

  "Further study reveals why"
  ; (= __
  ;    (map map? [(Nobel. "chemistry")
  ;               (Pulitzer. "music")]))
  (= [true false]
    (map map? [(Nobel. "chemistry")
               (Pulitzer. "music")]))

  "Either sort of datatype can define methods in a protocol"
  ; (= __
  ;    (with-out-str (present (Oscar. "Best Picture") "Evil Alien Conquerors")))
  (= "Congratulations on your Best Picture Oscar, Evil Alien Conquerors!"
     (with-out-str (present (Oscar. "Best Picture") "Evil Alien Conquerors")))

  "Surely we can implement our own by now"
  ; (= "You're really the Worst Picture, Final Destination 5... sorry."
  ;    (with-out-str (present (Razzie. "Worst Picture") "Final Destination 5"))))
  (= "You're really the Worst Picture, Final Destination 5... sorry."
     (with-out-str (present (Razzie. "Worst Picture") "Final Destination 5"))))
