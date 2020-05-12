/*
문제
자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
- 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
입력
첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
출력
한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.

수열은 사전 순으로 증가하는 순서로 출력해야 한다.

예제 입력 1 
3 1
예제 출력 1 
1
2
3
*/

// n개중m 개를 순서 있게 고르는 순열 문제이다. nPm
package backTracking;

import java.io.*;

public class N15649 {
	//dfs 메서드에서 변수 사용이 가능하도록 static 변수로 선언한다.
	static int n,m;
	static int [] arr; //순열을 저장할 arr 배열
	static boolean [] visited; //숫자의 방문 여부를 저장할 visited 배열
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		arr = new int [n+1]; //배열의 index를 1부터 n까지 사용하기위해 배열크기를 하나 크게 설정한다.
		visited = new boolean [n+1];
		
		dfs(0);
		System.out.println(sb);
		
	}
	
	public static void dfs(int cnt) {
		//몇개의 숫자가 선택되었는지 확인하는 매개변수 cnt
		if(cnt==m) { //m개를 선택했다면
			for(int i=0;i<m;i++) {
				sb.append(arr[i]+" "); 
			}
			sb.append("\n");
			return; //StringBuilder에 더하고. return으로  dfs탐색을 빠져나온다.
		}
		
		for(int i=1;i<=n;i++) {
			if(visited[i]==false) { //만약 숫자(i)를 방문하지 않았다면
				visited[i] = true; //방문한 상태로 변경하고
				arr[cnt] = i; //cnt번째로 선택된 숫자 i를 배열 arr에 저장한다.
				dfs(cnt+1); //cnt+1번째 숫자를 선택하기위해 dfs(cnt+1) 탐색을 다시 시작한다.
				visited[i] = false; //방문이 끝난 곳의 상태는 방문하지 않은 상태로 변경한다.
			}
		}
	}
}
