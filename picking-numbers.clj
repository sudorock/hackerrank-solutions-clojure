;; start solution ;;

(defn pickingNumbers [a]
    (loop [[fst & rst] (into (sorted-map) (frequencies a)) maxLen 0]
        (cond 
            (empty? rst) (max (get fst 1) maxLen)
            (<= (- (get (first rst) 0) (get fst 0)) 1) 
                (recur rst (max (+ (get fst 1) (get (first rst) 1)) maxLen))
            (> (get fst 1) maxLen) (recur rst (get fst 1))
            :else (recur rst maxLen))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def a (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

(def result (pickingNumbers a))

(spit fptr (str result "\n") :append true)

; make freq from arr
; sorted map of freq
; if snd - fst <= 1 (max sum of keys, prevMax)
; else (recur rst prevMax)


