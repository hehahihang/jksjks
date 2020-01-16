//[DFS]
//인접리스트를 통해 구현한 DFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //정점의 개수
		int E = Integer.parseInt(st.nextToken()); //간선의 개수
		int start = Integer.parseInt(st.nextToken()); //시작 정점의 위치
		boolean [] visited = new boolean [V+1]; //방문여부를 확인할 visited 배열
		
		/*ArrayList를 담을 배열을 만든다. 배열 Adjlist에 ArrayList를 담는다.*/
		//or ArrayList<ArrayList<Integer>> = new ArrayList<ArrayList<Integer>>(V+1);을 통해 구현할 수도 있다.
		ArrayList<Integer> [] Adjlist = new ArrayList[V+1];
		
		//초기화를 해서 생성해야 오류가 생기지 않는다.
		for(int i=0;i<Adjlist.length;i++) {
			Adjlist[i] = new ArrayList<Integer>();
		}
		
		//양방향 연결이라고 생각하고 인접한 리스트를 추가한다.
		//연결된 정점을 연결하는 과정
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			Adjlist[x].add(y);
			Adjlist[y].add(x);
		}
		
		//인접리스트의 내부의 배열의 원소가 여러개가 있다면 가장 작은 원소 부터 방문하므로
		//오름차순으로 정렬한다.
		for(int i=0;i<Adjlist.length;i++) {
			Collections.sort(Adjlist[i]);
		}
		
		//DFS를 실행한다.
		dfs(Adjlist,visited,start);
		
	}
	public static void dfs(ArrayList<Integer>[] adjlist,boolean [] visited,int V) {
		visited[V] = true;
		System.out.print(V+" ");
		
		for(int i=0;i<adjlist[V].size();i++) {
			if(visited[i]==false) {
				dfs(adjlist,visited,i);
			}
		}
	}

}
