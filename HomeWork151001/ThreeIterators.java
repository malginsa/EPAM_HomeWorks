package HomeWork151001;

import java.util.Iterator;

public class ThreeIterators<T> implements Iterable<T> {

	enum Iterators { INNER_CLASS, LOCAL_CLASS }

	private Iterators currentIterator = Iterators.INNER_CLASS;

	private class Node {
		T data;
		Node next;
	}

	Node first;

	public void add(T data) {
		Node node = new Node();
		node.data = data;
		node.next = first;
		this.first = node;
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

	public void setCurrentIterator(Iterators currentIterator) {
		this.currentIterator = currentIterator;
	}

	public Iterator<T> iterator() {
		switch (this.currentIterator) {
		case INNER_CLASS:
			return new InnerIterator();
		case LOCAL_CLASS:
			return LocalIterator();
		default:
			throw new NullPointerException();
		}
	}

	
	class InnerIterator implements Iterator<T> {

		private Node current = first;

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
		public void remove() {
		}
	}

	
	public Iterator<T> LocalIterator() {

		class LocalIterator implements Iterator<T> {

			private Node current = first;

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
			public void remove() {
			}
		}

		return new LocalIterator();
	}

}
