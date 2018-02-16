package it.unical.dimes.teoriadellinformazione
import utest._

object LempevZivTest extends TestSuite {
  def encodeTest(s: String, shouldBe: List[Int]): Unit = {
    val lempevZiv = new LempevZiv(7, 4)
    val data = s.map(_.toInt).toArray
    val encoded = lempevZiv.encode(data).toList
    assert(encoded == shouldBe)
  }

  val tests = Tests {
    "longestMatch" - {
      val lempevZiv = new LempevZiv(10, 3)
      val data = Array[Int](0,0,0,1,0,1,0,0,0,0,0,0,0,0)
      val matching = lempevZiv.longestMatch(data, 8)
      assert(matching == (0, 3))
    }

    "encode Banana" - {
      encodeTest("Banana", List(0,0,'B'.toInt, 0,0,'a'.toInt,0,0,'n'.toInt,6,2,-1))
    }

    "encode abracadabra" - {
      encodeTest("abracadabra", List(0,0,'a',
                                     0,0,'b',
                                     0,0,'r',
                                     3,1,'c',
                                     2,1,'d',
                                     7,4,-1).map(_.toInt))
    }

    "encode and decode" - {
      val lempevZiv = new LempevZiv(10, 3)

      val data = new Array[Int](1000)
      for(i <- 0 until data.length) data(i) = util.Random.nextInt(100)
      val encoded = lempevZiv.encode(data)
      val decoded = lempevZiv.decode(encoded)
      val a = decoded.toList
      val b = data.toList
      assert(a == b)
    }
    //
    // "encode and decode compression ratio" - {
    //   val lempevZiv = new LempevZiv(10, 3)
    //   val r = util.Random.nextDouble
    //   val data = new Array[Int](1000)
    //   for(i <- 0 until data.length) data(i) = if(r < 0.1) 0 else 1
    //   val encoded = lempevZiv.encode(data)
    //   val decoded = lempevZiv.decode(encoded)
    //   val a = decoded.toList
    //   val b = data.toList
    //   assert(a == b)
    // }
  }
}
