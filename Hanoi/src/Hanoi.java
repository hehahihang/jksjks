/*[하노이의 탑][재귀]
<문제>
3개의 기둥이 있고, 첫번째 기둥에는 반경이 다른 원판 n개가 쌓여있다. 각 원판은 직경이 큰 순서대로 쌓여있다.
다음의 규칙을 따라 원판을 3번째 기둥으로 옮기려한다. 
<규칙>
- 원반은 한번에 하나씩만 옮길 수 있다
- 옮기는 과정에서 작은 원반위에 큰 원반이 올라가서는 안된다
<생각>
- 원반n개중 n-1개를 옮기고 n-1개중 n-2개를 옮기고, 결국 원반 1개를 옮기는 문제로 생각 할 수 있었다
<해결 방법>
- 가장 큰 원반을 제외한 나머지 n-1개를 첫번째 기둥에서 중간기둥으로 옮긴다
- 가장 큰 원반을 3번째 기둥으로 옮긴다
- 나머지 n-1개의 원반을 같은 방식으로 중간기둥에서 3번째 기둥으로 옮긴다*/


import java.util.Scanner;

public class Hanoi {
	static int cnt=0;

	static void move(int n,int start,int end) //n개의 원반을 start기둥에서 end기둥으로 옮기는 메서드
	{
		cnt++;
		if(n>1){
			move(n-1,start,6-start-end); //n-1개의 원반을 start기둥에서 6-start-end(중간)기둥으로 올긴다.
		}
		System.out.println("원반 "+n+"을 "+start+"기둥에서 "+end+"기둥으로 옮긴다.");

		if(n>1){
			move(n-1,6-start-end,end); //n-1개의 원반을 6-start-end(중간)기둥에서 end기둥으로 옮긴다.
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("하노이의 탑");
		System.out.print("원반의 개수 :");
		int n = sc.nextInt();
		move(n,1,3); // 1번기둥의 n개의 원반을 3번기둥으로 옮긴다.
		System.out.println("이동 횟수 = "+cnt);
	}
}

/*[고찰]
사실 간단한 재귀 같지만 내용을 이해하기에 정말 어려웠다.
알고리즘을 해결했다기보다는 손으로 재귀 순서를 작성해보며 거의 외웠다.
문제 풀이에 가장 중요했다고 생각하는 점은 결국 원판의 개수를 1씩 줄여가며
결국 원반 1개씩을 옮기는 문제라는것, 그리고 기둥번호의 합이 6이므로
중간에 이동하는 기둥을 6-start-end로 설정한다는 것이었다*/