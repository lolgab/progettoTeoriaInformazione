import default._
object DCT {
  def discreteCosineTransform(m: Matrix[Float], u: Int, v: Int, startY: Int, startX: Int) = {
    import Math.{ cos, PI }
    def alpha(v: Int) = if(v == 0) 1 / Math.sqrt(2) else 1
    def cosFormula(uv: Int, xy: Int) = cos( ( 2 * xy + 1) * uv  * PI / 16 )

    val coefficient = alpha(u) * alpha(v) / 4

    var sum = 0.0
    for(x <- 0 until rowLength; y <- 0 until colLength)
      sum += m(startY + y, startX + x) * cosFormula(u, x) * cosFormula(v, y)
    coefficient * sum
  }
}