/*[백준][N10711][모래성]

과정

1번째 시도
- 일반적인 BFS + 탐색 문제라고 생각하여 입력받은 맵을 복사하고, 큐를 새로 만들어 다시 복사하는 과정을 거쳐 풀었다
하지만, 역시나... 시간초과

5번째 시도
- 시간 초과를 해결하기 위해 복사하는 부분을 없애고 모래의 좌표(x,y)를 바로 넣었고, 높이가 9인 것들은 제외했다.
이건 메모리 초과

6번째 시도
- 메모리 초과를 해결하는 방법을 생각하지 못해, 블로그를 참조했다.
- 해결 방법은 모래를 기준으로 탐색을 하는 것이 아니라, 모래가 없는 곳을 큐에 넣고 이를 바탕으로 맵을 탐색하여, 
모래를 깎아나가고 깎인 모래의 크기가 map상의 모래의 높이보다 같아지는 순간에 visited 배열로 방문처리를 하고 
해당 위치를 모래가 없는 곳의 좌표로 큐에 다시 넣는다.

계속 반복하며, 큐가 비게되면 물이 들어오기 전에 먼저 탐색을 하고 시작했으므로 answer - 1을 출력하며 종료


피드백
- 생각의 전환이 필요한 문제였다. 
- 메모리 초과, 시간 초과를 해결하기 어렵다면 기준을 뒤집어 반대로 생각할 수 있는 힘이 필요할 것 같다.

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
