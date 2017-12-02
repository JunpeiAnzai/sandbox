package example

object Main extends App {
  override def main(args: Array[String]): Unit = {
    val set = Set(1L, 2L, 3L)

    val condition1 = ConditionParser.parse("""1 and 2""")
    assert(condition1.get.apply(set))

    val condition2 = ConditionParser.parse("""1 and 4""")
    assert(!condition2.get.apply(set))
  }
}
