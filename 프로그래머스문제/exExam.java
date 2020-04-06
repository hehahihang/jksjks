/*[���α׷��ӽ�][LEVEL1][���ǰ��]
<����>
���� ����
�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. 
1�� �������� ������ �������� ������ ���� ����ϴ�.

1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, 
���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

<���� ����>
������ �ִ� 10,000 ������ �����Ǿ��ֽ��ϴ�.
������ ������ 1, 2, 3, 4, 5�� �ϳ��Դϴ�.
���� ���� ������ ���� ����� ������ ���, return�ϴ� ���� �������� �������ּ���.

<����� ��>
answers		return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]

<����>
- �� �����ڰ� ��� ����� �迭�� �����س��� �̸� ���ϴ� ����.
���� ��ν������� �κ��� ���� ���� ������ ����������� 1,2,3 ��ȣ�� �ο��ؾ��Ѵٴ°�
�̸� arrlist�� ���� ���� ũ�ٸ� i+1�� ��ȣ�� �ο��ϴ� ����� ����ߴ�.

*/
package Level1;

import java.util.ArrayList;

public class exExam {
	
	public static int [] solution(int [] answers) {
		int [] result = {};
		
		int [] arr1 = {1,2,3,4,5};
		int [] arr2 = {2,1,2,3,2,4,2,5};
		int [] arr3 = {3,3,1,1,2,2,4,4,5,5};
		
		int [] answer = {0,0,0};
		
		
		for(int i=0;i<answers.length;i++)
        {
            if(answers[i]==arr1[i%5])
                answer[0]++;
        }
        for(int j=0;j<answers.length;j++)
        {
            if(answers[j]==arr2[j%8])
                answer[1]++;
        }
        for(int k=0;k<answers.length;k++)
        {
            if(answers[k]==arr3[k%10])
                answer[2]++;
        }
		
		int max = Math.max(answer[0],Math.max(answer[1], answer[2]));
		
		ArrayList<Integer> arrlist = new ArrayList<>();
		
		for(int i=0;i<answer.length;i++) {
			if(max==answer[i])
				arrlist.add(i+1);
		}
		
		result = new int [arrlist.size()];
		
		for(int i=0;i<arrlist.size();i++) {
			result[i] = arrlist.get(i);
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] answers = {1,3,2,4,2};
	}
}
