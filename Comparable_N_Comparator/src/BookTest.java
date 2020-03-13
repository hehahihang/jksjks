import java.util.Arrays;
import java.util.Comparator;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book [] books = new Book [3];
		books[0] = new Book("a book",300);
		books[1] = new Book("b book",100);
		books[2] = new Book("c book",200);
		
		System.out.println("Comparable을 사용한 기존의 정렬기준-----");
		System.out.println("Book클래스의 CompareTo를 사용하여 비교함");
		Arrays.sort(books);
		
		for(Book book:books) {
			System.out.println(book);
		}
		
		System.out.println();
		System.out.println("Comparator를 사용하여 만든 새로운 정렬기준-----");
		System.out.println("Comparator에서 정의한 새로운 기준을 사용하여 비교함");
		
		Arrays.sort(books,new Comparator<Book>() {
			@Override
			public int compare(Book book1, Book book2) {
				// TODO Auto-generated method stub
				return book1.getName().compareTo(book2.getName());
			}
		});
		
		for(Book book:books) {
			System.out.println(book);
		}
	}

}
