import java.io.*;

public class N1085 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		//���ʾƷ� ������(0,0)
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		//�Ѽ��� ��ġ(x,y)
		int w = Integer.parseInt(str[2]);
		int h = Integer.parseInt(str[3]);
		//�������� �������� ��ġ(w,h)
		
		int answer = 0;
		//���� ����� �Ÿ��� �� answer;
		
		int top = h-y; //���ΰŸ�
		int right = w-x; //���ΰŸ�
		
		if(top>y)
			top = y;
		//���� top������ �Ÿ��� top�ε� �ٴں��� ������ ���� 6 2 10 3y�� ž���� �۴ٸ�
		//y�� �����Ÿ��� �ȴ�.
		
		if(right>x)
			right = x;
		//���� �����ʺ������� �Ÿ��� right�ε� ������ ���� x�� �� �۴ٸ�
		//x�� �� �����Ÿ����ȴ�.
		
		if(top>right)
			answer = right;
		else
			answer = top;
		
		System.out.println(answer);
		
		
		
	}

}
