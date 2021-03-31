package exercise_4

import scala.math.sqrt

object Exercise4 {

  //opdracht 1
  val people = List("Alfred", "Boris", "Ann", "Jan", "Anya", "Monique", "Christophe", "Jan", "Joris", "Bert", "Olaf")

  //opdracht 2.1
  def size(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case _ => 1 + size(list.tail)
    }
  }

  //opdracht 2.2
  def sum(list: List[Int]): Int = {
    list match {
      case Nil => 0
      case _ => list.head + sum(list.tail)
    }
  }

  //opdracht 2.3
  def max(list: List[Int]): Int = {
    if (list == Nil)
      return 0;
    //TODO ?
    0
  }

  //opdracht 2.4
  def replicate(s: String, x: Int): String = {
    x match {
      case num if num > 0 => s + " " + replicate(s, num - 1)
      case _ => ""
    }
  }

  //opdracht 4.1
  def swap(list: List[(String, Int)]): List[(Int, String)] = {
    list match {
      case Nil => Nil
      case (s: String, i: Int) :: _ => ((i, s) :: swap(list.tail))
    }
  }


  //opdracht 2.1
  def getFirstElement(list: List[Int]): Option[Int] = {
    list match {
      case Nil => None
      //case list.head :: _ => Some(list.head)
    }
  }

  //opdracht 2.2
  def getLargestElement(list: List[Int]): Option[Int] = {
    list match {
      case Nil => None
      case _ => {
        val option = getLargestElement(list.tail)

        option match {
          case None => Option(list.head)
          case Some(num) if num >= list.head => option
          case _ => Option(list.head)
        }
      }
    }
  }

  //opdracht 2.3
  def replicate(s: Option[String], i: Option[Int]): Option[String] = {
    s match {
      case None => None
      case Some(s) =>
        i match {
          case None => None
          case Some(i) if i > 0 =>
            Option(s + replicate(s, i - 1))
          case _ => Option("")
        }
    }
  }

  //opdracht 3.1
  def squareRoot(either: Either[Double, String]): Either[Double, String] = {
    either match {
      case Right(x) if !x.isEmpty => either
      case Left(x) if x < 0 => Right("Input cannot be negative!")
      case Left(x) => Left(sqrt(x))
    }
  }

  //opdracht 3.2
  def DivideBy10(either: Either[Double, String]): Either[Double, String] = {
    either match {
      case Right(x) if !x.isEmpty => either
      case Left(x) if x == 0 => Right("Input cannot be zero")
      case Left(x) => Left(10 / x)
    }
  }

  //opdracht 3.3
  def DivideBy1(either: Either[Double, String]): Either[Double, String] = {
    either match {
      case Right(x) if !x.isEmpty => either
      case Left(x) if x == 1 => Right("Input cannot be One")
      case Left(x) => Left(1 / (x - 1))
    }
  }
}
