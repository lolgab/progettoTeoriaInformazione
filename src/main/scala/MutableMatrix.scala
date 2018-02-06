import scala.reflect.ClassTag

class MutableMatrix[T: ClassTag](rows: Int, cols: Int) extends Matrix(rows, cols) {
  def update(i: Int, j: Int, v: T): Unit = array(i * cols + j) = v

  def toMatrix: Matrix[T] = this.asInstanceOf[Matrix[T]]
}