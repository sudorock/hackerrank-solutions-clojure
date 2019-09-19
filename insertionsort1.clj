

; Complete the insertionSort1 function below.
(defn prnstring [arr]
    (println (clojure.string/join " " arr)))

(defn insertionSort1 [n arr]
    (let [el (get arr (dec n))]
        (loop [cnt (dec n) left (subvec arr 0 (dec n)) right []]
            (let [currEl (get left (dec cnt))]
                (cond
                    (empty? left) (prnstring (cons el right))
                    (< el currEl) 
                        (do (prnstring (into left (cons currEl right))) 
                            (recur 
                                (dec cnt) 
                                (subvec arr 0 (dec cnt)) 
                                (cons currEl right)))
                    :else (prnstring (into left (cons el right))))))))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(insertionSort1 n arr)

;; size = 4, c = 3 
;; left 2 3 4
; 2 3 4 1
; left 2 3 4
; curr = 3 

; get el= last k = 0
; if el < last of sub vec 0 last - k then last is cons to right arr k -- 
; if el >= subvec 0 last - k el right
; if empty? subvec then el right 
