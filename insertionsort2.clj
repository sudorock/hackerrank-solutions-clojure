
;; start solution ;;

(defn prnstring [arr ctr]
    (when (> ctr 0)
        (println (clojure.string/join " " arr))))

(defn insert-left [arr el]
    (loop [left arr currEl (peek left) result []]
        (cond
            (empty? left) (cons el result) 
            (< el currEl) 
                (let [newLeft (pop left) newCurr (peek newLeft)]
                    (recur newLeft newCurr (cons currEl result)))
            :else (into (vec left) (cons el result)))))


(defn insertionSort2 [arr]
    (loop [[fst & rst] arr result [] ctr 0]
        (if (nil? fst) 
            result 
            (let [res (vec (insert-left result fst))]
                (prnstring (into res rst) ctr)
                (recur rst res (inc ctr))))))

;; end solution ;;

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(insertionSort2 arr)
