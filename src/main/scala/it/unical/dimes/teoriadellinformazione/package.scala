package it.unical.dimes.teoriadellinformazione

package object teoriadellinformazione {
  val rowLength, colLength = 8
  type Data = Array[Int]
  def createEmptyData(length: Int): Data = new Array[Int](length)
}
