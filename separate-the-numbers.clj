;; start solution ;;

(defn count-digits [n]
    (if (zero? n) 1
        (int (inc (Math/log10 n)))))
    
(defn check-rem-string [s el]
    (let [n (biginteger el) remSize (count s)]
        (loop [buildRem [] cumuCount 0 curr (inc n)]
            (let [newCnt (+ cumuCount (count-digits curr))]
                (cond 
                    (< newCnt remSize) 
                        (recur (conj buildRem curr) newCnt (inc curr))
                    (= newCnt remSize) (= s (clojure.string/join (conj buildRem curr)))
                    :else false))))) 

(defn separateNumbers [s]
    (if (= 1 (count s)) 
        (println "NO")
        (loop [size 1 fst (subs s 0 size)]
            (cond 
                (> size (int (/ (count s) 2))) (println "NO")
                (check-rem-string (subs s size) fst) (println "YES" fst)
                :else (recur (inc size) (subs s 0 (inc size)))))))

;; end solution ;;

(def q (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [q-itr (range q)]
    (def s (read-line))

    (separateNumbers s)
)

; "91011"
; take first el 9
; make next elem 10 and check cumulative count
;    if cucount < rem count add 1 to 10
; if cucount > rem return NO
; else check string of elem arr = subs
; if false start by increasing size
; if true return "YES" first el  
