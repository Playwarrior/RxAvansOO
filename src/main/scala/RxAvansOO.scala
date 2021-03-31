object RxAvansOO {

  type Observer[T] = T => Unit

  def link[A](next: Observer[A]) = (data: A) => next(data)

  def map[A](transform: A => A, next: Observer[A]): Observer[A] = {
    _ => transform andThen next
  }

  def filter[A](filter: A => Boolean, next: Observer[A]): Observer[A] = {
    (data: A) => if(filter(data)) next(data)
  }

  def fork[A](next: List[Observer[A]]):

}
