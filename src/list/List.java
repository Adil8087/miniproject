package list;

import java.io.Serializable;

public class List<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Generic node instance

	Node<T> head;
	// Data member to store length of list
	private int size;

	public List() {
		this.head = null;
		this.size = 0;
	}

	public void add(T data)

	{
		// Creating new node with given value
		Node<T> temp = new Node<>(data);
		// Checking if list is empty
		// and assigning new value to head node
		if (this.head == null) {
			head = temp;
		}
		// If list already exists
		else {
			// Temporary node for traversal
			Node<T> X = head;
			// Iterating till end of the List
			while (X.next != null) {
				X = X.next;
			}

			// Adding new valued node at the end of the list
			X.next = temp;
		}

		// Increasing length after adding new node

		size++;

	}

		
	// Returning the length of LinkedList
	public int size() {
		return this.size;
	}
	public boolean isEmpty() {
		if(this.size==0)
			return true;
		else 
			return false;
	}

	// Search Sequentially
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T> T Search(int pos) {
		if(head == null)
			return null;
		
		if (pos == 0)
			return (T) head.data;
		Node<T> current = new Node<T>(null);
		current = (Node<T>) head;

		while (pos > 0 && current != null) {
			current = current.next;
			pos--;
		}
		if (current != null)
			return (T) current.data;
		else
			return null;

	}

	// To display the LinkedList
	 @Override
	public String toString() {
		String S = "";
		Node<T> X = head;
		if (X == null)
			return S;
		while (X.next != null) {
			S += String.valueOf(X.data) + "\n";
			X = X.next;
		}
		S += String.valueOf(X.data);
		return S + "";
	}
}