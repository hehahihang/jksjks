/*���̿켱Ž�� (Breadth First Search)
BFS��?
- ��Ʈ��忡�� Ž���Ͽ� ������ ��带 ���� Ž���ϴ� ���
- �� �������� �ִܰ�� OR ������ ��θ� ã���� ����Ѵ�.

Ư¡
- DFS���� �����ϴ�.
- Queue�� ����� �����Ѵ�.
(ť�� �湮�� ��带 �����Ѵ�. ���� ť���� ���� ���� ����� ��带 �湮,�����Ѵ�.
�̸� �ݺ��ϸ� ť�� �����ɶ����� ����Ѵ�.)
*/


//��������Ʈ�� ������ BFS
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BFS {
	
	public static void bfs(int [][] Graph,boolean [] visited,int v) {
		//ť�� ����ؼ� bfs�� �����ϴ� ������ �����Ѵ�.
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v); //���� ���� v�� ���� �߰��Ѵ�.
		visited[v] = true;
		
		while(!queue.isEmpty()) {
			v = queue.poll();
			System.out.println(v+"�湮"+" ");
			
			for(int i=1;i<=visited.length;i++) {
				if(Graph[v][i]==1&&visited[i]==false) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int vertex = Integer.parseInt(st.nextToken()); //������ ����
		int edge = Integer.parseInt(st.nextToken()); //������ ����
		int start = Integer.parseInt(st.nextToken()); //���� ������ ��ġ
		int [][] Graph = new int [vertex+1][vertex+1]; //�׷����� ��Ÿ�� �������
		boolean [] visited = new boolean[vertex+1]; //�湮���θ� ��Ÿ�� �迭
		
		//������ ������ŭ ������ �������ش�.
		//a1���� a2�� ����Ǿ��ִٸ� ��Ÿ����.
		for(int i=1;i<=edge;i++) {
			st = new StringTokenizer(st.nextToken());
			int a1 = Integer.parseInt(st.nextToken());
			int a2 = Integer.parseInt(st.nextToken());
			
			Graph[a1][a2] = 1;
			Graph[a2][a1] = 1;
		}
		
		bfs(Graph,visited,start);
		
		

	}

}
