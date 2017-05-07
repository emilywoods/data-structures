(ns my-stack)

(defprotocol ImplementStack
             (push [this item])
             (pop-off [this])
             (is-empty? [this])
             (top [this])
             )

(defrecord Stack [elements]
           ImplementStack
           (push [_ item]
                 (swap! elements conj item))
           (pop-off [_]
                    (swap! elements rest) )

           (is-empty? [_]
                      (= 0 (count @elements)))
           (top [_]
                (last @elements))
           )

(def stack (Stack. (atom ())))

(println (.is-empty? stack))
(println (.push stack 1))
(println (.push stack 5))
(println (.push stack 2))
(println (.push stack 17))
(println (.is-empty? stack))
(println (.pop-off stack))
(println (.top stack))
(println stack)












