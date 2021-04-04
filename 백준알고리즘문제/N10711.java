/*[����][N10711][�𷡼�]

����

1��° �õ�
- �Ϲ����� BFS + Ž�� ������� �����Ͽ� �Է¹��� ���� �����ϰ�, ť�� ���� ����� �ٽ� �����ϴ� ������ ���� Ǯ����
������, ���ó�... �ð��ʰ�

5��° �õ�
- �ð� �ʰ��� �ذ��ϱ� ���� �����ϴ� �κ��� ���ְ� ���� ��ǥ(x,y)�� �ٷ� �־���, ���̰� 9�� �͵��� �����ߴ�.
�̰� �޸� �ʰ�

6��° �õ�
- �޸� �ʰ��� �ذ��ϴ� ����� �������� ����, ��α׸� �����ߴ�.
- �ذ� ����� �𷡸� �������� Ž���� �ϴ� ���� �ƴ϶�, �𷡰� ���� ���� ť�� �ְ� �̸� �������� ���� Ž���Ͽ�, 
�𷡸� ��Ƴ����� ���� ���� ũ�Ⱑ map���� ���� ���̺��� �������� ������ visited �迭�� �湮ó���� �ϰ� 
�ش� ��ġ�� �𷡰� ���� ���� ��ǥ�� ť�� �ٽ� �ִ´�.

��� �ݺ��ϸ�, ť�� ��ԵǸ� ���� ������ ���� ���� Ž���� �ϰ� ���������Ƿ� answer - 1�� ����ϸ� ����


�ǵ��
- ������ ��ȯ�� �ʿ��� ��������. 
- �޸� �ʰ�, �ð� �ʰ��� �ذ��ϱ� ��ƴٸ� ������ ������ �ݴ�� ������ �� �ִ� ���� �ʿ��� �� ����.

*/


package BFS;

import java.util.*;
import java.io.*;

public class N10711 {
	
	static class Dot{
		int x,y;
		Dot(int x,int y){
			this.x = x;
			this.y = y;
		}
	}
	static int [] dx = {-1,0,1,0,-1,1,1,-1};
	static int [] dy = {0,1,0,-1,1,1,-1,-1};
	static int n,m;
	static int [][] map;
	static int [][] cnt;
	static boolean [][] visited;

	static int answer = 0;
	static Queue<Dot> queue = new LinkedList<>();
	static Queue<Dot> newSand = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		map = new int [n][m];
		cnt = new int [n][m];
		visited = new boolean [n][m];
		
		for(int i=0;i<n;i++) {
			String input = br.readLine();
			for(int j=0;j<m;j++) {
				char tmp = input.charAt(j);
				if(tmp=='.') {
					queue.add(new Dot(i,j));
					visited[i][j] = true;
					map[i][j] = 0;	
				}
				else
					map[i][j] = tmp -'0';		
			}
		}
		bfs();
		System.out.println(answer-1);
	}
	
	public static void bfs() {
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				Dot dot = queue.poll();
				for(int j=0;j<8;j++) {
					int nx = dot.x + dx[j];
					int ny = dot.y + dy[j];
					
					if(nx<0 || ny<0 || nx>=n || ny>=m)
						continue;
					
					if(visited[nx][ny])
						continue;
					
					if(map[nx][ny]!='.') {
						cnt[nx][ny]++;
						
						if(cnt[nx][ny]>=map[nx][ny]) {
							visited[nx][ny] = true;
							queue.add(new Dot(nx,ny));
						}
					}
				}
			}
			answer++;
		}
	}
}
