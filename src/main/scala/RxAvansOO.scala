object RxAvansOO {

  type Observer[T] = T => Unit

  def link[A](next: Observer[A]) = (data: A) => next(data)

  def map[A, B](transform: A => B, next: Observer[A]): Observer[B] = {
    (_: A) => next(transform(_))
  }



}
