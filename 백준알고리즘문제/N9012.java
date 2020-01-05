/*����
��ȣ ���ڿ�(Parenthesis String, PS)�� �� ���� ��ȣ ��ȣ�� ��(�� �� ��)�� ������ �����Ǿ� �ִ� ���ڿ��̴�. 
�� �߿��� ��ȣ�� ����� �ٸ��� ������ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(Valid PS, VPS)�̶�� �θ���. 
�� ���� ��ȣ ��ȣ�� �� ��( )�� ���ڿ��� �⺻ VPS �̶�� �θ���. ���� x �� VPS ��� �̰��� �ϳ��� ��ȣ�� ���� ���ο� ���ڿ� ��(x)���� VPS �� �ȴ�. 
�׸��� �� VPS x �� y�� ����(concatenation)��Ų ���ο� ���ڿ� xy�� VPS �� �ȴ�. 
���� ��� ��(())()���� ��((()))�� �� VPS ������ ��(()(��, ��(())()))�� , �׸��� ��(()�� �� ��� VPS �� �ƴ� ���ڿ��̴�. 

�������� �Է����� �־��� ��ȣ ���ڿ��� VPS ���� �ƴ����� �Ǵ��ؼ� �� ����� YES �� NO �� ��Ÿ����� �Ѵ�. 

�Է�
�Է� �����ʹ� ǥ�� �Է��� ����Ѵ�. �Է��� T���� �׽�Ʈ �����ͷ� �־�����. 
�Է��� ù ��° �ٿ��� �Է� �������� ���� ��Ÿ���� ���� T�� �־�����. 
�� �׽�Ʈ �������� ù° �ٿ��� ��ȣ ���ڿ��� �� �ٿ� �־�����. �ϳ��� ��ȣ ���ڿ��� ���̴� 2 �̻� 50 �����̴�. 

���
����� ǥ�� ����� ����Ѵ�. ���� �Է� ��ȣ ���ڿ��� �ùٸ� ��ȣ ���ڿ�(VPS)�̸� ��YES��, �ƴϸ� ��NO���� �� �ٿ� �ϳ��� ���ʴ�� ����ؾ� �Ѵ�. 

���� �Է� 1           		�������1
6
(())())  				NO
(((()())() 				NO
(()())((())) 			YES
((()()(()))(((())))() 	NO
()()()()(()()())() 		YES
(()((())()( 			NO
 */


/*[�ذ���]
- �⺻���� �ذ����� ������ �̿��� ��ȣ������ �Ȱ���.
���� �߿��ϰ� ����ϰ���� �κ��� 49��° �ٿ���
for���� �ݺ��Ǹ� �ѹ��� �ݺ��� �������Ǹ� Stack�� �ʱ�ȭ �Ǿ���ϹǷ�
Stack�� for�� ���ο� �������־���Ѵٴ°� ���� �߿��ϴ� �����Ѵ�.*/

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N9012 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0;i<T;i++) {
			Stack<Character> st = new Stack<>();
			//�ѹ��� �ݺ��Ҷ����� Stack�� �ʱ�ȭ�Ǿ� �ϹǷ� for�� ���ʿ� Stack�� ����
			String str = br.readLine();
			boolean vps = true;
			char ch;
			
			for(int j=0;j<str.length();j++) {
				ch = str.charAt(j);
				
				if(ch=='(') {
					st.push('(');
				}
				else if(ch==')') {
					if(!st.isEmpty()) {
						st.pop();
					}else {
						vps = false;
					}
				}
			}
			if(!st.empty()) {
				vps = false;
			}
			if(vps==true){
				System.out.println("YES");
			}
			else
				System.out.println("NO");
		}
	}
}