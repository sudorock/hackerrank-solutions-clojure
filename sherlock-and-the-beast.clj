;; start solution ;;

(defn three-five [n]
      (if (zero? (mod n 3))
        (vector (quot n 3) 0)
        (loop [x (int (/ n 3))]
          (cond
            (< x 0) (vector 0 0)
            (zero? (mod (- n (* 3 x)) 5)) (vector x (quot (- n (* 3 x)) 5))
            :else (recur (dec x))))))

(defn decentNumber [n]
      (let [[fives threes] (three-five n)]
        (if (and (zero? threes) (zero? fives))
          (vector -1)
          (concat (repeat (* 3 fives) 5) (repeat (* 5 threes) 3)))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def t (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [t-itr (range t)]
  (def n (Integer/parseInt (clojure.string/trim (read-line))))

  (def result (decentNumber n))
  (println (clojure.string/join "" result))
  )

; 3x + 5y = num
; x <= num / 3
; y <= num / 5
; maximize x
; start with x = num/3 then dec until

