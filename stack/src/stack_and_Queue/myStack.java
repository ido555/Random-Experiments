package stack_and_Queue;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class myStack<T> {
	
	private List<T> array;
	private int lastIndex = 0;
	
	public myStack() {
		array = new ArrayList<T>(10);
	}
	
	// lifo - last in first out
	public T pop() throws EmptyStackException{
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		// decrease one from lastIndex and return the value at that position
		T  value = array.get(--lastIndex);
		// delete the value
		array.remove(lastIndex);
		// return the value
		return value;
	}

	public void push(T value) {
		// add new value to the last empty index
		array.add(lastIndex, value);
		// increase the last index position
		lastIndex++;
	}

	public boolean isEmpty() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return lastIndex == 0;
	}

	public T peek() {
		return array.get(lastIndex-1);
	}
}
