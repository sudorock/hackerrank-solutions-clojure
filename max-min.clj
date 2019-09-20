;; start solution ;;

(defn maxMin [k arr]
  (let [sorted (vec (sort arr) )size (count arr)]
    (loop [subStart 0 subEnd (dec k) minVal ##Inf]
      (if (> subEnd (dec size)) 
          minVal
          (recur (inc subStart) 
                 (inc subEnd) 
                 (min minVal (- (sorted subEnd) (sorted subStart))))))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def k (Integer/parseInt (clojure.string/trim (read-line))))

(def arr [])

(doseq [_ (range n)]
    (def arr (conj arr (Integer/parseInt (read-line))))
)

(def result (maxMin k arr))

(spit fptr (str result "\n") :append true)
