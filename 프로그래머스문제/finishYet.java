/*[���α׷��ӽ�][LEVEL1][�������� ���� ����]
<����>
������ ������ �������� �����濡 �����Ͽ����ϴ�. �� �� ���� ������ �����ϰ�� ��� ������ �������� �����Ͽ����ϴ�.
�����濡 ������ �������� �̸��� ��� �迭 participant�� ������ �������� �̸��� ��� �迭 completion�� �־��� ��, 
�������� ���� ������ �̸��� return �ϵ��� solution �Լ��� �ۼ����ּ���.

<����� ��>
participant	// completion														return
[leo, kiki, eden] // [eden, kiki]												leo
[marina, josipa, nikola, vinko, filipa] // [josipa, filipa, marina, nikola]		vinko
[mislav, stanko, mislav, ana] / [stanko, ana, mislav]							mislav

<����>
�ؽ� ���� �̿��ؼ� ������ Ǯ��� �Ѵٴ� ������ ��Ҵ�.
�� �ȿ� key,value�� ������� �־�� �ϴ����� ���� ����̾���. ( �ᱹ �ٸ����� �ڵ带 �����ߴ٤�)
ó���� participant key�� value�� ��� 1�� ����ְ�
completion�� key�� ��ġ�Ҷ� value���� -1�ؼ� �ٽ� ����־���.

���� ���������� �־��ٸ� value���� 1�� ���̰�, Ȥ�� completion�� �̸��� ��� value���� 1�̴�.
���� �ؽø��� VALUE��==1 �� KEY���� �������� ���� participant�� �� ���̴�.

-> ���� ���� � �ڷᱸ���� ����ؾ����� ������ �ذ����� ���Ѵ�.
�ڷᱸ��,�˰��� ���� ���� ������, �������� �����ϰ� �����ְ� �ڵ��ϴµ����� �������� �ִٰ� �����Ѵ�.
�̸� �����ؼ� ��ġ�ִ� �����ڰ� �ǰ� �ʹ�.
*/

package Level1;

import java.util.*;

public class finishYet {
	
	public static String solution(String [] participant,String [] completion) {
		String answer ="";
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		for(String player:participant) {
			if(!hm.containsKey(player)) {
				hm.put(player, 1);
			}
			else {
				int index = hm.get(player);
				hm.put(player, index+1);
			}
		}
		
		for(String player:completion) {
			int index = hm.get(player);
			hm.put(player, index-1);
		}
		
		for(String player:participant) {
			if(hm.get(player)==1)
				answer = player;
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] participant = {"mislav","stanko","mislav","ana"};
		String [] completion = {"stanko","mislav","ana"};
		
		System.out.println(solution(participant,completion));
	}
}
