class Map[T](private val transform: T => T) extends ReactiveLink[T] {

  def next(data: T): Unit = {
    notifyObservers(transform(data))
  }
}
