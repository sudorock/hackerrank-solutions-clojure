;; start solution ;;

(defn appendAndDelete [s t k]
    (loop [[fs & rs :as sa] s [ft & rt :as ra] t init nil]
        (cond
            (= (set s) (set t)) "Yes"
            (and (nil? fs) (nil? ft)) "Yes"
            (= ft fs) (recur rs rt 1)
            :else 
                (cond 
                    (> (+ (count sa) (count ra)) k) "No"
                    (and (< (+ (count sa) (count ra)) k) (some? init)) "No"
                    :else "Yes"))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def s (read-line))

(def t (read-line))

(def k (Integer/parseInt (clojure.string/trim (read-line))))

(def result (appendAndDelete s t k))

(spit fptr (str result "\n") :append true)
