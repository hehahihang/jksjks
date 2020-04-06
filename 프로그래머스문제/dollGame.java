/*[���α׷��ӽ�][LEVEL1][ũ���� �����̱� ����][2019 īī�� ������ �ܿ� ���Ͻ� ����]
 
 [���� ����(������)]
 - �������迭 board�� NxN ����� �ǿ� ������ �־�����
 moves �迭�� ���ҿ� ���� �� ��ġ�� ���� ���� ������ �̴´�.
 �� ��, ���� ����� ������ �ΰ� �����ؼ� ���̰� �Ǹ� �� ������ �Ͷ߷����鼭 �������.
 
 ����� ������ �� ������ ���ϼ���.
 
 
[����]
 - ������ ���ڸ��� ������ �̿��ϴ� ������°��� ���ö���.
 ������  moves�� ������ ���ڿ� �����̱��ϴ� board�� �ε�����
 ���ߴ� �������� ���� �ָ� �Ծ���.
 ���� �������� �����ϴ� �κ��� ���� �����ϴٰ� �����Ѵ�.. ������ �������.
 * */
package Level1;

import java.util.*;

public class dollGame {
	
	public static int solution(int [][] board, int [] moves) {
		int answer = 0;		
		Stack<Integer> st = new Stack<>();
		
		for(int i=0;i<moves.length;i++) {
			int tmp = moves[i] -1 ; //���� ��ġ�� �ε����� �����ϱ����� -1�Ѵ�.
			
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
