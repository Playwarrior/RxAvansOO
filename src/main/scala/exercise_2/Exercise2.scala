package exercise_2


package object Exercise2 {

  //opdracht 1
  def swap(tuple: (Int, String)): (String, Int) = {
    (tuple._2, tuple._1)
  }

  //opdracht 2
  def doubleHead(list: List[Int]): List[Int] = {
    list.head * 2 :: list.tail
  }

  //opdracht 3
  //  def add(f: Int => Int => Int): (Int, Int) => Int = {
  //
  //  }

  //opdracht 4
  //fuck you

  //opdracht 5
  def applyFunc(x: Int, y: Int, f: (Int, Int) => Int): Int = {
    f(x, y)
  }

  //opdracht 6
  def sizeDescription(list: List[Int]): String = {
    if (list.length < 10) "short" else if (list.length < 100) "long" else "very long"
  }

  //opdracht 7
  def lucky(x: Int): (Int) => String = {

  }
}
