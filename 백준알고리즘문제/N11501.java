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
			
			/*가치가 떨어지기 직전 시점에 파는것이 아니라, 현재의 주가를 현재일 이후에 가장 비싸게 팔수 있는 날에 판매한다.
			하지만, 앞에서 부터 하나씩 반복해서 탐색하면 시간이 오래걸린다.
			따라서, 뒤쪽부터 탐색하여, 최대값인 max를 갱신하며 max보다 작은 값은 max와의 차이를 더해주어 모두 합한 값을 출력한다. */ 
			
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
