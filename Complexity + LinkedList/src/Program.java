public class Program {
	public static void main(String[] args) {
//		Node<String> node1 = new Node<String>("hello");
//		Node<Integer> node2 = new Node<Integer>(10);
		
		LinkedList<Integer> myList = new LinkedList<Integer>(new Node<Integer>(1));
		myList.addLast(2);
		myList.addLast(3);
		myList.addLast(4);
		myList.addLast(5);
		myList.addLast(6);
		myList.printList();
	}
}
