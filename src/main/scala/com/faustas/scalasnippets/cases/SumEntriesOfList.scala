package com.faustas.scalasnippets.cases

import scala.annotation.tailrec

/*
  These examples summarize the entries of a List and return an Integer.
 */
object SumEntriesOfList {
  /**
   * Use the `sum` function of the List.
   *
   * @param entries The list of entries.
   * @return The Integer result.
   */
  def sumSum(entries: List[Int]) : Int = {
    entries.sum
  }

  /**
   * Fold the entries with the help of the neutral element.
   *
   * @param entries The list of entries.
   * @return The Integer result.
   */
  def sumFold(entries: List[Int]) : Int = {
    entries.fold(0)(_ + _)
  }

  /**
   * Use the `reduce` function.
   *
   * @param entries The list of entries.
   * @return The Integer result.
   */
  def sumReduce(entries: List[Int]) : Int = {
    entries.reduce((s1, s2) => s1 + s2)
  }

  /**
   * Loop over the elements of the List and add the entries to a variable.
   *
   * @param entries The list of entries.
   * @return The Integer result.
   */
  def sumForEach(entries: List[Int]) : Int = {
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
   * Go recursively through the list and make it tailrec
   *
   * @param values The list of entries.
   * @return The sum of the entries of the list.
   */
  @tailrec
  def sumRecursiveTailrec(values : List[Int], sum: Int = 0) : Int = {
    values match {
      case Nil => sum
      case l: List[Int] => sumRecursiveTailrec(l.tail, sum + l.head)
    }
  }

  /**
   * Go recursively through the entries of the list and use an inner tailrec function.
   *
   * @param entries The list of entries.
   * @return The Integer result.
   */
  def sumTailRecursive(entries: List[Int]) : Int = {
    @annotation.tailrec
    def loop(pos: Int, sum: Int) : Int = {
      if (pos == entries.length) sum
      else loop(pos + 1, sum + entries(pos))
    }
    loop(0, 0)
  }

  val entries = List(1,2,3,4,5,6,7,8,9)

  /**
   * Test the single functions.
   *
   * @param args Arguments
   */
  def main(args: Array[String]): Unit = {
    println(s"sumSum produces: ${SumEntriesOfList.sumSum(entries)}")

    println(s"sumFold produces: ${SumEntriesOfList.sumFold(entries)}")

    println(s"sumReduce produces: ${SumEntriesOfList.sumReduce(entries)}")

    println(s"sumForEach produces: ${SumEntriesOfList.sumForEach(entries)}")

    println(s"sumRecursive produces: ${SumEntriesOfList.sumRecursive(entries)}")

    println(s"sumRecursiveTailrec produces: ${SumEntriesOfList.sumRecursiveTailrec(entries)}")

    println(s"sumTailRecursive produces: ${SumEntriesOfList.sumTailRecursive(entries)}")
  }
}