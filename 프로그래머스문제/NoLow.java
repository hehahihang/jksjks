/*[프로그래머스][LEVEL1][문자열 내림차순으로 배치하기]
문제 설명
문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수, solution을 완성해주세요.
s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은 것으로 간주합니다.

제한 사항
str은 길이 1 이상인 문자열입니다.

입출력 예
s	      return
Zbcdefg	  gfedcbZ

<해결 방법>
- 문자열을 문자 배열 ch 에 저장한뒤 Array.sort를 이용해 오름차순으로 정렬
- 정렬된 배열 ch를 역순으로 문자열 answer에 더한다*/



import java.util.Arrays;

public class NoLow {
	
	
	//내가 해결한 방법
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
	
	//다른사람의 해결방법
	public static String reverseStr(String str)
	{
		char [] arr = str.toCharArray();
		Arrays.sort(arr);
		StringBuilder sb = new StringBuilder(new String(arr)); //char배열 arr을 새로운 StringBuilder로 생성
		return sb.reverse().toString(); //완성된 StringBuilder를 뒤집에서 String으로 변환한다.
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

/*[고찰]
다른 사람의 코드를 확인했는데 내가 너무 무식하게 풀었다는 생각이 들었다.
StringBuilder를 활용해서 문자를 정렬하고 reverser하는 방법이었다.
이 외에도 Comparator를 활용하는 방법도 있었다
Comparator와 Comparable에 대한 개념도 잘 이해가 되지않아 다시 공부해야 할것같다.
*/