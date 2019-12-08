/*[프로그래머스][Level1][같은 숫자는 싫어]
배열 arr가 주어집니다. 배열 arr의 각 원소는 숫자 0부터 9까지로 이루어져 있습니다. 
이때, 배열 arr에서 연속적으로 나타나는 숫자는 하나만 남기고 전부 제거하려고 합니다. 
단, 제거된 후 남은 수들을 반환할 때는 배열 arr의 원소들의 순서를 유지해야 합니다. 예를 들면,

arr = [1, 1, 3, 3, 0, 1, 1] 이면 [1, 3, 0, 1] 을 return 합니다.
arr = [4, 4, 4, 3, 3] 이면 [4, 3] 을 return 합니다.
배열 arr에서 연속적으로 나타나는 숫자는 제거하고 남은 수들을 return 하는 solution 함수를 완성해 주세요.

제한사항
배열 arr의 크기 : 1,000,000 이하의 자연수
배열 arr의 원소의 크기 : 0보다 크거나 같고 9보다 작거나 같은 정수

입출력 예
arr	             answer
[1,1,3,3,0,1,1]  [1,3,0,1]
[4,4,4,3,3]      [4,3]

[해결 방법]
1.Arraylist를 사용하여 answer에 들어갈 리스트를 만든다.
2.입력 배열의 가장 처음 원소는 list에 추가한다.
3.이후 for반복문을 통해 리스트 i번째와 i-1번째를 비교하여 두 원소가 다르다면
arrlist에 i번째 원소를 추가한다.
4.이 후 list의 요소를 answer배열에 옮긴다.*/

import java.util.*;

public class NoSameNumber {
	
	public static int [] solution(int [] arr)
	{
		
		ArrayList<Integer> arrlist = new ArrayList<>();
		
		
		for(int i=0;i<arr.length;i++)
		{
			if(i==0)
				arrlist.add(arr[i]);
			else
			{
				if(arr[i-1]!=arr[i])
				{
					arrlist.add(arr[i]);
				}
			}
		}
		int [] answer = new int [arrlist.size()];

		for(int i=0;i<arrlist.size();i++)
		{
			answer[i] = arrlist.get(i);
		}
		
		for(int i=0;i<answer.length;i++)
		{
			System.out.print(answer[i]+" ");
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] arr = {1,1,3,3,0,1,1};
		solution(arr);
	}
}
