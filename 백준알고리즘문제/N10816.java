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
	
	//num2[index] : ���� ã�����ϴ� �� == target , ���� target�̶� �Ѵ�.
	//UpperBound : target���� ū ���� ������ ù��° �ε����� ��ȯ�Ѵ�.
	private static int upperBound(int index){ //target���� ū ���� ������ ù��° �ε����� ��ȯ
		int left = 0;
		int right = num1.length; 
		//UpperBound�� target���� ū ���� ó������ ������ �ε����� ��ȯ�Ѵ�.
		//ã�� �����ȿ� ���� ��쿡�� ���� ������+1 �� ��ġ�� �����ؾ��ϹǷ� (right == �迭�Ǳ���)
		int mid;
		while(left<right) {
			mid = (left+right)/2;
			if(num1[mid]<=num2[index]) { //target���� ó������ ū ���� ������ ��츦 ã�� ���̹Ƿ�
				left = mid+1;			//num1[mid]������ �۰ų� ������ left = mid+1�� �Ѵ�.
			}
			else 
				right = mid; //num1[mid]>target �̴��� ��� �ε����� ���ؼ� Ž���ؾ��ϹǷ� right = mid�� �����Ѵ�.
		}
		return right;
	}
	
	private static int lowerBound(int index){
		int left = 0;
		int right = num1.length;
		//LowerBound�� target�� ���ų� ū ���� ó������ ���ö��� return �ؾ��Ѵ�.
		//ã�� �����ȿ� ���� ��쿡�� ���� ������+1�� ��ġ�� �����ؾ��Ѵ�.
		//���� right = �迭�� ����-1 �� �ƴ϶� �迭�� ���̷� �����ؾ��Ѵ�.
		int mid;
		while(left<right) {
			mid = (left+right)/2;
			if(num1[mid]<num2[index]) { //target�� ������ ũ�ų� ���� ù��° ��ġ�� ã�� ���̹Ƿ� ��ȣ�� �������� �ʴ´�.
				left = mid+1; 			//�׷��� target���� ���� num1[mid]���� �������� left = mid+1��
			}
			else
				right = mid;
		}
		return right;
	}
}
