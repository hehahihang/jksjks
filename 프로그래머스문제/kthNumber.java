/*[���α׷��ӽ�][LEVEL1][K��°��]
<���� ����>
�迭 array�� i��° ���ں��� j��° ���ڱ��� �ڸ��� �������� ��, k��°�� �ִ� ���� ���Ϸ� �մϴ�.

���� ��� array�� [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3�̶��

array�� 2��°���� 5��°���� �ڸ��� [5, 2, 6, 3]�Դϴ�.
1���� ���� �迭�� �����ϸ� [2, 3, 5, 6]�Դϴ�.
2���� ���� �迭�� 3��° ���ڴ� 5�Դϴ�.
�迭 array, [i, j, k]�� ���ҷ� ���� 2���� �迭 commands�� �Ű������� �־��� ��, 
commands�� ��� ���ҿ� ���� �ռ� ������ ������ �������� �� ���� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

<���ѻ���>
array�� ���̴� 1 �̻� 100 �����Դϴ�.
array�� �� ���Ҵ� 1 �̻� 100 �����Դϴ�.
commands�� ���̴� 1 �̻� 50 �����Դϴ�.
commands�� �� ���Ҵ� ���̰� 3�Դϴ�.

<����� ��>
array					commands							return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 
<����>
- �̰͵� ���� ��������� ���� �ذ��ϴµ��� �ٸ� ����Ʈ�� ���� ����٤Ф�
arr_count��� ������ �ִ°��� ����Ʈ��� �����Ѵ�.
���ο� �迭 temp�� ����� �̰��� arr_count�� index��� �����ϰ� 1�� ������Ű��
i��°���� j���� ������ ���Ҹ� ��´�. ���� �迭 temp�� �����ϰ�.
���� �迭 answer�� ó������ temp�� k��° ���Ҹ� �����Ѵ�. 
 */
package Level1;

import java.util.Arrays;

public class kthNumber {
	
	public static int [] solution(int [] array,int [][] commands) {
		int [] answer = new int [commands.length];
		
		for(int i=0;i<commands.length;i++) {
			int first = commands[i][0];
			int last = commands[i][1];
			int k = commands[i][2];
		
			int arr_count = 0; 
			int cnt = 0;
			
			int [] temp = new int [last-first+1];
			
			for(int j=first-1;j<=last-1;j++) {
				temp[arr_count] = array[j];
				arr_count++;
			}
			Arrays.sort(temp);
			answer[cnt] = temp[k];
			cnt++;
			arr_count = 0;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
