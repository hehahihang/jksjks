import java.util.Arrays;
import java.util.*;

public class Book implements Comparable<Book> {
	private String name;
	private int price;
	
	public Book(String input_name,int input_price) {
		this.name = input_name;
		this.price = input_price;
	}
	
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public void setName(String input_name) {
		name = input_name;
	}
	public void setPrice(int input_price) {
		price = input_price;
	}
	public String toString() {
		return "Book : name = " + this.name + " // : Price = "+this.price;
	}
	
	@Override
	public int compareTo(Book compareBook) {
		// TODO Auto-generated method stub
		return compareBook.price - this.price;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book [] books = new Book[3];
		books[0] = new Book("a book",300);
		books[1] = new Book("b book",100);
		books[2] = new Book("c book",200);
		
		Arrays.sort(books);
		
		for(int i=0;i<books.length;i++) {
			System.out.println(books[i]+" ");
		}
	}
}
