//[DFS]
//인접행렬을 이용한 DFS구현
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS1 {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); //정점의 개수 == 노드
		int E = Integer.parseInt(st.nextToken()); //간선의 개수 == Edge
		int start = Integer.parseInt(st.nextToken()); //방문을 시작하게될 정점의 위치
		
		int [][] Graph = new int[V+1][V+1];
		//배열의 인덱스는 0번부터 시작하므로 +1을 하여 0번인덱스를 사용하지않고 
		//ArrayIndexOutOfBounds를 방지하기위해 사용한다.
		
		boolean [] visited = new boolean [V+1];
		// 방문한 정점을 표시하는 배열이다. 방문 이후 visited=true로 갱신한다.
		
		//인접행렬을 생성한다.
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//양방향 그래프를 설정한다.
			Graph[x][y] = Graph[y][x] = 1;
			//단방향인 경우 x->y or y->x 본인 입맞게 맞게 설정한다.
		}
		
		//우리가 설정한 인접행렬Graph에서 방문여부 visited를 start정점부터 탐색한다.
		dfs(Graph,visited,start);
		
	}
	public static void dfs(int[][] Graph,boolean [] visited,int V) {
		visited[V] = true; //V 노드를 방문 한 것이므로 visted = true로 바꿔준다
		
		System.out.print(V+" ");
		
		//재귀를 사용하여 다음 노드를 방문하면 그곳에서 다시 dfs를 실행한다.
		for(int i=1;i<visited.length;i++) {
			//dfs재귀가 실행되는 조건은 그래프가 연결되어있으면서 방문하지 않았던 정점이다.
			if(Graph[V][i]==1 && visited[i]==false) {
				dfs(Graph,visited,i);
			}
		}
	}

}
