package exercise_3

object Exercise3 extends App {

  val people = List("Alfred", "Boris", "Ann", "Jan", "Anya", "Monique", "Christophe", "Jan", "Joris", "Bert", "Olaf")

  //opdracht 1.1
  def addDear(people: List[String]): List[String] = {
    val name = addDear(people.head);

    if (people.tail != Nil)
      name :: addDear(people.tail)

    else
      Nil
  }

  //opdracht 1.2
  def addDear(p: String): String = {
    "Dear " + p
  }

  val newPeople = addDear(people)

  newPeople foreach println

  //opdracht 1.3
  var x = List[Any]()

  people foreach (p => {
    x = x ++ p.toList
  })

  println(x)

  //opdracht 1.4
  var set = x.toSet

  println(set)

  //opdracht 1.5
  var sum = 0;

  people foreach (x => sum += x.length)

  println(sum)

  //opdracht 1.6
  var opdracht6 = people.fold("Dear")(_ + ", " + _)

  println(opdracht6)

  //opdracht 1.7
  var peopleWithAn = people.count(x => x.contains("an"))

  println(peopleWithAn)

  //opdracht 1.8
  var peopleWithNameGreaterThan3 = people.count(x => x.length > 3)

  println(peopleWithNameGreaterThan3)

  //opdracht 1.9
  var peopleWithAllCapitalLetter = people.forall(x => x.toList.head.isUpper)

  println(peopleWithAllCapitalLetter)

  //opdracht 1.10
  var peopleWithAnX = people.exists(x => x.contains('x'))

  println(peopleWithAnX)

  //opdracht 1.11
  people.filter(x => x.contains("x") || x.contains("q")) foreach println

  //opdracht 1.12
  var groupedByNameSize = people.groupBy(x => x.length)

  //opdracht 1.13
  println(people.toSet.size != people.size)

  //opdracht 2.1
  def size(list: List[Int]): Int = {
    if (list == Nil)
      return 0

    1 + size(list.tail)
  }

  //opdracht 2.2
  def sum(list: List[Int]): Int = {
    if (list == Nil)
      return 0

    list.head + sum(list.tail)
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
    if (x != 0)
      return s + " " + replicate(s, x - 1)

    ""
  }

  //opdracht 4.1
  def swap(list: List[(String, Int)]): List[(Int, String)] = {
    if (list == Nil)
      Nil

    else {
      val x: (String, Int) = list.head

      (x._2, x._1) :: swap(list.tail)
    }
  }

  //opdracht 4.2
  def zip(list1: List[Int], list2: List[Int]): List[(Int, Int)] = {
    if (list1 == Nil || list2 == Nil)
      Nil

    else {
      (list1.head, list2.head) :: zip(list1.tail, list2.tail)
    }
  }
}
