package HomeWork151005;

import java.awt.List;
import java.util.Iterator;

//import java.util.Iterator;

public class UseBoundedList {

	public static void main(String[] args) {

		MyBoundedList<String> list = new MyBoundedList<String>(2);
		try {
			list.add("one");
			list.add("two");
			list.add("three");
		} catch (ListOverflowException e) {
			System.out.println(e.getMessage());
		}
				
		for (String item : list) {
			System.out.println(item);
		}
		
	}
}