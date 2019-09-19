;; start solution ;;

(defn balancedSums [arr]
    (let [total (apply + arr)]
        (loop [[fst & rst] arr left 0 right (- total fst)]
            (cond
                (< right left) "NO"
                (= right left) "YES"
                :else (recur rst (+ left fst) (- right (first rst)))))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def T (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [T-itr (range T)]
    (def n (Integer/parseInt (clojure.string/trim (read-line))))

    (def arr (vec (map #(Integer/parseInt %) (clojure.string/split (clojure.string/trimr (read-line)) #" "))))

    (def result (balancedSums arr))

    (spit fptr (str result "\n") :append true)
)


; get total sum
; calc left sum
; if total sum - curr = left sum return yes
; if total sum - curr < left sum return NO
; if fst is nil return NO
