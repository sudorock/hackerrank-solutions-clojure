;; start solution ;;

(defn getAbsPos [origin, distances]
  (vec (map #(+ origin %) distances)))

(defn filterPositions [s t positions]
  (vec (filter #(and (> % (dec s)) (< % (inc t))) positions)))

(defn countApplesAndOranges [s t a b apples oranges]
  (println (clojure.string/join "\n" (vec (map count 
   (map #(filterPositions s t %) 
    (map getAbsPos 
     [a b] [apples oranges])))))))

;; end solution ;;

(def st (clojure.string/split (read-line) #" "))

(def s (Integer/parseInt (clojure.string/trim (nth st 0))))

(def t (Integer/parseInt (clojure.string/trim (nth st 1))))

(def ab (clojure.string/split (read-line) #" "))

(def a (Integer/parseInt (clojure.string/trim (nth ab 0))))

(def b (Integer/parseInt (clojure.string/trim (nth ab 1))))

(def mn (clojure.string/split (read-line) #" "))

(def m (Integer/parseInt (clojure.string/trim (nth mn 0))))

(def n (Integer/parseInt (clojure.string/trim (nth mn 1))))

(def apples (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def oranges (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(countApplesAndOranges s t a b apples oranges)

; input: s t a b apples oranges output: Int apples and Int oranges
; apples and oranges -> absolute positions
; filter apple abs pos > s and < t -> count a
; filter orange abs pos < t and > s -> count o
; return a and o

; a b [apples oranges] -> map getabs [a b] [ap or] -> ([apabs] [orabs]) -> map filterpos s t -> ([2, 3] [4 5 6]) -> map count -> (2 3)
