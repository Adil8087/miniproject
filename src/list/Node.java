package list;

import java.io.Serializable;

public class Node<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// Data members
	public T data;
	public Node<T> next;

	// Parameterized constructor to assign value

	public Node(T data)

	{

		this.data = data;
		this.next = null;

	}
}