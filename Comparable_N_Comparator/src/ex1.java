import java.util.*;

public class ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] alphabetArray = {"b","d","a","c","z","e"};
		ArrayList<String> arrlist = new ArrayList<>();
		
		for(int i=0;i<alphabetArray.length;i++) {
			arrlist.add(alphabetArray[i]);
		}
		Arrays.sort(alphabetArray);
		Collections.sort(arrlist);
		
		System.out.println("Array.sort 정렬결과");
		for(int i=0;i<alphabetArray.length;i++) {
			System.out.print(alphabetArray[i]+" " );
		}
		System.out.println();
		System.out.println("Collection.sort 정렬결과");
		for(int i=0;i<alphabetArray.length;i++) {
			System.out.print(arrlist.get(i)+" " );
		}
	}
}
/*Arrays.sort와 Collection.sort에서 같은 결과를 얻을 수 있는 이유는
String클래스 내부적으로 Comparable이 구현되어 있어서 알파벳순으로 정렬할 수 있기 때문이다
*/