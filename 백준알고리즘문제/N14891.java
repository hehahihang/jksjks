/*
[����][N14891][��Ϲ���]

���� ���� : �� ��Ͽ� �ش��ϴ� ��ü�� ����� �����Ϸ��� ������ ����!
�ذ� ��� : ��ִ��� ��α׸� �����߰�, �迭�� ��͸� �̿��Ͽ� Ǯ���� �� �����ߴ�.
 
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
			
			//��Ϲ����� ��ȣ�� 1~4�̴ϱ�
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
	
	//ȸ���Ҷ� �� �����ִ� ��Ϲ����� �ݴ�������� ȸ���ϰų�, ������ ���� ���� -dir�� �ִ´�.
	public static void solution(int idx,int dir) {
		left(idx-1,-dir);
		right(idx+1, -dir);
		rotate(idx, dir);
	}
	
	//�ð�������� ����, 3��==2 && 9��==6
	public static void left(int idx,int dir) {
		if(idx<0) {
			return;
		}
		//�� ����� 3�ù���� , �� ������ ���(���� ���)�� 9�ð� �����ʴٸ� ȸ���ؾ��ϴϱ� �� �������� ���Ž��
		if(arr[idx][2]!=arr[idx+1][6]) {
			left(idx-1, -dir);
			//�׸��� ȸ����Ų��
			rotate(idx, dir);
		}
	}
	
	public static void right(int idx,int dir) {
		if(idx>3) {
			return;
		}
		//�� ����� 3�ù���� , �� ���� ���(���� ���)�� 9�ð� �����ʴٸ� ȸ���ؾ��ϴϱ� �� ���������� ���Ž��
		if(arr[idx][6]!=arr[idx-1][2]) {
			right(idx+1, -dir);
			//�׸��� ȸ����Ų��.
			rotate(idx,dir);
		}
	}
	
	public static void rotate(int idx,int dir) {
		//������ ȸ��
		if(dir==1) {
			int tmp = arr[idx][7];
			for(int i=7;i>0;i--) {
				arr[idx][i] = arr[idx][i-1];
			}
			arr[idx][0] = tmp;
		}
		//������ ȸ��
		else {
			int tmp = arr[idx][0];
			for(int i=0;i<7;i++) {
				arr[idx][i] = arr[idx][i+1];
			}
			arr[idx][7] = tmp;
		}
	}
}