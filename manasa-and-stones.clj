;; start solution ;;

(defn stones [n a b]
    (loop [x 0 y (dec n) lasts #{}]
        (if (> x (dec n))
            (apply sorted-set lasts) 
            (recur (inc x) (dec y) (conj lasts (+ (* a x) (* b y)))))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def T (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [T-itr (range T)]
    (def n (Integer/parseInt (clojure.string/trim (read-line))))

    (def a (Integer/parseInt (clojure.string/trim (read-line))))

    (def b (Integer/parseInt (clojure.string/trim (read-line))))

    (def result (stones n a b))

    (spit fptr (clojure.string/join " " result) :append true)
    (spit fptr "\n" :append true)
)

; ax + by = sum where x + y = n
