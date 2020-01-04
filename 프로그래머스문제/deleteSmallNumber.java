/*[���α׷��ӽ�][LEVEL1][���� ���� �� �����ϱ�]
���� ����
������ ������ �迭, arr ���� ���� ���� ���� ������ �迭�� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
��, �����Ϸ��� �迭�� �� �迭�� ��쿣 �迭�� -1�� ä�� �����ϼ���. 
������� arr�� [4,3,2,1]�� ���� [4,3,2]�� ���� �ϰ�, [10]�� [-1]�� ���� �մϴ�.

���� ����
arr�� ���� 1 �̻��� �迭�Դϴ�.
�ε��� i, j�� ���� i �� j�̸� arr[i] �� arr[j] �Դϴ�.

����� ��
arr			return
[4,3,2,1]	[4,3,2]
[10]		[-1]
		
<�ذ���>
- �迭arr���̰� 1�̸� answer�� -1�� �־� return�Ѵ�
- ���� ���� ���� ��ġ�� ����Ű�� minIndex�� �����ϰ�
for���� �ݺ��ϸ� �����Ѵ�
- ���� ���� ������ �ٷ� �� ���� �ε����� �ϳ��� ������ �̵���Ų��*/
		
public class deleteSmallNumber {
	
	public static int [] solution (int [] arr)
	{
		if(arr.length==1){
			int [] answer = {-1};
			return answer;
		}
		
		int [] answer = new int [arr.length-1];
		int minIndex=0;
		
		for(int i=0;i<arr.length;i++){
			if(arr[minIndex]>arr[i])
				minIndex = i;
		}
		
		for(int i=minIndex+1;i<arr.length;i++) {
			arr[i-1] = arr[i];
		}
		for(int i=0;i<answer.length;i++) {
			answer[i] = arr[i];
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] arr = {4,2,3,5};
		int [] answer = solution(arr);
		for(int i=0;i<answer.length;i++)
			System.out.print(answer[i]+" ");
	}
}

/*[����]
ó���� Array.sort�� �̿��ؼ� �����ϰ� �Ǿ� ���ڸ� �����ϰ�,
���� ���ں��� answer�迭�� �ִ� ����� �̿��߾���.
������ ������ �迭�� �����ؼ� �������� ��󳻴°��̾ƴ϶�
�� �迭 �״�ο��� ���� ���� ���� �����°��̾����Ƿ� ���� ��� Ʋ�Ⱦ���..*/
