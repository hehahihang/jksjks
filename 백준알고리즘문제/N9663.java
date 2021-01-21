
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
			col[depth] = i; //depth열 i행에 퀸을 먼저 놓는다.
			if(check(depth)) {
				dfs(depth+1);
			}
		}
	}
	
	public static boolean check(int depth) {
		for(int i=1;i<depth;i++) {
			//다른 열인데 같은행에 있다면 false;
			if(col[depth]==col[i]) {
				return false;
			}
			//대각선에 있는거 체크
			else if(Math.abs(depth-i)==Math.abs(col[depth]-col[i])) {
				return false;
			}
		}
		return true;
	}
}
