case class RGB(value: Int) extends AnyVal {
  def r = (value >> 16) & 0xff
  def g = (value >> 8) & 0xff
  def b = value & 0xff

  def toYCbCr: YCbCr = {
    new YCbCr(
      0.299F * r + 0.587F * g + 0.114F * b,
      128F - 0.16874F * r - 0.33126F * g + 0.5F * b,
      128F + 0.5F * r - 0.418688F * g - 0.081312F * b
    )
  }

  override def toString: String = s"RGB($r,$g,$b)"
}
object RGB {
  def apply(r: Int, g: Int, b: Int): RGB = new RGB(r << 16 | g << 8 | b)
}