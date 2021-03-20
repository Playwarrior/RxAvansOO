class NameExtractor extends ReactiveLink[String] {

  def next(data: String): Unit = {
    notifyObservers(data)
  }
}
