/*[����][10610][30]
 * 
 * ����
��� ��, �̸��ڴ� �쿬�� ��Ÿ����� ��� N�� ���Ҵ�. �̸��ڴ� 30�̶� ���� �����ϱ� ������, 
�״� ��Ÿ����� ã�� ���� ���Ե� ���ڵ��� ���� 30�� ����� �Ǵ� ���� ū ���� ����� �;��Ѵ�.

�̸��ڸ� ���� �װ� ����� �;��ϴ� ���� ����ϴ� ���α׷��� �ۼ��϶�.

�Է�
N�� �Է¹޴´�. N�� �ִ� 105���� ���ڷ� �����Ǿ� ������, 0���� �������� �ʴ´�.

���
�̸��ڰ� ����� �;��ϴ� ���� �����Ѵٸ� �� ���� ����϶�. �� ���� �������� �ʴ´ٸ�, -1�� ����϶�.


-> ������ �������� �������� ����� ����

ó������ ������ ����ؼ� ������ �ذ������� �޸� �ʰ�....
���� �׸��� ����ؾ� �Ѵٴ� ���� �ٸ� ��α׿��� �����ߴ�.
�������̴� ���������� �� ȿ�������� �ذ��� �� �ִ� ����� �����ϴ� ��Ⱑ �ƴ�.

*/
import java.util.*;
import java.io.*;

public class N10610 {
	static int n;
	static int [] arr;
	static int answer = 0;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		n = str.length();
		arr = new int [10];
		long sum = 0;
		for(int i=0;i<n;i++) {
			int tmp = str.charAt(i) - '0';
			sum += tmp;
			arr[tmp]++;
		}
		
		if(!str.contains("0") || sum%3!=0) {
			System.out.println(-1);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=9;i>=0;i--) {
			while(arr[i]>0) {
				sb.append(i);
				arr[i]--;
			}
		}
		System.out.println(sb.toString());
	}
}