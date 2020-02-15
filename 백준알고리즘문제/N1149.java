/*[���ؾ˰���][N1149][RGB�Ÿ�]
����
RGB�Ÿ��� ��� ������� ���� ����, �ʷ�, �Ķ��߿� �ϳ��� ĥ�Ϸ��� �Ѵ�. 
����, �׵��� ��� �̿��� ���� ������ ĥ�� �� ���ٴ� ��Ģ�� ���ߴ�. 
�� i�� �̿��� �� i-1�� �� i+1�̰�, ù ���� ������ ���� �̿��� �ƴϴ�.

�� ���� �������� ĥ�� �� ��� ���, �ʷ����� ĥ�� �� ��� ���, �Ķ����� ��� ����� �־��� ��,
��� ���� ĥ�ϴ� ����� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� ���� �� N�� �־�����. N�� 1,000���� �۰ų� ����. 
��° �ٺ��� N���� �ٿ� �� ���� ��������, �ʷ�����, �Ķ����� ĥ�ϴ� ����� �־�����. 
����� 1,000���� �۰ų� ���� �ڿ����̴�.

���
ù° �ٿ� ��� ���� ĥ�ϴ� ����� �ּڰ��� ����Ѵ�.

���� �Է� 1  	���� ��� 1
3		 	96
26 40 83
49 60 57
13 89 99
*/

package Dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class N1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	
		int [][] cost = new int [n+1][3]; //�� ���� ĥ�ϴµ��� ���� ���
		int [][] dp = new int [n+1][3];
		
		//�� ������ ����Ʈ ����� [][] 2�����迭�� ����
		for(int i=1;i<=n;i++) { //1���� 2���� 3�����̹Ƿ� 1���� n�����ߴ�.
			String [] str = br.readLine().split(" ");
			for(int j=0;j<3;j++) {
				cost[i][j] = Integer.parseInt(str[j]); //�� ���� ������� ������ ������ ĥ�� ����� ����ִ� cost�迭
			}
		}
		
		//������� �� ĥ�ϴµ� ����� dp���� ù���� ������� �ʱ�ȭ�Ѵ�.
		dp[1][0] = cost[1][0]; 
		dp[1][1] = cost[1][1];
		dp[1][2] = cost[1][2];
		
		for(int i=2;i<=n;i++) {
			// 2������ n������ ���Ѵ�.
			// �������� ������ ����� �ּҰ��� ���� ���� �ּҰ��� ���Ѵ�.
			dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2])+cost[i][0];
			dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2])+cost[i][1];
			dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1])+cost[i][2];
		}
		
		int tmp = Math.min(dp[n][0], dp[n][1]);
		System.out.println(Math.min(tmp,dp[n][2]));
		
	}
}

/*
[����]
���� ��ȹ���̳� Brute�������� ��� ����� ���� �˻��ϰų� �̷������� ���� ������Ѵٰ� ������.
������ ������ Ǯ��� ������� ������ �ذ����� �Ӹ��� �����ϰ� �˰����� �ذ��Ϸ��� �ؾ��Ѵٴ� �����̴�.
*/
