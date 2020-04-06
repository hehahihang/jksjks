/*[프로그래머스][LEVEL1][크레인 인형뽑기 게임][2019 카카오 개발자 겨울 인턴쉽 문제]
 
 [문제 설명(간략히)]
 - 이차원배열 board에 NxN 모양의 판에 인형이 주어지고
 moves 배열의 원소에 따라 각 위치의 가장 위에 인형을 뽑는다.
 이 후, 같은 모양의 인형이 두개 연속해서 쌓이게 되면 두 인형은 터뜨려지면서 사라진다.
 
 사라진 인형의 총 갯수를 구하세요.
 
 
[생각]
 - 문제를 보자마자 스택을 이용하는 문제라는것이 떠올랐다.
 하지만  moves의 원소의 숫자와 인형뽑기하는 board의 인덱스를
 맞추는 과정에서 조금 애를 먹었다.
 아직 논리적으로 생각하는 부분이 많이 부족하다고 생각한다.. 열심히 노력하자.
 * */
package Level1;

import java.util.*;

public class dollGame {
	
	public static int solution(int [][] board, int [] moves) {
		int answer = 0;		
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<moves.length;i++) {
			int tmp = moves[i] -1 ; //뽑을 위치를 인덱스로 변경하기위해 -1한다.
			
			for(int j=0;j<board.length;j++) {
				if(board[j][tmp]!=0) {
					
					if(st.isEmpty()) {
						st.push(board[j][tmp]);
					}
					else {
						if(st.peek()==board[j][tmp]) {
							st.pop();
							answer+=2;
						}
						else {
							st.push(board[j][tmp]);
						}
					}
					board[j][tmp]=0;
					break;
					
				}
			}
		}
		return answer;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int [] moves = {1,5,3,5,1,2,1,4};
		
		System.out.println(solution(board,moves));
	}
}
