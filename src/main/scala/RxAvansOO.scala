object RxAvansOO {

  type Observer[T] = T => Unit
  type Observable[A] = Observer[A] => Unit

  def map[A, B](next: Observable[A], transform: A => B): Observable[B] = {
    (obs: Observer[B]) => next(transform andThen obs)
  }

  def filter[A](obs: Observable[A], filter: A => Boolean): Observable[A] = {
    (observer: Observer[A]) => obs((data: A) => if (filter(data)) observer(data))
  }

  def fork[A](obs: Observable[A]): Observable[A] = {
    var mem: Option[A] = None

    (observer: Observer[A]) => {
      mem match {
        case Some(data) => observer(data)
        case None => obs((data: A) => {
          mem = Some(data)
          observer(data);
        })
      }
    }
  }


  def log[A](obs: Observable[A]): Observable[A] = {
    (observer: Observer[A]) => {
      obs((data: A) => {
        println(data);
        observer(data);
      })
    }
  }
}
