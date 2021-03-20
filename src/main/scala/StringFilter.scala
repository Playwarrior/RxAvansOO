class StringFilter(private val keyword: String) extends ReactiveLink[String] {
  override def next(data: String): Unit = if (data.contains(keyword)) notifyObservers(data.split(",")(1))
}
