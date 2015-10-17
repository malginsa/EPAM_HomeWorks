package HomeWork151008;

// Generate elements of matrix in threads

import java.util.Iterator;
import java.util.Random;

import org.omg.SendingContext.RunTime;

public class GenerateInThreads {

	static final int rows = 10;
	static final int cols = 8_000_000;
	
	public static void main(String[] args) {


		long start = System.nanoTime();
		double[][] matrix = generate();
		long stop = System.nanoTime();
		System.out.println("generated without threads = " + (stop - start) / 1_000_000_000. + " secs");

		matrix = null;
		System.gc();

		start = System.nanoTime();
		matrix = generateSeparate();
		stop = System.nanoTime();
		System.out.println("generated in threads = " + (stop - start) / 1_000_000_000. + " secs");

	}

	private static double[][] generate() {
		// Generate in main thread
		Random random = new Random();

		double[][] matrix = new double[rows][cols];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = random.nextDouble();
			}
		}

		return matrix;
	}

	private static double[][] generateSeparate() {
		// Generate in threads

		Thread[] threads = new Thread[rows];
		double[][] matrix = new double[rows][];

		for (int i = 0; i < rows; i++) {
			final int i2 = i;
			threads[i] = new Thread() {
				@Override
				public void run() {
					matrix[i2] = generateRow();
				}
			};
			threads[i].start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		return matrix;
	}

	private static double[] generateRow() {
		Random random = new Random();
		double[] ds = new double[cols];
		for (int i = 0; i < ds.length; i++) {
			ds[i] = random.nextDouble();
		}
		return ds;
	}

}
