//[백준알고리즘][N1197][최소스패닝트리]
//최소 스패닝트리 자바
//크루스칼알고리즘 : 간선을 중심으로 탐색하면서 노드를 확인용으로만 사용한다.
//-> 크루스칼알고리즘이 == 모든 간선을 다 지나는 최소의 값  + 싸이클이 생기면 안됨이므로 Union-Find 방식으로 찾음
//Disijoint set(서로소 집합) : 서로 중복되지 않는 집합들로 나눠진 원소들에 대한 정보를 저장하고 조작하는 자료구조
//전체 집합이 있을때, 구성 원소들이 겹치지 않는지 사용한다. 즉 ,서로 다른 원소들이 같은 집합에 속해있는지 확인한다.
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
		
		//가중치 v가 가장 작은 간선이 가장 앞으로 가도록 객체를 정렬한다.
		//점수가 오름차순이 되도로 정렬하려면 
		//1이 return 되면 두 객체의 자리가 변한다.
		public int compareTo(Node n) {
			return this.v - n.v;
			
			//return this.v - n.v;
			//나는 오름차순으로 정렬을 할 것 이기 때문에
			//지금 막 들어온 값(this.v)이 이전의 값(n.v)보다 크다면 1, 즉 양수를 return 하여 뒤로 보내주면되기떄문에
			//return this.v - n.v로 나타낸다. (return this.v - n.v ? 1 : -1) 삼항연산자 사용도 가능
			//반대로 내림차순으로 정렬을 한다면 
			//return n.v - this.v (return n.v - this.v ? 1 : -1 또는 return this.v - n.v ? -1 : 1)
			
			//현재 객체 < 파라미터 객체 : 음수 리턴
			//현재 객체 == 파라미터 객체 : 0 리턴
			//현재 객체 > 파라미터 객체 : 양수 리턴
		}
		
	}

	static int v,e; //v=정점, e=간선
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
			pq.add(new Node(start,end,val)); //시작 정점 , 끝 정점 , 가중치
		}
		
		//각각 처음에 자기자신의 부모는 자기자신이다
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
			
			//두개가 같다면 그냥 넘겨 == 왜냐? 싸이클이니까
			if(a==b) {
				continue;
			}
			
			//근데 아니라면 두 노드를 합쳐야 한다.
			//그리고 비용추가
			else {
				union(a,b);
				cost += node.v;
			}
		}
		System.out.println(cost);
	}
	
	//어떤 두 원소 a,b가 주어질때, 이들이 속한 두 집합을 하나로 합치는 과정
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
	
	//어떤 원소 a가 주어질때, 이 원소가 속한 집합을 찾는다
	public static int find(int a) {
		if(a==parent[a]) {
			return a;
		}
		parent[a] = find(parent[a]);
		return parent[a];
	}
}

