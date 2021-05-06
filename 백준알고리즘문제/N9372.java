/*[����][N9372][������ǿ���]
����̴� �ܿ������ �¾� N������ �����ϸ鼭 �ھƸ� ã��� �����Ծ���. ������ ����̴� ���ο� ����⸦ �������ϱ� ������, �ִ��� ���� ������ ����⸦ Ÿ�� �������� �̵��Ϸ��� �Ѵ�.
�̹� ���� ������ ���� �������� �־����� ��, ����̰� ���� ���� ������ ����⸦ Ÿ�� ��� �������� ������ �� �ֵ��� ��������.
����̰� �� �������� �ٸ� ������ �̵��� �� �ٸ� ������ ���� ����(������ �̹� �湮�� ������) �ȴ�.

�Է�
ù ��° �ٿ��� �׽�Ʈ ���̽��� �� T(T �� 100)�� �־�����,
�� �׽�Ʈ ���̽����� ������ ���� ������ �־�����.
ù ��° �ٿ��� ������ �� N(2 �� N �� 1 000)�� ������� ���� M(1 �� M �� 10 000) �� �־�����.
���� M���� �ٿ� a�� b �ֵ��� �Էµȴ�. a�� b�� �պ��ϴ� ����Ⱑ �ִٴ� ���� �ǹ��Ѵ�. (1 �� a, b �� n; a �� b) 
�־����� ���� �������� �׻� ���� �׷����� �̷��.
���
�׽�Ʈ ���̽����� �� ���� ����Ѵ�.

����̰� ��� ������ �����ϱ� ���� Ÿ�� �ϴ� ����� ������ �ּ� ������ ����Ѵ�.
���� �Է� 1 
2
3 3
1 2
2 3
1 3
5 4
2 1
2 3
4 3
4 5
���� ��� 1 
2
4
*/

/* [����]
 * ó������ ������¸� ��Ÿ���� ������ �迭�� visited�� DFS�� �����Ͽ� ������ �ذ��Ϸ��� �ߴ�.
 * �ٵ� �ϴٺ��� �ᱹ ���ٺ��� 1�ۿ� �ȳ����°� Ȯ��... �ٺ����� Ǯ�� ���� ��̴�.
 * �߰��� �� ������ Union-Find�� ����ؼ� �� ������ ���̰Ը� �ϸ� �ɰŰ��ٰ� �����߰� ����...
 * ������ ��ȯ, ������ �����ϴ� ������ �� �ʿ��ϴٰ� ��������.
 * �ᱹ���� �̷��͵��� �� ������ ������ �ذ��ϴ� ���α׷���, �ڵ� ������ �� ���̶�� �����Ѵ�.
 * */

package Graph;

import java.util.*;
import java.io.*;

public class N9372 {
	static StringBuilder sb = new StringBuilder();
	static int n,m,cnt;
	static int [] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			parent = new int [n+1];
			for(int i=1;i<=n;i++)
				parent[i] = i;
			
			int cnt = 0;
			m = Integer.parseInt(st.nextToken());
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(find(a)==find(b)) {
					continue;
				}
				else {
					union(find(a),find(b));
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	public static int find(int x) {
		if(x==parent[x]) {
			return parent[x];
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	public static void union(int x,int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot==yRoot)
			return;
		if(xRoot>yRoot)
			parent[xRoot] = yRoot;	
		else
			parent[yRoot] = xRoot;
	}
}
