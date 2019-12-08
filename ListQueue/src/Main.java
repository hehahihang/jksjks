
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Linked리스트로 구현한 Queue");
		ListQueue<String> LQ = new ListQueue<>();
		LQ.add("A");
		LQ.add("B");
		LQ.add("C");
		LQ.add("D");
		LQ.show();
		LQ.remove();
		LQ.show();
		LQ.add("F");
		LQ.show();

	}

}
