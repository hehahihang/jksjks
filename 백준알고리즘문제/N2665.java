//[����][N2665][�̷θ����]
/*
ó�� ���� : ������ �Ѱ����� �����ؼ� �ٸ� �Ѱ������� �ִ밪 OR �ּҰ��� �����ϴ� ����
-> �׷������� �̷��� ������ Ǯ���� BFS�� �̿��Ѵ�.
-> �׸��� �ϳ����� �ϳ����� �ּҰ��� ã������ ���ͽ�Ʈ��(Dijkstra)����

-> �� �������� �ִܰ�� == �÷��̵� �ͼ� �˰���
-> ���������κ��� ������ ���������� �ִܰ�� == ���ͽ�Ʈ��(���� ����ġ ��� x)

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
		//������ 0, ��� 1
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