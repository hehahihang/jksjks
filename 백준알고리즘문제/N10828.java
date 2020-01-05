/*문제
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 
주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.*/

/*[해결 방법]
- BufferedReader를 이용해 Line단위의 입력을 받는다.
- split을 이용해 push 뒤의 정수X를 해결한다.
- 각 명령별로 조건문을 작성한다. */

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

/*[고찰]
처음엔 Scanner를 이용해 풀었었는데 메모리 효율에서 BufferedReader가 훨씬좋아
문제를 다시 풀었다. 앞으로는 여러개를 입력받을 경우에는 BufferdReader를 활용해야겠다!
*/
