
;; start solution ;;

(defn ceil [n]
  (if (= (float (int n)) (float n)) (int n) (inc (int n))))

(defn remove-space [s]
  (clojure.string/replace s #"(\s)" ""))

(defn get-row [s idx adder limit]
  (apply str (map #(get s %) (take-while #(<= % limit) (iterate #(+ % adder) idx)))))

(defn encryption [s]
  (let [trimmed (remove-space s) 
        sqrt (Math/sqrt (count trimmed)) 
        rows (if (< (* (int sqrt)  (ceil sqrt)) (count trimmed)) (ceil sqrt) (int sqrt)) 
        cols (ceil sqrt)]
    (loop [idx 0 result []]
      (cond
        (> idx (dec cols)) (clojure.string/join " " result)
        :else (recur (inc idx) (conj result (get-row trimmed idx cols (dec (* rows cols)))))))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def s (read-line))

(def result (encryption s))

(spit fptr (str result "\n") :append true)
