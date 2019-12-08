/*문제
어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다. 
예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 
반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.

입력
첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.

출력
첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.

예제 입력 1 216
예제 출력 1 198

[해결 방법]
모든 자연수의 생성자는 자기 자신보다 작다고 생각했다.
따라서 자기자신부터 1씩 감소시키며 반복을 진행한다.
1.반복문 안의 숫자i를 String으로 변환하고 이를 다시 char로 변환해 각각의 자리수를 sum에  더한다.
3.i+sum이 입력받은 숫자 k와 같다면 i를 출력한다. */

package Brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class N2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int idx = k;
		int res=0;
		
		for(int i=idx;i>0;i--)
		{
			int sum=0;
			String str = String.valueOf(i);
			
			for(int j=0;j<str.length();j++)
			{
				sum += str.charAt(j)-48;
			}
			if(i+sum==k)
			{
				res = i;
			}
		}
		if(res==0)
			System.out.println(0);
		else
			System.out.println(res);
		
	}
}

/*고찰
- 각각의 자리수를 더하는 방법을 나는 while문을 이용해서 count를 계산하고
그 크기 만큼의 배열을 생성하고 다시 while문을 생성해서 자릿수를 더했었다. 굉장히 비효율적인 방법.. 
for문을 반복하여 i를 String으로 각각의 자리를 char변수로 바꿔서 해결하는 방법은 생각 못했다....
이렇게도 생각 할 수 있는 계기가되었다!*/

