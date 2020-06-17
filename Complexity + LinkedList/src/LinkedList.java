public class LinkedList<T> {

	private Node<T> head;

	public LinkedList(T value) {
		head = new Node<T>(value);
	}

	public void deleteFirst() {
		// if list is 1 node long delete that node
		if (head.getNext() == null) {
			head = null;
		}

		// else if its longer: replace current head with next.
		// head is now referenceless and will be deleted by GC
		head = head.getNext();
	}

	public void deleteLast() {
		Node<T> next = null;
		Node<T> nextNext = null;
		// goal: iterate nodes until one before last and do node.setnext = null
		
		// if head is not the only one in LinkedList
		if (head.getNext() != null) {
			next = head.getNext();
			nextNext = next;
			// while next is not last
			while (next.getNext() != null) {
				// make nextNext the last node
				nextNext = next.getNext();
				// if last node(nextNext) has no next; make the node before it point at nothing
				// (GC will collect the referenceless last node)
				if (nextNext.getNext() == null) {
					next.setNext(null);
					return;
				}
				// if nextNext isnt last continue iterating the LinkedList
				next = next.getNext();
			}
		}
	}

	public void addFirst(T value) {
		Node<T> temp = new Node<T>(value);
		temp.setNext(head);
		head = temp;
	}

	public void addLast(T value) {
		// head.setNext(new Node<T>(value));
		Node<T> temp = head;
		while (temp.getNext() != null) {
			temp = temp.getNext();
		}

		temp.setNext(new Node<T>(value));
	}

	public void printList() {
		Node<T> temp = head;
		if (head == null)
			return;

		while (temp.getNext() != null) {
			System.out.print(temp + "=>");
			temp = temp.getNext();
		}
		System.out.println(temp + "=>");
	}

}