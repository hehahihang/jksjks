/*
[백준][N14891][톱니바퀴]

문제 생각 : 각 톱니에 해당하는 객체를 만들어 구현하려고 했으나 실패!
해결 방법 : 뱀귤님의 블로그를 참조했고, 배열과 재귀를 이용하여 풀이한 후 이해했다.
 
*/
package Samsung;

import java.util.*;
import java.io.*;

public class N14891 {

	static int [][] arr = new int [4][8];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<4;i++) {
			String s = br.readLine();
			for(int j=0;j<8;j++) {
				arr[i][j] = s.charAt(j) - '0';
			}
		}
		int k = Integer.parseInt(br.readLine());
		for(int i=0;i<k;i++) {
			String [] str = br.readLine().split(" ");
			int idx = Integer.parseInt(str[0]);
			int dir = Integer.parseInt(str[1]);
			
			//톱니바퀴의 번호는 1~4이니까
			solution(idx-1,dir);
		}
		
		int score = 0;
		for(int i=0;i<4;i++) {
			int p = (int)Math.pow(2, i);
			if(arr[i][0]==1) {
				score += arr[i][0]*p;
			}
		}
		System.out.println(score);
	}
	
	//회전할때 내 옆에있는 톱니바퀴는 반대방향으로 회전하거나, 가만히 있음 따라서 -dir을 넣는다.
	public static void solution(int idx,int dir) {
		left(idx-1,-dir);
		right(idx+1, -dir);
		rotate(idx, dir);
	}
	
	//시계방향으로 돌때, 3시==2 && 9시==6
	public static void left(int idx,int dir) {
		if(idx<0) {
			return;
		}
		//내 톱니의 3시방향과 , 내 오른쪽 톱니(원래 톱니)의 9시가 같지않다면 회전해야하니까 그 왼쪽으로 재귀탐색
		if(arr[idx][2]!=arr[idx+1][6]) {
			left(idx-1, -dir);
			//그리고 회전시킨다
			rotate(idx, dir);
		}
	}
	
	public static void right(int idx,int dir) {
		if(idx>3) {
			return;
		}
		//내 톱니의 3시방향과 , 내 왼쪽 톱니(원래 톱니)의 9시가 같지않다면 회전해야하니까 그 오른쪽으로 재귀탐색
		if(arr[idx][6]!=arr[idx-1][2]) {
			right(idx+1, -dir);
			//그리고 회전시킨다.
			rotate(idx,dir);
		}
	}
	
	public static void rotate(int idx,int dir) {
		//정방향 회전
		if(dir==1) {
			int tmp = arr[idx][7];
			for(int i=7;i>0;i--) {
				arr[idx][i] = arr[idx][i-1];
			}
			arr[idx][0] = tmp;
		}
		//역방향 회전
		else {
			int tmp = arr[idx][0];
			for(int i=0;i<7;i++) {
				arr[idx][i] = arr[idx][i+1];
			}
			arr[idx][7] = tmp;
		}
	}
}