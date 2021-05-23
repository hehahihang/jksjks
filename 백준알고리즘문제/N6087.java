/*[����][N6087][���������]
 * ����
ũ�Ⱑ 1��1�� ���簢������ �������� W��H ũ���� ������ �ִ�. ������ �� ĭ�� �� ĭ�̰ų� ���̸�, �� ĭ�� 'C'�� ǥ�õǾ� �ִ� ĭ�̴�.

'C'�� ǥ�õǾ� �ִ� �� ĭ�� �������� ����ϱ� ���ؼ� ��ġ�ؾ� �ϴ� �ſ� ������ �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. �������� ����Ѵٴ� ���� �� ĭ�� �������� ������ �� ������ �ǹ��Ѵ�.

�������� C������ �߻��� �� �ְ�, �� ĭ�� �ſ�('/', '\')�� ��ġ�ؼ� ������ 90�� ȸ����ų �� �ִ�. 

�Ʒ� �׸��� H = 8, W = 7�� ����̰�, �� ĭ�� '.', ���� '*'�� ��Ÿ�´�. ������ �ʱ� ����, �������� �ּ� ������ �ſ��� ����ؼ� �� 'C'�� ������ ���̴�.

7 . . . . . . .         7 . . . . . . .
6 . . . . . . C         6 . . . . . /-C
5 . . . . . . *         5 . . . . . | *
4 * * * * * . *         4 * * * * * | *
3 . . . . * . .         3 . . . . * | .
2 . . . . * . .         2 . . . . * | .
1 . C . . * . .         1 . C . . * | .
0 . . . . . . .         0 . \-------/ .
  0 1 2 3 4 5 6           0 1 2 3 4 5 6
�Է�
ù° �ٿ� W�� H�� �־�����. (1 �� W, H �� 100)

��° �ٺ��� H���� �ٿ� ������ �־�����. ������ �� ���ڰ� �ǹ��ϴ� ���� ������ ����.

.: �� ĭ
*: ��
C: �������� �����ؾ� �ϴ� ĭ
'C'�� �׻� �� ���̰�, �������� ������ �� �ִ� �Է¸� �־�����.

���
ù° �ٿ� C�� �����ϱ� ���� ��ġ�ؾ� �ϴ� �ſ� ������ �ּڰ��� ����Ѵ�.*/


/*[����]
 * 1. ù���� �õ�
 * - visited�迭�� boolean Ÿ������ �����Ͽ� �湮���� ���� ���� �湮�ϵ��� �Ͽ� ���������� ����
 * ���� : �ش� ������ �湮 ���ΰ� �߿��� ���� �ƴ϶�, �̹� �湮�ߴ� �����̴��� ������ �ٲ��� �ʾƼ� �ſ��� ������ �� �۴ٸ� Ž���ؾ��ϱ� �����̴�
 *
 * 2. �ι��� �õ�
 * - �ذ� ����� �������� �ʾ� ��α׸� �����ߴ�.
 * - visted �迭�� int ������ �����Ͽ� �湮 �������� �ſ� ������ �������� �湮 + Ž��
 * 
 * �ǵ�� : ����� Ž���� Ǯ�ٺ��� �ʹ� ��������� Ǯ���� �����ϴ� �� ����.
 * ���δ� �湮�� ���κ��ٴ� �湮 �� ��� �������� �湮�ؾ��ϴ����� �ľ��ϴ� ���� �߿��ϴ�.
 * �ܼ��� �ڵ�, Ǯ�̹���� �ܿ�⺸�ٴ� ������ �����ϰ� ��� ������� Ǯ��������� �����ϴ� ���� �� �߿��ϴٰ� ������.
 * */

package BFS;

import java.util.*;
import java.io.*;

public class N6087 {

	static class Dot{
		int x,y,dir,cnt;
		Dot(int x,int y,int dir,int cnt){
			this.x = x;
			this.y = y;
			this.dir = dir; //����
			this.cnt = cnt; //�ſ� ����
		}
	}
	
	//������ �ٲ�� �ſ��� ��ġ�ؾ� �Ѵ�.
	static int [] dx = {0,1,0,-1,0};
	static int [] dy = {0,0,1,0,-1};
	
	static int answer = Integer.MAX_VALUE;
	static int w,h;
	static char [][] map;
	static int [][] visited;
	static int sx,sy,ex,ey;
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		w = Integer.parseInt(str[0]);
		h = Integer.parseInt(str[1]);
		map = new char [h][w];
		visited = new int [h][w];
		int cnt = 0;
		
		for(int i=0;i<h;i++) {
			String input = br.readLine();
			for(int j=0;j<w;j++) {
				visited[i][j] = Integer.MAX_VALUE;
				map[i][j] = input.charAt(j);
				if(map[i][j]=='C' && cnt==0) {
					sx = i;
					sy = j;
					cnt++;
				}
				else if(map[i][j]=='C' && cnt==1) {
					ex = i;
					ey = j;
				}
			}
		}
		bfs();
		System.out.println(answer);
	}
	
	public static void bfs() {
		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(sx,sy,0,0));
		visited[sx][sy] = 0; //��� �ڸ��� 0
		
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			
			for(int i=1;i<=4;i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				if(nx==ex && ny==ey) {
					if(dot.dir!=i)
						answer = Math.min(answer,dot.cnt+1);
					else
						answer = Math.min(answer, dot.cnt);
					break;
				}
							
				if(!isRange(nx,ny)) continue;
				if(map[nx][ny]=='*') continue;
				
				//������ ���ų� ó���� ��
				if(dot.dir==0 || dot.dir==i) {
					if(visited[nx][ny]>=dot.cnt) {
						visited[nx][ny] = dot.cnt;
						queue.add(new Dot(nx,ny,i,dot.cnt));
					}
				}
				//������ �ٸ��ٸ�
				else {
					if(visited[nx][ny]>= dot.cnt+1) {
						visited[nx][ny] = dot.cnt+1;
						queue.add(new Dot(nx,ny,i,dot.cnt+1));
					}
				}
			}
		}
	}
	
	public static boolean isRange(int nx,int ny) {
		if(nx<0 || ny<0 || nx>=h || ny>=w)
			return false;
		else
			return true;
	} 
}