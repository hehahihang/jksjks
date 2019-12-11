/*[프로그래머스][LEVEL1][최대공약수와 최소공배수]
문제 설명
두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해 보세요. 
배열의 맨 앞에 최대공약수, 그다음 최소공배수를 넣어 반환하면 됩니다. 
예를 들어 두 수 3, 12의 최대공약수는 3, 최소공배수는 12이므로 solution(3, 12)는 [3, 12]를 반환해야 합니다.

제한 사항
두 수는 1이상 1000000이하의 자연수입니다.

입출력 예
n	m	return
3	12	[3, 12]
2	5	[1, 10]
		
입출력 예 설명
입출력 예 #1
위의 설명과 같습니다.

입출력 예 #2
자연수 2와 5의 최대공약수는 1, 최소공배수는 10이므로 [1, 10]을 리턴해야 합니다.

<해결 방법>
- 먼저 m의 값이 크게하기위해 tmp를 사용해서 n<m이 성립하도록 만들어준다
- n*m = 최대공약수 * 최소공배수 임을 이용했다*/

public class gcmLcm {
	
	public static int [] arr (int n,int m)
	{
		int [] answer = new int [2];
		
		int tmp;
		
		if(m<n){
			tmp = n;
			n = m;
			m = tmp;
		}
		
		if(m%n==0) {
			answer[0] = n;
			answer[1] = m;
		}
		else {
			for(int i=1;i<n;i++) {
				if(n%i==0&&m%i==0){
					answer[0] = i;
					answer[1] = (n*m)/i;
				}
			}
		}
		
		return answer;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] answer = arr(20,36);
		for(int i=0;i<answer.length;i++) {
			System.out.print(answer[i]+" ");
		}
	}
}

/*[고찰]
- 맨 처음에 n<m을 만든다는 생각을 못하고 조건문을 두개를 사용해서
코드를 짰었는데 "야 그거 그냥 무조건 m이 크게 만들면되잖아"라는 친구의 얘기를 듣고
코드를 수정했다. 조건을 내가 바꿀수있다는 방법도 생각해서 문제를 바라보는 사고가 필요하다고 느꼈다.*/