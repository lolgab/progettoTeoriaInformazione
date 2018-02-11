package it.unical.dimes.teoriadellinformazione

import utest._

object HammingTest extends TestSuite {
  implicit def toBoolean(i: Int) = i != 0
  import Hamming._
  val tests = Tests {
    "r dovrebbe essere 3 per n = 4: Hamming(7,4)" - {
      val n = 4
      val r1 = r(4)
      assert(r1 == 3)
    }
    'hamming74 - {
      val data: Data = Array(1,1,0,1)
      val calculated = encode(data).toList
      val inserted: List[Boolean] = List(1,1,0,1,0,1,0)
      assert(calculated == calculated)
    }

    "esempio Youtube https://youtu.be/373FUw-2U2k" - {
      val data: Data = Array(1,0,0,1,1,0,1,0)
      val inserted: List[Boolean] = List(0,1,1,1,0,0,1,0,1,0,1,0)
      val calculated = encode(data).toList
      assert(calculated == calculated)
    }
  }
}
