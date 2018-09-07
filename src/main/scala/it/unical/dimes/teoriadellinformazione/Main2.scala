package it.unical.dimes.teoriadellinformazione

import java.io._

import javax.imageio.ImageIO

object Main2 {

  def main(args: Array[String]): Unit = {
    val imgGrande  = ImageIO.read(new File(args(0)))
    val imgPiccola = new FileInputStream(new File(args(1)))

    for (i <- 0 until imgGrande.getWidth; j <- 0 until imgGrande.getHeight by 8) {
      val byte  = imgPiccola.read()
      val byte1 = imgPiccola.read()
      val byte2 = imgPiccola.read()

      val rgb = imgGrande.getRGB(i, j)

      for (k <- 0 until 8) {
        imgGrande.setRGB(
          i,
          j + k,
          (rgb & 0xFFF7F7F7) | ((byte >> k) & 1) | (((byte1 >> k) & 1) << 8) | (((byte2 >> k) & 1) << 16))
      }
    }

    ImageIO.write(imgGrande, "jpg", new File("gattoNew.jpg"))
  }
}
