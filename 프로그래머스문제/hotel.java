/*ȣ���̴� �� ���� k�� , ���ȣ�� 1������ k������
1.�� ���� �� �� ��û�� ������� ���� �����մϴ�.
2.���� �����ϱ� ���ϴ� �� ��ȣ�� �����մϴ�.
3.���� ���ϴ� ���� ��� �ִٸ� ��� �����մϴ�.
4.���� ���ϴ� ���� �̹� �����Ǿ� ������ ���ϴ� �溸�� ��ȣ�� ũ�鼭 ����ִ� �� �� ���� ��ȣ�� ���� ���� �����մϴ�.
*/

package intern2020;
import java.util.*;

public class hotel {
	
	static HashMap<Long,Long> hashMap = new HashMap<>();
	
	//ù��° �õ�, �ƹ��������� ������ �ۼ��� �ڵ�
	//��Ȯ�� �κ��� ��� ��������� ȿ���� 0�� �Ф� (�ð��ʰ� + ��Ÿ�ӿ���)
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
	
	//2��° �õ�, HashMap�� ����ؾ��Ѵٴ� ģ���� ��⸦ ��� �ٽ� �õ�
	//ä���� ����ϱ� �Ͽ����� ��͸� ����ϴ� ����� �˰ԵǾ 3��° �õ��� �ٽ� �ϰԵ�
	public static long [] solution2(long k, long [] room_number) {
		long [] answer = new long [room_number.length];
		HashMap<Long,Long> hm = new HashMap<>();
		//���ȣ, �� ���ȣ
		
		int idx = 0;
		for(int i=0;i<room_number.length;i++) {
			long tmp = room_number[i]; //���� ���ϴ� ���ȣ
			if(!hm.containsKey(tmp)) { //�ƹ��� ������ ����� ������
				hm.put(tmp, tmp+1);
				answer[idx++] = tmp;
			}
			else {//��ȣ�� �̹� �ִٸ�
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
	
	//3��° �õ� findRoom�̶�� ����Լ��� ����� ���ϴ� ���ȣ�� ���ö����� �ݺ��ϴ� ���
	//������ ���ߴ� ����̴�... ��Ͱ� ������ �������� �ִٴ� �� �˰ԵǾ���.
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
