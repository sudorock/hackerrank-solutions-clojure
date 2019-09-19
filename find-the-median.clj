;; start solution ;;

(defn findMedian [arr]
    (get (vec (sort arr)) (int (/ (count arr) 2))))
    
;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (findMedian arr))

(spit fptr (str result "\n") :append true)
