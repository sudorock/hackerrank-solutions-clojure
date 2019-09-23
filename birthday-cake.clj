;; start solution ;;

(defn findNumMax [[num max] el]
  (cond 
   (> el max) [1 el]
   (= el max) [(inc num) max]
   :else [num max]))

;; end solution ;;

(defn birthdayCakeCandles [ar]
  (first (reduce findNumMax [0 0] ar)))

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def ar-count (Integer/parseInt (clojure.string/trim (read-line))))

(def ar (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (birthdayCakeCandles ar))

(spit fptr (str result "\n") :append true)
