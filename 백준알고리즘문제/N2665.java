//[백준][N2665][미로만들기]
/*
처음 생각 : 지도의 한곳에서 시작해서 다른 한곳으로의 최대값 OR 최소값을 선택하는 문제
-> 그래프에서 이러한 문제를 풀때는 BFS를 이용한다.
-> 그리고 하나에서 하나로의 최소값을 찾을때는 다익스트라(Dijkstra)생각

-> 각 정점간의 최단경로 == 플로이드 와샬 알고리즘
-> 시작점으로부터 나머지 정점까지의 최단경로 == 다익스트라(음의 가중치 사용 x)

*/
package dijkstra;

import java.util.*;
import java.io.*;

public class N2665 {

	static int n;
	static int [][] arr;
	static int [][] dist;
	static int [] dx = {1,-1,0,0};
	static int [] dy = {0,0,1,-1};
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		dist = new int [n][n];
		//검은방 0, 흰방 1
		for(int i=0;i<n;i++) {
			String str = br.readLine();
			for(int j=0;j<n;j++) {
				arr[i][j] = str.charAt(j) - '0';
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		bfs(0,0);
		System.out.println(dist[n-1][n-1]);
	}
	
	public static void bfs(int x,int y) {
		PriorityQueue<miro> queue = new PriorityQueue<>();
		queue.add(new miro(x,y,0));
		dist[0][0] = 0;
		
		while(!queue.isEmpty()) {
			miro m = queue.poll();
			
			for(int i=0;i<4;i++) {
				int nx = m.x + dx[i];
				int ny = m.y + dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<n && dist[nx][ny]>m.cost) {
					if(arr[nx][ny]==0) {
						dist[nx][ny] = m.cost+1;
						queue.add(new miro(nx,ny,m.cost+1));
					}
					else {
						dist[nx][ny] = m.cost;
						queue.add(new miro(nx,ny,m.cost));
					}
				}
				
			}
		}
	}
}

class miro implements Comparable<miro>{
	int x,y,cost;
	public miro(int x,int y,int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	public int compareTo(miro m) {
		return this.cost - m.cost;
	}
}