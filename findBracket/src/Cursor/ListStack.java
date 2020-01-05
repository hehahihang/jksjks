package Cursor;

import java.util.NoSuchElementException;

public class ListStack<E>{
	private Node<E> top;
	private int size;
	
	public ListStack() {
		top = null;
		size = 0;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	
	public void print() {
		Node<E> p = top;
		for(int i=0;i<size();i++) {
			System.out.print(top.getItem()+"\t");
			p=p.getNext();
		}
		System.out.println();
	}
	
	public void push(E newItem) {
		Node<E> newNode = new Node<E>(newItem,top);
		top = newNode;
		size++;
	}
	public E pop(){
		if(isEmpty())
			throw new NoSuchElementException();
		E popitem = top.getItem();
		top = top.getNext();
		size--;
		return popitem;
	}
	public E peek() {
		if(isEmpty())
			throw new NoSuchElementException();
		return top.getItem();
	}
}
