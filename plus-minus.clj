;; start solution ;;

(defn checkSign [el]
    (cond 
        (> el 0) [1 0 0]
        (< el 0) [0 1 0]
        :else [0 0 1]))

(defn addSign [init el]
    (vec (map + init (checkSign el))))

(defn plusMinus [arr]
    (println 
        (clojure.string/join "\n"
            (map #(float (/ % (count arr))) 
                (reduce addSign [0 0 0] arr)))))

;; start solution ;;

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(plusMinus arr)
