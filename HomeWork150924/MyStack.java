package HomeWork150924;

public class MyStack<T> {

  private Node<T> head;

  public void pop(T data) {
	if (null == this.head) {
	  this.head = new Node<T>(data);
	} else {
	  Node<T> tmp = new Node<>(data);
	  tmp.setNext(this.head);
	  this.head = tmp;
	}
  }

  public T push() {
	if (null == this.head)
	  return null;
	T data = this.head.getData();
	this.head = this.head.getNext();
	return data;
  }
  
  @Override
  public String toString() {
	String s = "Nodes of stack from top to bottom: [";
	Node<T> tmp = this.head;
	while (null != tmp) {
	  s += tmp.getData();
	  if (null != tmp.getNext())
		s += ", ";
	  tmp = tmp.getNext();
	}
	s += "]";
	return s;
  }

}
