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

        imgGrande.setRGB(i, j, (imgGrande.getRGB(i, j) & 0xFFFFFFF7) | (byte & 1))
        imgGrande.setRGB(i, j + 1, (imgGrande.getRGB(i, j + 1) & 0xFFFFFFF7) | ((byte >> 1) & 1))
        imgGrande.setRGB(i, j + 2, (imgGrande.getRGB(i, j + 2) & 0xFFFFFFF7) | ((byte >> 2) & 1))
        imgGrande.setRGB(i, j + 3, (imgGrande.getRGB(i, j + 3) & 0xFFFFFFF7) | ((byte >> 3) & 1))
        imgGrande.setRGB(i, j + 4, (imgGrande.getRGB(i, j + 4) & 0xFFFFFFF7) | ((byte >> 4) & 1))
        imgGrande.setRGB(i, j + 5, (imgGrande.getRGB(i, j + 5) & 0xFFFFFFF7) | ((byte >> 5) & 1))
        imgGrande.setRGB(i, j + 6, (imgGrande.getRGB(i, j + 6) & 0xFFFFFFF7) | ((byte >> 6) & 1))
        imgGrande.setRGB(i, j + 7, (imgGrande.getRGB(i, j + 7) & 0xFFFFFFF7) | ((byte >> 7) & 1))

        imgGrande.setRGB(i, j, (imgGrande.getRGB(i, j) & 0xFFFFF7FF) | (byte & 1))
        imgGrande.setRGB(i, j + 1, (imgGrande.getRGB(i, j + 1) & 0xFFFFF7FF) | ((byte >> 1) & 1))
        imgGrande.setRGB(i, j + 2, (imgGrande.getRGB(i, j + 2) & 0xFFFFF7FF) | ((byte >> 2) & 1))
        imgGrande.setRGB(i, j + 3, (imgGrande.getRGB(i, j + 3) & 0xFFFFF7FF) | ((byte >> 3) & 1))
        imgGrande.setRGB(i, j + 4, (imgGrande.getRGB(i, j + 4) & 0xFFFFF7FF) | ((byte >> 4) & 1))
        imgGrande.setRGB(i, j + 5, (imgGrande.getRGB(i, j + 5) & 0xFFFFF7FF) | ((byte >> 5) & 1))
        imgGrande.setRGB(i, j + 6, (imgGrande.getRGB(i, j + 6) & 0xFFFFF7FF) | ((byte >> 6) & 1))
        imgGrande.setRGB(i, j + 7, (imgGrande.getRGB(i, j + 7) & 0xFFFFF7FF) | ((byte >> 7) & 1))

        imgGrande.setRGB(i, j, (imgGrande.getRGB(i, j) & 0xFFF7FFFF) | (byte & 1))
        imgGrande.setRGB(i, j + 1, (imgGrande.getRGB(i, j + 1) & 0xFFF7FFFF) | ((byte >> 1) & 1))
        imgGrande.setRGB(i, j + 2, (imgGrande.getRGB(i, j + 2) & 0xFFF7FFFF) | ((byte >> 2) & 1))
        imgGrande.setRGB(i, j + 3, (imgGrande.getRGB(i, j + 3) & 0xFFF7FFFF) | ((byte >> 3) & 1))
        imgGrande.setRGB(i, j + 4, (imgGrande.getRGB(i, j + 4) & 0xFFF7FFFF) | ((byte >> 4) & 1))
        imgGrande.setRGB(i, j + 5, (imgGrande.getRGB(i, j + 5) & 0xFFF7FFFF) | ((byte >> 5) & 1))
        imgGrande.setRGB(i, j + 6, (imgGrande.getRGB(i, j + 6) & 0xFFF7FFFF) | ((byte >> 6) & 1))
        imgGrande.setRGB(i, j + 7, (imgGrande.getRGB(i, j + 7) & 0xFFF7FFFF) | ((byte >> 7) & 1))

    }

    ImageIO.write(imgGrande, "jpg", new File("gattoNew.jpg"))
  }
}
