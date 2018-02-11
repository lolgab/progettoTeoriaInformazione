package it.unical.dimes.teoriadellinformazione

object Hamming {
  def r(n: Int): Int = {
    def loop(r: Int): Int = if(n + r + 1 <= (1 << r)) r else loop(r + 1)
    loop(1)
  }

  type Data = Array[Boolean]

  def encode(data: Data): Data = {
    def powOf2(i: Int): Boolean = (i & (i - 1)) == 0 //fails for i == 0

    val totalBits = data.length + r(data.length)
    val res = new Array[Boolean](totalBits)
    val (parityIndexes, dataIndexes) =
      0.until(totalBits)
       .partition(i => powOf2(i + 1))
       println(parityIndexes)
    for((index, i) <- dataIndexes.zipWithIndex){
      res(index) = data(i)
    }
    for(i <- parityIndexes)
      res(i) = dataIndexes.filter((j: Int) => (j & (i+1)) != 0).count(res(_) == true) % 2 != 0
    res
  }
}
