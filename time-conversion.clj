;; start solution ;;

(defn removeAMPM [string am-pm] (clojure.string/replace string am-pm ""))

(defn splitString [string] (clojure.string/split string #":"))

(defn convertInt [arr] (map #(. Integer parseInt %) arr))

(defn hourFormatAM [arr] (assoc arr 0 (mod (first arr) 12)))

(defn hourFormatPM [arr] 
  (if (= 12 (first arr))
    arr
    (assoc arr 0 (+ 12 (first arr)))))

(defn joinFormat [arr] (clojure.string/join ":" (map #(format "%02d" %) arr)))

(defn formatTime [s am-pm]
  (let [timeArr (vec (convertInt (splitString (removeAMPM s am-pm))))]
    (joinFormat
     (cond
      (= am-pm "AM") (hourFormatAM timeArr)
      (= am-pm "PM") (hourFormatPM timeArr)))))

(defn timeConversion [s]
  (cond 
   (re-find #"AM" s) (formatTime s "AM")
   (re-find #"PM" s) (formatTime s "PM")))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def s (read-line))

(def result (timeConversion s))

(spit fptr (str result "\n") :append true)


; s -> Check for AM PM and 12 hour (state) -> Split -> ParseInt 
; -> if AM -> hour % 12 -> str format -> str join
; -> if PM -> (if !(hour = 12) -> hour + 12 else hour = hour) -> str format -> str join

