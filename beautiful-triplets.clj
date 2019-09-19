(defn beautifulTriplets [d arr]
    (let [freq (frequencies arr)]
        (loop [[fst & rst] (apply sorted-set arr) total 0]
            (let [secondVal (+ fst d) 
                  thirdVal (+ secondVal d)
                  srch (take-while #(<= % thirdVal) rst)]
                (cond
                    (empty? rst) total
                    (and (some #{secondVal} srch) (some #{thirdVal} srch))
                        (recur 
                            rst 
                            (+ total (apply * (map freq [fst secondVal thirdVal]))))
                    :else (recur rst total))))))


(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def nd (clojure.string/split (read-line) #" "))

(def n (Integer/parseInt (clojure.string/trim (nth nd 0))))

(def d (Integer/parseInt (clojure.string/trim (nth nd 1))))

(def arr (vec (map #(Integer/parseInt %) (clojure.string/split (read-line) #" "))))

(def result (beautifulTriplets d arr))

(spit fptr (str result "\n") :append true)
