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
		
		System.out.println("Array.sort ���İ��");
		for(int i=0;i<alphabetArray.length;i++) {
			System.out.print(alphabetArray[i]+" " );
		}
		System.out.println();
		System.out.println("Collection.sort ���İ��");
		for(int i=0;i<alphabetArray.length;i++) {
			System.out.print(arrlist.get(i)+" " );
		}
	}
}
/*Arrays.sort�� Collection.sort���� ���� ����� ���� �� �ִ� ������
StringŬ���� ���������� Comparable�� �����Ǿ� �־ ���ĺ������� ������ �� �ֱ� �����̴�
*/