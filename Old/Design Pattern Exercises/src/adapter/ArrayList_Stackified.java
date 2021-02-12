package adapter;

import java.util.ArrayList;

public class ArrayList_Stackified<E>{
	private ArrayList<E> list;

	// LIFO last in first out
	// pop from last index
	// push into first empty index
	public ArrayList_Stackified() {
		this.list = new ArrayList<E>();
	}

	public void pop() {
		if (!list.isEmpty()) {
			this.list.remove(list.size()-1);
		}
	}

	public void push(E element) {
		this.list.add(element);
	}
	@Override
	public String toString() {
		return "ArrayList_Stackified" + list;
	}
}
