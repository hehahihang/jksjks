import java.util.EmptyStackException;

public class ListStack<E> {
	private Node<E> top; //스택의 top을 가진 Node를 만듬
	private int size; //리스트의 개수
	
	public ListStack() //스택의 생성자
	{
		top = null;
		size =0;
	}
	public int size() { // size == 리스트의 개수
		return size;
	}
	public boolean isEmpty() { //스택이 비어있으면 true를 리턴한다.
		return size==0;
	}
	public void push(E newItem)
	{
		Node<E> newNode = new Node<E>(newItem,top); 
		//newNode객체 생성, newItem을 newNode에 저장하고, top이 가진 참조(top)을 next에 복사 
		top = newNode; //top이 newNode노드를 가리킨다.
		size++; //리스트의 개수 1증가
		//새 노드를 연결리스트의 가장 앞에 삽입하는 push
	}
	public E pop() 
	{
		if(isEmpty())
			throw new EmptyStackException();
		E topitem = top.getItem(); //top의 item을 topitem에 저장한다.
		top = top.getNext(); //top이 top의 바로 아래를 가리키도록 함
		size--;
		return topitem;
	}
	public E peek()
	{
		if(isEmpty())
			throw new EmptyStackException();
		return top.getItem(); //top위치에 있는 list의 item을 리턴한다.
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
