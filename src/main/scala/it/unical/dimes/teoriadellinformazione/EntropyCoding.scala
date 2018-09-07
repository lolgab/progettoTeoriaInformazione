//package it.unical.dimes.teoriadellinformazione
//
//import teoriadellinformazione._
//
//object EntropyCoding {
//
//  def rle(d: Seq[Int]): Seq[Byte] = {
//    def toBynaryString(n: Int) = {
//      val abs = Math.abs(n)
//
//      val bin = abs.toBinaryString
//      val binLength = bin.length
//      if(abs >= 1 << (binLength - 1)) abs - binLength
//    }
//
//    val reversed = 0 :: 0 :: d
//      .foldLeft((List.empty[Int], 0)) {
//        case ((acc, count), nextInt) =>
//          if (nextInt == 0 && count == 16) (15 :: 0 :: acc, 0)
//          else if (nextInt == 0) (acc, count + 1)
//          else (count :: nextInt :: acc, 0)
//      }
//      ._1
//
//    val partial = reversed.reverse
//
//    partial.sliding(2, 2).map {
//      case List(value, zeroNum) =>
//        val valueBinary  = value.toBinaryString
//        val lengthBinary = Integer.toBinaryString()
//    }
//  }
//
//  def zigzag(m: Matrix[Int]): Array[Int] = {
//
//    val res = new Array[Int](rowLength * colLength)
//    res(0) = m(0, 0)
//    res(1) = m(0, 1)
//    res(2) = m(1, 0)
//    res(3) = m(2, 0)
//    res(4) = m(1, 1)
//    res(5) = m(0, 2)
//    res(6) = m(0, 3)
//    res(7) = m(1, 2)
//    res(8) = m(2, 1)
//    res(9) = m(3, 0)
//    res(10) = m(4, 0)
//    res(11) = m(3, 1)
//    res(12) = m(2, 2)
//    res(13) = m(1, 3)
//    res(14) = m(0, 4)
//    res(15) = m(0, 5)
//    res(16) = m(1, 4)
//    res(17) = m(2, 3)
//    res(18) = m(3, 2)
//    res(19) = m(4, 1)
//    res(20) = m(5, 0)
//    res(21) = m(6, 0)
//    res(22) = m(5, 1)
//    res(23) = m(4, 2)
//    res(24) = m(3, 3)
//    res(25) = m(2, 4)
//    res(26) = m(1, 5)
//    res(27) = m(0, 6)
//    res(28) = m(0, 7)
//    res(29) = m(1, 6)
//    res(30) = m(2, 5)
//    res(31) = m(3, 4)
//    res(32) = m(4, 3)
//    res(33) = m(5, 2)
//    res(34) = m(6, 1)
//    res(35) = m(7, 0)
//    res(36) = m(7, 1)
//    res(37) = m(6, 2)
//    res(38) = m(5, 3)
//    res(39) = m(4, 4)
//    res(40) = m(3, 5)
//    res(41) = m(2, 6)
//    res(42) = m(1, 7)
//    res(43) = m(2, 7)
//    res(44) = m(3, 6)
//    res(45) = m(4, 5)
//    res(46) = m(5, 4)
//    res(47) = m(6, 3)
//    res(48) = m(7, 2)
//    res(49) = m(7, 3)
//    res(50) = m(6, 4)
//    res(51) = m(5, 5)
//    res(52) = m(4, 6)
//    res(53) = m(3, 7)
//    res(54) = m(4, 7)
//    res(55) = m(5, 6)
//    res(56) = m(6, 5)
//    res(57) = m(7, 4)
//    res(58) = m(7, 5)
//    res(59) = m(6, 6)
//    res(60) = m(5, 7)
//    res(61) = m(6, 7)
//    res(62) = m(7, 6)
//    res(63) = m(7, 7)
//
//    res
//  }
//}
