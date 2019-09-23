;; start solution ;;

(defn fibonacciModified [t1 t2 n]
  (loop [l1 (biginteger t1) l2 (biginteger t2) cnt 2]
    (cond
      (= cnt n) l2
      :else (recur l2 (+ l1 (* l2 l2)) (inc cnt)))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def t1T2n (clojure.string/split (read-line) #" "))

(def t1 (Integer/parseInt (clojure.string/trim (nth t1T2n 0))))

(def t2 (Integer/parseInt (clojure.string/trim (nth t1T2n 1))))

(def n (Integer/parseInt (clojure.string/trim (nth t1T2n 2))))

(def result (fibonacciModified t1 t2 n))

(spit fptr (str result "\n") :append true)
