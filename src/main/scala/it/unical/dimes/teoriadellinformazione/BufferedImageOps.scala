package it.unical.dimes.teoriadellinformazione

import java.awt.image.BufferedImage

object BufferedImageOps {
  def toRGBMatrix(image: BufferedImage): Matrix[RGB] = {
    val w = image.getWidth
    val h = image.getHeight

    val m = new MutableMatrix[RGB](w,h)

    for (i <- 0 until w; j <- 0 until h) {
      m(i, j) = RGB(image.getRGB(i,j))
    }

    m.toMatrix
  }

}
