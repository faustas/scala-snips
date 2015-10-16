package com.faustas.scalasnippets.diverse

object Lists {
  /**
   * Test the single functions.
   *
   * @param args Arguments
   */
  def main(args: Array[String]): Unit = {
    // fill the list 3x with the given tuple
    val entries : List[(String, Int)] = List.fill(3)(("foo", 2))

    println(s"The entries: $entries")

    // Make a tuple of two lists of the first and second values from `entries`
    val (words, sum) = entries.unzip

    println(s"List of strings: $words")
    println(s"List of Ints: $sum")

    // sum the values in `sum`
    val summed = sum.reduce((s1,s2) => s1 + s2)

    println(s"The sum of the Ints: $summed")

    val summed2 = sum.fold(0)(_ + _)

    println(s"The sum with `fold`: $summed2")
  }
}
