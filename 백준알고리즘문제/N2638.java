/*[����][N2638][ġ��2]
 * ġ��1�� ������ ������, ����� �ô�� �ִ� �κ��� 2���̻��ΰ͸� �߰��ؼ� üũ���ָ�ȴ�.
 */
package Simulation;

import java.util.*;
import java.io.*;

public class N2638 {
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static int n,m;
	static int [][] arr;
	static boolean [][] visited;
	static int answer = 0;
	static int cheese = 0;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int [n][m];
		
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1)
					cheese++;
			}
		}
		
		
		while(true) {
			if(cheese==0) {
				System.out.println(answer);
				break;
			}
			
			//�ٱ��� �ִ� �͵��� 2�� �ٲٴ� �۾�
			outside(0,0);
			
			//���� �͵��� üũ�ؼ� �����صд�.
			visited = new boolean [n][m];
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==1) {
						find(i,j);
					}
				}
			}
			
			int remove = 0;
			for(int i=0;i<n;i++) {
				for(int j=0;j<m;j++) {
					if(arr[i][j]==3) {
						remove++;
						arr[i][j] = 2;
					}
				}
			}
			cheese -= remove;
			answer++;
		}
	}
	
	public static void find(int x,int y) {
		int cnt = 0;
		for(int i=0;i<4;i++) {
			int nx = dx[i] + x;
			int ny = dy[i] + y;
			if(nx>=0 && ny>=0 && nx<n && ny<m) {
				if(arr[nx][ny]==2) {
					cnt++;
				}
			}
		}
		
		if(cnt>=2) {
			arr[x][y] = 3;
		}
	}
	
	
	//�ٱ��� �ִ� 0�̳� 2�϶�
	public static void outside(int x,int y) {
		Queue<Dot> queue = new LinkedList<>();
		boolean [][] out = new boolean [n][m];
		queue.add(new Dot(x,y));
		out[x][y] = true;
		arr[x][y] = 2;
		
		while(!queue.isEmpty()) {
			Dot dot =  queue.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(arr[nx][ny]==0 || arr[nx][ny]==2 && !out[nx][ny]) {
						arr[nx][ny] = 2;
						out[nx][ny] = true;
						queue.add(new Dot(nx,ny));
					}
				}
			}
		}
	}
	
	public static void print() {
		System.out.println();
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
