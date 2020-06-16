
public class LinkedList<T> {
	private Node<T> head;

	public LinkedList(Node<T> firstNode) {
		this.head = firstNode;
	}
	
	public void addFirst(T value) {
		Node<T> temp = new Node<T>(value);
		temp.setNextNode(head);
		head = temp;
	}
	
	public void addLast(T value) {
		Node<T> temp = head;
		while(temp.getNextNode() != null) {
			temp = temp.getNextNode();
		}
		temp.setNextNode(new Node<T>(value));
	}
	
	public void printList() {
		Node<T> temp = head;
		while(temp.getNextNode() != null) {
			System.out.print(temp + "=>");
			temp = temp.getNextNode();
		}
		System.out.print(temp + "=>");
	}
}
