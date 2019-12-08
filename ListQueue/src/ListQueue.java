import java.util.NoSuchElementException;

public class ListQueue<E> {
	public Node<E> rear,front; // ť�� ����� front�� rear�� ����
	public int size;
	
	public ListQueue() { //ListQueue�� �����ڸ� ���� front��rear�� null�� �ʱ�ȭ
		front=rear=null;
		size=0;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	public void add(E newItem) //ť�� newItem�̶�� �����͸� ���� ���ο� ��带 �߰��ϴ� �޼���
	{
		Node<E> newNode = new Node<E>(newItem,null); 
		//newNode��ü �����Ѵ�. data = newItem �̰� ����Ű�� ���� null
		if(isEmpty())
			front = newNode; // ť�� ����ִٸ� front��尡 newNode�� �ȴ�.
		else
			rear.setNext(newNode); // rear����� ������ newNode�� �����Ѵ�.
		rear = newNode; //�׸��� newNode�� ���� ������ ����� rear��尡 �ȴ�.
		size++;
	}
	public E remove() //ť�� ����, FIFO�����̹Ƿ� �� ���� ��带 ����
	{
		if(isEmpty())
			throw new NoSuchElementException();
		E frontitem = front.getItem(); //front����� �������� �����´�.
		front = front.getNext(); //front�� ������尡 front�� �ǵ����Ѵ�.
		
		if(isEmpty())	
			rear = null; //���� �� ����Ʈ�� empty�� �Ǿ��ٸ� rear�� null�� �����Ѵ�.
		size--;
		return frontitem;
	}
	
	public void show() 
	{
		Node<E> t = front;
		for(int i=0;i<size;i++)
		{
			System.out.print(t.getItem()+" ");
			t = t.getNext();
		}
		System.out.println();
	}
}
