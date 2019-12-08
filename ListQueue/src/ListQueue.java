import java.util.NoSuchElementException;

public class ListQueue<E> {
	public Node<E> rear,front; // 큐의 노드인 front와 rear를 선언
	public int size;
	
	public ListQueue() { //ListQueue의 생성자를 통해 front와rear를 null로 초기화
		front=rear=null;
		size=0;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int size() {
		return size;
	}
	public void add(E newItem) //큐에 newItem이라는 데이터를 가진 새로운 노드를 추가하는 메서드
	{
		Node<E> newNode = new Node<E>(newItem,null); 
		//newNode객체 생성한다. data = newItem 이고 가리키는 노드는 null
		if(isEmpty())
			front = newNode; // 큐가 비어있다면 front노드가 newNode가 된다.
		else
			rear.setNext(newNode); // rear노드의 다음을 newNode로 설정한다.
		rear = newNode; //그리고 newNode가 가장 마지막 노드인 rear노드가 된다.
		size++;
	}
	public E remove() //큐를 삭제, FIFO구조이므로 맨 앞의 노드를 삭제
	{
		if(isEmpty())
			throw new NoSuchElementException();
		E frontitem = front.getItem(); //front노드의 아이템을 가져온다.
		front = front.getNext(); //front의 다음노드가 front가 되도록한다.
		
		if(isEmpty())	
			rear = null; //삭제 후 리스트가 empty가 되었다면 rear를 null로 갱신한다.
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
