(ns my-stack)

(defprotocol ImplementStack
             (push [this item])
             (pop-off [this])
             (is-empty? [this])
             )

(defrecord Stack [elements]
           ImplementStack
           (push [this item]
                 (swap! elements conj item))
           (pop-off [this]
                    (swap! elements pop))
           (is-empty? [this]
                      (= 0 (count this)))
           )

(def stack (Stack. (atom [])))

(println (.push stack 1))
(println (.push stack 5))
(println (.push stack 2))
(println (.push stack 17))
(println (.is-empty? stack))
(println (.pop-off stack))












