/*DFS�� �����ϴٺ��� ��������Ʈ�� ������ DFS�߿� 
ArrayList<ArrayList<String>> �� ArrayList�ȿ� ArrayList�� ����� �ڵ带 ���Ҵ�.
�̸� �� �׳� �Ѿ �� �� ���⿡ GeeksforGeeks�� ������ ���� Ȯ���� ���Ҵ�.
*/
import java.util.ArrayList;
import java.util.*;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//n���� Array����Ʈ�� ����� ������ ����Ʈ�� Arraylist a1a2a3�� �߰��Ѵ�.
		int n =3;
		
		//ArrayList�ȿ� ArrayList�� �����ϰ� �̸� aList�� �̸�������.
		ArrayList<ArrayList<Integer>> aList = new ArrayList<ArrayList<Integer>>(n);
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(1);
		a1.add(2);
		aList.add(a1);
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(3);
		aList.add(a2);
		
		ArrayList<Integer> a3 = new ArrayList<Integer>();
		a3.add(10);
		a3.add(20);
		a3.add(30);
		a3.add(50);
		aList.add(a3);
		

		
		//ArrayList�� ArrayList�� ��½ÿ��� �迭�� ���·� �迭 ���ο� 
		//������ ����Ʈ�� ������ �ִ� ������ �� �� �ִ�. [1,2] [3] [10,20,30,50]
		for(int i=0;i<aList.size();i++) {
			System.out.print(aList.get(i)+" ");
		}
		
		System.out.println();
		
		//�� ArrayList�� �Ϻ� ArrayList�� ����ϱ����� �ڵ�
		for(int i=0;i<aList.size();i++) {
			for(int j=0;j<aList.get(i).size();j++) {
				System.out.print(aList.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
