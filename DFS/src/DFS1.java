//[DFS]
//��������� �̿��� DFS����
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DFS1 {
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(st.nextToken()); //������ ���� == ���
		int E = Integer.parseInt(st.nextToken()); //������ ���� == Edge
		int start = Integer.parseInt(st.nextToken()); //�湮�� �����ϰԵ� ������ ��ġ
		
		int [][] Graph = new int[V+1][V+1];
		//�迭�� �ε����� 0������ �����ϹǷ� +1�� �Ͽ� 0���ε����� ��������ʰ� 
		//ArrayIndexOutOfBounds�� �����ϱ����� ����Ѵ�.
		
		boolean [] visited = new boolean [V+1];
		// �湮�� ������ ǥ���ϴ� �迭�̴�. �湮 ���� visited=true�� �����Ѵ�.
		
		//��������� �����Ѵ�.
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//����� �׷����� �����Ѵ�.
			Graph[x][y] = Graph[y][x] = 1;
			//�ܹ����� ��� x->y or y->x ���� �Ը°� �°� �����Ѵ�.
		}
		
		//�츮�� ������ �������Graph���� �湮���� visited�� start�������� Ž���Ѵ�.
		dfs(Graph,visited,start);
		
	}
	public static void dfs(int[][] Graph,boolean [] visited,int V) {
		visited[V] = true; //V ��带 �湮 �� ���̹Ƿ� visted = true�� �ٲ��ش�
		
		System.out.print(V+" ");
		
		//��͸� ����Ͽ� ���� ��带 �湮�ϸ� �װ����� �ٽ� dfs�� �����Ѵ�.
		for(int i=1;i<visited.length;i++) {
			//dfs��Ͱ� ����Ǵ� ������ �׷����� ����Ǿ������鼭 �湮���� �ʾҴ� �����̴�.
			if(Graph[V][i]==1 && visited[i]==false) {
				dfs(Graph,visited,i);
			}
		}
	}

}
