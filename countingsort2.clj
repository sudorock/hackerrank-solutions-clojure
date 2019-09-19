;; start solution ;;

(defn print-list [countArr]
    (loop [[fst & rst] countArr n 0 result []]
        (cond 
            (nil? fst) result
            (zero? fst) (recur rst (inc n) result)
            :else (recur rst (inc n) (into result (repeat fst n))))))

(defn countingSort [arr]
    (loop [[fst & rst] arr
            countArr (vec (repeat (inc (apply max arr)) 0))]
            (if (nil? fst) 
                (print-list countArr)
                (recur rst (assoc countArr fst (inc (countArr fst)))))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (countingSort arr))

(spit fptr (clojure.string/join " " result) :append true)
(spit fptr "\n" :append true)
