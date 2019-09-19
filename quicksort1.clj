;; start solution ;;

(defn quickSort [arr]
    (let [el (get arr 0)]
        (loop [[fst & rst] arr left [] equal [] right []]
            (cond 
                (nil? fst) (concat left equal right)
                (> fst el) (recur rst left equal (cons fst right))
                (< fst el) (recur rst (cons fst left) equal right)
                :else (recur rst left (cons fst equal) right)))))
              
;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (quickSort arr))

(spit fptr (clojure.string/join " " result) :append true)
(spit fptr "\n" :append true)
