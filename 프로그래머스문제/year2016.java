/*[���α׷��ӽ�][LEVLE1][2016��]
<���� ����>
2016�� 1�� 1���� �ݿ����Դϴ�. 2016�� a�� b���� ���� �����ϱ��? �� �� a ,b�� �Է¹޾� 2016�� a�� b���� ���� �������� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
������ �̸��� �Ͽ��Ϻ��� ����ϱ��� ���� SUN,MON,TUE,WED,THU,FRI,SAT �Դϴ�. ���� ��� a=5, b=24��� 5�� 24���� ȭ�����̹Ƿ� ���ڿ� TUE�� ��ȯ�ϼ���.

<���� ����>
2016���� �����Դϴ�. 
2016�� a�� b���� ������ �ִ� ���Դϴ�. (13�� 26���̳� 2�� 45�ϰ��� ��¥�� �־����� �ʽ��ϴ�)
����� ��
a	b	result
5	24	TUE

<����>
���� == 2��29�ϱ����ִ� �⵵�� �����ϰ� Ǯ��!
*/

package Level1;

public class year2016 {
	
	public String solution(int a, int b) {
		String answer = "";
		String [] weeks = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
		int [] month = {31,29,31,30,31,30,31,31,30,31,30,31};
		
		if(a==1) {
			int k = b%7;
			answer = weeks[k];
		}
		
		else {
			int day = 0;
			for(int i=0;i<a-1;i++) {
				day += month[i];
			}
			day += b;
			answer = weeks[day%7];
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
