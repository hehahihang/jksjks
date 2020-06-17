package binarySearch;

import java.util.*;
import java.io.*;

public class N10816 {

	static int [] num1;
	static int [] num2;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		num1 = new int [n];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
			num1[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(num1);
		
		int m = Integer.parseInt(br.readLine());
		num2 = new int [m];
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<m;i++) 
			num2[i] = Integer.parseInt(st.nextToken());
		
		int [] answer = new int [m];
		for(int i=0;i<m;i++) {
			if(upperBound(i)==m && lowerBound(i)==m)
				answer[i] = 0;
			else
				answer[i] = upperBound(i) - lowerBound(i);
		}
		for(int i=0;i<answer.length;i++)
			bw.write(answer[i]+" ");
		bw.flush();
		bw.close();
	}
	
	//num2[index] : 내가 찾고자하는 값 == target , 이하 target이라 한다.
	//UpperBound : target보다 큰 값이 나오는 첫번째 인덱스를 반환한다.
	private static int upperBound(int index){ //target보다 큰 값이 나오는 첫번째 인덱스를 반환
		int left = 0;
		int right = num1.length; 
		//UpperBound는 target보다 큰 값이 처음으로 나오는 인덱스를 반환한다.
		//찾는 구간안에 없을 경우에는 가장 마지막+1 의 위치를 전달해야하므로 (right == 배열의길이)
		int mid;
		while(left<right) {
			mid = (left+right)/2;
			if(num1[mid]<=num2[index]) { //target보다 처음으로 큰 값이 나오는 경우를 찾는 것이므로
				left = mid+1;			//num1[mid]값보다 작거나 같으면 left = mid+1로 한다.
			}
			else 
				right = mid; //num1[mid]>target 이더라도 모든 인덱스에 대해서 탐색해야하므로 right = mid로 설정한다.
		}
		return right;
	}
	
	private static int lowerBound(int index){
		int left = 0;
		int right = num1.length;
		//LowerBound는 target과 같거나 큰 값이 처음으로 나올때를 return 해야한다.
		//찾는 구간안에 없을 경우에는 가장 마지막+1의 위치를 전달해야한다.
		//따라서 right = 배열의 길이-1 이 아니라 배열의 길이로 전달해야한다.
		int mid;
		while(left<right) {
			mid = (left+right)/2;
			if(num1[mid]<num2[index]) { //target의 값보다 크거나 같은 첫번째 위치를 찾는 것이므로 등호를 포함하지 않는다.
				left = mid+1; 			//그래서 target보다 현재 num1[mid]값이 작을때만 left = mid+1로
			}
			else
				right = mid;
		}
		return right;
	}
}
