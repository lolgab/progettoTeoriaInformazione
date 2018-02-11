package it.unical.dimes.teoriadellinformazione

import scala.reflect.ClassTag

class Matrix[T: ClassTag](protected val array: Array[T],
                          val rows: Int,
                          val cols: Int) {
  def this(rows: Int, cols: Int) =
    this(new Array[T](rows * cols), rows, cols)

  @inline def apply(i: Int, j: Int) = array(i * cols + j)
  @inline def get(i: Int, j: Int): T = apply(i, j)

  def toArray = array.toArray

  def map[U: ClassTag](f: T => U): Matrix[U] =
    new Matrix(array.map(f), rows, cols)

  def foreach(f: T => Unit): Unit = array.foreach(f)
}
