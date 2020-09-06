/*
[백준알고리즘][N7569][토마토]
철수의 토마토 농장에서는 토마토를 보관하는 큰 창고를 가지고 있다. 토마토는 아래의 그림과 같이 격자모양 상자의 칸에 하나씩 넣은 다음, 상자들을 수직으로 쌓아 올려서 창고에 보관한다.
창고에 보관되는 토마토들 중에는 잘 익은 것도 있지만, 아직 익지 않은 토마토들도 있을 수 있다. 보관 후 하루가 지나면, 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들은 익은 토마토의 영향을 받아 익게 된다. 
하나의 토마토에 인접한 곳은 위, 아래, 왼쪽, 오른쪽, 앞, 뒤 여섯 방향에 있는 토마토를 의미한다. 
대각선 방향에 있는 토마토들에게는 영향을 주지 못하며, 토마토가 혼자 저절로 익는 경우는 없다고 가정한다. 철수는 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지 그 최소 일수를 알고 싶어 한다.
토마토를 창고에 보관하는 격자모양의 상자들의 크기와 익은 토마토들과 익지 않은 토마토들의 정보가 주어졌을 때, 
며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라. 단, 상자의 일부 칸에는 토마토가 들어있지 않을 수도 있다.

입력
첫 줄에는 상자의 크기를 나타내는 두 정수 M,N과 쌓아올려지는 상자의 수를 나타내는 H가 주어진다. M은 상자의 가로 칸의 수, N은 상자의 세로 칸의 수를 나타낸다. 
단, 2 ≤ M ≤ 100, 2 ≤ N ≤ 100, 1 ≤ H ≤ 100 이다. 둘째 줄부터는 가장 밑의 상자부터 가장 위의 상자까지에 저장된 토마토들의 정보가 주어진다. 즉, 둘째 줄부터 N개의 줄에는 하나의 상자에 담긴 토마토의 정보가 주어진다.
각 줄에는 상자 가로줄에 들어있는 토마토들의 상태가 M개의 정수로 주어진다. 정수 1은 익은 토마토, 정수 0 은 익지 않은 토마토, 정수 -1은 토마토가 들어있지 않은 칸을 나타낸다. 이러한 N개의 줄이 H번 반복하여 주어진다.

출력
여러분은 토마토가 모두 익을 때까지 최소 며칠이 걸리는지를 계산해서 출력해야 한다. 만약, 저장될 때부터 모든 토마토가 익어있는 상태이면 0을 출력해야 하고, 토마토가 모두 익지는 못하는 상황이면 -1을 출력해야 한다.*/

/*
[나의 생각]
 이전에 풀었던 BFS문제와 다르다고 느껴 Github에 꼭 업로드 하고싶었다.
 이전 문제들은 조건에 맞는 2차원 배열의 원소를 선택해서 거기에서 bfs를 모두 진행하고 다시 main으로 돌아와서 다시 조건을 탐색하는 경우가 많았다.
 하지만 이 문제는 조건에 맞는 3차원 배열의 원소들을 모두 Queue에 한번에 다 집어넣고 그 이후에 그 Queue에 대해서 bfs를 진행한다는 점 때문에 굉장히 헷갈렸다.
 친한친구의 블로그를 보며 참고해서 풀었다ㅠㅠ 문제 해석력을 키워야할 필요가 있겠다는 생각이 들었다!*/

package BFS;

//토마토의 상태
//1 : 익은 토마토
//0 : 익지 않은 토마토
//-1 : 토마토가 없는 자리

import java.io.*;
import java.util.*;

public class N7569 {
	static int m,n,h;
	static int [][][] arr;
	static boolean [][][] visited;
	static int [] dx = {1,-1,0,0,0,0}; 
	static int [] dy = {0,0,1,-1,0,0}; 
	static int [] dz = {0,0,0,0,1,-1};
	static boolean flag = true;
	static int cnt = 0;
	static Queue<tmt> queue = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken()); //상자의 가로칸 수
		n = Integer.parseInt(st.nextToken()); //상자의 세로칸 수
		h = Integer.parseInt(st.nextToken()); //상자의 층
		arr = new int [n][m][h];
		visited = new boolean [n][m][h];
		
		for(int i=0;i<h;i++) {//층
			for(int j=0;j<n;j++) {//행
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<m;k++) {//열
					arr[j][k][i] = Integer.parseInt(st.nextToken());
				}
			}
		}
		for(int i=0;i<h;i++) {//층
			for(int j=0;j<n;j++) {//행
				for(int k=0;k<m;k++) {//열
					if(arr[j][k][i]==1) {
						//1이 들어있는 곳을 모두 Queue에 넣어놓고 하나씩 뽑으면서 bfs를 진행한다.
						queue.add(new tmt(j,k,i));
					}
				}
			}
		}
		
		//한 바퀴 돌때마다 queue에서 뽑힌 1 앞,뒤,좌,우,상,하의 토마토를 모두 익게한다.
		while(true) {
			bfs(queue);
			if(!flag) {
				break;
			}
			cnt++;
			//그리고 while문을 수행할때마다 1일증가한다.
		}
		check();
		
	}
	
	public static void bfs(Queue<tmt> queue) {
		int size = queue.size();
		
		for(int i=0;i<size;i++) {
			tmt t = queue.poll();
			for(int j=0;j<6;j++) {
				int nx = t.x + dx[j];
				int ny = t.y + dy[j];
				int nz = t.z + dz[j];
				
				//조건을 만족하는 것이 있다면 1로 변경 == 익은 토마토와 인접해 있어서 익을 가능성이 있는 토마토를 익게 해준다.
				if(nx>=0 && ny>=0 && nz>=0 && nx<n && ny<m && nz<h) {
					if(arr[nx][ny][nz]==0) {
						arr[nx][ny][nz] = 1;
						queue.add(new tmt(nx,ny,nz));
					}
				}
			}
		}
		
		if(queue.size()==0) {
			flag = false;
			return;
		}
	}
	
	public static void check() {
		for(int i=0;i<h;i++) {//층
			for(int j=0;j<n;j++) {
				for(int k=0;k<m;k++) {
					//익지 않은 토마토가 하나라도 있다면 -1출력
					if(arr[j][k][i]==0) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		//아니라면 cnt출력
		System.out.println(cnt);
	}
	
}

class tmt{
	int x,y,z;
	public tmt(int x,int y,int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}