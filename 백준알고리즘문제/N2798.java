/*[백준알고리즘][N2798] 블랙잭
카지노에서 제일 인기 있는 게임 블랙잭의 규칙은 상당히 쉽다. 카드의 합이 21을 넘지 않는 한도 내에서, 카드의 합을 최대한 크게 만드는 게임이다. 
블랙잭은 카지노마다 다양한 규정이 있다.한국 최고의 블랙잭 고수 김정인은 새로운 블랙잭 규칙을 만들어 상근, 창영이와 게임하려고 한다.
김정인 버젼의 블랙잭에서 각 카드에는 양의 정수가 쓰여 있다. 그 다음, 딜러는 N장의 카드를 모두 숫자가 보이도록 바닥에 놓는다. 그런 후에 딜러는 숫자 M을 크게 외친다.
이제 플레이어는 제한된 시간 안에 N장의 카드 중에서 3장의 카드를 골라야 한다. 블랙잭 변형 게임이기 때문에, 플레이어가 고른 카드의 합은 M을 넘지 않으면서 M과 최대한 가깝게 만들어야 한다.
N장의 카드에 써져 있는 숫자가 주어졌을 때, M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.

입력
첫째 줄에 카드의 개수 N(3 ≤ N ≤ 100)과 M(10 ≤ M ≤ 300,000)이 주어진다. 둘째 줄에는 카드에 쓰여 있는 수가 주어지며, 이 값은 100,000을 넘지 않는다.
합이 M을 넘지 않는 카드 3장을 찾을 수 있는 경우만 입력으로 주어진다.

출력
첫째 줄에 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 출력한다.

[해결방법]
1.카드의 개수(n)과 같은 크기의 배열을 생성한다.
2.n개중 3개의 합을 저장할 변수 sum을 설정,반복문을 돌며 m과 가장 가까운 합을 저장한 변수 answer를 설정
3.첫번째 for문은 가장 마지막 숫자보다 2개전까지,두번째 for문은 마지막숫자보다 1개전까지
세번째 for문은 가장 마지막 숫자까지 반복하며 가능한 모든 세 숫자의 합을 계산한다.
4.세 숫자의 합 sum이 m보다 작거나 같고 현재 가장 m과 가까운 answer보다 크다면 
sum을 answer로 바꾼다.*/

package Brute;

import java.util.*;

public class N2798 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] arr = new int [n];
		
		for(int i=0;i<n;i++)
		{
			arr[i] = sc.nextInt();
		}
		
		int sum=0;
		int answer=0;
		for(int i=0;i<n-2;i++)
		{
			for(int j=i+1;j<n-1;j++)
			{
				for(int k=j+1;k<n;k++)
				{
					sum = arr[i]+arr[j]+arr[k];
					if(sum<=m && sum>answer)
						answer = sum;
				}
			}
		}
		System.out.println(answer);
	}
}	
