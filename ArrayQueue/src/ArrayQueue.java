/*�迭�� ���� ť�� �����ߴ�.
 ť : ���԰� ������ �� ������ ���� ����Ǵ� �ڷᱸ�� FIFO
- ť�� �迭�� �����ϴ� ��� ���԰� ������ ������ �� ť�� item���� ���ʿ��� ����
front�� �ε����� ����ؼ� Ŀ����. 

�ذ� 1.ť�� item���� ������ �̵��Ѵ�.-> ����ð��� ���
�ذ� 2.ť�� �������� �����Ѵ�. -> ����ִ��� empty�˻縦 ���� �ʾ� ȿ���� ����.
�������� �����ϸ� ť�� ������� 0���ε����� �׻� �������
 */

import java.util.NoSuchElementException;

public class ArrayQueue<E> {
	private E [] q;
	private int front,rear,size;
	public ArrayQueue() {
		q = (E[])new Object[2]; //front�� rear�� �����Ƿ� �ʱ� ũ��=2
		front = rear = size = 0; //0���� �ʱ�ȭ���ش�
	}
	public int size() {return size;}
	public boolean isEmpty() {return (size==0);} 
	
	//ť�� item �߰�
	public void add(E newItem) {
		if((rear+1)%q.length==front){//���� ť�� �� �� ������ 
			resize(2*q.length);	
		}
			//rear���� ������ �ε����� front�� ������ overflow�� �߻��Ѱ��̹Ƿ�
			//resize �޼��带 �ҷ� �迭�� 2��� Ȯ��
		rear = (rear+1)%q.length;
		q[rear] = newItem;
		size++;
	}
	
	//ť�� ����ִ� item����
	public E remove() {
		if(isEmpty()) 
			throw new NoSuchElementException();
		front = (front+1)%q.length; 
		//front�� �׻� null�� ����Ű�Ƿ� �� ���� item�� �ִ� ���� front�� �����ش�.
		E item = q[front];
		//����� queue�� front�� �ִ� item
		q[front] = null; //������ �÷����� ���� nulló���Ѵ�.
		size--;
		if(size>0 && size ==q.length/4)
			resize(q.length/2);
		return item;
	}
	
	//����� �����ϴ°��
	private void resize(int newSize) {
		Object [] t = new Object[newSize];
		for(int i=1,j=front+1;i<size+1;i++,j++) {
			t[i] = q[j%q.length];
		}
		front = 0;
		rear = size;
		q = (E[])t;
	}
	public void print() {
		for(int i=0;i<q.length;i++)
		{
			System.out.print(q[i]+"\t");
		}
		System.out.println();
	}
}
