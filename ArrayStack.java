package Stack;

import java.util.EmptyStackException;

public class ArrayStack<E> {
	
	private E s[];
	private int top;
	public int size;
	public ArrayStack()
	{
		s=(E[]) new Object[1];
		top=-1;
	}
	
	public int size() {return top+1;}
	public boolean isEmpty() {return (top==-1);}

	
	public E peek()
	{
		if(isEmpty()) 
			throw new EmptyStackException();
		return s[top];
	}
	public void push(E newItem)
	{
		if(size()==s.length)
			resize(2*s.length);
		s[++top]=newItem;
		
		size++;
	}
	public E pop() 
	{
		if(isEmpty()) throw new EmptyStackException();
		E item=s[top];
		s[top--]=null;
		size--;
		if(size()>0&&size()==s.length/4)
			resize(s.length/2);
		return item;
	}
	public void resize(int newSize)
	{
		Object[] t=new Object[newSize];
		for(int i=0;i<size;i++)
			t[i]=s[i];
		s=(E[])t;

		
		/*E[]t=(E[]) new Object[newSize];
		 * for(int i=0;i<size();i++)
		 * t[i]=s[i]
		*/
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