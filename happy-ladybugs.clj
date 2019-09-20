;; start solution ;;

(defn check-one-letter [b]
 (if (nil? (some #(and (not (= (key %) \_)) (= (val %) 1)) (frequencies b)))
  false
  true))

(defn check-for-only-dash [b]
  (= (set b) #{\_}))

(defn check-for-no-dash [b]
 (not (contains? (set b) \_)))

(defn check-for-happy-bugs [b]
  (loop [[fst & rst] b lastEl (get b 0) cnt 0]
    (cond
      (nil? fst) true
      (= fst lastEl) (recur rst fst (inc cnt))
      (and (not (zero? cnt)) (not (= fst lastEl))) (recur rst fst 0)
      :else false)))

(defn happyLadybugs [b]
  (cond 
    (check-one-letter b) "NO"
    (check-for-only-dash b) "YES"
    (check-for-no-dash b)
      (if (check-for-happy-bugs b)
          "YES"
          "NO")
    :else "YES"))

;; end solution ;;

(def fptr (get (System/getenv) "OUTPUT_PATH"))

(def g (Integer/parseInt (clojure.string/trim (read-line))))

(doseq [g-itr (range g)]
    (def n (Integer/parseInt (clojure.string/trim (read-line))))

    (def b (read-line))

    (def result (happyLadybugs b))

    (spit fptr (str result "\n") :append true)
)

; case some ascii freq is 1 then false
; if there are no free gaps and next letters are not same then false
; if only _ yes
;; if all ladybugs have pair and more then yes

