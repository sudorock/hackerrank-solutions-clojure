;; start solution ;;

(defn luckBalance [k contests]
  (let [impContests (sort > (map #(% 0) (filter #(= 1 (% 1)) contests)))
        impContestsLose (take k impContests)
        impContLostSum (reduce + impContestsLose)
        impContWonSum (- (reduce + impContests) impContLostSum)
        unimpContestsSum (reduce + (map #(% 0) (filter #(= 0 (get % 1)) contests)))]
      (- (+ unimpContestsSum impContLostSum) impContWonSum)))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def nk (clojure.string/split (read-line) #" "))

(def n (Integer/parseInt (clojure.string/trim (nth nk 0))))

(def k (Integer/parseInt (clojure.string/trim (nth nk 1))))

(def contests [])

(doseq [_ (range n)]
    (def contests (conj contests (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" ")))))
)
(println contests)
(def result (luckBalance k contests))

(spit fptr (str result "\n") :append true)
