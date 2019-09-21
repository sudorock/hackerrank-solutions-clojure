;; start solution ;;

(defn twoStrings [s1 s2]
  (if (some #(contains? (set s1) %) (set s2))
      "YES"
      "NO"))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def q (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [q-itr (range q)]
    (def s1 (read-line))

    (def s2 (read-line))

    (def result (twoStrings s1 s2))

    (spit fptr (str result "\n") :append true)
)
