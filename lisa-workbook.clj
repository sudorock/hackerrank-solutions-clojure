;; start solution ;;

(defn workbook [n k arr]
  (loop [page 1 start 1 end k chapter 0 special 0 ctr 1]
  (println "page" page "start" start "end" end "chapter" chapter "special" special)

      (cond
        (> chapter (dec n)) special
        (> start (arr chapter)) 
          (recur page 1 k (inc chapter) special 1)
        (and (> end (arr chapter)) (>= page start) (<= page (arr chapter)))
          (recur (inc page) 1 k (inc chapter) (inc special) 1)
        (and (> end (arr chapter)) (not (and (>= page start) (<= page (arr chapter)))))
          (recur (inc page) 1 k (inc chapter) special 1) 
        (and (>= page start) (<= page end)) 
          (recur (inc page) 
                 (inc (* ctr k)) 
                 (* (inc ctr) k) 
                 chapter 
                 (inc special) 
                 (inc ctr))
        :else 
          (recur (inc page) 
                 (inc (* ctr k)) 
                 (* (inc ctr) k) 
                 chapter special
                 (inc ctr)))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def nk (clojure.string/split (read-line) #" "))

(def n (Integer/parseInt (clojure.string/trim (nth nk 0))))

(def k (Integer/parseInt (clojure.string/trim (nth nk 1))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (workbook n k arr))

(spit fptr (str result "\n") :append true)

; special = 1
; k = 3
; arr 4 2 6 1 0
; start 1 end 3
; start 4 end 6 page 2
; page 3 start > 4
; page 3 start 1 end 3  tot 2
; page 4 start 1 end 3 tot 6 chapter 3
; page 5 start 4 end 6 tot 6
