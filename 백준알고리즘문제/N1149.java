/*[백준알고리즘][N1149][RGB거리]
문제
RGB거리에 사는 사람들은 집을 빨강, 초록, 파랑중에 하나로 칠하려고 한다. 
또한, 그들은 모든 이웃은 같은 색으로 칠할 수 없다는 규칙도 정했다. 
집 i의 이웃은 집 i-1과 집 i+1이고, 첫 집과 마지막 집은 이웃이 아니다.

각 집을 빨강으로 칠할 때 드는 비용, 초록으로 칠할 때 드는 비용, 파랑으로 드는 비용이 주어질 때,
모든 집을 칠하는 비용의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 집의 수 N이 주어진다. N은 1,000보다 작거나 같다. 
둘째 줄부터 N개의 줄에 각 집을 빨강으로, 초록으로, 파랑으로 칠하는 비용이 주어진다. 
비용은 1,000보다 작거나 같은 자연수이다.

출력
첫째 줄에 모든 집을 칠하는 비용의 최솟값을 출력한다.

예제 입력 1  	예제 출력 1
3		 	96
26 40 83
49 60 57
13 89 99
*/

package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		int [][] cost = new int [n+1][3]; //각 집을 칠하는데에 들어가는 비용
		int [][] dp = new int [n+1][3];
		
		//각 집마다 페인트 비용을 [][] 2차원배열에 저장
		for(int i=1;i<=n;i++) { //1번집 2번집 3번집이므로 1부터 n까지했다.
			String [] str = br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				cost[i][j] = Integer.parseInt(str[j]); //각 집을 대상으로 최초의 색상을 칠할 비용이 들어있는 cost배열
			}
		}
		
		//모든집을 다 칠하는데 비용인 dp에는 첫층의 비용으로 초기화한다.
		dp[1][0] = cost[1][0]; 
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		
		for(int i=2;i<=n;i++) {
			// 2층부터 n층까지 더한다.
			// 같은색을 제외한 비용의 최소값과 현재 층의 최소값을 더한다.
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+cost[i][2];
		}
		
		int tmp = Math.min(dp[n][0], dp[n][1]);
		System.out.println(Math.min(tmp,dp[n][2]));
		
	}
}

/*
[고찰]
동적 계획법이나 Brute포스같이 모든 경우의 수를 검사하거나 이런문제를 내가 어려워한다고 느낀다.
손으로 문제를 풀어보며 어떤식으로 문제를 해결할지 머리로 생각하고 알고리즘을 해결하려고 해야한다는 생각이다.
*/
