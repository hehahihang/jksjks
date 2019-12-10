/*[프로그래머스][LEVEL1][제일 작은 수 제거하기]
문제 설명
정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 
예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

제한 조건
arr은 길이 1 이상인 배열입니다.
인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.

입출력 예
arr			return
[4,3,2,1]	[4,3,2]
[10]		[-1]
		
<해결방법>
- 배열arr길이가 1이면 answer에 -1만 넣어 return한다
- 제일 작은 수의 위치를 가리키는 minIndex를 설정하고
for문을 반복하며 갱신한다
- 가장 작은 숫자의 바로 뒤 부터 인덱스를 하나씩 앞으로 이동시킨다*/
		
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

/*[고찰]
처음에 Array.sort를 이용해서 정렬하고 맨앞 숫자를 제외하고,
뒤쪽 숫자부터 answer배열에 넣는 방법을 이용했었다.
하지만 문제는 배열을 정렬해서 작은수를 골라내는것이아니라
그 배열 그대로에서 가장 작은 수만 빼내는것이었으므로 나는 계속 틀렸었다..*/
