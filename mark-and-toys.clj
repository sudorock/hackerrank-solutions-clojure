;; start solution ;;

(defn maximumToys [prices k]
    (loop [[fst & rst] (sort prices) sum 0 counter 0]
        (cond 
            (nil? fst) counter
            (> (+ sum fst) k) counter
            (= (+ sum fst) k) (inc counter)
            :else (recur rst (+ sum fst) (inc counter)))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def nk (clojure.string/split (read-line) #" "))

(def n (Integer/parseInt (clojure.string/trim (nth nk 0))))

(def k (Integer/parseInt (clojure.string/trim (nth nk 1))))

(def prices (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (maximumToys prices k))

(spit fptr (str result "\n") :append true)


; sort array
; start loop with counter 1 sum 0 fst & rst arr
; if fst is nil return counter
; if sum + fst >= budget return counter
; else (inc counter) (sum + fst) (rst)
