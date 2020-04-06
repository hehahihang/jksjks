/*[프로그래머스][LEVEL1][모의고사]
<문제>
문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

<제한 조건>
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

<입출력 예>
answers		return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]

<생각>
- 각 수포자가 찍는 방식을 배열로 저장해놓고 이를 비교하는 문제.
가장 고민스러웠던 부분은 가장 많은 문제를 맞힌사람부터 1,2,3 번호를 부여해야한다는것
이를 arrlist를 통해 가장 크다면 i+1로 번호를 부여하는 방식을 사용했다.

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
