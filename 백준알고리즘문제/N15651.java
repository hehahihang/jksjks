/*
 문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 M개를 고른 수열
같은 수를 여러 번 골라도 된다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 7)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.
 */

package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//같은 수를 여러번 골라도 된다.
//조합을 푸는 문제 nCm : n개중에 반복해서 m개를 뽑는 경우.
public class N15651 {
	static int [] arr;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		arr = new int [n+1];
		visited = new boolean [n+1];
		
		dfs(0,n,m);
		System.out.println(sb);
	}
	
	public static void dfs(int cnt,int n,int m) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(visited[i]==false && cnt<m) {
				//반복을 허용하므로 방문상태를 나타내는 vistied[i]의 if문을 사용하지 않는다.
				arr[cnt] = i;
				dfs(cnt+1,n,m);
			}
		}
	}
}
