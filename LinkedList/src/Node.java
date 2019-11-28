
public class Node<E> {
	private Node<E> next;
	private E item;
	
	public Node(E newItem,Node<E> node)
	{
		item = newItem;
		next = node;
	}
	public E getItem() {
		return item;
	}
	public Node<E> getNext(){
		return next;
	}
	public void setItem(E newItem) {
		item = newItem;
	}
	public void setNext(Node<E> newNext) {
		next = newNext;
	}

}
