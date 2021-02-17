//백준 아이디 3개파서 계속 반복풀이하는중!
//[백준알고리즘][N1922][네트워크연결]

package Kruscal;

import java.util.*;
import java.io.*;

public class N1922 {
	
	//자주 사용하니까 겹치지 않게 inner class로 처리한다. 효율적으로!
	static class Node implements Comparable<Node>{
		int start,end,cost;
		public Node(int start,int end,int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
		//앞서 이해했으니 그대로 작성하겠다.
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
		n = Integer.parseInt(br.readLine());//정점의 개수 = 컴퓨터의 개수
		m = Integer.parseInt(br.readLine());//간선의 개수 = 연결하는 선의 수
		
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
		
		//각 자 자기 자신 초기화
		for(int i=1;i<=n;i++)
			parent[i] = i;
		
		int answer = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			//Node에 해당하는 상위노드를 먼저 찾아본다
			int a = find(node.start);
			int b = find(node.end);
			
			//그런데 상위노드가 같다면?
			//갱신하지 않고 돌아간다. 왜냐하면 싸이클이 생기면 안되니까
			if(a==b) {
				continue;
			}
			//그런데 그것이 아니라면
			//상위 노드들을 합치고
			//사용된 비용 cost를 결과값에 더한다.
			else {
				union(a,b);
				answer += node.cost;
			}
		}
		System.out.println(answer);
		
	}
	
	public static void union(int a,int b) {
		//a와b 두가지의 부모를 찾는다.
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot==bRoot) {
			return;
		}
		//아니라면 a의 상위노드를 b라고 정한다.
		parent[aRoot] = b;
	}
	
	
	//들어온 매개변수의 가장 상위 컴퓨터를 찾아보자
	public static int find(int a) {
		//자기자신이 그대로라면 그대로 출력
		if(a==parent[a]) {
			return a;
		}
		//a의 상위노드의 상위노드를을 찾아서 그것을 a의 상위노드로 변경한다.
		parent[a] = find(parent[a]);
		return parent[a];
	}

}
