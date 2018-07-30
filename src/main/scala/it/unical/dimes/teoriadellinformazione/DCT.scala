package it.unical.dimes.teoriadellinformazione
import teoriadellinformazione._

import scala.collection.mutable
object DCT {
  private val sqrt2 = Math.sqrt(2)
  private val cosFormulaCache: mutable.WeakHashMap[(Int, Int), Double] = mutable.WeakHashMap()

  def discreteCosineTransform(m: Matrix[Float], u: Int, v: Int, startY: Int, startX: Int) = {
    import Math.{ cos, PI }

    def alpha(v: Int) = if(v == 0) 1 / sqrt2 else 1.0

    def cosFormula(uv: Int, xy: Int) = {
      cosFormulaCache.get((uv, xy)) match {
        case None =>
          val res = cos( ( 2 * xy + 1) * uv  * PI / 16 )
          cosFormulaCache((uv, xy)) = res
          res
        case Some(res) => res
      }
    }

    val coefficient = alpha(u) * alpha(v) / 4

    var sum = 0.0
    for(x <- 0 until rowLength; y <- 0 until colLength)
      sum += m(startY + y, startX + x) * cosFormula(u, x) * cosFormula(v, y)
    coefficient * sum
  }
}
