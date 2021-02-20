/*
���������� �� Ż���� ������ �� ������ ���󱸰��� �ϰ� �ִ�. �׷��ٰ� ��ȭ�ο� ������ ���� �Ǿ��µ�, �װ������� �� �� ���� ���� �������� �־���.
������ N���� ���� �� ������ �����ϴ� M���� ��� �̷���� �ִ�. ���� ��� �������ε��� �ٴ� �� �ִ� ���� ���̴�. �׸��� �� �渶�� ���� �����ϴµ� ��� ������ �ִ�.(cost)
������ ������ ������ �� ���� �и��� ������ ������ ��ȹ�� ������ �ִ�. ������ �ʹ� Ŀ�� ȥ�ڼ��� ������ �� ���� �����̴�. ������ ������ ���� �� �и��� ���� �ȿ� ������ ���� ����ǵ��� �����ؾ� �Ѵ�. 
�� �и��� ���� �ȿ� �ִ� ������ �� �� ���̿� ��ΰ� �׻� �����ؾ� �Ѵٴ� ���̴�. �������� ���� �ϳ� �̻� �־�� �Ѵ�.
�׷��� ������ ������ ��ȹ�� ����ٰ� ���� �ȿ� ���� �ʹ� ���ٴ� ������ �ϰ� �Ǿ���. �ϴ� �и��� �� ���� ���̿� �ִ� ����� �ʿ䰡 �����Ƿ� ���� �� �ִ�. 
�׸��� �� �и��� ���� �ȿ����� ������ �� �� ���̿� ��ΰ� �׻� �����ϰ� �ϸ鼭 ���� �� ���� �� �ִ�. ������ ������ �� ������ �����ϵ��� ����� ��� ���ְ� ������ ���� �������� ���� �ּҷ� �ϰ� �ʹ�. 
�̰��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.*/

package Kruscal;

import java.util.*;
import java.io.*;

public class N1647 {
	
	static class Node implements Comparable<Node>{
		int start,end,cost;
		public Node(int start,int end,int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		
		//���Ͽ� cost�� ª�� ���� ť�� ���ʿ� ������
		public int compareTo(Node n) {
			return this.cost - n.cost;
		}
	}
	static ArrayList<Integer> arrlist = new ArrayList<>();
	static int n,m;
	static int [] parent;
	static PriorityQueue<Node> queue = new PriorityQueue<>();
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]); //���� ���� n�� �ϱ� n+1 ������
		m = Integer.parseInt(str[1]);
		parent = new int [n+1];
		
		for(int i=1;i<=n;i++)
			parent[i] = i;
		
		for(int i=0;i<m;i++) {
			String [] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int cost = Integer.parseInt(input[2]);
			queue.add(new Node(start,end,cost));
		}
		
		//�ΰ��� �и��� ���� == parent[x] ���� Ž�������� ������ 2��
		//���� ��� ��ΰ� �����ؾ��Ѵ�
		
		int cnt = 0; //�ΰ��� ��
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int s = find(node.start); //�������� parent
			int e = find(node.end); //�� ���� parent
			//Ž���Ѵ�.
			
			//������ ������ �ΰ��� �и��� ������ ������ ��ȹ�� ������ �ִ�.
			//�� �и��� ���� �ȿ����� ��� ����Ǿ� �־�� �Ѵ�.
			//���� ���ο� ���� �ʹ� ����.
			//�׷���, �и��� �� ���� ������ ���� ��� ����
			//�и��� ���� ���ο����� �� �������� ��ΰ� �����ϰ� �ϸ鼭 ���� �� ���� �� �ִ�.
			if(s==e) {
				continue;
			}
			
			//�ٸ��ٸ� ����Ǿ� �ִ°� �ƴ���
			else {
				union(s,e);
				arrlist.add(node.cost);
			}
		}
		
		//�ּ��� ������� �ΰ��� ������ �����ϱ� ���ؼ��� ���� ū ����� ��� ���� �ϳ��� �����ϸ� �ȴ�.
		//ũ�罺Į �˰����� ����� ���� �� ���� ���� �̾���� ������ ���� �������� ���� ��� �ϳ��� ���� ������ �ȴ�.
		
		Collections.sort(arrlist);
		int answer = 0;
		for(int v : arrlist)
			answer += v;
		answer -= arrlist.get(arrlist.size()-1);
		System.out.println(answer);
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA==rootB) {
			return;
		}
		parent[rootB] = rootA;
	}
	
	public static int find(int x) {
		if(x==parent[x]) {
			return x;
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
}
