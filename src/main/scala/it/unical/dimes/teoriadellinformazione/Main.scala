package it.unical.dimes.teoriadellinformazione

import java.io.File

import javax.imageio.ImageIO

object Main {
  val blockSize = 8

  def main(args: Array[String]): Unit = {
    val imgGrande = ImageIO.read(new File(args(0)))

    val rgb = BufferedImageOps.toRGBMatrix(imgGrande)

    val yCbCr = rgb.map(_.toYCbCr)

    val y  = yCbCr.map(_.y)
    val cb = yCbCr.map(_.cb)
    val cr = yCbCr.map(_.cr)

    val cbDownsampled = Downsampling.fourTwoTwo(cb)
    val crDownsampled = Downsampling.fourTwoTwo(cr)

    val yDCT = new MutableMatrix[Double](y.rows, y.cols)

    for (i <- 0 until y.rows by blockSize; j <- 0 until y.cols by blockSize; u <- 0 until blockSize; v <- 0 until blockSize) {
      yDCT(i + u, j + v) = DCT.discreteCosineTransform(y, u, v, i, j)
    }
//
//    val quantizedY = new MutableMatrix[Int](yDCT.rows, yDCT.cols)
//    for (i <- 0 until y.rows by blockSize; j <- 0 until y.cols by blockSize) {
//      Quantization.quantizeBlock(yDCT.toMatrix, quantizedY, i, j)
//    }
//
//    for(i <- 0 until blockSize; j <- 0 until blockSize) {
//      println(s"quantizedY($i,$j) = ${quantizedY(i,j)}")
//    }

  }
}
