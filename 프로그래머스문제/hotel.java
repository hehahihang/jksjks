/*호텔이는 총 방이 k개 , 방번호는 1번부터 k번까지
1.한 번에 한 명씩 신청한 순서대로 방을 배정합니다.
2.고객은 투숙하기 원하는 방 번호를 제출합니다.
3.고객이 원하는 방이 비어 있다면 즉시 배정합니다.
4.고객이 원하는 방이 이미 배정되어 있으면 원하는 방보다 번호가 크면서 비어있는 방 중 가장 번호가 작은 방을 배정합니다.
*/

package intern2020;
import java.util.*;

public class hotel {
	
	static HashMap<Long,Long> hashMap = new HashMap<>();
	
	//첫번째 시도, 아무생각없이 빠르게 작성한 코드
	//정확도 부분은 모드 통과했지만 효율성 0점 ㅠㅠ (시간초과 + 런타임에러)
	public static long [] solution(long k, long [] room_number) {
		long [] answer = new long [room_number.length];
		boolean [] room = new boolean [(int)k+1];
		
		Queue<Long> queue = new LinkedList<>();
		for(int i=0;i<room_number.length;i++) {
			queue.add(room_number[i]);
		}
		
		int idx = 0;
		
		while(!queue.isEmpty()) {
			long tmp = queue.poll();
			if(!room[(int)tmp]) {
				room[(int)tmp] = true;
				answer[idx++] = tmp;
			}
			
			else {
				for(int i=(int)tmp+1;i<=k;i++) {
					if(!room[i]) {
						room[i] = true;
						answer[idx++] = i;
						break;
					}
				}
			}
			
		}
		
		return answer;
	}
	
	//2번째 시도, HashMap을 사용해야한다는 친구의 얘기를 듣고 다시 시도
	//채점을 통과하긴 하였으나 재귀를 사용하는 방식을 알게되어서 3번째 시도를 다시 하게됨
	public static long [] solution2(long k, long [] room_number) {
		long [] answer = new long [room_number.length];
		HashMap<Long,Long> hm = new HashMap<>();
		//방번호, 들어갈 방번호
		
		int idx = 0;
		for(int i=0;i<room_number.length;i++) {
			long tmp = room_number[i]; //고객이 원하는 방번호
			if(!hm.containsKey(tmp)) { //아무도 선택한 사람이 없으면
				hm.put(tmp, tmp+1);
				answer[idx++] = tmp;
			}
			else {//번호가 이미 있다면
				Queue<Long> queue = new LinkedList<>();
				long next = hm.get(tmp);
				queue.add(next);
				while(hm.containsKey(next)) {
					next = hm.get(next);
					queue.add(next);
				}
				answer[idx++] = next;
				
				while(!queue.isEmpty()) {
					hm.put(queue.poll(), next+1);
				}
			}
		}
		return answer;
	}
	
	//3번째 시도 findRoom이라는 재귀함수를 만들어 원하는 방번호가 나올때까지 반복하는 방법
	//생각도 못했던 방법이다... 재귀가 오히려 빠를때도 있다는 걸 알게되었다.
	public static long [] solution3(long k, long [] room_number) {
		long [] answer = new long [room_number.length];
		for(int i=0;i<room_number.length;i++) {
			answer[i] = findRoom(room_number[i]);
		}
		return answer;
	}
	
	public static long findRoom(long roomNumber) {
		if(!hashMap.containsKey(roomNumber)) {
			hashMap.put(roomNumber, roomNumber+1);
			return roomNumber;
		}
		else {
			long nextRoom = hashMap.get(roomNumber);
			long emptyRoom = findRoom(nextRoom);
			hashMap.put(roomNumber, emptyRoom);
			return emptyRoom;
		}
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long k = 10;
		long [] room_number = 	{1,3,4,1,3,1};
		long [] answer = solution(k,room_number);
		long [] answer2 = solution2(k,room_number);
		long [] answer3 = solution3(k,room_number);
		for(int i=0;i<answer.length;i++)
			System.out.print(answer[i]+" ");
	}
}
