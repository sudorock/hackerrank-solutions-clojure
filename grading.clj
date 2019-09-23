;; start solution ;;

(defn roundGrade [grade]
  (let [diff (mod grade 5)]
    (if (> diff 2) 
      (+ grade (- 5 diff))
      grade)))

(defn modifyGrade [grade]
  (if (< grade 38)
    grade
    (roundGrade grade)))

(defn gradingStudents [grades]
  (vec (map modifyGrade grades)))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def grades-count (Integer/parseInt (clojure.string/trim (read-line))))

(def grades [])

(doseq [_ (range grades-count)]
    (def grades (conj grades (Integer/parseInt (clojure.string/trim (read-line)))))
)

(def result (gradingStudents grades))

(spit fptr (clojure.string/join "\n" result) :append true)
(spit fptr "\n" :append true)


; Int array (grades) -> Int array (grades)
; grades -> map round grades
; grade -> round - rounded grade
; if grade < 38 no round return grade
; round: if (mod grade 5) > 2 (+ grade (- 5 (mod grade 5))  

