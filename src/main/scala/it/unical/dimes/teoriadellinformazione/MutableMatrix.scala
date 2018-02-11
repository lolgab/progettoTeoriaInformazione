package it.unical.dimes.teoriadellinformazione

import scala.reflect.ClassTag

class MutableMatrix[T: ClassTag](rows: Int, cols: Int) extends Matrix(rows, cols) {
  @inline def update(i: Int, j: Int, v: T): Unit = array(i * cols + j) = v
  @inline def set(i: Int, j: Int, v: T): Unit = update(i, j, v)

  def toMatrix: Matrix[T] = this.asInstanceOf[Matrix[T]]
}
