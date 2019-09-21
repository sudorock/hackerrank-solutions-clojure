;; start solution ;;

(def grid)

(defn get-all-cavity-coords [n]
  (for [x (range 1 (dec n)) y (range 1 (dec n))] [x y]))

(defn cavity? [grid r c]
  (let [el (- (int (aget grid r c)) 48)]
     (cond
      (<= el (- (int (aget grid (inc r) c)) 48)) false
      (<= el (- (int (aget grid (dec r) c)) 48)) false
      (<= el (- (int (aget grid r (inc c))) 48)) false
      (<= el (- (int (aget grid r (dec c))) 48)) false
      :else true)))

(defn mark-cavity [grid [x y]]
  (cond 
    (cavity? grid x y) (do (aset grid x y \X) grid)
    :else grid))

(defn cavityMap [grid n]
  (reduce mark-cavity grid (get-all-cavity-coords n)))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def grid [])

(doseq [_ (range n)]
    (def grid (conj grid (read-line)))
)

(def result (cavityMap (to-array-2d grid) n))
(spit fptr (clojure.string/join "\n" (map #(apply str %) result)) :append true)
(spit fptr "\n" :append true)
