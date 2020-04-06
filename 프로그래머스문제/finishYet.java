/*[프로그래머스][LEVEL1][완주하지 못한 선수]
<문제>
수많은 마라톤 선수들이 마라톤에 참여하였습니다. 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 주어질 때, 
완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.

<입출력 예>
participant	// completion														return
[leo, kiki, eden] // [eden, kiki]												leo
[marina, josipa, nikola, vinko, filipa] // [josipa, filipa, marina, nikola]		vinko
[mislav, stanko, mislav, ana] / [stanko, ana, mislav]							mislav

<생각>
해쉬 맵을 이용해서 문제를 풀어야 한다는 방향을 잡았다.
맵 안에 key,value를 어떤것으로 넣어야 하는지가 조금 고민이었다. ( 결국 다른분의 코드를 참고했다ㅠ)
처음에 participant key의 value를 모두 1로 집어넣고
completion의 key와 일치할때 value값을 -1해서 다시 집어넣었다.

만약 동명이인이 있었다면 value값은 1일 것이고, 혹은 completion에 이름이 없어도 value값은 1이다.
따라서 해시맵의 VALUE값==1 인 KEY값이 완주하지 못한 participant가 될 것이다.

-> 지금 나는 어떤 자료구조를 사용해야할지 알지만 해결하지 못한다.
자료구조,알고리즘에 대한 이해 부족과, 논리적으로 생각하고 끈기있게 코딩하는데에서 부족함이 있다고 생각한다.
이를 보완해서 가치있는 개발자가 되고 싶다.
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
