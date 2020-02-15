import java.io.*;

public class N1085 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		//왼쪽아래 꼭지점(0,0)
		int x = Integer.parseInt(str[0]);
		int y = Integer.parseInt(str[1]);
		//한수의 위치(x,y)
		int w = Integer.parseInt(str[2]);
		int h = Integer.parseInt(str[3]);
		//오른쪽위 꼭지점의 위치(w,h)
		
		int answer = 0;
		//가장 가까운 거리가 될 answer;
		
		int top = h-y; //세로거리
		int right = w-x; //가로거리
		
		if(top>y)
			top = y;
		//원래 top까지의 거리는 top인데 바닥부터 떨어진 길이 6 2 10 3y가 탑보다 작다면
		//y가 가까운거리가 된다.
		
		if(right>x)
			right = x;
		//원래 오른쪽벽까지의 거리가 right인데 떨어진 길이 x가 더 작다면
		//x가 더 가까운거리가된다.
		
		if(top>right)
			answer = right;
		else
			answer = top;
		
		System.out.println(answer);
		
		
		
	}

}
