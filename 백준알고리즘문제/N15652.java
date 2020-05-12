/*
����
�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

1���� N���� �ڿ��� �߿��� M���� �� ����
���� ���� ���� �� ��� �ȴ�.
�� ������ �񳻸������̾�� �Ѵ�.
���̰� K�� ���� A�� A1 �� A2 �� ... �� AK-1 �� AK�� �����ϸ�, �񳻸������̶�� �Ѵ�.
�Է�
ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)

���
�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.

������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
*/

package backTracking;

import java.io.*;

public class N15652 {
	static int [] arr;
	static boolean [] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		arr = new int [n+1];
		visited = new boolean [n+1];
		
		dfs(0,n,m);
		System.out.println(sb);
	}
	private static void dfs(int cnt,int n,int m) {
		if(cnt==m) {
			for(int i=0;i<m;i++) {
				sb.append(arr[i]+" ");
			}
			sb.append("\n");
			return;
		}
		
		for(int i=1;i<=n;i++) {
			if(visited[i]==false && cnt<m) {
				//�ߺ��� ����ϹǷ� visted[i] = true�� �ٲ��� �ʴ´�.
				arr[cnt] = i; 
				if(cnt==0)
					dfs(cnt+1,n,m);
				if(cnt>0 && arr[cnt]>=arr[cnt-1]) //�񳻸������� �̿��ϹǷ�, ���� ���ҿ� ���� ���Ұ� ���ٴ� ������ �߰��Ѵ�.
					dfs(cnt+1,n,m);
			}
		}
	}
}
