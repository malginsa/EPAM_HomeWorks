package HomeWork150924;

public class Node<T> {

  private T data;
  private Node<T> next;
  
  public Node(T data) {
	this.setData(data);
  }

  public Node<T> getNext() {
	return this.next;
  }

  public void setNext(Node<T> next) {
	this.next = next;
  }

  public T getData() {
	return data;
  }

  public void setData(T data) {
	this.data = data;
  }
}
