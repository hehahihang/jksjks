/*[���α׷��ӽ�][LEVEL1][���ڿ� ������������ ��ġ�ϱ�]
���� ����
���ڿ� s�� ��Ÿ���� ���ڸ� ū�ͺ��� ���� ������ ������ ���ο� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.
s�� ���� ��ҹ��ڷθ� �����Ǿ� ������, �빮�ڴ� �ҹ��ں��� ���� ������ �����մϴ�.

���� ����
str�� ���� 1 �̻��� ���ڿ��Դϴ�.

����� ��
s	      return
Zbcdefg	  gfedcbZ

<�ذ� ���>
- ���ڿ��� ���� �迭 ch �� �����ѵ� Array.sort�� �̿��� ������������ ����
- ���ĵ� �迭 ch�� �������� ���ڿ� answer�� ���Ѵ�*/



import java.util.Arrays;

public class NoLow {
	
	
	//���� �ذ��� ���
	public static String solution(String str)
	{
		String answer ="";
		char [] ch = str.toCharArray();
		Arrays.sort(ch);
		for(int i=ch.length-1;i>=0;i--)
		{
			answer+=ch[i];
		}
		return answer;
	}
	
	//�ٸ������ �ذ���
	public static String reverseStr(String str)
	{
		char [] arr = str.toCharArray();
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder(new String(arr)); //char�迭 arr�� ���ο� StringBuilder�� ����
		return sb.reverse().toString(); //�ϼ��� StringBuilder�� �������� String���� ��ȯ�Ѵ�.
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str= "bjsdASKJW";
		char [] arr = str.toCharArray();
		System.out.println(solution(str));
		
		NoLow rs = new NoLow();
		System.out.println(rs.reverseStr("Zbcdefg"));
	}
		
}

/*[����]
�ٸ� ����� �ڵ带 Ȯ���ߴµ� ���� �ʹ� �����ϰ� Ǯ���ٴ� ������ �����.
StringBuilder�� Ȱ���ؼ� ���ڸ� �����ϰ� reverser�ϴ� ����̾���.
�� �ܿ��� Comparator�� Ȱ���ϴ� ����� �־���
Comparator�� Comparable�� ���� ���䵵 �� ���ذ� �����ʾ� �ٽ� �����ؾ� �ҰͰ���.
*/