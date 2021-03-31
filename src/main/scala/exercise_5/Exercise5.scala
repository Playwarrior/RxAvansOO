package exercise_5

object Exercise5 extends App {

  //opdracht 2
  val log: String => Unit = makeLogger()

  def makeLogger(): String => Unit = {
    var x = 1;

    (s: String) => {
      println(x + ". " + s);
      x += 1;
    }
  }

  //opdracht 3
  val (incr, decr): (() => Int, () => Int) = makeCounter()

  def makeCounter() = {
    var x = 0;

    (() => {
      x += 1;
      println(x);
      x
    }, () => {
      x -= 1;
      println(x)
      x
    });
  }

  //opdracht 4
  val remember: String => String = createMemory()

  def createMemory() = {
    var x = "";

    (s: String) => {
      val old = x;

      x = s;

      old
    }
  }

  //opdracht 5
  val myRange = range(10, 20, 3)

  def range(i: Int, i1: Int, i2: Int) = {
    var start = i
    val step = i2
    val end = i1;

    () => {
      start += step;

      println(start);

      start match {
        case x if x > start && start <= end => Some(x)
        case _ => None
      }
    }
  }
}
