;; start solution ;;

(defn beautifulBinaryString [b]
  (if (< (count b) 3) 
      0
      (loop [[fst & rst] (subs b 2) lst (get b 1) sndlst (get b 0) cnt 0]
        (cond 
          (nil? fst) cnt
          (and (= fst \0) (= lst \1) (= sndlst \0)) (recur rst \1 lst (inc cnt))
          :else (recur rst fst lst cnt)))))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def n (Integer/parseInt (clojure.string/trim (read-line))))

(def b (read-line))

(def result (beautifulBinaryString b))

(spit fptr (str result "\n") :append true)
