/*배열로 원형 큐를 구현했다.
 큐 : 삽입과 삭제가 양 끝에서 각각 수행되는 자료구조 FIFO
- 큐를 배열로 구현하는 경우 삽입과 삭제가 많아질 시 큐의 item들이 뒤쪽에만 남아
front의 인덱스가 계속해서 커진다. 

해결 1.큐의 item들을 앞으로 이동한다.-> 수행시간이 길다
해결 2.큐를 원형으로 생성한다. -> 비어있는지 empty검사를 하지 않아 효율이 좋다.
원형으로 생성하면 큐의 가장앞으 0번인덱스는 항상 비어있음
 */

import java.util.NoSuchElementException;

public class ArrayQueue<E> {
	private E [] q;
	private int front,rear,size;
	public ArrayQueue() {
		q = (E[])new Object[2]; //front와 rear가 있으므로 초기 크기=2
		front = rear = size = 0; //0으로 초기화해준다
	}
	public int size() {return size;}
	public boolean isEmpty() {return (size==0);} 
	
	//큐에 item 추가
	public void add(E newItem) {
		if((rear+1)%q.length==front){//원형 큐가 꽉 차 있을떄 
			resize(2*q.length);	
		}
			//rear다음 원소의 인덱스가 front와 같으면 overflow가 발생한것이므로
			//resize 메서드를 불러 배열을 2배로 확장
		rear = (rear+1)%q.length;
		q[rear] = newItem;
		size++;
	}
	
	//큐에 들어있는 item삭제
	public E remove() {
		if(isEmpty()) 
			throw new NoSuchElementException();
		front = (front+1)%q.length; 
		//front는 항상 null을 가리키므로 그 다음 item이 있는 곳을 front로 정해준다.
		E item = q[front];
		//출력할 queue의 front에 있는 item
		q[front] = null; //가비지 컬렉션을 위해 null처리한다.
		size--;
		if(size>0 && size ==q.length/4)
			resize(q.length/2);
		return item;
	}
	
	//사이즈를 조정하는경우
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
