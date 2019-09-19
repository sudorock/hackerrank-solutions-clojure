;; start solution ;;

(def hString "hackerrank")

(defn hackerrankInString [s]
    (loop [[fst & rst] s counter 0 next (get hString 0)]
        (cond    
            (= counter 10) "YES"
            (nil? fst) "NO"
            (= fst next) (recur rst (inc counter) (get hString (inc counter)))
            :else (recur rst counter next))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def q (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [q-itr (range q)]
    (def s (read-line))

    (def result (hackerrankInString s))

    (spit fptr (str result "\n") :append true)
)

; loop: [fst & rst] s [fstH & rstH :as all] hString
; (nil? fst) "NO"
; (nil? fstH) "YES"
; (= fst fstH) (recur rst rstH) 
; :else (recur rst all)
