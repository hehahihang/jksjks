package Greedy;

import java.util.*;
import java.io.*;

public class N11501 {

	static int n;
	static int [] arr;
	static boolean [] visited;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			n = Integer.parseInt(br.readLine());
			arr = new int [n];
			visited = new boolean [n];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0;i<n;i++)
				arr[i] = Integer.parseInt(st.nextToken());
			
			boolean flag = false;
			for(int i=0;i<n-1;i++) {
				if(arr[i]<arr[i+1]) {
					flag  = true;
					break;
				}
			}
			
			int max = 0;
			long sum = 0;
			
			/*��ġ�� �������� ���� ������ �Ĵ°��� �ƴ϶�, ������ �ְ��� ������ ���Ŀ� ���� ��ΰ� �ȼ� �ִ� ���� �Ǹ��Ѵ�.
			������, �տ��� ���� �ϳ��� �ݺ��ؼ� Ž���ϸ� �ð��� �����ɸ���.
			����, ���ʺ��� Ž���Ͽ�, �ִ밪�� max�� �����ϸ� max���� ���� ���� max���� ���̸� �����־� ��� ���� ���� ����Ѵ�. */ 
			
			for(int i=n-1;i>=0;i--) {
				//
				if(arr[i]>max) {
					max = arr[i];
				}
				else{
					sum += (max-arr[i]);
				}
			}
			System.out.println(sum);
		}
	}
}
