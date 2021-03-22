class PersonGenerator(private val url: String) extends Observable[String] {

  def trigger() = {
    println("fetching...")
    scala.io.Source.fromURL(url).getLines().drop(1).foreach(notifyObservers)
    //    while (input.hasNext) {
    //      notifyObservers(input.next())
    //  }
  }
}
