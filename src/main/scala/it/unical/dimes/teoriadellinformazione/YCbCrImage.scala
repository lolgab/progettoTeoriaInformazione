package it.unical.dimes.teoriadellinformazione

class YCbCrImage(pixels: Matrix[YCbCr]) {
  lazy val y:  Matrix[Float] = pixels.map(_.y)
  lazy val cr: Matrix[Float] = pixels.map(_.cr)
  lazy val cb: Matrix[Float] = pixels.map(_.cb)
}
