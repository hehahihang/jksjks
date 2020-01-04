
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayQueue<String> queue = new ArrayQueue<>();
		queue.add("apple");
		queue.add("orange");
		queue.add("cherry");
		queue.add("pear");
		queue.print();
		queue.remove();
		queue.print();
		queue.add("lemon");
		queue.print();
		queue.add("mango");
		queue.print();
		queue.remove();
		queue.print();
	}

}
