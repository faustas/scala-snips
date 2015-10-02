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
