/*
����
�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
- 1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
�Է�
ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)
���
�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.

������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.

���� �Է� 1 
3 1
���� ��� 1 
1
2
3
*/

// n����m ���� ���� �ְ� ���� ���� �����̴�. nPm
package backTracking;

import java.io.*;

public class N15649 {
	//dfs �޼��忡�� ���� ����� �����ϵ��� static ������ �����Ѵ�.
	static int n,m;
	static int [] arr; //������ ������ arr �迭
	static boolean [] visited; //������ �湮 ���θ� ������ visited �迭
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);
		
		arr = new int [n+1]; //�迭�� index�� 1���� n���� ����ϱ����� �迭ũ�⸦ �ϳ� ũ�� �����Ѵ�.
		visited = new boolean [n+1];
		
		dfs(0);
		System.out.println(sb);
		
	}
	
	public static void dfs(int cnt) {
		//��� ���ڰ� ���õǾ����� Ȯ���ϴ� �Ű����� cnt
		if(cnt==m) { //m���� �����ߴٸ�
			for(int i=0;i<m;i++) {
				sb.append(arr[i]+" "); 
			}
			sb.append("\n");
			return; //StringBuilder�� ���ϰ�. return����  dfsŽ���� �������´�.
		}
		
		for(int i=1;i<=n;i++) {
			if(visited[i]==false) { //���� ����(i)�� �湮���� �ʾҴٸ�
				visited[i] = true; //�湮�� ���·� �����ϰ�
				arr[cnt] = i; //cnt��°�� ���õ� ���� i�� �迭 arr�� �����Ѵ�.
				dfs(cnt+1); //cnt+1��° ���ڸ� �����ϱ����� dfs(cnt+1) Ž���� �ٽ� �����Ѵ�.
				visited[i] = false; //�湮�� ���� ���� ���´� �湮���� ���� ���·� �����Ѵ�.
			}
		}
	}
}
