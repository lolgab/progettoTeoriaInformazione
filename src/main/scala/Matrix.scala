import collection.mutable.ArrayBuffer
import scala.reflect.ClassTag

class Matrix[T: ClassTag](protected val array: ArrayBuffer[T],
                                    val rows: Int,
                                    val cols: Int) {
  def this(rows: Int, cols: Int) =
    this(new ArrayBuffer[T](rows * cols), rows, cols)

  def apply(i: Int, j: Int) = array(i * cols + j)

  def toArray = array.toArray

  def map[U: ClassTag](f: T => U): Matrix[U] = new Matrix(array.map(f), rows, cols)

  def foreach(f: T => Unit): Unit = array.foreach(f)
}