;; start solution ;;
(defn get-serve-time [orders]
    (map #(+ (get % 0) (get % 1)) orders))

(defn jimOrders [orders]
    (map #(get % 1) (sort-by first (map vector (get-serve-time orders) (range 1 (inc (count orders)))))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def orders [])

(doseq [_ (range n)]
    (def orders (conj orders (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" ")))))
)

(def result (jimOrders orders))

(spit fptr (clojure.string/join " " result) :append true)
(spit fptr "\n" :append true)


