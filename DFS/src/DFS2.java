//[DFS]
//��������Ʈ�� ���� ������ DFS

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); //������ ����
		int E = Integer.parseInt(st.nextToken()); //������ ����
		int start = Integer.parseInt(st.nextToken()); //���� ������ ��ġ
		boolean [] visited = new boolean [V+1]; //�湮���θ� Ȯ���� visited �迭
		
		/*ArrayList�� ���� �迭�� �����. �迭 Adjlist�� ArrayList�� ��´�.*/
		//or ArrayList<ArrayList<Integer>> = new ArrayList<ArrayList<Integer>>(V+1);�� ���� ������ ���� �ִ�.
		ArrayList<Integer> [] Adjlist = new ArrayList[V+1];
		
		//�ʱ�ȭ�� �ؼ� �����ؾ� ������ ������ �ʴ´�.
		for(int i=0;i<Adjlist.length;i++) {
			Adjlist[i] = new ArrayList<Integer>();
		}
		
		//����� �����̶�� �����ϰ� ������ ����Ʈ�� �߰��Ѵ�.
		//����� ������ �����ϴ� ����
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			Adjlist[x].add(y);
			Adjlist[y].add(x);
		}
		
		//��������Ʈ�� ������ �迭�� ���Ұ� �������� �ִٸ� ���� ���� ���� ���� �湮�ϹǷ�
		//������������ �����Ѵ�.
		for(int i=0;i<Adjlist.length;i++) {
			Collections.sort(Adjlist[i]);
		}
		
		//DFS�� �����Ѵ�.
		dfs(Adjlist,visited,start);
		
	}
	public static void dfs(ArrayList<Integer>[] adjlist,boolean [] visited,int V) {
		visited[V] = true;
		System.out.print(V+" ");
		
		for(int i=0;i<adjlist[V].size();i++) {
			if(visited[i]==false) {
				dfs(adjlist,visited,i);
			}
		}
	}

}
