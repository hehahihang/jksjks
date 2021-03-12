/*[����][N16236][�Ʊ���]
 * ������� �������� 10���õ����� �������� ������ �����ϴµ� �ð��� �����ɷȰ�, �ذ����� �������� �ʾ� �ٸ����� ��α׸� �����ߴ�.
 * 
 * �ٽ� : ������� �Ʊ� ���� �Ÿ��� dist��� �迭�� ��� ���� �ٽ��̶�� �����Ѵ�.
 * �׸��� �̷��� �������� ���� �� �ֳ� ����, �Ʊ� �� ������ �� �ֳ� ���ĸ� �ľ��ϸ�ȴ�.
 * 1) �ִܰ�� : ��� ���������� �ִܰŸ��� ���� ���̳� -> BFS�� ����ؼ� ���� ����� ��ġ�κ��� ��� ������� �̵��Ÿ��� ã��, �� �߿��� ���� �Ÿ��� ª�� ����⸦ ã�´�.
 * 2) �ڷᱸ�� : ��� ������ ��ġ������ ������ ������ -> class�� ����Ͽ� ����
 * 3) �̵� : ��� �����¿�� 1ĭ�� ��������
 * 4) �Ÿ��� ���� ª�� ����Ⱑ ���� ������ ���, ��� ���� ���� ���� ���� ����⸦ ã���� if else ���� minX, minY, minDist;
 * */

package Simulation;

import java.util.*;
import java.io.*;

public class N16236 {
	
	//������� ��ġ�� �Ÿ��� ���� Ŭ��
	static class Dot{
		int x,y;
		public Dot(int x,int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int [] dx = {0,1,0,-1};
	static int [] dy = {1,0,-1,0};
	static ArrayList<Dot> fish;
	static int n;
	static int [][] dist;
	static int [][] arr;
	static int time = 0; //�ð�
	static int sx,sy;
	static int size = 2; //����� ó�� ������
	static int minX,minY,minDist;
	static int eatingCnt = 0; //�Ʊ�� ���� 
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		//0��ĭ, 123456������� ũ�� 9����� ��ġ
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==9) {
					sx = i;
					sy = j;
					arr[i][j] = 0;
					//���� ����� ��ġ, 0���� �ʱ�ȭ ���ش�.
				}
			}
		}
		
		while(true) {
			dist = new int [n][n]; //�� ����Ŭ�� �������� ���� ������ �Ÿ��� �ʱ�ȭ ���ش�.
			minX = Integer.MAX_VALUE; //�� �Ÿ��� x��
			minY = Integer.MAX_VALUE; //�� �Ÿ��� y��
			minDist = Integer.MAX_VALUE; //�׸��� �����̴� �Ÿ�
			
			//���� ����� ��ġ���� BFSŽ���� ����.
			bfs(sx,sy);
			
			//�̵��� �ѹ��� ���ߵ��� minX�� minY�� �ʱⰪ �״�� �� ��
			if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				eatingCnt++;
				arr[minX][minY] = 0; //���� ������� ��ġ�� 0���� �������ش�.
				sx = minX;
				sy = minY;
				time += dist[minX][minY];
				
				if(eatingCnt==size) {
					size++;
					eatingCnt=0;
				}
			}
			
			else
				break;
		}
		
		System.out.println(time);
	}
	
	
	//�Ʊ���� �ڽź��� ū ũ���� ����Ⱑ �ִ� ĭ�� ������ �� ����.
	//������ ĭ�� ��� ������ �� �ִ�.
	//�Ʊ���� �ڱ� �ڽ��� ũ�⺸�� ���� ����⸸ ���� �� �ִ�.
	//ũ�Ⱑ ���� ������ ���� �� ������, ������ ���� �ִ�.
	
	//����� ��ġ���� bfs����
	public static void bfs(int x,int y) {
		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(sx,sy)); //���� ��ġ�� ť�� �ְ� Ž���Ѵ�.
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				//1.�� �����̷��� ���� ��ǥ������ ������ ������ 2.ũ�Ⱑ �۰ų� ���� ����Ⱑ �־� �̵��� �������� 3.�̰������� �Ÿ��� �湮������ �ִ���
				if(isPossible(nx,ny) && isMove(nx,ny) && dist[nx][ny]==0) {
					dist[nx][ny] = dist[dot.x][dot.y] + 1; //ù �湮�̹Ƿ� ���������� �Ÿ����� 1�� ���Ѵ�.
					
					//����⸦ ���� �� �ִٸ�, �׸��� �Ÿ��� �� �۴ٸ� �ִܰŸ��� �ֽ�ȭ
					if(isEat(nx,ny)) {
						if(minDist>dist[nx][ny]) {
							minDist = dist[nx][ny];
							minX = nx;
							minY = ny;
						}
						//���� ���� �ִµ� �Ÿ��� ���ٸ�
						else if(minDist==dist[nx][ny]) {
							//������ ���� ������ �Ÿ��� ���ٸ�
							if(minX==nx) {
								//���� ���ʿ� �ִ°� �Դ´�. �װ� �� ��ǥ�� �ȴ�.
								if(minY>ny) {
									minX = nx;
									minY = ny;
								}
							}
							//�ٵ� ���� ���� �ִ°� �Ծ�� �Ѵ�. �װ� X���� ���� ������
							else if(minX>nx) {
								minX = nx;
								minY = ny;
							}
						}
					}
					//����⸦ ã�Ҵٰ� �ٷ� �ִ� ���� �ƴ϶� ���� ����� ����Ⱑ ���������� ��� ���� ���� �Ա� ���ؼ�
					//ť�� ���������� �ִ´�.
					//������� ��ġ�� ť�� �־��ش�.
					queue.add(new Dot(nx,ny));
				}
			}
		}
	}
	
	public static boolean isPossible(int nx,int ny){
		if(nx>=0 && ny>=0 && nx<n && ny<n)
			return true;
		else
			return false;
	}
	
	public static boolean isMove(int nx,int ny) {
		if(arr[nx][ny]<=size)
			return true;
		else
			return false;
	}
	
	public static boolean isEat(int nx,int ny) {
		if(arr[nx][ny]!=0 && arr[nx][ny]<size)
			return true;
		else
			return false;
	}
}
