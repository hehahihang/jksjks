/*[���α׷��ӽ�][Level1][�̻��� ���� �����]
		���� ����
		���ڿ� s�� �� �� �̻��� �ܾ�� �����Ǿ� �ֽ��ϴ�. �� �ܾ�� �ϳ� �̻��� ���鹮�ڷ� ���еǾ� �ֽ��ϴ�. 
		�� �ܾ��� ¦����° ���ĺ��� �빮�ڷ�, Ȧ����° ���ĺ��� �ҹ��ڷ� �ٲ� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ��ϼ���.

		<���� ����>
		���ڿ� ��ü�� ¦/Ȧ�� �ε����� �ƴ϶�, �ܾ�(������ ����)���� ¦/Ȧ�� �ε����� �Ǵ��ؾ��մϴ�.
		ù ��° ���ڴ� 0��° �ε����� ���� ¦����° ���ĺ����� ó���ؾ� �մϴ�.
		<����� ��>
		s	            return
		try hello world	TrY HeLlO WoRlD
		<����� �� ����>
		try hello world�� �� �ܾ� try, hello, world�� �����Ǿ� �ֽ��ϴ�. �� �ܾ��� ¦����° ���ڸ� �빮�ڷ�, 
		Ȧ����° ���ڸ� �ҹ��ڷ� �ٲٸ� TrY, HeLlO, WoRlD�Դϴ�. ���� TrY HeLlO WoRlD �� �����մϴ�.*/

/*[�ذ���]
1. ���ڿ��� �������� ������
2. ������ ������ ������ �����Ƿ� ���ο� ���ڿ��� �����Ҷ� ���� index�� 0���� ���� �����Ѵ�
3. index�� �Ǵ��ϸ� ¦���̸� LowerCase, Ȧ���̸� UpperCase�� ���ڸ� ��ȯ�Ѵ�*/

public class weirdString {
	
	public static String solution(String s)
	{
		String answer="";
		char ch=' ';
		int index=0;
		
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)==' ')
			{
				ch = s.charAt(i);
				index=0;
			}
			else
			{
				index +=1;
				if(index%2==1)
					ch = Character.toUpperCase(s.charAt(i));
				else
					ch = Character.toLowerCase(s.charAt(i));
			}
			answer += ch;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "try hello world";
		System.out.println(solution(s));
	}
}
