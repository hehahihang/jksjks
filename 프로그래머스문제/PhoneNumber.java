/*[프로그래머스][Level1][핸드폰 번호 가리기]
프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요.

제한 조건
s는 길이 4 이상, 20이하인 문자열입니다.
		
[해결방법]
1. 문자열 p를 분할하여  char 형 배열 ch에 저장한다.
2. 뒤의 4자리를 제외하고 '*'로 바꾼다.
3. ch 배열을 합쳐 문자열 answer로 저장한다.*/


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
