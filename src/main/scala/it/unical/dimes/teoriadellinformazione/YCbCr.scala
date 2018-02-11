package it.unical.dimes.teoriadellinformazione

import Math.round
case class YCbCr(y: Float, cb: Float, cr: Float) {
  def toRGB: RGB = RGB(
    round(y + 1.402F * (cr - 128F)).toInt,
    round(y - 0.344136F * (cb - 128F) - 0.714136F * (cr - 128F)).toInt,
    round(y + 1.772F * (cb - 128F)).toInt
  )
}
