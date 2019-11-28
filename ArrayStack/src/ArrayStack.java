import java.util.EmptyStackException;

public class ArrayStack<E> {
	
	private E s[]; // ���׷��� ��� EŸ�� �Ķ���� �迭s
	private int top; //������ top
	public int size; //������ ũ��
	public ArrayStack()
	{
		s=(E[]) new Object[1];
		//�迭 s�� ��� Ÿ���� ����Ŭ������ ObjectŸ���� EŸ������ casting�� �迭�̴�.
		top=-1;
		//�ʱ� �����ÿ� ������ ��������Ƿ� -1
	}
	
	public int size() {return top+1;}
	public boolean isEmpty() {return (top==-1);}

	
	public E peek()
	{
		if(isEmpty()) 
			throw new EmptyStackException();
		return s[top];
	}
	public void push(E newItem)//E Ÿ���� ������ newItem�� �����Ѵ�.
	{
		if(size()==s.length) //������ ���� �� �ִٸ� �迭 ũ�⸦ 2��� �����Ѵ�.
			resize(2*s.length);
		s[++top]=newItem; // ������ ���� �� ���� �ʴٸ� top�� 1������Ų �迭�� ��ġ�� newItem�� �߰��Ѵ�.
		
		size++;
	}
	public E pop() //������ top�κ� �迭 ���Ҹ� �����ϰ� return�Ѵ�.
	{
		if(isEmpty()) 
			throw new EmptyStackException(); //�迭�� ����ִ°��
		E item=s[top]; //�迭s�� �������� ���Ҹ� EŸ�� ���� item�� �����Ѵ�.
		s[top--]=null; //�׸��� �迭s[top]=null�� �����ϰ�, top�� 1���ҽ�Ų��.
		size--;
		if(size()>0&&size()==s.length/4) //����� ��ü ������ 1/4�� �Ǹ� �迭�� 1/2�� �����Ѵ�.
			resize(s.length/2);
		return item;
	}
	public void resize(int newSize) //������ ����� ����
	{
		Object[] t=new Object[newSize]; //ũ��=newSize�� �迭 t�� �ӽ÷� ����
		for(int i=0;i<size;i++)
			t[i]=s[i]; // �迭s�� �����͸� t�� ��� �����Ѵ�.
		s=(E[])t; //ObjectŸ�� �迭t�� EŸ�Թ迭�� ĳ�����ؼ� s�迭�� �����Ѵ�.
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