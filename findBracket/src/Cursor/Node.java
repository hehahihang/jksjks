package Cursor;

public class Node<E> {
	private E item;
	private Node<E> next;
	
	public Node(E newItem,Node<E> node) {
		item = newItem;
		next = node;
	}
	
	public E getItem() {
		return item;
	}
	public Node<E> getNext(){
		return next;
	}
	public void setNext(Node<E> newNext) {
		next = newNext;
	}
	public void setItem(E newItem) {
		item = newItem;
	}

}
