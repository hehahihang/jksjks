/*[백준][N1260][DFS와 BFS]
 
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.

예제 입력 1 예체 줄력 1
4 5 1   1 2 4 3
1 2     1 2 3 4
1 3
1 4
2 4
3 4
 */
package DFSBFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N1260 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]); //정점의 개수
		int m = Integer.parseInt(str[1]); //간선의 개수
		int v = Integer.parseInt(str[2]); //탐색을 시작할 정점의 번호
		
		int [][] graph = new int [n+1][n+1];
		boolean [] visited = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			String [] s1 = br.readLine().split(" ");
			int x = Integer.parseInt(s1[0]);
			int y = Integer.parseInt(s1[1]);
			
			graph[x][y] = graph[y][x] = 1;
		}
		
		dfs(graph,visited,v);
		
		Arrays.fill(visited, false);
		
		System.out.println();
		
		bfs(graph,visited,v);
		

	}
	
	public static void dfs(int [][] graph,boolean [] visited,int start) {
		visited[start] = true;
		
		System.out.print(start+" ");
		
		for(int i=1;i<visited.length;i++) {
			if(graph[start][i]==1 && visited[i]==false) {
				dfs(graph,visited,i);
			}
		}
	}
	
	public static void bfs(int [][] graph,boolean [] visited,int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			start = queue.remove();
			System.out.print(start+" ");
			
			for(int i=1;i<visited.length;i++) {
				if(graph[start][i]==1 && visited[i]==false) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
	}
}
