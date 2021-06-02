import org.scalacheck.Properties
import org.scalacheck.Prop.forAll
import BandOps._

object BandSpecification extends Properties("Band") {
  property("assoc") = forAll {
    (a: Set[Int], b: Set[Int], c: Set[Int]) =>
      var s1 : Set[Int] = (a ++ b) ++ c
      var s2 : Set[Int] = a ++ (b ++ c)
      s1 == s2
  }

  property("Idempotence") = forAll {
    (a: Set[Int]) =>
      var s1 : Set[Int] = (a ++ a)
      var s2 : Set[Int] = a
      s1 == s2
  }
}