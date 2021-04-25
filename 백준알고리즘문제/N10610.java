/*[백준][10610][30]
 * 
 * 문제
어느 날, 미르코는 우연히 길거리에서 양수 N을 보았다. 미르코는 30이란 수를 존경하기 때문에, 
그는 길거리에서 찾은 수에 포함된 숫자들을 섞어 30의 배수가 되는 가장 큰 수를 만들고 싶어한다.

미르코를 도와 그가 만들고 싶어하는 수를 계산하는 프로그램을 작성하라.

입력
N을 입력받는다. N는 최대 105개의 숫자로 구성되어 있으며, 0으로 시작하지 않는다.

출력
미르코가 만들고 싶어하는 수가 존재한다면 그 수를 출력하라. 그 수가 존재하지 않는다면, -1을 출력하라.


-> 간단해 보이지만 생각보다 고생한 문제

처음에는 조합을 사용해서 문제를 해결했으나 메모리 초과....
이후 그리디를 사용해야 한다는 점을 다른 블로그에서 참조했다.
쉬워보이는 문제이지만 더 효율적으로 해결할 수 있는 방법을 생각하는 계기가 됐다.

*/
import java.util.*;
import java.io.*;

public class N10610 {
	static int n;
	static int [] arr;
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		n = str.length();
		arr = new int [10];
		long sum = 0;
		for(int i=0;i<n;i++) {
			int tmp = str.charAt(i) - '0';
			sum += tmp;
			arr[tmp]++;
		}
		
		if(!str.contains("0") || sum%3!=0) {
			System.out.println(-1);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=9;i>=0;i--) {
			while(arr[i]>0) {
				sb.append(i);
				arr[i]--;
			}
		}
		System.out.println(sb.toString());
	}
}