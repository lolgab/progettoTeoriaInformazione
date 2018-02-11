package it.unical.dimes.teoriadellinformazione

object Downsampling {
  def fourTwoTwo(m: Matrix[Float]): Matrix[Float] = {
    val res = new MutableMatrix[Float](m.rows, m.cols / 2)
    for (i <- 0 until (m.rows - 1); j <- 0 until (m.cols - 1) by 2)
      res(i, j) = (m(i, j) + m(i, j + 1)) / 2
    res.toMatrix
  }

  def fourTwoZero(m: Matrix[Float]): Matrix[Float] = {
    val res = new MutableMatrix[Float](m.rows, m.cols / 2)
    for (i <- 0.until(m.rows - 1) by 2; j <- 0.until(m.cols - 1) by 2)
      res(i, j) = (m(i, j) + m(i, j + 1) + m(i + 1, j) + m(i + 1, j + 1)) / 4
    res.toMatrix
  }
}
