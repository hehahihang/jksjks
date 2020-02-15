/*[����][N1260][DFS�� BFS]
 
����
�׷����� DFS�� Ž���� ����� BFS�� Ž���� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
��, �湮�� �� �ִ� ������ ���� ���� ��쿡�� ���� ��ȣ�� ���� ���� ���� �湮�ϰ�, �� �̻� �湮�� �� �ִ� ���� ���� ��� �����Ѵ�. ���� ��ȣ�� 1������ N�������̴�.

�Է�
ù° �ٿ� ������ ���� N(1 �� N �� 1,000), ������ ���� M(1 �� M �� 10,000), Ž���� ������ ������ ��ȣ V�� �־�����. 
���� M���� �ٿ��� ������ �����ϴ� �� ������ ��ȣ�� �־�����. � �� ���� ���̿� ���� ���� ������ ���� �� �ִ�. �Է����� �־����� ������ ������̴�.

���
ù° �ٿ� DFS�� ������ �����, �� ���� �ٿ��� BFS�� ������ ����� ����Ѵ�. V���� �湮�� ���� ������� ����ϸ� �ȴ�.

���� �Է� 1 ��ü �ٷ� 1
4 5 1   1 2 4 3
1 2     1 2 3 4
1 3
1 4
2 4
3 4
 */
package DFSBFS;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class N1260 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		
		int n = Integer.parseInt(str[0]); //������ ����
		int m = Integer.parseInt(str[1]); //������ ����
		int v = Integer.parseInt(str[2]); //Ž���� ������ ������ ��ȣ
		
		int [][] graph = new int [n+1][n+1];
		boolean [] visited = new boolean[n+1];
		
		for(int i=0;i<m;i++) {
			String [] s1 = br.readLine().split(" ");
			int x = Integer.parseInt(s1[0]);
			int y = Integer.parseInt(s1[1]);
			
			graph[x][y] = graph[y][x] = 1;
		}
		
		dfs(graph,visited,v);
		
		Arrays.fill(visited, false);
		
		System.out.println();
		
		bfs(graph,visited,v);
		

	}
	
	public static void dfs(int [][] graph,boolean [] visited,int start) {
		visited[start] = true;
		
		System.out.print(start+" ");
		
		for(int i=1;i<visited.length;i++) {
			if(graph[start][i]==1 && visited[i]==false) {
				dfs(graph,visited,i);
			}
		}
	}
	
	public static void bfs(int [][] graph,boolean [] visited,int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			start = queue.remove();
			System.out.print(start+" ");
			
			for(int i=1;i<visited.length;i++) {
				if(graph[start][i]==1 && visited[i]==false) {
					queue.add(i);
					visited[i]=true;
				}
			}
		}
	}
}
