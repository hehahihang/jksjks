/*[����][N2636][ġ��]
 * ó������ BFSŽ���� ���� �ٱ����⸦ ó���ϸ� ������ ���⵵ �ٲ�ٰ� �����Ͽ� �õ��� ���ߴ�.
 * ������, �ٸ� ��α׵��� �����غ��� �ٽ� ������ �غ��� �ٱ� ���⿡�� �ƹ��� BFS�� �������� ���ο� ���� ����δ� ���� �� �� ���ٶ�� ���� ���޾Ҵ�.
 * 
 * �ٽ� : �ܺ� ���⸦ 2�� �ٲ۴�. �ܺΰ���� �ô�� �ִ� �κ��� 3���� �ٲٰ�, 3���� ���ִ� �κ��� 2�� �ٽ� �ٲٸ鼭 �ݺ��Ѵ�.
 * ġ�� ������ 0�� �Ǹ� BREAK;
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
	 
	static int cheese; //��ü ġ�� ����
	static int n,m;	
	static int before_cheese;
	static int [][] arr;
	static int answer = 0;

	static Queue<Dot> queue;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //������ ����
		m = Integer.parseInt(st.nextToken()); //������ ����
		arr = new int [n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1)
					cheese++; //��ü ġ���� ����
			}
		}
		
		before_cheese = cheese;
		
		//�� �ٱ��� �ִ� �͵��� ���� 2�� �ٲ��ش�.
		init();

		while(true) {
			if(cheese==0) {
				System.out.println(answer);
				System.out.println(before_cheese);
				break;
			}
			bfs();
			
			//���⿡ ����Ȱ� 3���� �ٲ۴�.
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==1) {
						find(i,j);
					}
				}
			}
			//�� ������ 3���� �Ȱ� �� 2�� ó���Ѵ�.
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
	
	//���� �ٱ��� �ִ� �͵��� bfs()�ؼ� 2�� �ٲ�����Ѵ� ����
	
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
