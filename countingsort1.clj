
;; start solution ;;

(defn countingSort [arr]
    (loop [[fst & rst] arr
            countArr (vec (repeat 100 0))]
            (if (nil? fst) 
                countArr
                (recur rst (assoc countArr fst (inc (countArr fst)))))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (countingSort arr))

(spit fptr (clojure.string/join " " result) :append true)
(spit fptr "\n" :append true)
