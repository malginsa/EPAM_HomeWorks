package HomeWork150924;

import java.util.List;

public class UseMyStack {

	public static void main(String[] args) {

		MyStack<Integer> digits = new MyStack<>();
		System.out.println(digits);
		digits.pop(1);
		System.out.println("added 1");
		System.out.println(digits);
		digits.pop(2);
		System.out.println("added 2");
		digits.pop(3);
		System.out.println("added 3");
		System.out.println(digits);

		System.out.println("extracted: " + digits.push());
		System.out.println(digits);
		System.out.println("extracted: " + digits.push());
		System.out.println("extracted: " + digits.push());
		System.out.println(digits);

		System.out.println("extracted: " + digits.push());
		System.out.println(digits);

		digits.pop(11);
		System.out.println("added 11");
		System.out.println(digits);

		System.err.println();
		MyStack<Character> letters = new MyStack<>();
		System.out.println(letters);
		System.out.println("extracted: " + letters.push());
		System.out.println(letters);
	}
}
