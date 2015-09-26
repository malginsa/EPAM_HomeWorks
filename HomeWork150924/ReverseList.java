package HomeWork150924;

public class ReverseList<T> {

	private Node<T> first;
	private Node<T> last;
	
	public void add(T data) {
		Node<T> new_node = new Node<T>(data);
		if (null==this.first) {
		  this.first = new_node;
		  this.last = new_node;
		}
		else {
		  this.last.setNext(new_node);
		  this.last = this.last.getNext();
		}
	}
	
	@Override
	public String toString() {
		String s = "[";
		Node<T> item = first;
		while (null != item) {
			s += item.getData();
			if (null != item.getNext())
				s += ", ";
			item = item.getNext();
		}
		s += "]";
		return s;
	}
}
