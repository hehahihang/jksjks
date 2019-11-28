
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<String> LS = new LinkedList<>();
		LS.InsertFront("A");
		LS.InsertFront("B");
		LS.InsertAfter("C", LS.head.getNext());
		LS.InsertFront("K");
		LS.print();
		
		System.out.println("리스트의 길이 "+LS.size);
		System.out.println("A는 "+LS.search("A")+"에 있다");
		System.out.println("K는 "+LS.search("K")+"에 있다");
		
		LS.deleteAfter(LS.head);
		LS.print();
		System.out.println("리스트의 길이 "+LS.size);
		LS.deleteFront();
		LS.print();
		System.out.println("리스트의 길이 "+LS.size);
		
		System.out.println();
		
		LinkedList<Integer> LI = new LinkedList<>();
		LI.InsertFront(1);
		LI.InsertFront(2);
		LI.InsertFront(3);
		LI.InsertFront(4);
		LI.print();
		LI.InsertAfter(7, LI.head);
		LI.InsertAfter(5, LI.head.getNext());
		LI.InsertAfter(6, LI.head.getNext().getNext());
		LI.print();
		
		System.out.println("리스트의 길이 "+LI.size);

	}

}
