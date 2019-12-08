//���Ḯ��Ʈ�� �����ϴµ� �ʿ��� NodeŬ���� (LinkedList�� NodeŬ������ ����)

public class Node<E> {
	private Node<E> next;
	private E item;
	
	public Node(E newItem,Node<E> node)
	{
		next = node;
		item = newItem;
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
