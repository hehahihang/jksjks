/*[프로그래머스][Level1][이상한 문자 만들기]
		문제 설명
		문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로 구분되어 있습니다. 
		각 단어의 짝수번째 알파벳은 대문자로, 홀수번째 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.

		<제한 사항>
		문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
		첫 번째 글자는 0번째 인덱스로 보아 짝수번째 알파벳으로 처리해야 합니다.
		<입출력 예>
		s	            return
		try hello world	TrY HeLlO WoRlD
		<입출력 예 설명>
		try hello world는 세 단어 try, hello, world로 구성되어 있습니다. 각 단어의 짝수번째 문자를 대문자로, 
		홀수번째 문자를 소문자로 바꾸면 TrY, HeLlO, WoRlD입니다. 따라서 TrY HeLlO WoRlD 를 리턴합니다.*/

/*[해결방법]
1. 문자열을 공백으로 나눈다
2. 공백이 여러개 있을수 있으므로 새로운 문자열이 시작할때 마다 index를 0으로 새로 설정한다
3. index를 판단하면 짝수이면 LowerCase, 홀수이면 UpperCase로 문자를 반환한다*/

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
