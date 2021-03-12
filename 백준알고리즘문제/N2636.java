/*[백준][N2636][치즈]
 * 처음에는 BFS탐색을 통해 바깥공기를 처리하면 내부의 공기도 바뀐다고 생각하여 시도를 못했다.
 * 하지만, 다른 블로그들을 참조해보고 다시 생각을 해보니 바깥 공기에서 아무리 BFS를 돌려봐야 내부에 막힌 공기로는 도달 할 수 없다라는 것을 깨달았다.
 * 
 * 핵심 : 외부 공기를 2로 바꾼다. 외부공기과 맡닿아 있는 부분을 3으로 바꾸고, 3으로 되있는 부분을 2로 다시 바꾸면서 반복한다.
 * 치즈 개수가 0이 되면 BREAK;
 * */
package Simulation;

import java.util.*;
import java.io.*;

public class N2636 {
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	 
	static int cheese; //전체 치즈 개수
	static int n,m;	
	static int before_cheese;
	static int [][] arr;
	static int answer = 0;

	static Queue<Dot> queue;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //세로의 길이
		m = Integer.parseInt(st.nextToken()); //가로의 길이
		arr = new int [n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1)
					cheese++; //전체 치즈의 개수
			}
		}
		
		before_cheese = cheese;
		
		//맨 바깥에 있는 것들을 먼저 2로 바꿔준다.
		init();

		while(true) {
			if(cheese==0) {
				System.out.println(answer);
				System.out.println(before_cheese);
				break;
			}
			bfs();
			
			//공기에 노출된거 3으로 바꾼다.
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==1) {
						find(i,j);
					}
				}
			}
			//그 다음에 3으로 된거 다 2로 처리한다.
			int cnt = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==3) {
						arr[i][j] = 2;
						cnt++;
					}
				}
			}
			before_cheese = cheese;
			cheese -= cnt;
			answer++;
		}
	
	}
	
	public static void find(int x,int y) {
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx>=0 && ny>=0 && nx<n && ny<m) {
				if(arr[nx][ny]==2) {
					arr[x][y] = 3;
					return;
				}
			}
		}
	}
	
	//가장 바깥에 있는 것들을 bfs()해서 2로 바꿔줘야한다 먼저
	
	public static void bfs() {
		Queue<Dot> queue = new LinkedList<>();
		boolean [][] visited = new boolean [n][m];
		queue.add(new Dot(0,0));
		visited[0][0] = true;
			
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = dx[i] + dot.x;
				int ny = dy[i] + dot.y;
				if(nx<0 || ny<0 || nx>=n || ny>=m)
					continue;
				
				if(!visited[nx][ny] && arr[nx][ny]==2 || arr[nx][ny]==0) {
					queue.add(new Dot(nx,ny));
					arr[nx][ny] = 2;
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	
	
	
	public static void init() {
		Queue<Dot> queue = new LinkedList<>();
		boolean [][] visited = new boolean [n][m];
		queue.add(new Dot(0,0));
		arr[0][0] = 2;
		visited[0][0] = true;
			
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = dx[i] + dot.x;
				int ny = dy[i] + dot.y;
				if(nx<0 || ny<0 || nx>=n || ny>=m)
					continue;
				
				if(!visited[nx][ny] && arr[nx][ny]==0) {
					queue.add(new Dot(nx,ny));
					arr[nx][ny] = 2;
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	public static void print() {
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
