package HomeWork151013;

import java.util.LinkedList;
import java.util.Queue;

public class BoundedBlockingQueue<T> {

	private Queue<T> queue = new LinkedList<>();
	private int size;
	private Object mutexIsEmpty = new Object();
	private Object mutexIsFull = new Object();

	public BoundedBlockingQueue(int size) {
		this.size = size;
	}

	public T take() {
		synchronized (mutexIsEmpty) {
			while (queue.isEmpty()) {
				try {
					System.out.println("queue is empty, waiting for putting...");
					mutexIsEmpty.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
			synchronized (mutexIsFull) {
				T item = queue.poll();
//				System.out.println("taken " + item);
				mutexIsFull.notify();
				return item;
			}
	}

	public void put(T item) {
		synchronized (mutexIsFull) {
			while (this.isFull()){
				try {
					System.out.println("queue is full, waiting for takeing...");
					mutexIsFull.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
			synchronized (mutexIsEmpty) {
				queue.offer(item);
//				System.out.println("put " + item);
				mutexIsEmpty.notify();
			}
	}

	private boolean isFull() {
		return this.size() >= this.size;
	}

	public int size() {
		return queue.size();
	}

}
