/*����
� �ڿ��� N�� ���� ��, �� �ڿ��� N�� �������� N�� N�� �̷�� �� �ڸ����� ���� �ǹ��Ѵ�. � �ڿ��� M�� �������� N�� ���, M�� N�� �����ڶ� �Ѵ�. 
���� ���, 245�� �������� 256(=245+2+4+5)�� �ȴ�. ���� 245�� 256�� �����ڰ� �ȴ�. ����, � �ڿ����� ��쿡�� �����ڰ� ���� ���� �ִ�. 
�ݴ��, �����ڰ� ���� ���� �ڿ����� ���� �� �ִ�.
�ڿ��� N�� �־����� ��, N�� ���� ���� �����ڸ� ���س��� ���α׷��� �ۼ��Ͻÿ�.

�Է�
ù° �ٿ� �ڿ��� N(1 �� N �� 1,000,000)�� �־�����.

���
ù° �ٿ� ���� ����Ѵ�. �����ڰ� ���� ��쿡�� 0�� ����Ѵ�.

���� �Է� 1 216
���� ��� 1 198

[�ذ� ���]
��� �ڿ����� �����ڴ� �ڱ� �ڽź��� �۴ٰ� �����ߴ�.
���� �ڱ��ڽź��� 1�� ���ҽ�Ű�� �ݺ��� �����Ѵ�.
1.�ݺ��� ���� ����i�� String���� ��ȯ�ϰ� �̸� �ٽ� char�� ��ȯ�� ������ �ڸ����� sum��  ���Ѵ�.
3.i+sum�� �Է¹��� ���� k�� ���ٸ� i�� ����Ѵ�. */

package Brute;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class N2231 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int k = Integer.parseInt(br.readLine());
		int idx = k;
		int res=0;
		
		for(int i=idx;i>0;i--)
		{
			int sum=0;
			String str = String.valueOf(i);
			
			for(int j=0;j<str.length();j++)
			{
				sum += str.charAt(j)-48;
			}
			if(i+sum==k)
			{
				res = i;
			}
		}
		if(res==0)
			System.out.println(0);
		else
			System.out.println(res);
		
	}
}

/*����
- ������ �ڸ����� ���ϴ� ����� ���� while���� �̿��ؼ� count�� ����ϰ�
�� ũ�� ��ŭ�� �迭�� �����ϰ� �ٽ� while���� �����ؼ� �ڸ����� ���߾���. ������ ��ȿ������ ���.. 
for���� �ݺ��Ͽ� i�� String���� ������ �ڸ��� char������ �ٲ㼭 �ذ��ϴ� ����� ���� ���ߴ�....
�̷��Ե� ���� �� �� �ִ� ��Ⱑ�Ǿ���!*/

