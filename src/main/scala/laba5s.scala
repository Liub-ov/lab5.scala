import scala.language.implicitConversions

trait Band[A]{
  def summ(x: A, y: A): A
}

object Band{
  implicit val intBand = new Band[Set[Int]] {
    override def summ(x: Set[Int], y: Set[Int]):
    Set[Int] = x | y
  }
}

class BandOps[A](x: A)(implicit g: Band[A]) {
  def ++ (y: A): A = g.summ(x, y)
}

object BandOps {
  implicit def BandSyntax[A](x: A)(implicit g: Band[A]): BandOps[A] = {
    new BandOps[A](x)
  }
}