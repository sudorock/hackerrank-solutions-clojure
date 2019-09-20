;; start solution ;;

(defn staircase [n]
  (loop [num 1]
    (cond 
     (= 0 (compare num n)) (print (clojure.string/join "" (repeat num "#")))
     :else (do 
            (println 
             (clojure.string/join "" (concat (repeat (- n num) " ") (repeat num "#"))))
            (recur (inc num))))))

;; end solution ;;

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(staircase n)

