/*[백준][N6087][레이저통신]
 * 문제
크기가 1×1인 정사각형으로 나누어진 W×H 크기의 지도가 있다. 지도의 각 칸은 빈 칸이거나 벽이며, 두 칸은 'C'로 표시되어 있는 칸이다.

'C'로 표시되어 있는 두 칸을 레이저로 통신하기 위해서 설치해야 하는 거울 개수의 최솟값을 구하는 프로그램을 작성하시오. 레이저로 통신한다는 것은 두 칸을 레이저로 연결할 수 있음을 의미한다.

레이저는 C에서만 발사할 수 있고, 빈 칸에 거울('/', '\')을 설치해서 방향을 90도 회전시킬 수 있다. 

아래 그림은 H = 8, W = 7인 경우이고, 빈 칸은 '.', 벽은 '*'로 나타냈다. 왼쪽은 초기 상태, 오른쪽은 최소 개수의 거울을 사용해서 두 'C'를 연결한 것이다.

7 . . . . . . .         7 . . . . . . .
6 . . . . . . C         6 . . . . . /-C
5 . . . . . . *         5 . . . . . | *
4 * * * * * . *         4 * * * * * | *
3 . . . . * . .         3 . . . . * | .
2 . . . . * . .         2 . . . . * | .
1 . C . . * . .         1 . C . . * | .
0 . . . . . . .         0 . \-------/ .
  0 1 2 3 4 5 6           0 1 2 3 4 5 6
입력
첫째 줄에 W와 H가 주어진다. (1 ≤ W, H ≤ 100)

둘째 줄부터 H개의 줄에 지도가 주어진다. 지도의 각 문자가 의미하는 것은 다음과 같다.

.: 빈 칸
*: 벽
C: 레이저로 연결해야 하는 칸
'C'는 항상 두 개이고, 레이저로 연결할 수 있는 입력만 주어진다.

출력
첫째 줄에 C를 연결하기 위해 설치해야 하는 거울 개수의 최솟값을 출력한다.*/


/*[생각]
 * 1. 첫번쨰 시도
 * - visited배열을 boolean 타입으로 선언하여 방문하지 않은 곳만 방문하도록 하여 제출했으나 실패
 * 이유 : 해당 지점의 방문 여부가 중요한 것이 아니라, 이미 방문했던 지점이더라도 방향을 바꾸지 않아서 거울의 개수가 더 작다면 탐색해야하기 때문이다
 *
 * 2. 두번쨰 시도
 * - 해결 방법이 떠오르지 않아 블로그를 참고했다.
 * - visted 배열을 int 형으로 선언하여 방문 했을때의 거울 갯수를 기준으로 방문 + 탐색
 * 
 * 피드백 : 비슷한 탐색만 풀다보니 너무 기계적으로 풀려고 생각하는 것 같다.
 * 때로는 방문의 여부보다는 방문 시 어떠한 조건으로 방문해야하는지를 파악하는 것이 중요하다.
 * 단순히 코드, 풀이방법을 외우기보다는 문제를 이해하고 어떠한 방식으로 풀어나가야할지 생각하는 힘이 더 중요하다고 느꼈다.
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
			this.dir = dir; //방향
			this.cnt = cnt; //거울 개수
		}
	}
	
	//방향이 바뀌면 거울을 설치해야 한다.
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
		visited[sx][sy] = 0; //출발 자리는 0
		
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
				
				//방향이 같거나 처음일 때
				if(dot.dir==0 || dot.dir==i) {
					if(visited[nx][ny]>=dot.cnt) {
						visited[nx][ny] = dot.cnt;
						queue.add(new Dot(nx,ny,i,dot.cnt));
					}
				}
				//방향이 다르다면
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