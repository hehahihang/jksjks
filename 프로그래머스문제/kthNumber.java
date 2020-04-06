/*[프로그래머스][LEVEL1][K번째수]
<문제 설명>
배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
2에서 나온 배열의 3번째 숫자는 5입니다.
배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때, 
commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.

<제한사항>
array의 길이는 1 이상 100 이하입니다.
array의 각 원소는 1 이상 100 이하입니다.
commands의 길이는 1 이상 50 이하입니다.
commands의 각 원소는 길이가 3입니다.

<입출력 예>
array					commands							return
[1, 5, 2, 6, 3, 7, 4]	[[2, 5, 3], [4, 4, 1], [1, 7, 3]]	[5, 6, 3]
 
<생각>
- 이것도 역시 쉬운문제지만 나는 해결하는데에 다른 사이트의 참고를 얻었다ㅠㅠ
arr_count라는 변수를 넣는것이 포인트라고 생각한다.
새로운 배열 temp를 만들어 이곳에 arr_count를 index라고 생각하고 1씩 증가시키며
i번째부터 j번쨰 까지의 원소를 담는다. 이후 배열 temp를 정렬하고.
정답 배열 answer의 처음부터 temp의 k번째 원소를 삽입한다. 
 */
package Level1;

import java.util.Arrays;

public class kthNumber {
	
	public static int [] solution(int [] array,int [][] commands) {
		int [] answer = new int [commands.length];
		
		for(int i=0;i<commands.length;i++) {
			int first = commands[i][0];
			int last = commands[i][1];
			int k = commands[i][2];
		
			int arr_count = 0; 
			int cnt = 0;
			
			int [] temp = new int [last-first+1];
			
			for(int j=first-1;j<=last-1;j++) {
				temp[arr_count] = array[j];
				arr_count++;
			}
			Arrays.sort(temp);
			answer[cnt] = temp[k];
			cnt++;
			arr_count = 0;
		}
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
