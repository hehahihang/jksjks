/*[���α׷��ӽ�][LEVEL2][�踷���]
 
 ����
 - "()" ��ȣ�� ������ ó���� if���ȿ� if������ ó���Ϸ��� �߾��µ� �ð����⵵ ������ ���ߴ�.
 �׸��� �𸣰ھ ģ������ ����ô٤Ф�
 
 - "()"��ȣ�� "1"�� �����ϰ� ���Ŀ� ���� Ǯ�̸� �����ߴ�.
 
 */

package Stack;

import java.io.*;
import java.util.*;

public class N10799 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int answer = 0;
		input = input.replace("()","1");
		
		System.out.println(input);
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<input.length();i++) {
			char k = input.charAt(i);
			
			if(k=='(') {
				stack.push(k);
			}
			//K==1�϶��� ������ �����Ͱ� �߻�� �� �̹Ƿ�
			//���ÿ� �׿��ִ� "("�� ����ŭ ������ �������Ƿ� �׸�ŭ�� ������ �߰��Ѵ�.
			else if(k=='1') {
				answer = answer + stack.size();
			}
			
			// k==")" �� ���ö��� �������� ���̰� ������ ������ ������ �ϳ� �߰����ش�.
			else if(k==')') {
				answer = answer +1;
				stack.pop();
			}
		}
		
		System.out.println(answer);
	}
}
