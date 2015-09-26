package HomeWork150924;

public class ReverseList<T> {

	Node<T> first;
	Node<T> last;
	
	public void add(T data) {
		Node<T> new_node = new Node<T>(data);
		if (null==this.first) {
		  this.first = new_node;
		  this.last = new_node;
		}
		else {
		  this.last.next = new_node;
		  this.last = this.last.next;
		}
	}
	
	@Override
	public String toString() {
		String s = "[";
		Node<T> item = first;
		while (null != item) {
			s += item.data;
			if (null != item.next)
				s += ", ";
			item = item.next;
		}
		s += "]";
		return s;
	}
}
