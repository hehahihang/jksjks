/*[���ؾ˰���][������������]
����
����� ������ �� �����־�� �Ѵ�. ��� ��, ���� ��� �׸��� ���� ��ȣ�� ������ ��ȣó�� ���̴�.

�������� �ӹ��� � ���ڿ��� �־����� ��, ��ȣ���� ������ �� ������ �ִ��� �Ǵ��ϴ� ���α׷��� ¥�� ���̴�.

���ڿ��� ���ԵǴ� ��ȣ�� �Ұ�ȣ("()") �� ���ȣ("[]")�� 2�����̰�, ���ڿ��� ������ �̷�� ������ �Ʒ��� ����.

��� ���� �Ұ�ȣ("(")�� ������ �Ұ�ȣ(")")�͸� ¦�� �̷� �� �ִ�.
��� ���� ���ȣ("[")�� ������ ���ȣ("]")�͸� ¦�� �̷� �� �ִ�.
��� ������ ��ȣ���� �ڽŰ� ¦�� �̷� �� �ִ� ���� ��ȣ�� �����Ѵ�.
��� ��ȣ���� ¦�� 1:1 ��Ī�� �����ϴ�. ��, ��ȣ �ϳ��� �� �̻��� ��ȣ�� ¦�������� �ʴ´�.
¦�� �̷�� �� ��ȣ�� ���� ��, �� ���̿� �ִ� ���ڿ��� ������ ������ �Ѵ�.
�����̸� ���� ���ڿ��� �־����� �� �������� ���ڿ����� �ƴ����� �Ǵ��غ���.

�Է�
�ϳ� �Ǵ� �����ٿ� ���ļ� ���ڿ��� �־�����. �� ���ڿ��� ���� ���ĺ�, ����, �Ұ�ȣ("( )") ���ȣ("[ ]")������ �̷���� ������, ���̴� 100���ں��� �۰ų� ����.

�Է��� ������������ �� �������� �� �ϳ�(".")�� ���´�.
���
�� �ٸ��� �ش� ���ڿ��� ������ �̷�� ������ "yes"��, �ƴϸ� "no"�� ����Ѵ�.

�����Է�1                                                                	�������
So when I die (the [first] I will see in (heaven) is a score list).		yes
[ first in ] ( first out ).												yes
Half Moon tonight (At least it is better than no Moon at all].			no
A rope may form )( a trail in a maze.									no
Help( I[m being held prisoner in a fortune cookie factory)].			no
([ (([( [ ] ) ( ) (( ))] )) ]).											yes
 .																		yes	
.																		����
*/
package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N4949 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String str = br.readLine();
			boolean vpn = true;
			Stack<Character> st = new Stack<>();
			if(str.equals("."))
				break;
			else {
				for(int i=0;i<str.length();i++) {
					
					char ch = str.charAt(i);
					if(ch=='('||ch=='['||ch=='{') {
						st.push(ch);
					}
					else if(ch==')') {
						if(!st.isEmpty()&&st.peek()=='(') {
							st.pop();
						}
						else {
							vpn = false;
						}
					}
					else if(ch==']') {
						if(!st.isEmpty()&&st.peek()=='[') {
							st.pop();
						}
						else {
							vpn = false;
						}
					}
					else if(ch=='}') {
						if(!st.isEmpty()&&st.peek()=='{') {
							st.pop();
						}
						else {
							vpn = false;
						}
					}
				}
				if(!st.isEmpty())
					vpn = false;
				if(vpn==true) {
					System.out.println("yes");
				}
				else
					System.out.println("no");
			}
		}
	}
}

/*
[�ذ���]
- �� ���� ���õ� �⺻ ��ȣ ���� �˻� ������ ���� ������ �����̴�
�Ѱ��� �ٸ����� �ִٸ� �������� (.)�� ������ �ݺ��� �����ϴ°�!
�׸��� ������ �� ���� ���ȣ�� ���������� ���ÿ� �°�ȣ�� �ִٴ� ������ ����
�׷��Ƿ� if������ !st.isEmpty()�� �߰��Ͽ� ������� ������ pop�� �ϵ��� ������ �ɾ���Ѵ�.
�׷��� �����ʾ����� �س´�!*/
