;; start solution ;;

(defn toys [w]
    (loop [[fst & rst] (sort w) maxRng (+ fst 4) cnt 1]
        (cond 
            (nil? fst) cnt
            (<= fst maxRng) (recur rst maxRng cnt)
            :else (recur rst (+ fst 4) (inc cnt)))))
            
;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def w (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (toys w))

(spit fptr (str result "\n") :append true)

; 1 2 14
; sort array 
; get fst and calc range 
; if next is within range go to rest
; else inc cnt and go to rest

; sort 7 8 12 15 19 24
;fst 7 recur with same maxrng and cnt
; fst 8 recur with same
; fst 12 fst > maxrng so recur 15... (16) 2
; fst 15 recur with same max rng and count
; fst 19 fst > max rng so recur with 24... (23) 3
; fst 24 fst > max so recur with () ... (29) 4
