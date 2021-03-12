/*[백준][N16236][아기상어]
 * 개어려운 문제였다 10번시도끝에 맞췄지만 솔직히 구현하는데 시간도 오래걸렸고, 해결방법도 생각나지 않아 다른분의 블로그를 참조했다.
 * 
 * 핵심 : 물고기들과 아기 상어간의 거리를 dist라는 배열에 담는 것이 핵심이라고 생각한다.
 * 그리고 이러한 물고기들을 먹을 수 있냐 없냐, 아기 상어가 움직일 수 있냐 없냐를 파악하면된다.
 * 1) 최단경로 : 어떻게 물고기까지의 최단거리를 구할 것이냐 -> BFS를 사용해서 현재 상어의 위치로부터 모든 물고기의 이동거리를 찾고, 그 중에서 가장 거리가 짧은 물고기를 찾는다.
 * 2) 자료구조 : 어떻게 지도와 위치정보를 저장할 것인지 -> class를 사용하여 저장
 * 3) 이동 : 어떻게 상하좌우로 1칸씩 움직일지
 * 4) 거리가 가장 짧은 물고기가 여러 마리일 경우, 어떻게 제일 위쪽 제일 왼쪽 물고기를 찾을지 if else 구문 minX, minY, minDist;
 * */

package Simulation;

import java.util.*;
import java.io.*;

public class N16236 {
	
	//물고기의 위치와 거리를 담을 클래
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
	static int time = 0; //시간
	static int sx,sy;
	static int size = 2; //상어의 처음 사이즈
	static int minX,minY,minDist;
	static int eatingCnt = 0; //아기상어가 먹은 
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int [n][n];
		//0빈칸, 123456물고기의 크기 9상어의 위치
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==9) {
					sx = i;
					sy = j;
					arr[i][j] = 0;
					//현재 상어의 위치, 0으로 초기화 해준다.
				}
			}
		}
		
		while(true) {
			dist = new int [n][n]; //한 사이클을 돌때마다 상어에서 떨어진 거리를 초기화 해준다.
			minX = Integer.MAX_VALUE; //그 거리의 x값
			minY = Integer.MAX_VALUE; //그 거리의 y값
			minDist = Integer.MAX_VALUE; //그리고 움직이는 거리
			
			//현재 상어의 위치에서 BFS탐색을 들어간다.
			bfs(sx,sy);
			
			//이동을 한번도 못했따면 minX와 minY가 초기값 그대로 일 것
			if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
				eatingCnt++;
				arr[minX][minY] = 0; //먹은 물고기의 위치를 0으로 갱신해준다.
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
	
	
	//아기상어는 자신보다 큰 크기의 물고기가 있는 칸은 지나갈 수 없다.
	//나머지 칸은 모두 지나갈 수 있다.
	//아기상어는 자기 자신의 크기보다 작은 물고기만 먹을 수 있다.
	//크기가 같은 물고기는 먹을 수 없지만, 지나갈 수는 있다.
	
	//상어의 위치에서 bfs실행
	public static void bfs(int x,int y) {
		Queue<Dot> queue = new LinkedList<>();
		queue.add(new Dot(sx,sy)); //현재 위치를 큐에 넣고 탐색한다.
		while(!queue.isEmpty()) {
			Dot dot = queue.poll();
			for(int i=0;i<4;i++) {
				int nx = dot.x + dx[i];
				int ny = dot.y + dy[i];
				
				//1.상어가 움직이려는 곳이 좌표상으로 가능한 곳인지 2.크기가 작거나 같은 물고기가 있어 이동이 가능한지 3.이곳까지의 거리를 방문한적이 있는지
				if(isPossible(nx,ny) && isMove(nx,ny) && dist[nx][ny]==0) {
					dist[nx][ny] = dist[dot.x][dot.y] + 1; //첫 방문이므로 이전까지의 거리에서 1을 더한다.
					
					//물고기를 먹을 수 있다면, 그리고 거리가 더 작다면 최단거리를 최신화
					if(isEat(nx,ny)) {
						if(minDist>dist[nx][ny]) {
							minDist = dist[nx][ny];
							minX = nx;
							minY = ny;
						}
						//먹을 수는 있는데 거리가 같다면
						else if(minDist==dist[nx][ny]) {
							//위에서 부터 떨어진 거리가 같다면
							if(minX==nx) {
								//가장 왼쪽에 있는걸 먹는다. 그게 곧 좌표가 된다.
								if(minY>ny) {
									minX = nx;
									minY = ny;
								}
							}
							//근데 가장 위에 있는걸 먹어야 한다. 그건 X값이 가장 작은거
							else if(minX>nx) {
								minX = nx;
								minY = ny;
							}
						}
					}
					//물고기를 찾았다고 바로 넣는 것이 아니라 가장 가까운 물고기가 여러마리인 경우 가장 먼저 먹기 위해서
					//큐에 마지막으로 넣는다.
					//물고기의 위치를 큐에 넣어준다.
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
