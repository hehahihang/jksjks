/*
����
�ڿ��� N�� M�� �־����� ��, �Ʒ� ������ �����ϴ� ���̰� M�� ������ ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.

1���� N���� �ڿ��� �߿��� �ߺ� ���� M���� �� ����
�� ������ ���������̾�� �Ѵ�.
�Է�
ù° �ٿ� �ڿ��� N�� M�� �־�����. (1 �� M �� N �� 8)

���
�� �ٿ� �ϳ��� ������ ������ �����ϴ� ������ ����Ѵ�. �ߺ��Ǵ� ������ ���� �� ����ϸ� �ȵǸ�, �� ������ �������� �����ؼ� ����ؾ� �Ѵ�.

������ ���� ������ �����ϴ� ������ ����ؾ� �Ѵ�.
*/

package backTracking;

import java.io.*;

public class N15650 {
	static boolean [] visited;
	static int [] arr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int m = Integer.parseInt(str[1]);
		arr = new int [n+1];
		visited = new boolean [n+1];
		
		dfs(0,n,m);
		
	}
	private static void dfs(int cnt, int n, int m) {
		// TODO Auto-generated method stub
		if(cnt==m) { //nPm ���� cnt==m �̸� m���� �̾Ҵٴ� ����̹Ƿ�
					//�ش� ������ ��� �̾����Ƿ� ����Ѵ�.
			for(int i=0;i<m;i++) {
					System.out.print(arr[i]+" ");
			}
			System.out.println();
			return; //�׸��� Ž���� ����������.
		}
		
		for(int i=1;i<=n;i++) { //1~n �� m���� �̴°��̹Ƿ� �ݺ����� 1~n���� �ݺ��Ѵ�.
			if(visited[i]==false) {//���� �湮���� �ʾҴٸ�
				visited[i] = true; //�湮�� ���·� ������Ʈ
				arr[cnt] = i; //���� ���ڸ� �迭�� �����Ѵ�.
				
				//�������� ������ ���� �ΰ����� ����� ������.
				//1.cnt==0�� ���, ���� ù��° ���ڸ� �̴°��̹Ƿ� �ٸ� ���� ���� cnt+1���Ͽ� Ž���� �ٽ� �����ϸ� �ȴ�.
				if(cnt==0) 
					dfs(cnt+1,n,m); 
				//2.cnt!=0�� ���, �ٷ� ���� ���ڿ� ���Ͽ� ���������̶�� Ž���� ��� �����Ѵ�.
				if(cnt>0 && arr[cnt]>arr[cnt-1])
					dfs(cnt+1,n,m);
				
				visited[i] = false; //Ž���� ������ ���� Ž���ߴ� ���ڴ� �湮���� �ʾҴ� ������ �ٽ� ó���Ѵ�.
			}
		}
	}
}