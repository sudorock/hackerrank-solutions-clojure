;; start solution ;;

(defn miniMaxSum [arr]
  (println 
    (- (reduce + arr) (apply max arr)) 
    (- (reduce + arr) (apply min arr))))

;; end solution ;;

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(miniMaxSum arr)
