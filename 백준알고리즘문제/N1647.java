/*
동물원에서 막 탈출한 원숭이 한 마리가 세상구경을 하고 있다. 그러다가 평화로운 마을에 가게 되었는데, 그곳에서는 알 수 없는 일이 벌어지고 있었다.
마을은 N개의 집과 그 집들을 연결하는 M개의 길로 이루어져 있다. 길은 어느 방향으로든지 다닐 수 있는 편리한 길이다. 그리고 각 길마다 길을 유지하는데 드는 유지비가 있다.(cost)
마을의 이장은 마을을 두 개의 분리된 마을로 분할할 계획을 가지고 있다. 마을이 너무 커서 혼자서는 관리할 수 없기 때문이다. 마을을 분할할 때는 각 분리된 마을 안에 집들이 서로 연결되도록 분할해야 한다. 
각 분리된 마을 안에 있는 임의의 두 집 사이에 경로가 항상 존재해야 한다는 뜻이다. 마을에는 집이 하나 이상 있어야 한다.
그렇게 마을의 이장은 계획을 세우다가 마을 안에 길이 너무 많다는 생각을 하게 되었다. 일단 분리된 두 마을 사이에 있는 길들은 필요가 없으므로 없앨 수 있다. 
그리고 각 분리된 마을 안에서도 임의의 두 집 사이에 경로가 항상 존재하게 하면서 길을 더 없앨 수 있다. 마을의 이장은 위 조건을 만족하도록 길들을 모두 없애고 나머지 길의 유지비의 합을 최소로 하고 싶다. 
이것을 구하는 프로그램을 작성하시오.*/

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
		
		//비교하여 cost가 짧은 것이 큐에 앞쪽에 오도록
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
		n = Integer.parseInt(str[0]); //집의 개수 n개 니까 n+1 번부터
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
		
		//두개의 분리된 마을 == parent[x] 값을 탐색했을때 개수가 2개
		//각각 모든 경로가 존재해야한다
		
		int cnt = 0; //두개의 분
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			int s = find(node.start); //시작점의 parent
			int e = find(node.end); //끝 점의 parent
			//탐색한다.
			
			//마을의 이장은 두개의 분리된 마을로 분할할 계획을 가지고 있다.
			//각 분리된 마을 안에서는 모두 연결되어 있어야 한다.
			//마을 내부에 길이 너무 많다.
			//그래서, 분리된 두 마을 사이의 길은 모두 제거
			//분리된 마을 내부에서도 두 집사이의 경로가 존재하게 하면서 길을 더 없앨 수 있다.
			if(s==e) {
				continue;
			}
			
			//다르다면 연결되어 있는게 아니지
			else {
				union(s,e);
				arrlist.add(node.cost);
			}
		}
		
		//최소의 비용으로 두개의 마을을 분할하기 위해서는 가장 큰 비용이 드는 간선 하나를 제거하면 된다.
		//크루스칼 알고리즘은 비용이 적은 순 부터 길을 이어나가기 때문에 가장 마지막에 더한 비용 하나를 빼면 정답이 된다.
		
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
