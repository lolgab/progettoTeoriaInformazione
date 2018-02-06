class YCbCrImage(pixels: Matrix[YCbCr]) {
  val y:  Matrix[Float] = pixels.map(_.y)
  val cr: Matrix[Float] = pixels.map(_.cr)
  val cb: Matrix[Float] = pixels.map(_.cb)
}