;; start solution ;;

(defn weighted [s]
    (vec (map #(- (int %) 96) s)))

(defn uni-weights [s]
    (loop [[fst & rst] s setU #{} lstElem nil cumuW 0]
        (cond
            (nil? fst) setU
            (= fst lstElem) (recur rst (conj setU (+ fst cumuW)) lstElem (+ fst cumuW))
            :else (recur rst (conj setU fst) fst fst))))

(defn weightedUniformStrings [s queries]
    (let [res (uni-weights (weighted s))]
        (map #(if (contains? res %) "Yes" "No") queries)))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def s (read-line))

(def queries-count (Integer/parseInt (clojure.string/trim (read-line))))

(def queries [])

(doseq [_ (range queries-count)]
    (def queries (conj queries (Integer/parseInt (read-line))))
)

(def result (weightedUniformStrings s queries))

(spit fptr (clojure.string/join "\n" result) :append true)
(spit fptr "\n" :append true)


; get all weights of uniform strings
; check if sum contains in the above set

;get all weights by going through string
; add weight of single element to set
; store last elem and last cumulative weight
; check if last elem is same as curr elem
; if yes change last elem to curr elem and add to cumulative weight, add cumulative weight to set
; if curr elem is not equal to last elem, update last elem to curr elem and make cumulative weight as that of curr elem
; when fst is nil return set
