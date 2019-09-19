;; start solution ;;

(defn insert-left [arr el]
    (loop [left arr currEl (peek left) result [] ctr 0]
        (cond
            (empty? left) (vector (cons el result) ctr)
            (< el currEl) 
                (let [newLeft (pop left) newCurr (peek newLeft)]
                    (recur newLeft newCurr (cons currEl result) (inc ctr)))
            :else (vector (into (vec left) (cons el result)) ctr))))


(defn insertionSort2 [arr]
    (loop [[fst & rst] arr result [] ctr 0 total 0]
        (if (nil? fst) 
            total 
            (let [[res tot] (vec (insert-left result fst))]
                (recur rst (vec res) (inc ctr) (+ total tot))))))

(defn runningTime [arr]
    (insertionSort2 arr))
    
;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (runningTime arr))

(spit fptr (str result "\n") :append true)
