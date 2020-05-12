/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.

1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
고른 수열은 오름차순이어야 한다.
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)

출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.
*/

package backTracking;

import java.io.*;

public class N15650 {
	static boolean [] visited;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		arr = new int [n+1];
		visited = new boolean [n+1];
		
		dfs(0,n,m);
		
	}
	private static void dfs(int cnt, int n, int m) {
		// TODO Auto-generated method stub
		if(cnt==m) { //nPm 에서 cnt==m 이면 m개를 뽑았다는 얘기이므로
					//해당 갯수를 모두 뽑았으므로 출력한다.
			for(int i=0;i<m;i++) {
					System.out.print(arr[i]+" ");
			}
			System.out.println();
			return; //그리고 탐색을 빠져나간다.
		}
		
		for(int i=1;i<=n;i++) { //1~n 중 m개를 뽑는것이므로 반복문을 1~n까지 반복한다.
			if(visited[i]==false) {//만약 방문하지 않았다면
				visited[i] = true; //방문한 상태로 업데이트
				arr[cnt] = i; //뽑은 숫자를 배열에 저장한다.
				
				//오름차순 정렬을 위해 두가지로 방법을 나눈다.
				//1.cnt==0인 경우, 가장 첫번째 숫자를 뽑는것이므로 다른 조건 없이 cnt+1을하여 탐색을 다시 진행하면 된다.
				if(cnt==0) 
					dfs(cnt+1,n,m); 
				//2.cnt!=0인 경우, 바로 앞의 숫자와 비교하여 오름차순이라면 탐색을 계속 진행한다.
				if(cnt>0 && arr[cnt]>arr[cnt-1])
					dfs(cnt+1,n,m);
				
				visited[i] = false; //탐색에 들어가고나면 현재 탐색했던 숫자는 방문하지 않았던 것으로 다시 처리한다.
			}
		}
	}
}