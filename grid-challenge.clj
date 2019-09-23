;; start solution ;;

(defn gridChallenge [grid]
  (let [rowSorted (mapv #(vec (sort %)) grid) n (count (get grid 0))]
    (loop [index 0]
      (if (>= index n) 
        "YES"
        (let [column (map #(int (get % index)) rowSorted)]
          (if (not (apply <= column)) 
              "NO"
              (recur (inc index))))))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def t (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [t-itr (range t)]
    (def n (Integer/parseInt (clojure.string/trim (read-line))))

    (def grid [])

    (doseq [_ (range n)]
        (def grid (conj grid (read-line)))
    )

    (def result (gridChallenge grid))

    (spit fptr (str result "\n") :append true)
)

; sort all rows
; check sorted 
