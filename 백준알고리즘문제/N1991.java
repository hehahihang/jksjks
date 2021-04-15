/*[����][N1991][Ʈ����ȸ]
���� Ʈ���� �Է¹޾� ���� ��ȸ(preorder traversal), ���� ��ȸ(inorder traversal), ���� ��ȸ(postorder traversal)�� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.

���� ��� ���� ���� ���� Ʈ���� �ԷµǸ�,

���� ��ȸ�� ��� : ABDCEFG // (��Ʈ) (���� �ڽ�) (������ �ڽ�)
���� ��ȸ�� ��� : DBAECFG // (���� �ڽ�) (��Ʈ) (������ �ڽ�)
���� ��ȸ�� ��� : DBEGFCA // (���� �ڽ�) (������ �ڽ�) (��Ʈ)
�� �ȴ�.

�Է�
ù° �ٿ��� ���� Ʈ���� ����� ���� N(1��N��26)�� �־�����. ��° �ٺ��� N���� �ٿ� ���� �� ���� ���� ���� �ڽ� ���, ������ �ڽ� ��尡 �־�����. 
����� �̸��� A���� ���ʴ�� ������ �빮�ڷ� �Ű�����, �׻� A�� ��Ʈ ��尡 �ȴ�. �ڽ� ��尡 ���� ��쿡�� .���� ǥ���ȴ�.

���
ù° �ٿ� ���� ��ȸ, ��° �ٿ� ���� ��ȸ, ��° �ٿ� ���� ��ȸ�� ����� ����Ѵ�. �� �ٿ� N���� ���ĺ��� ���� ���� ����ϸ� �ȴ�.

*/

/*
Ǯ��
- Ʈ�� Class�� Ʈ���� �� ��带 ��Ÿ�� ��� Class�� �ۼ��Ѵ�.
(1)�ʱ��� Tree���� root = null �̸� Node�� �������ش�.
(2)root != null �̸�, �� root data�� left,right ������ �����ϴ��� ���(searchNode)�� Ž���Ѵ�.
(3)searchNode���� root�� null�̶�� ���� �Ʒ��� �ڽ� ������ �湮�� ���̹Ƿ� return;
(4)�Է��� data = root.data �� ���� ã������ Ʈ���� left�� right ���� �����Ѵ�.
(5)�Ѵ� �ƴ� ��쿡�� ����Ʈ���� �������� ������ seacrhNode�� Ž���� ����Ѵ�.
(6)����, ���� ��ȸ, ���� ��ȸ, ���� ��ȸ�� �����Ѵ�.

#������ȸ : ��Ʈ -> left -> right
#������ȸ : left -> ��Ʈ -> right
#������ȸ : left -> right -> root

�ǵ�� : Ʈ�� ��ƴ�. ��� ��ƴ�. �Ѵ� �ǳ� �򰥸��� ���䵵 ����� �������� ����.
���� ��Ȯ�ϰ� ���ذ� �� �ƴ� ����� ��Ͱ� �ݺ��Ǵ� ������ ������ �ۼ��ϸ� Ȯ���� �ô� ���̶�� �����Ѵ�.
ENM���� ��Ϳ��� �зȱ⶧���� ��Ϳ� Ʈ���� ������ �����ؾ߰ڴ�.
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
		Node root; //ó���� null
		public void add(char data, char left, char right) {
			//���� ������ ��
			if(root==null) {
				if(data!='.')
					root = new Node(data);
				if(left!='.')
					root.left = new Node(left);
				if(right!='.')
					root.right = new Node(right);
			}
			//���ʰ� �ƴ� �� -> ���� ���� �ϴ��� ã�´�.
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
		//������ȸ
		public void preOrder(Node root) {
			sb.append(root.data);
			if(root.left!=null)
				preOrder(root.left);
			if(root.right!=null)
				preOrder(root.right);
		}
		//���� ��ȸ
		public void inOrder(Node root) {
			if(root.left!=null)
				inOrder(root.left);
			sb.append(root.data);
			if(root.right!=null)
				inOrder(root.right);
		}
		//���� Ž��
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
