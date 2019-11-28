import java.util.NoSuchElementException;

public class LinkedList<E> { 
	
	public Node<E> head; //���Ḯ��Ʈ�� ù ��� head
	public int size;
		
	public LinkedList() //���Ḯ��Ʈ ������
	{
		head = null;
		size = 0;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty() {
			return size==0;
	}
	public void print()
	{
		if(isEmpty())
			throw new NoSuchElementException();
		else
		{
			Node<E> t = head;
			for(int i=0;i<size;i++)
			{
				System.out.print(t.getItem()+"  ");
				t=t.getNext();
			}
			System.out.println();
		}
	}
		
	public int search(E target) //target ��������  ���° �ε����� �ִ��� Ž����
	{
		Node <E> p = head; //���Ḯ��Ʈ�� ù��带 p��� ����
		for(int i=0;i<size;i++)
		{
			if(target==p.getItem()) //p�� ��������  target�̸�
				return i; //index i�� ������
			else
				p=p.getNext(); //�ƴѰ�� ������带 Ž���Ѵ�.
		}
		return -1; //����Ʈ�ȿ� target�� ������
	}
	public void InsertFront(E newItem) //�� ��尡 ����Ʈ�� ù��° ��尡�ǵ��� ����
	{
		Node<E> newNode = new Node<E>(newItem,head); //newNode��ü ����
		head = newNode;
		size++;
	}
	public void InsertAfter(E newItem,Node<E> p) //p�� ������ ��带 ����
	{
		/*Node<E> newNode = new Node<E>(newItem,p.getNext());
		p.setNext(newNode);*/
		
		p.setNext(new Node<E>(newItem,p.getNext()));
		
		//newItem�� ����ְ� p.getNext�� ���� p����Ű�� ��带 ����Ű�� ���ο� ��带 �����Ѵ�.
		// p�� ����Ű�� ��带 setNext�� ���� �ش� ���� �����Ѵ�.
		size++;
	}
	public void deleteFront()//�� ���� ��带 �����Ѵ�.
	{
		if(size==0)
			throw new NoSuchElementException();
		head = head.getNext(); // head.next �� �Ǿ��� ��尡 ����Ű�� ��带 head���� �����Ѵ�.
		size--;
	}
	public void deleteAfter(Node<E> p) //p�� ����Ű�� ���� ��带 ���� 
	{
		if(p==null)
			throw new NoSuchElementException();
		Node<E> t = p.getNext(); //p�� ������带 ��� t�� ����
		p.setNext(t.getNext()); //t�� ������带 �����ؼ� p�� �������� �����Ѵ�.
		t.setNext(null); //t�� ������带 null�� ó���Ѵ�.
		size--;
	}		
}

