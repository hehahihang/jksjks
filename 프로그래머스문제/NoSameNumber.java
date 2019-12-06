/*[���α׷��ӽ�][Level1][���� ���ڴ� �Ⱦ�]
�迭 arr�� �־����ϴ�. �迭 arr�� �� ���Ҵ� ���� 0���� 9������ �̷���� �ֽ��ϴ�. 
�̶�, �迭 arr���� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� �����Ϸ��� �մϴ�. 
��, ���ŵ� �� ���� ������ ��ȯ�� ���� �迭 arr�� ���ҵ��� ������ �����ؾ� �մϴ�. ���� ���,

arr = [1, 1, 3, 3, 0, 1, 1] �̸� [1, 3, 0, 1] �� return �մϴ�.
arr = [4, 4, 4, 3, 3] �̸� [4, 3] �� return �մϴ�.
�迭 arr���� ���������� ��Ÿ���� ���ڴ� �����ϰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
�迭 arr�� ũ�� : 1,000,000 ������ �ڿ���
�迭 arr�� ������ ũ�� : 0���� ũ�ų� ���� 9���� �۰ų� ���� ����

����� ��
arr	             answer
[1,1,3,3,0,1,1]  [1,3,0,1]
[4,4,4,3,3]      [4,3]

[�ذ� ���]
1.Arraylist�� ����Ͽ� answer�� �� ����Ʈ�� �����.
2.�Է� �迭�� ���� ó�� ���Ҵ� list�� �߰��Ѵ�.
3.���� for�ݺ����� ���� ����Ʈ i��°�� i-1��°�� ���Ͽ� �� ���Ұ� �ٸ��ٸ�
arrlist�� i��° ���Ҹ� �߰��Ѵ�.
4.�� �� list�� ��Ҹ� answer�迭�� �ű��.*/

import java.util.*;

public class NoSameNumber {
	
	public static int [] solution(int [] arr)
	{
		
		ArrayList<Integer> arrlist = new ArrayList<>();
		
		
		for(int i=0;i<arr.length;i++)
		{
			if(i==0)
				arrlist.add(arr[i]);
			else
			{
				if(arr[i-1]!=arr[i])
				{
					arrlist.add(arr[i]);
				}
			}
		}
		int [] answer = new int [arrlist.size()];

		for(int i=0;i<arrlist.size();i++)
		{
			answer[i] = arrlist.get(i);
		}
		
		for(int i=0;i<answer.length;i++)
		{
			System.out.print(answer[i]+" ");
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1,1,3,3,0,1,1};
		solution(arr);
	}
}
