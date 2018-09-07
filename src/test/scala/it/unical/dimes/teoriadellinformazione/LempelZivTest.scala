package it.unical.dimes.teoriadellinformazione
import utest._

object LempelZivTest extends TestSuite {
  def encodeTest(s: String, shouldBe: List[Int]): Unit = {
    val lempelZiv = new LempelZiv(10, 10)
    val data = s.map(_.toInt).toArray
    val encoded = lempelZiv.encode(data).toList
    assert(encoded == shouldBe)
  }

  val tests = Tests {
    "longestMatch" - {
      val lempelZiv = new LempelZiv(10, 10)
      val data = Array[Int](0,0,0,1,0,1,0,0,0,0,0,0,0,0)
      val matching = lempelZiv.longestMatch(data, 8)
      assert(matching == (8, 3))
    }

    "encode Banana" - {
      encodeTest("Banana", List(0,0,'B'.toInt, 0,0,'a'.toInt,0,0,'n'.toInt,2,2,'a'))
    }

    "encode abracadabra" - {
      encodeTest("aabracadabracd", List(0,0,'a',
                                     1,1,'b',
                                     0,0,'r',
                                     3,1,'c',
                                     2,1,'d',
                                     7,5,'d').map(_.toInt))
    }

    "encode and decode" - {
      val lempelZiv = new LempelZiv(10, 10)

      val data = "aabracadabracd".map(_.toInt).toArray
      val encoded = lempelZiv.encode(data)
      val decoded = lempelZiv.decode(encoded)
      val a = decoded.toList
      val b = data.toList
      assert(a == b)
    }
    
    "encode and decode 2" - {
      val lempelZiv = new LempelZiv(10, 10)

      val data = new Array[Int](100)
      for(i <- 0 until data.length) data(i) = util.Random.nextInt(1000)
      val encoded = lempelZiv.encode(data)
      val decoded = lempelZiv.decode(encoded)
      val a = decoded.toList
      val b = data.toList
      assert(a == b)
    }
    
    //
    // "encode and decode compression ratio" - {
    //   val lempelZiv = new LempelZiv(10, 3)
    //   val r = util.Random.nextDouble
    //   val data = new Array[Int](1000)
    //   for(i <- 0 until data.length) data(i) = if(r < 0.1) 0 else 1
    //   val encoded = lempelZiv.encode(data)
    //   val decoded = lempelZiv.decode(encoded)
    //   val a = decoded.toList
    //   val b = data.toList
    //   assert(a == b)
    // }
  }
}
