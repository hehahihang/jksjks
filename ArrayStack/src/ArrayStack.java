import java.util.EmptyStackException;

public class ArrayStack<E> {
	
	private E s[]; // 제네렉스 사용 E타입 파라미터 배열s
	private int top; //스택의 top
	public int size; //스택의 크기
	public ArrayStack()
	{
		s=(E[]) new Object[1];
		//배열 s는 모든 타입의 상위클래스인 Object타입을 E타입으로 casting한 배열이다.
		top=-1;
		//초기 생성시에 스택이 비어있으므로 -1
	}
	
	public int size() {return top+1;}
	public boolean isEmpty() {return (top==-1);}

	
	public E peek()
	{
		if(isEmpty()) 
			throw new EmptyStackException();
		return s[top];
	}
	public void push(E newItem)//E 타입의 데이터 newItem을 삽입한다.
	{
		if(size()==s.length) //스택이 가득 차 있다면 배열 크기를 2배로 조정한다.
			resize(2*s.length);
		s[++top]=newItem; // 스택이 가득 차 있지 않다면 top을 1증가시킨 배열의 위치에 newItem을 추가한다.
		
		size++;
	}
	public E pop() //스택의 top부분 배열 원소를 삭제하고 return한다.
	{
		if(isEmpty()) 
			throw new EmptyStackException(); //배열이 비어있는경우
		E item=s[top]; //배열s의 가장위의 원소를 E타입 변수 item에 저장한다.
		s[top--]=null; //그리고 배열s[top]=null로 제거하고, top은 1감소시킨다.
		size--;
		if(size()>0&&size()==s.length/4) //사이즈가 전체 길이의 1/4이 되면 배열을 1/2로 조정한다.
			resize(s.length/2);
		return item;
	}
	public void resize(int newSize) //스택의 사이즈를 조정
	{
		Object[] t=new Object[newSize]; //크기=newSize인 배열 t를 임시로 생성
		for(int i=0;i<size;i++)
			t[i]=s[i]; // 배열s의 데이터를 t에 모두 저장한다.
		s=(E[])t; //Object타입 배열t를 E타입배열로 캐스팅해서 s배열에 저장한다.
	}
	public void print()
	{
		for(int i=0;i<size;i++)
		{
			System.out.print(s[i]+" ");
		}
		System.out.println();
	}
}