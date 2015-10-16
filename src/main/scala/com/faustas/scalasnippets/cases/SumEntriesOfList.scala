package com.faustas.scalasnippets.cases

/*
  These examples summarize the entries of a List and return an Integer.
 */
object SumEntriesOfList {

  val entries = List(1,2,3,4,5,6,7,8,9)

  /**
   * Use the `sum` function of the List.
   *
   * @return The Integer result.
   */
  def sumSum : Int = {
    entries.sum
  }

  /**
   * Fold the entries with the help of the neutral element.
   *
   * @return The Integer result.
   */
  def sumFold : Int = {
    entries.fold(0)(_ + _)
  }

  /**
   * Use the `reduce` function.
   *
   * @return The Integer result.
   */
  def sumReduce : Int = {
    entries.reduce((s1, s2) => s1 + s2)
  }

  /**
   * Loop over the elements of the List and add the entries to a variable.
   *
   * @return The Integer result.
   */
  def sumForEach : Int = {
    var sum = 0
    entries.foreach(entry => sum += entry)
    sum
  }

  /**
   * Go recursively through the list
   *
   * @param values The list of entries.
   * @return The sum of the entries of the list.
   */
  def sumRecursive(values : List[Int]) : Int = {
    values match {
      case Nil => 0
      case l: List[Int] => l.head + sumRecursive(l.tail)
    }
  }

  /**
   * Go recursively through the entries of the list and use an inner tailrec function.
   *
   * @return The Integer result.
   */
  def sumTailRecursive : Int = {
    @annotation.tailrec
    def loop(pos: Int, sum: Int) : Int = {
      if (pos == entries.length) sum
      else loop(pos + 1, sum + entries(pos))
    }
    loop(0, 0)
  }

  /**
   * Test the single functions.
   *
   * @param args
   */
  def main(args: Array[String]): Unit = {
    println(s"sumSum produces: ${SumEntriesOfList.sumSum}")

    println(s"sumFold produces: ${SumEntriesOfList.sumFold}")

    println(s"sumReduce produces: ${SumEntriesOfList.sumReduce}")

    println(s"sumForEach produces: ${SumEntriesOfList.sumForEach}")

    println(s"sumRecursive produces: ${SumEntriesOfList.sumRecursive(entries)}")

    println(s"sumTailRecursive produces: ${SumEntriesOfList.sumTailRecursive}")
  }
}