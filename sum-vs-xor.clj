;; start solution ;;

(defn sumXor [n]
  (if (zero? n) 
    1
    (loop [zeros 0 curr n]
      (println zeros curr)
      (cond
        (< curr 1) (biginteger (Math/pow 2 zeros)) 
        (zero? (mod curr 2)) (recur (inc zeros) (quot curr 2))
        :else (recur zeros (quot curr 2))))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Long/parseLong (clojure.string/trim (read-line))))

(def result (sumXor n))

(spit fptr (str result "\n") :append true) 
