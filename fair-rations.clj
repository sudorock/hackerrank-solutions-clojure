;; start solution ;;

(defn fairRations [B]
  (if (odd? (count (filter odd? B)))
      "NO"
      (loop [[fst & rst] B lastOddIndex nil index 0 loaves 0]
        (cond 
          (nil? fst) loaves
          (and (odd? fst) (nil? lastOddIndex)) 
            (recur rst index (inc index) loaves)
          (and (odd? fst) (some? lastOddIndex)) 
            (recur rst nil (inc index) (+ loaves (* 2 (- index lastOddIndex))))
          :else (recur rst lastOddIndex (inc index) loaves)))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def N (Integer/parseInt (clojure.string/trim (read-line))))

(def B (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (fairRations B))

(spit fptr (str result "\n") :append true)

; if number of odds is odd then no
; loop: last odd el index, 
;  if last odd is nil then add odd
; if last odd then odd index -
