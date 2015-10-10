package HomeWork151001;

import java.util.Iterator;

public class MyArrayStack<T> implements Iterable<T>{

	private Integer CAPACITY = 10;
	private T[] data = (T[]) new Object[CAPACITY];
	private T[] newData;
	private Integer top = -1; // index of the toppest item

	public MyArrayStack(Integer newCapacity) {
		
		this.resize(newCapacity);
		this.CAPACITY = newCapacity;
	}

	public void push(T item) {
		
		if ((size() + 1) > CAPACITY)
			this.resize(CAPACITY * 2);
		data[++top] = item;
		System.out.println("-> " + item + 
			"  top: " + top + "  CAPACITY: " + CAPACITY);
	}

	public T pop() {
		
		if (isEmpty()) 
			throw new NullPointerException("Can't pop from empty stack");
		
		T returnData = data[top--];
		System.out.println("<- " + returnData + 
			"  top: " + top + "  CAPACITY: " + CAPACITY);
		if ((size() * 4) < CAPACITY)
			resize(CAPACITY / 2);
		return returnData;
	}

	public T top() {

		if (isEmpty()) 
			throw new NullPointerException("stack is empty");
		return data[top];
		
	}
	
	public int size() {
		return top + 1;
	}
	
	public boolean isEmpty() {
		return 0 == size();
	}
	
	// iterate over stack from top to bottom
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {

			private Integer current = top;
			
			@Override
			public boolean hasNext() {
				return current >= 0;
			}

			@Override
			public T next() {
				return data[current--];
			}
			
		};
	}

	private void resize(Integer newCapacity) {
		
		if (newCapacity > Integer.MAX_VALUE) 
			throw new IllegalArgumentException("Capacity is too big");
		if (newCapacity < 1) 
			throw new IllegalArgumentException("Capacity is too small");
		
		newData = (T[])new Object[newCapacity];
		for (int i = 0; i <= top; i++) {
			newData[i] = data[i];
		}
		data = newData;
		CAPACITY = newCapacity;
		System.out.println("resized, new Capacity: " + newCapacity);
	}

	public static void main(String[] args) {
		
		MyArrayStack<Integer> stack = new MyArrayStack(2);
		
		for (int i = 0; i < 13; i++) 
			stack.push(i);

		Iterator<Integer> it1 = stack.iterator();
		System.out.print("stack: [");
		while (it1.hasNext()) {
			System.out.print(it1.next() + ", ");
		}
		System.out.println("]");
		
		System.out.println("top: " + stack.top());
		
		for (int i = 0; i < 12; i++) 
			stack.pop();

		stack.push(101);
		stack.push(102);
		
		System.out.print("stack: [");
		it1 = stack.iterator();
		for (Integer item : stack) {
			System.out.print(item + ", ");
		}
		System.out.println("]");
		
		for (int i = 0; i < 3; i++) 
			stack.pop();
		stack.push(1001);

		System.out.println("top: " + stack.top());

		stack.push(1002);
		stack.push(1003);
		for (int i = 0; i < 3; i++) 
			stack.pop();
	}
}
