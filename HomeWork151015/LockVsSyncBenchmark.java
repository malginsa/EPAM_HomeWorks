package HomeWork151015;

// Compare Lock vs synchronized benchmark

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import lesson151008.Utils;

public class LockVsSyncBenchmark {

	static public class Counter {

		public int count;

		private Object mutex = new Object();
		private Lock lock = new ReentrantLock();
		
		public void inc_synchronized() {
			for (int i = 0; i < 100_000_000; i++) {
				synchronized (mutex) {
					count++;
				}
			}
		}

		public void inc_lock() {
			for (int i = 0; i < 100_000_000; i++) {
				lock.lock();
				try {
					count++;
				} finally {
					lock.unlock();
				}
			}

		}

	}

	public static void main(String[] args) {

		Counter counter = new Counter();

		long start = System.nanoTime();
		counter.inc_synchronized();
		long stop = System.nanoTime();
		System.out.println("using syncronized took: " 
			+ (stop - start)/1_000_000_000. + " seconds");
		
		counter.count = 0;
		
		start = System.nanoTime();
		counter.inc_lock();
		stop = System.nanoTime();
		System.out.println("using lock took: " 
			+ (stop - start)/1_000_000_000. + " seconds");
		
	}
}
