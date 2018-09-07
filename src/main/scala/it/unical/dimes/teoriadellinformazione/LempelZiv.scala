package it.unical.dimes.teoriadellinformazione
import collection.mutable

class LempelZiv(bufferSize:Int, window: Int) {
  import teoriadellinformazione._

  def encode(data: Data): Data = {
    var pos = 0
    val buffer = mutable.ListBuffer[Int]()
    while(pos < data.length) {
      val (matchIndex, matchLength) = longestMatch(data, pos)
      buffer += matchIndex
      buffer += matchLength
      val nextDataIndex = pos + matchLength
      buffer += (if(nextDataIndex < data.length) data(nextDataIndex) else -1)
      pos += 1 + matchLength
    }
    buffer.toArray
  }

  def decode(data: Data): Data = {
    var pos = 0
    var pos2 = 0
    val buffer = mutable.ListBuffer[Int]()
    while(pos + 2 < data.length) {
      val (matchIndex, matchLength, d) = (data(pos),data(pos+1),data(pos+2))
      for(i <- 0 until matchLength) buffer += buffer(pos2 - matchIndex + i)
      buffer += d
      pos += 3
      pos2 += matchLength+1
    }
    buffer.toArray
  }

  type Index  = Int
  type Length = Int
  def longestMatch(data: Data, pos: Int): (Index, Length) = {
    var matching = (0, 0)
    val startIndex = {
      val p = pos - window
      if(p > 0) p else 0
    }
    val endIndex = {
      val p = pos + window
      if(p < data.length) p else data.length - 1
    }
    for(i <- (startIndex until pos).reverse) {
      var j = 0
      while(pos + j < endIndex && i + j < pos && data(pos + j) == data(i + j)) j += 1
      if(j > matching._2) matching =  (pos-i, j)
    }
    matching
  }
}
