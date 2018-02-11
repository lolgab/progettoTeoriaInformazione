package it.unical.dimes.teoriadellinformazione;

import it.unical.dimes.teoriadellinformazione.*;
import scala.reflect.ClassTag;

public class ProvaJava {
	public static ClassTag<RGB> rgbTag = ClassTag.apply(RGB.class);
	public static ClassTag<Float> floatTag = ClassTag.apply(Float.class);
	public static ClassTag<YCbCr> YCbCrTag = ClassTag.apply(YCbCr.class);

	public static void main(String[] args) {
		MutableMatrix<Float> m = new MutableMatrix<Float>(10,10,floatTag);
		for(int i = 0; i < m.rows(); i++) {
			for(int j = 0; j < m.cols(); j++) {
				m.set(i,j,(float) Math.random());
			}
		}

		for(int i = 0; i < m.rows(); i++) {
			for(int j = 0; j < m.cols(); j++) {
				System.out.print(m.get(i,j) + " ");
			}
			System.out.println();
		}

		RGB black = RGB.apply(0,0,0);
		RGB white = RGB.apply(255,255,255);
		YCbCr blackYCbCr = black.toYCbCr();

		System.out.println("\nblack in YCbCr = " + blackYCbCr);

		MutableMatrix<RGB> image = new MutableMatrix<RGB>(10,10, rgbTag);
		java.util.Random r = new java.util.Random();
		for(int i = 0; i < image.rows(); i++) {
		  for(int j = 0; j < image.cols(); j++) {
				RGB c = RGB.apply(r.nextInt(256),r.nextInt(256),r.nextInt(256));
				image.set(i, j, c);
			}
		}

		MutableMatrix<YCbCr> yCbCrMatrix =
		  new MutableMatrix<YCbCr>(image.rows(),image.cols(),YCbCrTag);

		for(int i = 0; i < yCbCrMatrix.rows(); i++) {
			for(int j = 0; j < yCbCrMatrix.cols(); j++) {
				YCbCr v = image.get(i,j).toYCbCr();
				yCbCrMatrix.set(i,j,v);
			}
		}
		YCbCrImage yCbCrImage = new YCbCrImage(yCbCrMatrix);

		Matrix y = yCbCrImage.y();
		Matrix cb = yCbCrImage.cb();
		Matrix cbcr = yCbCrImage.cbcr();
	}
}
