package it.unical.dimes.teoriadellinformazione
import teoriadellinformazione._
import Math.round

object Quantization {
  val baseQuantizationMatrix = new Matrix(
    Array(16, 11, 10, 16, 24, 40, 51, 61, 12, 12, 14, 19, 26, 58, 60, 55, 14, 13, 16, 24, 40, 57,
      69, 56, 14, 17, 22, 29, 51, 87, 80, 62, 18, 22, 37, 56, 68, 109, 103, 77, 24, 35, 55, 64, 81,
      104, 113, 92, 49, 64, 78, 87, 103, 121, 120, 101, 72, 92, 95, 98, 112, 100, 103, 99),
    rows = 8,
    cols = 8
  )

  def quantizationMatrix(q: Int): Matrix[Int] = {
    val s = if (q < 50) 5000 / q else 200 - 2 * q
    baseQuantizationMatrix.map(v => (s * v + 50) / 100)
  }

  def quantizeBlock(m: Matrix[Double],
                    res: MutableMatrix[Int],
                    startY: Int,
                    startX: Int,
                    quantizationMatrix: Matrix[Int] = baseQuantizationMatrix): Unit = {
    for (i <- 0 until rowLength; j <- 0 until colLength)
      res(startY + i, startX + j) = round(m(startY + i, startX + j) / quantizationMatrix(i, j)).toInt
    res.toMatrix
  }
}
