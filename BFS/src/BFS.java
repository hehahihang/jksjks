/*깊이우선탐색 (Breadth First Search)
BFS란?
- 루트노드에서 탐색하여 인접한 노드를 먼저 탐색하는 방법
- 두 노드사이의 최단경로 OR 임의의 경로를 찾을때 사용한다.

특징
- DFS보다 복잡하다.
- Queue를 사용해 구현한다.
(큐에 방문된 노드를 삽입한다. 이후 큐에서 꺼낸 노드와 연결된 노드를 방문,삽입한다.
이를 반복하며 큐가 소진될때까지 계속한다.)
*/


//인접리스트로 구현한 BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
	
	public static void bfs(int [][] Graph,boolean [] visited,int v) {
		//큐를 사용해서 bfs를 실행하는 노드들을 저장한다.
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v); //시작 정점 v를 먼저 추가한다.
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			System.out.println(v+"방문"+" ");
			
			for(int i=1;i<=visited.length;i++) {
				if(Graph[v][i]==1&&visited[i]==false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int vertex = Integer.parseInt(st.nextToken()); //정점의 갯수
		int edge = Integer.parseInt(st.nextToken()); //간선의 갯수
		int start = Integer.parseInt(st.nextToken()); //시작 정점의 위치
		int [][] Graph = new int [vertex+1][vertex+1]; //그래프를 나타낼 인접행렬
		boolean [] visited = new boolean[vertex+1]; //방문여부를 나타낼 배열
		
		//간선의 개수만큼 정점을 연결해준다.
		//a1에서 a2로 연결되어있다를 나타낸다.
		for(int i=1;i<=edge;i++) {
			st = new StringTokenizer(st.nextToken());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			Graph[a1][a2] = 1;
			Graph[a2][a1] = 1;
		}
		
		bfs(Graph,visited,start);
		
		

	}

}
