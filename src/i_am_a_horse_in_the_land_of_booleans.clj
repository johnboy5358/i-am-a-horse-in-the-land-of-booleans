(ns i-am-a-horse-in-the-land-of-booleans
  (:refer-clojure :exclude [boolean]))

(defn boolean [x]
  (if x true false ))

(defn abs [x]
  (if (< x 0)
    (* -1 x)
    x))

(defn divides? [divisor n]
  (if (< 0 (mod n divisor))
    false
    true))

(defn fizzbuzz [n]
  (defn divisible-by-3? [n]
    (divides? 3 n))
  (defn divisible-by-5? [n]
    (divides? 5 n))
  (defn divisible-by-3-and-5? [n]
    (if (and (divisible-by-3? n) (divisible-by-5? n))
      true false))
  (cond
    (divisible-by-3-and-5? n) "gotcha!"
    (divisible-by-3? n) "fizz"
    (divisible-by-5? n) "buzz"
    :else ""))

(defn teen? [age]
  (> 20 age 12))

(defn not-teen? [age]
  (if (not (teen? age))
    true
    false))

(defn generic-doublificate [x]
  (cond
    (number? x) (* 2 x)
    (empty? x) nil
    (or (list? x) (vector? x)) (* 2 (count x))
    :else true))

(defn leap-year? [year]
  (defn divisible-by-4? [yr]
    (divides? 4 yr))
  (defn not-divisible-by-100? [yr]
    (not (divides? 100 yr)))
  (defn divisible-by-400? [yr]
    (divides? 400 yr))
  (cond
    (and (divisible-by-4? year)(not-divisible-by-100? year)) true
    :else (cond
            (divisible-by-400? year) true
            :else false)))

; '_______'
