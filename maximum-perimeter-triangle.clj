;; start solution ;;

(defn maximumPerimeterTriangle [sticks] 
      (loop [[fst & rst] (sort > sticks)] 
        (let [snd (first rst) thd (second rst)]
          (cond
            (nil? thd) (vector -1)
            (< fst (+ thd snd)) (vector thd snd fst)
            :else (recur rst)))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def sticks (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (maximumPerimeterTriangle sticks))

(spit fptr (clojure.string/join " " result) :append true)
(spit fptr "\n" :append true)

; construct triangle with max possible perimeter
; output 3 sides in increasing order (arr) or if no such triangles exist then -1

; sort arr in reverse order
; check if first elem is less than sum of second and third

; 10 5 4 3 2 1
; check if 10 < 5 + 4, no, then move to next
; 5 < 4 + 3 valid triangle

; check if first < second + third then return [third, second, first]


; loop [fst & rst] arr]
; let [snd (first rest) thd (second rest)]
; if thd is nil return -1
; else 
; if fst < snd + thd return [third, second, first]
; else (recur rst)
