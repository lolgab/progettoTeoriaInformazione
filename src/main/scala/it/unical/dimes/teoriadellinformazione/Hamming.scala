package it.unical.dimes.teoriadellinformazione

object Hamming {
  type Data = Array[Boolean]
  def r(n: Int): Int = {
    def loop(r: Int): Int = if(n + r + 1 <= (1 << r)) r else loop(r + 1)
    loop(1)
  }
  def powOf2(i: Int): Boolean = (i & (i - 1)) == 0 //fails for i == 0
  def parityDataIndexes(totalBits: Int): (Seq[Int], Seq[Int]) =
    0.until(totalBits)
      .partition(i => powOf2(i + 1))
  def parityBit(i: Int, data: Data, dataIndexes: Seq[Int]): Boolean =
    dataIndexes.filter((j: Int) => (j & (i + 1)) != 0).count(data(_) == true) % 2 != 0
  def toInt(parities: Seq[Boolean], parityIndexes: Seq[Int]): Int =
    0.until(parities.length).foldLeft(0)((sum, i) => if(parities(i)) sum | (parityIndexes(i) + 1) else sum)

  def encode(data: Data): Data = {
    val totalBits = data.length + r(data.length)
    val res = new Data(totalBits)
    val (parityIndexes, dataIndexes) = parityDataIndexes(totalBits)
    for((index, i) <- dataIndexes.zipWithIndex) {
      res(index) = data(i)
    }
    for(i <- parityIndexes)
      res(i) = parityBit(i, res, dataIndexes)
    res
  }

  def decode(data: Data): Data = {
    val totalBits = data.length
    val (parityIndexes, dataIndexes) = parityDataIndexes(totalBits)
    val calculatedParities =
      for (i <- parityIndexes) yield parityBit(i, data, dataIndexes)
    val dataParities = parityIndexes.map(data)
    if(calculatedParities != dataParities) {
      val equalParities =
        calculatedParities
          .zip(dataParities)
          .map {
            case (a,b) =>
              a != b
          }
      val errorIndex: Int =
        toInt(equalParities, parityIndexes)
      data(errorIndex) = !data(errorIndex)
    }
    dataIndexes.map(data).toArray
  }
}