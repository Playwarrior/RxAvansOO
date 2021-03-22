object Main extends App {

  val pg = new PersonGenerator("https://randomuser.me/api/?format=csv&results=10&inc=name,nat,email")

  val logger = new Logger[String]()
  pg.observe(logger)

  val misterFilter = new Filter[String](data => data.contains("Mr"))
  logger.observe(misterFilter)

  val missFilter = new Filter[String](data => data.contains("Miss"))
  logger.observe(missFilter)

  val misterExtractor = new Map[String](x => x.split(",")(1))
  misterFilter.observe(misterExtractor);

  val missExtractor = new Map[String](x => x.split(",")(1))
  missFilter.observe(missExtractor);

  val misterPrint = new Printer("mister")
  misterExtractor.observe(misterPrint)

  val missPrint = new Printer("miss")
  missExtractor.observe(missPrint)

  pg.trigger();

}
