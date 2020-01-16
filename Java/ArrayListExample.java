/*DFS를 공부하다보니 인접리스트로 구현한 DFS중에 
ArrayList<ArrayList<String>> 즉 ArrayList안에 ArrayList를 사용한 코드를 보았다.
이를 또 그냥 넘어갈 수 가 없기에 GeeksforGeeks의 예제를 통해 확인해 보았다.
*/
import java.util.ArrayList;
import java.util.*;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//n개의 Array리스트를 만들어 각각의 리스트에 Arraylist a1a2a3를 추가한다.
		int n =3;
		
		//ArrayList안에 ArrayList를 선언하고 이를 aList라 이름지었다.
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
		

		
		//ArrayList의 ArrayList를 출력시에는 배열의 형태로 배열 내부에 
		//각각의 리스트가 가지고 있는 정보를 볼 수 있다. [1,2] [3] [10,20,30,50]
		for(int i=0;i<aList.size();i++) {
			System.out.print(aList.get(i)+" ");
		}
		
		System.out.println();
		
		//각 ArrayList의 하부 ArrayList를 출력하기위한 코드
		for(int i=0;i<aList.size();i++) {
			for(int j=0;j<aList.get(i).size();j++) {
				System.out.print(aList.get(i).get(j)+" ");
			}
			System.out.println();
		}
	}

}
