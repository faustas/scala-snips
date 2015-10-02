def factorial(n: Long) : Long = {
  @annotation.tailrec
  def loop(n: Long, acc: Long): Long =
    if (n <= 0) acc
    else loop(n-1, n*acc)

  loop(n, 1)
}

println(s"Factorial of 7 is: ${factorial(7)}")
println(s"Factorial of 55 is: ${factorial(55)}")

def fib2(n: Int): Int = {
  @annotation.tailrec
  def loop(n: Int, prev: Int, cur: Int): Int =
    if (n == 0) prev
    else loop(n - 1, cur, prev + cur)
  loop(n, 0, 1)
}

println(s"Fibonacci of 6: ${fib2(6)}")

def double(n: Int) : Int = n*2
def formatResult(n: Int, f: Int => Int) = {
  s"The double of $n is ${f(n)}"
}

println(formatResult(4, double))

def findFirst(ar: Array[String], key: String): Int = {
  @annotation.tailrec
  def loop(n: Int): Int =
    if (n >= ar.length) -1
    else if (ar(n).equals(key)) n
    else loop(n + 1)
  loop(0)
}

val ar: Array[String] = List("foo", "bar", "foobar").toArray
println(s"Findfirst of `bar` in ${ar.toList} is on position: ${findFirst(ar, "bar")}")

def findFirstGeneric[A](as: List[A], p: A => Boolean): Int = {
  @annotation.tailrec
  def loop(n: Int): Int =
    if (n >= as.length) -1
    else if (p(as(n))) n
    else loop(n + 1)
  loop(0)
}

val arGeneric: List[String] = List("foo", "dog", "bar", "foobar")
val searchGeneric = "bar"
println(s"FindfirstGeneric of `$searchGeneric` in $arGeneric is on position: ${findFirstGeneric(arGeneric, (x: String) => x.equals(searchGeneric))}")

def isSorted[A](values: List[A], f: (A,A) => Boolean) : Boolean = {
  @annotation.tailrec
  def loop(n: Int) : Boolean =
    if (values.length < 2) true
    else if(values.length == n) f(values(n - 2), values(n - 1))
    else if (!f(values(n - 2), values(n - 1))) false
    else loop(n + 1)
  loop(2)
}

def isSortedShorter[A](v: List[A], f: (A,A) => Boolean) : Boolean = {
  @annotation.tailrec
  def loop(n: Int) : Boolean =
    if (n >= v.length - 1) true
    else if(f(v(n), v(n+1))) false
    else loop(n + 1)
  loop(0)
}

val unsorted : List[Int] = List(1,4,2,7,8,4)
println(s"The list $unsorted is sorted?: ${isSorted(unsorted, (x: Int,y: Int) => x <= y)}")
val sorted : List[Int] = List(2,4,6,8)
println(s"The list $sorted is sorted?: ${isSorted(sorted, (x: Int,y: Int) => x <= y)}")

println(s"The list $unsorted is sorted?: ${isSortedShorter(unsorted, (x: Int,y: Int) => x > y)}")
println(s"The list $sorted is sorted?: ${isSortedShorter(sorted, (x: Int,y: Int) => x > y)}")