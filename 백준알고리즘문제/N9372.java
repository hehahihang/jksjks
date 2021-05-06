/*[백준][N9372][상근이의여행]
상근이는 겨울방학을 맞아 N개국을 여행하면서 자아를 찾기로 마음먹었다. 하지만 상근이는 새로운 비행기를 무서워하기 때문에, 최대한 적은 종류의 비행기를 타고 국가들을 이동하려고 한다.
이번 방학 동안의 비행 스케줄이 주어졌을 때, 상근이가 가장 적은 종류의 비행기를 타고 모든 국가들을 여행할 수 있도록 도와주자.
상근이가 한 국가에서 다른 국가로 이동할 때 다른 국가를 거쳐 가도(심지어 이미 방문한 국가라도) 된다.

입력
첫 번째 줄에는 테스트 케이스의 수 T(T ≤ 100)가 주어지고,
각 테스트 케이스마다 다음과 같은 정보가 주어진다.
첫 번째 줄에는 국가의 수 N(2 ≤ N ≤ 1 000)과 비행기의 종류 M(1 ≤ M ≤ 10 000) 가 주어진다.
이후 M개의 줄에 a와 b 쌍들이 입력된다. a와 b를 왕복하는 비행기가 있다는 것을 의미한다. (1 ≤ a, b ≤ n; a ≠ b) 
주어지는 비행 스케줄은 항상 연결 그래프를 이룬다.
출력
테스트 케이스마다 한 줄을 출력한다.

상근이가 모든 국가를 여행하기 위해 타야 하는 비행기 종류의 최소 개수를 출력한다.
예제 입력 1 
2
3 3
1 2
2 3
1 3
5 4
2 1
2 3
4 3
4 5
예제 출력 1 
2
4
*/

/* [생각]
 * 처음에는 연결상태를 나타내는 이차원 배열과 visited로 DFS를 구현하여 문제를 해결하려고 했다.
 * 근데 하다보니 결국 돌다보면 1밖에 안나오는거 확인... 바보같이 풀고 많이 헤맸다.
 * 중간에 든 생각은 Union-Find를 사용해서 한 점으로 모이게만 하면 될거같다고 생각했고 정답...
 * 생각의 전환, 문제를 이해하는 사고력이 더 필요하다고 느껴진다.
 * 결국에는 이런것들이 모여 현실의 문제를 해결하는 프로그래밍, 코딩 역량이 될 것이라고 생각한다.
 * */

package Graph;

import java.util.*;
import java.io.*;

public class N9372 {
	static StringBuilder sb = new StringBuilder();
	static int n,m,cnt;
	static int [] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			
			parent = new int [n+1];
			for(int i=1;i<=n;i++)
				parent[i] = i;
			
			int cnt = 0;
			m = Integer.parseInt(st.nextToken());
			for(int i=0;i<m;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(find(a)==find(b)) {
					continue;
				}
				else {
					union(find(a),find(b));
					cnt++;
				}
			}
			sb.append(cnt+"\n");
		}
		System.out.println(sb.toString());
	}
	public static int find(int x) {
		if(x==parent[x]) {
			return parent[x];
		}
		parent[x] = find(parent[x]);
		return parent[x];
	}
	
	public static void union(int x,int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot==yRoot)
			return;
		if(xRoot>yRoot)
			parent[xRoot] = yRoot;	
		else
			parent[yRoot] = xRoot;
	}
}
