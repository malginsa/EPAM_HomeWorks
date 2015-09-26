package HomeWork150924;

public class UseReverseList {

  public static void main(String[] args) {
	ReverseList<String> reverse_list = new ReverseList<>();

	System.out.println(reverse_list);

	reverse_list.add("One");
	reverse_list.add("Two");

	System.out.println(reverse_list);
	
	reverse_list.add("3");
	reverse_list.add("4");
	
	System.out.println(reverse_list);

  }
}
