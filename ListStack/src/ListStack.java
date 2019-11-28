import java.util.EmptyStackException;

public class ListStack<E> {
	private Node<E> top; //������ top�� ���� Node�� ����
	private int size; //����Ʈ�� ����
	
	public ListStack() //������ ������
	{
		top = null;
		size =0;
	}
	public int size() { // size == ����Ʈ�� ����
		return size;
	}
	public boolean isEmpty() { //������ ��������� true�� �����Ѵ�.
		return size==0;
	}
	public void push(E newItem)
	{
		Node<E> newNode = new Node<E>(newItem,top); 
		//newNode��ü ����, newItem�� newNode�� �����ϰ�, top�� ���� ����(top)�� next�� ���� 
		top = newNode; //top�� newNode��带 ����Ų��.
		size++; //����Ʈ�� ���� 1����
		//�� ��带 ���Ḯ��Ʈ�� ���� �տ� �����ϴ� push
	}
	public E pop() 
	{
		if(isEmpty())
			throw new EmptyStackException();
		E topitem = top.getItem(); //top�� item�� topitem�� �����Ѵ�.
		top = top.getNext(); //top�� top�� �ٷ� �Ʒ��� ����Ű���� ��
		size--;
		return topitem;
	}
	public E peek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		return top.getItem(); //top��ġ�� �ִ� list�� item�� �����Ѵ�.
	}
	public void print()
	{
		System.out.println("top---------->bottom");
		Node<E> p = top;
		for(int i=0;i<size;i++)
		{
			System.out.print(p.getItem()+"  ");
			p=p.getNext();
		}
		System.out.println();
	}
}
