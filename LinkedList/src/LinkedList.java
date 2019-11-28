import java.util.NoSuchElementException;

public class LinkedList<E> { 
	
	public Node<E> head; //연결리스트의 첫 노드 head
	public int size;
		
	public LinkedList() //연결리스트 생성자
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
		
	public int search(E target) //target 아이템이  몇번째 인덱스에 있는지 탐색함
	{
		Node <E> p = head; //연결리스트의 첫노드를 p라고 하자
		for(int i=0;i<size;i++)
		{
			if(target==p.getItem()) //p의 아이템이  target이면
				return i; //index i를 리턴함
			else
				p=p.getNext(); //아닌경우 다음노드를 탐색한다.
		}
		return -1; //리스트안에 target이 없을때
	}
	public void InsertFront(E newItem) //새 노드가 리스트의 첫번째 노드가되도록 연결
	{
		Node<E> newNode = new Node<E>(newItem,head); //newNode객체 생성
		head = newNode;
		size++;
	}
	public void InsertAfter(E newItem,Node<E> p) //p의 다음에 노드를 삽입
	{
		/*Node<E> newNode = new Node<E>(newItem,p.getNext());
		p.setNext(newNode);*/
		
		p.setNext(new Node<E>(newItem,p.getNext()));
		
		//newItem이 들어있고 p.getNext를 통해 p가리키던 노드를 가리키는 새로운 노드를 생성한다.
		// p가 가리키는 노드를 setNext를 통해 해당 노드로 설정한다.
		size++;
	}
	public void deleteFront()//맨 앞으 노드를 삭제한다.
	{
		if(size==0)
			throw new NoSuchElementException();
		head = head.getNext(); // head.next 즉 맨앞의 노드가 가리키던 노드를 head노드로 변경한다.
		size--;
	}
	public void deleteAfter(Node<E> p) //p가 가리키는 다음 노드를 삭제 
	{
		if(p==null)
			throw new NoSuchElementException();
		Node<E> t = p.getNext(); //p의 다음노드를 노드 t라 하자
		p.setNext(t.getNext()); //t의 다음노드를 리턴해서 p의 다음노드로 설정한다.
		t.setNext(null); //t의 다음노드를 null로 처리한다.
		size--;
	}		
}

