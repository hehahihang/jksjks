//���� ���̵� 3���ļ� ��� �ݺ�Ǯ���ϴ���!
//[���ؾ˰���][N1922][��Ʈ��ũ����]

package Kruscal;

import java.util.*;
import java.io.*;

public class N1922 {
	
	//���� ����ϴϱ� ��ġ�� �ʰ� inner class�� ó���Ѵ�. ȿ��������!
	static class Node implements Comparable<Node>{
		int start,end,cost;
		public Node(int start,int end,int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		//�ռ� ���������� �״�� �ۼ��ϰڴ�.
		public int compareTo(Node node) {
			return this.cost - node.cost;
		}
	}

	static int n,m;
	static int [] parent;
	static boolean [] visited;
	static PriorityQueue<Node> queue;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());//������ ���� = ��ǻ���� ����
		m = Integer.parseInt(br.readLine());//������ ���� = �����ϴ� ���� ��
		
		parent = new int [n+1];
		visited = new boolean [n+1];
		queue = new PriorityQueue<>();
		
		
		for(int i=0;i<m;i++) {
			String [] str = br.readLine().split(" ");
			int start = Integer.parseInt(str[0]);
			int end = Integer.parseInt(str[1]);
			int cost = Integer.parseInt(str[2]);
			
			queue.add(new Node(start,end,cost));
		}
		
		//�� �� �ڱ� �ڽ� �ʱ�ȭ
		for(int i=1;i<=n;i++)
			parent[i] = i;
		
		int answer = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			//Node�� �ش��ϴ� ������带 ���� ã�ƺ���
			int a = find(node.start);
			int b = find(node.end);
			
			//�׷��� ������尡 ���ٸ�?
			//�������� �ʰ� ���ư���. �ֳ��ϸ� ����Ŭ�� ����� �ȵǴϱ�
			if(a==b) {
				continue;
			}
			//�׷��� �װ��� �ƴ϶��
			//���� ������ ��ġ��
			//���� ��� cost�� ������� ���Ѵ�.
			else {
				union(a,b);
				answer += node.cost;
			}
		}
		System.out.println(answer);
		
	}
	
	public static void union(int a,int b) {
		//a��b �ΰ����� �θ� ã�´�.
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) {
			return;
		}
		//�ƴ϶�� a�� ������带 b��� ���Ѵ�.
		parent[aRoot] = b;
	}
	
	
	//���� �Ű������� ���� ���� ��ǻ�͸� ã�ƺ���
	public static int find(int a) {
		//�ڱ��ڽ��� �״�ζ�� �״�� ���
		if(a==parent[a]) {
			return a;
		}
		//a�� ��������� ������带�� ã�Ƽ� �װ��� a�� �������� �����Ѵ�.
		parent[a] = find(parent[a]);
		return parent[a];
	}

}
