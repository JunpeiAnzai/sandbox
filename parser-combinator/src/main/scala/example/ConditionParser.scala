package example

import scala.util.parsing.combinator._

/**
  * expr ::= term {"or" term }
  * term ::= not_term { "and" not_term }
  * not_term :: = ["not"] factor
  * factor ::= Integer | "(" expr ")"
  */
object ConditionParser extends JavaTokenParsers {

  def expr: Parser[Condition] = term~rep("or"~>term) ^^ {
    case f~fs => fs.foldLeft(f) { (f1, f2) => f1 or f2}
  }

  def term: Parser[Condition] = not_term~rep("and"~>not_term) ^^ {
    case f~fs => fs.foldLeft(f) { (f1, f2) => f1 and f2}
  }

  def not_term: Parser[Condition] = opt("not")~factor ^^ {
    case Some("not")~f => NotCondition(f)
    case None~f => f
  }

  def factor: Parser[Condition] = (
    wholeNumber ^^ {str => TargetElement(str.toLong)}
    | "("~>expr<~")"
  )

  def parse(input: String): ParseResult[Condition] = parseAll(expr, input)
}

trait Condition {
  def apply(conditionIds: Set[Long]): Boolean

  def and(other: Condition): Condition = AndCondition(this, other)

  def or(other: Condition): Condition = OrCondition(this, other)

  def not: Condition = NotCondition(this)
}

case class AndCondition(c1: Condition, c2: Condition) extends Condition {
  override def apply(conditionIds: Set[Long]): Boolean = {
    c1(conditionIds) && c2(conditionIds)
  }
}

case class OrCondition(c1: Condition, c2: Condition) extends Condition {
  override def apply(conditionIds: Set[Long]): Boolean = {
    c1(conditionIds) || c2(conditionIds)
  }
}

case class NotCondition(c: Condition) extends Condition {
  override def apply(conditionIds: Set[Long]): Boolean = {
    !c(conditionIds)
  }
}

case class TargetElement(id: Long) extends Condition {
  override def apply(conditionIds: Set[Long]): Boolean = {
    conditionIds.contains(id)
  }
}
