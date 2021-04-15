/*[백준][N1991][트리순회]
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.

예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 
노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현된다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.

*/

/*
풀이
- 트리 Class와 트리의 각 노드를 나타낼 노드 Class를 작성한다.
(1)초기의 Tree에서 root = null 이면 Node를 생성해준다.
(2)root != null 이면, 이 root data와 left,right 정보가 들어가야하는지 재귀(searchNode)로 탐색한다.
(3)searchNode에서 root가 null이라면 가장 아래쪽 자식 노드까지 방문한 것이므로 return;
(4)입력할 data = root.data 인 값을 찾았을때 트리에 left와 right 값을 저장한다.
(5)둘다 아닌 경우에는 이진트리의 양쪽으로 찢어져 seacrhNode로 탐색을 계속한다.
(6)이후, 전위 순회, 중위 순회, 후위 순회를 실행한다.

#전위순회 : 루트 -> left -> right
#중위순회 : left -> 루트 -> right
#후위순회 : left -> right -> root

피드백 : 트리 어렵다. 재귀 어렵다. 둘다 맨날 헷갈리고 개념도 제대로 안잡힌것 같다.
가장 정확하고 이해가 잘 됐던 방법은 재귀가 반복되는 과정을 손으로 작성하며 확인해 봤던 것이라고 생각한다.
ENM에서 재귀에서 털렸기때문에 재귀와 트리를 열심히 공부해야겠다.
*/
package Recursion;

import java.io.*;
import java.util.*;

public class N1991 {
	static StringBuilder sb;
	static class Node{
		char data;
		Node left, right;
		public Node(char data) {
			this.data = data;
		}
	}
	static class Tree{
		Node root; //처음엔 null
		public void add(char data, char left, char right) {
			//최초 상태일 때
			if(root==null) {
				if(data!='.')
					root = new Node(data);
				if(left!='.')
					root.left = new Node(left);
				if(right!='.')
					root.right = new Node(right);
			}
			//최초가 아닐 때 -> 어디로 들어가야 하는지 찾는다.
			else {
				search(root,data,left,right);
			}
		}
		public void search(Node root, char data, char left, char right) {
			if(root==null) {
				return; 
			}
			else if(root.data == data) {
				if(left!='.')
					root.left = new Node(left);
				if(right!='.')
					root.right = new Node(right);
			}
			else {
				search(root.left,data,left,right);
				search(root.right,data,left,right);				
			}
		}
		//전위순회
		public void preOrder(Node root) {
			sb.append(root.data);
			if(root.left!=null)
				preOrder(root.left);
			if(root.right!=null)
				preOrder(root.right);
		}
		//중위 순회
		public void inOrder(Node root) {
			if(root.left!=null)
				inOrder(root.left);
			sb.append(root.data);
			if(root.right!=null)
				inOrder(root.right);
		}
		//후위 탐색
		public void postOrder(Node root) {
			if(root.left!=null)
				postOrder(root.left);
			if(root.right!=null)
				postOrder(root.right);
			sb.append(root.data);
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Tree tree = new Tree();
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char data = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			tree.add(data, left, right);
		}
		
		sb = new StringBuilder();
		tree.preOrder(tree.root);
		System.out.println(sb.toString());
		
		sb = new StringBuilder();
		tree.inOrder(tree.root);
		System.out.println(sb.toString());
		
		sb = new StringBuilder();
		tree.postOrder(tree.root);
		System.out.println(sb.toString());
		
	}
}
