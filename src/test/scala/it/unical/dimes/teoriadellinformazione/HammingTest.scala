package it.unical.dimes.teoriadellinformazione

import utest._

object HammingTest extends TestSuite {
  implicit def toBoolean(i: Int) = i != 0
  implicit def toInt(b: Boolean) = if(b) 1 else 0
  import Hamming._
  def swapBit(d: Data, index: Int): Unit = d(index) = !d(index)

  val tests = Tests {
    // "r dovrebbe essere 3 per n = 4: Hamming(7,4)" - {
    //   val n = 4
    //   val r1 = r(4)
    //   assert(r1 == 3)
    // }
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

    "encode e decode dovrebbero coincidere" - {
      val data: Data = Array(1,1,1,0,1,0,1,0,1,0,0,0,0,1,0,1,1,0)
      val encoded = encode(data)
      val decoded = decode(encoded).toList.map(_.toInt)
      val dataList = data.toList.map(_.toInt)
      assert(dataList == decoded)
    }

    "encode e decode array generati random" - {
      import scala.util.Random
      for(j <- 1 until 100) {
        val data: Data = new Array(Random.nextInt(1000))
        for(i <- data.indices) data(i) = Random.nextBoolean
        val encoded = encode(data)
        val decoded = decode(encoded).toList.map(_.toInt)
        val dataList = data.toList.map(_.toInt)
        assert(dataList == decoded)
      }
    }

    "encode e decode con swap di un bit dei dati. Array generati random" - {
      import scala.util.Random
      for(j <- 1 until 1000) {
        val length = Random.nextInt(1000) + 1
        val data: Data = new Array(length)
        for(i <- data.indices) data(i) = Random.nextBoolean
        val encoded = encode(data)
        val (pI, dI) = parityDataIndexes(encoded.length)
        val swappedIndex = dI(Random.nextInt(dI.length))
        swapBit(encoded, swappedIndex)  // swap a random bit
        val decoded = decode(encoded).toList.map(_.toInt)
        val dataList = data.toList.map(_.toInt)
        assert(dataList == decoded)
      }
    }
  }
}
