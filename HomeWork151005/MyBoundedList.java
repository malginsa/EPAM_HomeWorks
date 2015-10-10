package HomeWork151005;

import java.util.Iterator;

public class MyBoundedList<T> implements Iterable<T> {

	private class Node {
		T data;
		Node next;
	}

	private Node first;
	private int size;
	private int maxSize;

	public MyBoundedList(int maxSize) {
		if (maxSize <= 0)
			throw new IllegalArgumentException();
		this.maxSize = maxSize;
		size = 0;
	}

	public void add(T data) throws ListOverflowException {
		if (size >= maxSize) {
			throw new ListOverflowException("Overflow: max size = " + maxSize);
		}
		Node node = new Node();
		node.data = data;
		node.next = first;
		this.first = node;
		size++;
	}

	@Override
	public String toString() {
		String s = "[";
		Node temp = first;
		while (temp != null) {
			s += temp.data;
			if (temp.next != null)
				s += ", ";
			temp = temp.next;
		}
		s += "]";
		return s;
	}

	public Iterator<T> iterator() {
		
		return new Iterator<T>() {
			Node current = first;
			
			@Override
			public boolean hasNext() {
				return null != current;
			}

			@Override
			public T next() {
				T data = current.data;
				current = current.next;
				return data;
			}

			@Override
			public void remove() {}
		};
	}

}
