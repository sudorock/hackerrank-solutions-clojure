
;; start solution ;;

(defn stringConstruction [s]
  (count (set s)))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def q (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [q-itr (range q)]
    (def s (read-line))

    (def result (stringConstruction s))

    (spit fptr (str result "\n") :append true)
) 
