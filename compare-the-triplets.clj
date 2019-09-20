;; start solution ;;

(defn compareAandB [a b] 
    (cond
        (> a b) {:a 1 :b 0}
        (> b a) {:a 0 :b 1}
        :else {:a 0 :b 0}))

(defn sumAandB [init-vector {a :a b :b}] 
    (vector (+ (first init-vector) a) (+ (second init-vector) b)))


(defn compareTriplets [a b] 
    (reduce sumAandB [0 0] (map compareAandB a b)))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def a (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def b (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def result (compareTriplets a b))

(spit fptr (clojure.string/join " " result) :append true)
(spit fptr "\n" :append true)
