/*����
������ �����ϴ� ������ ������ ����, �Է����� �־����� ����� ó���ϴ� ���α׷��� �ۼ��Ͻÿ�.

����� �� �ټ� �����̴�.

push X: ���� X�� ���ÿ� �ִ� �����̴�.
pop: ���ÿ��� ���� ���� �ִ� ������ ����, �� ���� ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
size: ���ÿ� ����ִ� ������ ������ ����Ѵ�.
empty: ������ ��������� 1, �ƴϸ� 0�� ����Ѵ�.
top: ������ ���� ���� �ִ� ������ ����Ѵ�. ���� ���ÿ� ����ִ� ������ ���� ��쿡�� -1�� ����Ѵ�.
�Է�
ù° �ٿ� �־����� ����� �� N (1 �� N �� 10,000)�� �־�����. ��° �ٺ��� N���� �ٿ��� ����� �ϳ��� �־�����. 
�־����� ������ 1���� ũ�ų� ����, 100,000���� �۰ų� ����. ������ �������� ���� ����� �־����� ���� ����.

���
����ؾ��ϴ� ����� �־��� ������, �� �ٿ� �ϳ��� ����Ѵ�.*/

/*[�ذ� ���]
- BufferedReader�� �̿��� Line������ �Է��� �޴´�.
- split�� �̿��� push ���� ����X�� �ذ��Ѵ�.
- �� ��ɺ��� ���ǹ��� �ۼ��Ѵ�. */

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N10828 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<N;i++) {
			String [] str = br.readLine().split(" ");
			
			if(str[0].equals("push")) {
				st.push(Integer.parseInt(str[1]));
			}
			else if(str[0].equals("pop")) {
				if(st.isEmpty()==true)
					System.out.println(-1);
				else {
					System.out.println(st.pop());
				}
			}
			else if(str[0].equals("size")) {
				System.out.println(st.size());
			}
			else if(str[0].equals("empty")) {
				if(st.isEmpty()==true)
					System.out.println(1);
				else
					System.out.println(0);
			}
			else if(str[0].equals("top")) {
				if(st.isEmpty()==true) {
					System.out.println(-1);
				}
				else {
					System.out.println(st.peek());
				}
			}
		}
	}
}
