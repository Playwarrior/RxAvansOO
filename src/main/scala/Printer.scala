class Printer(private val template: String) extends ReactiveLink[String] {
  def next(data: String): Unit = {
    println(template + " " + data)
  }
}
