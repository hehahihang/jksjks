/*[���α׷��ӽ�][Level1][�ڵ��� ��ȣ ������]
���α׷��ӽ� ������� �������� ��ȣ�� ���� �������� ���� �� ������ ��ȭ��ȣ�� �Ϻθ� �����ϴ�.
��ȭ��ȣ�� ���ڿ� phone_number�� �־����� ��, ��ȭ��ȣ�� �� 4�ڸ��� ������ ������ ���ڸ� ���� *���� ���� ���ڿ��� �����ϴ� �Լ�, solution�� �ϼ����ּ���.

���� ����
s�� ���� 4 �̻�, 20������ ���ڿ��Դϴ�.
		
[�ذ���]
1. ���ڿ� p�� �����Ͽ�  char �� �迭 ch�� �����Ѵ�.
2. ���� 4�ڸ��� �����ϰ� '*'�� �ٲ۴�.
3. ch �迭�� ���� ���ڿ� answer�� �����Ѵ�.*/


public class PhoneNumber {
	
	public String solution(String p)
	{
		String answer ="";
		char [] ch = new char[p.length()]; 
		// char [] ch = p.toCharArray();
		
		for(int i=0;i<p.length();i++) 
		{
			ch[i] = p.charAt(i);
			if(i<p.length()-4) 
				ch[i] = '*';
		}
		
		answer = String.valueOf(ch);
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PhoneNumber pn = new PhoneNumber();
		System.out.println(pn.solution("027778888"));
	}

}
