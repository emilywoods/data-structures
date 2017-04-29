(ns queue )

(defprotocol ImplementQueue
             (enqueue [this item])
             (dequeue [this])
             (is-empty? [this])
             (top [this])
             )

(defrecord Queue [elements]
           ImplementQueue
           (enqueue
             [_ item]
             (swap! elements conj item))
           (dequeue
             [_]
             (swap! elements drop-last))
           (is-empty?
             [_]
             (= 0 (count @elements)))
           (top
             [_]
             (first @elements)))

(def queue (Queue. (atom '())))


(println(.is-empty? queue))
(println(.enqueue queue 5))
(println(.enqueue queue 1))
(println(.enqueue queue 6))
(println(.enqueue queue 9))
(println(.is-empty? queue))
(println(.dequeue queue))
(println queue)
(println(.top queue))





