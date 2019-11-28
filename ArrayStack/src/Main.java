public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayStack<String> stack = new ArrayStack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		System.out.println(stack.peek());
		
		stack.push("D");
		stack.print();
		stack.pop();
		System.out.println(stack.peek());
		
		stack.push("F");
		stack.print();

	}

}
