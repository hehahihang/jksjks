public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("����Ʈ ���� - �ǽ�");
		
		ListStack<String> lstack = new ListStack<String>();
		
		lstack.push("A");
		lstack.push("B");
		lstack.push("C");
		
		System.out.println("[top] ==  " + lstack.peek());
		
		lstack.push("D");
		lstack.print();
		lstack.pop();
		
		System.out.println("[top] ==  " + lstack.peek());
		
		lstack.push("F");
		lstack.print();
	}

}
