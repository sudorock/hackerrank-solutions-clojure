;; start solutioin ;;

(defn get-max-distance [[lastEl maxD] el]
    (if (nil? lastEl) 
        [el maxD]
        (let [newMaxD (int (/ (- el lastEl) 2))]
            (if (> newMaxD maxD) 
                [el newMaxD]
                [el maxD]))))

(defn flatlandSpaceStations [n c]
    (let [sorted (vec (sort c))]
        (max (- (first sorted) 0) 
             ((reduce get-max-distance [nil 0] (sort sorted)) 1) 
             (- (dec n) (peek sorted)))))
   
;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def nm (clojure.string/split (read-line) #" "))

(def n (Integer/parseInt (clojure.string/trim (nth nm 0))))

(def m (Integer/parseInt (clojure.string/trim (nth nm 1))))

(def c (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (flatlandSpaceStations n c))

(spit fptr (str result "\n") :append true)


; max (ceil (d between consecutive stations) / 2) , (0 to first el) and last station to (dec count of c)
