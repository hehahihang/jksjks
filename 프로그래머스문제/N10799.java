/*[프로그래머스][LEVEL2][쇠막대기]
 
 생각
 - "()" 괄호가 닫힐때 처리를 if문안에 if문으로 처리하려고 했었는데 시간복잡도 때문에 못했다.
 그리고 모르겠어서 친구에게 물어봤다ㅠㅠ
 
 - "()"괄호는 "1"로 변경하고 이후에 문제 풀이를 진행했다.
 
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
			//K==1일때는 레이저 포인터가 발사될 때 이므로
			//스택에 쌓여있는 "("의 수만큼 조각이 나눠지므로 그만큼의 개수를 추가한다.
			else if(k=='1') {
				answer = answer + stack.size();
			}
			
			// k==")" 가 나올때는 포인터의 길이가 끝나서 마지막 조각을 하나 추가해준다.
			else if(k==')') {
				answer = answer +1;
				stack.pop();
			}
		}
		
		System.out.println(answer);
	}
}
