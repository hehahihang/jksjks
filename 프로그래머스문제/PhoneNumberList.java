package LEVEL2;

import java.util.HashMap;
import java.util.Hashtable;

public class PhoneNumberList {
	
	public boolean solution(String [] phone_book) {
		boolean answer = true;
		
		for(int i=0;i<phone_book.length;i++) {
			for(int j=0;j<phone_book.length && j!=i;j++) {
				if(phone_book[i].startsWith(phone_book[j])) {
					answer = false;
					break;
				}
				else if(phone_book[j].startsWith(phone_book[i])){
					answer = false;
					break;
				}
			}
		}
		
		return answer;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
