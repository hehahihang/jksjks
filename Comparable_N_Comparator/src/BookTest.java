import java.util.Arrays;
import java.util.Comparator;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book [] books = new Book [3];
		books[0] = new Book("a book",300);
		books[1] = new Book("b book",100);
		books[2] = new Book("c book",200);
		
		System.out.println("Comparable�� ����� ������ ���ı���-----");
		System.out.println("BookŬ������ CompareTo�� ����Ͽ� ����");
		Arrays.sort(books);
		
		for(Book book:books) {
			System.out.println(book);
		}
		
		System.out.println();
		System.out.println("Comparator�� ����Ͽ� ���� ���ο� ���ı���-----");
		System.out.println("Comparator���� ������ ���ο� ������ ����Ͽ� ����");
		
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
