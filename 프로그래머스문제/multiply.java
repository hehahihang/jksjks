/*[프로그래머스][LEVEL2][행렬의 곱셈]*/

package LEVEL2;

public class multiply {
	
	//2X3 3X5라고 해보자
	public int [][] solution(int [][] arr1,int [][] arr2){
		int [][] answer = new int [arr1.length][arr2[0].length];
		
		for(int i=0;i<arr1.length;i++) {
			for(int j=0;j<arr1[0].length;j++) {
				for(int k=0;k<arr2[0].length;k++) {
					answer[i][k] = arr1[i][j]*arr2[j][k];
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
