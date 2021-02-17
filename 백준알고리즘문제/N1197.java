//[���ؾ˰���][N1197][�ּҽ��д�Ʈ��]
//�ּ� ���д�Ʈ�� �ڹ�
//ũ�罺Į�˰��� : ������ �߽����� Ž���ϸ鼭 ��带 Ȯ�ο����θ� ����Ѵ�.
//-> ũ�罺Į�˰����� == ��� ������ �� ������ �ּ��� ��  + ����Ŭ�� ����� �ȵ��̹Ƿ� Union-Find ������� ã��
//Disijoint set(���μ� ����) : ���� �ߺ����� �ʴ� ���յ�� ������ ���ҵ鿡 ���� ������ �����ϰ� �����ϴ� �ڷᱸ��
//��ü ������ ������, ���� ���ҵ��� ��ġ�� �ʴ��� ����Ѵ�. �� ,���� �ٸ� ���ҵ��� ���� ���տ� �����ִ��� Ȯ���Ѵ�.
package Graph;

import java.util.*;
import java.io.*;

public class N1197 {
	
	static class Node implements Comparable<Node>{
		int s,e,v;
		public Node(int s,int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
		
		//����ġ v�� ���� ���� ������ ���� ������ ������ ��ü�� �����Ѵ�.
		//������ ���������� �ǵ��� �����Ϸ��� 
		//1�� return �Ǹ� �� ��ü�� �ڸ��� ���Ѵ�.
		public int compareTo(Node n) {
			return this.v - n.v;
			
			//return this.v - n.v;
			//���� ������������ ������ �� �� �̱� ������
			//���� �� ���� ��(this.v)�� ������ ��(n.v)���� ũ�ٸ� 1, �� ����� return �Ͽ� �ڷ� �����ָ�Ǳ⋚����
			//return this.v - n.v�� ��Ÿ����. (return this.v - n.v ? 1 : -1) ���׿����� ��뵵 ����
			//�ݴ�� ������������ ������ �Ѵٸ� 
			//return n.v - this.v (return n.v - this.v ? 1 : -1 �Ǵ� return this.v - n.v ? -1 : 1)
			
			//���� ��ü < �Ķ���� ��ü : ���� ����
			//���� ��ü == �Ķ���� ��ü : 0 ����
			//���� ��ü > �Ķ���� ��ü : ��� ����
		}
		
	}

	static int v,e; //v=����, e=����
	static int [] parent;
	static boolean [] visited;
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
		String [] str = br.readLine().split(" ");
		v = Integer.parseInt(str[0]);
		e = Integer.parseInt(str[1]);
		parent = new int [v+1];
		visited = new boolean [v+1];
		pq = new PriorityQueue<>();
		
		for(int i=0;i<e;i++) {
			String [] tmp = br.readLine().split(" ");
			int start = Integer.parseInt(tmp[0]);
			int end = Integer.parseInt(tmp[1]);
			int val = Integer.parseInt(tmp[2]);
			pq.add(new Node(start,end,val)); //���� ���� , �� ���� , ����ġ
		}
		
		//���� ó���� �ڱ��ڽ��� �θ�� �ڱ��ڽ��̴�
		for(int i=1;i<=v;i++) {
			parent[i] = i;
		}
		
		int cost = 0;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			int start = node.s;
			int end = node.e;
			int a = find(start);
			int b = find(end);
			
			//�ΰ��� ���ٸ� �׳� �Ѱ� == �ֳ�? ����Ŭ�̴ϱ�
			if(a==b) {
				continue;
			}
			
			//�ٵ� �ƴ϶�� �� ��带 ���ľ� �Ѵ�.
			//�׸��� ����߰�
			else {
				union(a,b);
				cost += node.v;
			}
		}
		System.out.println(cost);
	}
	
	//� �� ���� a,b�� �־�����, �̵��� ���� �� ������ �ϳ��� ��ġ�� ����
	public static void union(int a,int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) {
			return;
		}
		else {
			parent[aRoot] = b;
		}
	}
	
	//� ���� a�� �־�����, �� ���Ұ� ���� ������ ã�´�
	public static int find(int a) {
		if(a==parent[a]) {
			return a;
		}
		parent[a] = find(parent[a]);
		return parent[a];
	}
}

