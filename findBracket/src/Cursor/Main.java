package Cursor;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("괄호 짝 맞추기를 ListStack으로 해결해보았다.");
		
		String formula = "{(2+3)/(3-1)}+{3*(5-4)}";
		ListStack<Character> ls = new ListStack<>();
		Character cursor;
		
		for(int i=0;i<formula.length();i++) {
			cursor = formula.charAt(i);
			
			if(cursor=='(' || cursor=='{') {
				ls.push(cursor);
				ls.print();
			}
			else if(cursor==')') {
				if(ls.pop()=='(') {
					System.out.println("find () match");
				}
				else {
					throw new IllegalArgumentException();
				}
			}
			else if(cursor=='}') {
				if(ls.pop()=='{') {
					System.out.println("find {} match");
				}
				else {
					throw new IllegalArgumentException();
				}
			}
		}
		if(ls.isEmpty())
			System.out.println("succeess");
	}

}
