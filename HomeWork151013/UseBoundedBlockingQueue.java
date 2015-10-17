package HomeWork151013;

import java.util.Date;
import java.util.Random;

import lesson151008.Utils;

public class UseBoundedBlockingQueue {

	static Random random = new Random();

	static class Producer implements Runnable {

		private BoundedBlockingQueue<Long> queue;

		public Producer(BoundedBlockingQueue<Long> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				Utils.pause(random.nextInt(1_000));
				Long item = System.nanoTime(); 
				queue.put(item);
				System.out.println(" + produced "+ item +", total: " + queue.size());
			}
		}
		
	}

	static class Consumer implements Runnable {

		private BoundedBlockingQueue<Long> queue;

		public Consumer(BoundedBlockingQueue<Long> queue) {
			this.queue = queue;
		}

		@Override
		public void run() {
			while (true) {
				Utils.pause(random.nextInt(1_000));
				Long item = queue.take();
				System.err.println(" - consumed "+ item +", total: " + queue.size());
			}
		}

	}

	public static void main(String[] args) {

		BoundedBlockingQueue<Long> queue = new BoundedBlockingQueue<>(2);

		new Thread(new Producer(queue)).start();
//		Utils.pause(10_000);
		new Thread(new Consumer(queue)).start();
	}
}
