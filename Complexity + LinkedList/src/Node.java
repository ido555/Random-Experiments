public class Node<T>{
	private T value;
	private Node<T> next;
	
	public Node(T value) {
		this.value = value;
	}
	public T getValue() {
		return value;
	}
	public Node<T> getNextNode() {
		return next;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public void setNextNode(Node<T> nextNode) {
		this.next = nextNode;
	}
	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
