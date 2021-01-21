
import java.util.*;
import java.io.*;

public class N9663 {
	static int n;
	static int [] col;
	static int cnt = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		col = new int [n+1]; 
		dfs(1);
		System.out.println(cnt);
	}
	
	public static void dfs(int depth) {
		if(depth==n+1) {
			cnt++;
			return;
		}
		
		for(int i=1;i<=n;i++) {
			col[depth] = i; //depth�� i�࿡ ���� ���� ���´�.
			if(check(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	public static boolean check(int depth) {
		for(int i=1;i<depth;i++) {
			//�ٸ� ���ε� �����࿡ �ִٸ� false;
			if(col[depth]==col[i]) {
				return false;
			}
			//�밢���� �ִ°� üũ
			else if(Math.abs(depth-i)==Math.abs(col[depth]-col[i])) {
				return false;
			}
		}
		return true;
	}
}
