;; start solution ;;

(defn gameOfThrones [s]
    (if (> (count (filter odd? (vals (frequencies s)))) 1)
        "NO"
        "YES"))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def s (read-line))

(def result (gameOfThrones s))

(spit fptr (str result "\n") :append true)


; calculate frequencies of letters
; get vals
; if number of odd vals > 1 return "NO"
; else "YES"
