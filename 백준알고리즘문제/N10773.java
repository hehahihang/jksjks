/*����
���ڴ� ���� ����̴� ���Ƹ� ȸ���� �غ��ϱ� ���ؼ� ��θ� �����ϴ� ���̴�.

�����̴� ����̸� ���ͼ� ���� �����ϴ� ���ε�, �ּ��ϰԵ� �׻� ���ž��� �����̴� ���� �Ǽ��� �߸� �θ��� ��� ġ�� �Ͼ�����.

�����̴� �߸��� ���� �θ� ������ 0�� ���ļ�, ���� �ֱٿ� ����̰� �� ���� ����� ��Ų��.

����̴� �̷��� ��� ���� �޾� ���� �� �� ���� ���� �˰� �;� �Ѵ�. ����̸� ��������!

�Է�
ù ��° �ٿ� ���� K�� �־�����. (1 �� K �� 100,000)

���� K���� �ٿ� ������ 1���� �־�����. ������ 0���� 1,000,000 ������ ���� ������, ������ "0" �� ��쿡�� ���� �ֱٿ� �� ���� �����, �ƴ� ��� �ش� ���� ����.

������ "0"�� ��쿡 ���� �� �ִ� ���� ������ ������ �� �ִ�.

���
����̰� ���������� ���� �� ���� ���� ����Ѵ�.*/

/*[�ذ���]
 ������ ��������. 0�� �ƴ� ���� �Է¹����� ���ÿ� push�ϰ�
 0�� ������ pop�� �Ѵ�. ���������� ������ �������������
 ��� ���ڸ� pop�ϸ� ���� sum�� ����Ѵ�!*/

package Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class N10773 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		int sum = 0;
		
		for(int i=0;i<N;i++) {
			int K = Integer.parseInt(br.readLine());
			
			if(K!=0) {
				st.push(K);
			}
			else if(st.isEmpty()==false && K==0){
				st.pop();
			}
		}
		while(st.isEmpty()==false) {
			sum += st.pop();
		}
		System.out.println(sum);
	}
}
