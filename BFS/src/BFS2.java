import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//인접리스트로 구현한 BFS

public class BFS2 {
	
	public static void bfs2(ArrayList<Integer>[] adjlist,boolean [] visited,int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(start);
		
		//큐가 비어있지 않을때까지 반복한다.
		while(!queue.isEmpty()) {
			start = queue.poll();
			System.out.println(start+"방문"+" ");
			
			for(int i=0;i<adjlist.length;i++) {
				if(visited[i]==false) {
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
		
		int vertex = Integer.parseInt(st.nextToken());
		int edge = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(st.nextToken());
		int [][] Graph = new int [vertex+1][vertex+1];
		boolean [] visited = new boolean [vertex+1];
		
		//ArrayList형 원소를 가지는 배열
		ArrayList<Integer> [] adjlist = new ArrayList[vertex+1];
		
		for(int i=0;i<adjlist.length;i++) {
			adjlist[i] = new ArrayList<Integer>();
		}
		
		
		for(int i=1;i<=edge;i++) {
			st = new StringTokenizer(br.readLine());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			adjlist[a1].add(a2); 
			adjlist[a2].add(a1);
		}
		
		//자식이 여러개라면 노드번호가 작은것 먼저 방문하므로 오름차순으로 정렬을한다.
		for(int i=0;i<adjlist.length;i++) {
			Collections.sort(adjlist[i]);
		}
		
		bfs2(adjlist,visited,start);
		
		
	}

}
