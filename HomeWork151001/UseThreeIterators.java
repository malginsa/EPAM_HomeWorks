package HomeWork151001;

//import java.awt.List;
import java.util.Iterator;
import HomeWork151001.ThreeIterators.Iterators;

public class UseThreeIterators {

	public static void main(String[] args) {

		ThreeIterators<String> list = new ThreeIterators<String>() {{
				add("one");
				add("two");
				add("three");
			}};

		for (Iterators iterator : Iterators.values()) {
			list.setCurrentIterator(iterator);

			Iterator<String> it1 = list.iterator();
			System.out.println(it1.next());
			System.out.println(it1.next());

			Iterator<String> it2 = list.iterator();
			System.out.println(it2.next());
			System.out.println();
		}

	}
}
