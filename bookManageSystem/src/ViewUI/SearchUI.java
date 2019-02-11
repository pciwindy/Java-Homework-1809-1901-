package ViewUI;

import java.util.Scanner;

import center.UserCet;
import dataBase.Book;

public class SearchUI extends AllUI{
	void show(String userName) {
		Book book;
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		
		System.out.println("��������Ҫ���ҵ���ţ�");
		String bookNo = scanner.nextLine();
		book=(Book)userCet.search(bookNo);
		
		if(book==null) {
			System.out.println("δ�ҵ�����");
		}
		else {
			System.out.println("�Ȿ���ID�ǣ� " + book.getBookId());
			System.out.println("�Ȿ��������ǣ� " + book.getBookName());
			System.out.println("�Ȿ�黹�� " + book.getNumber()+" ��");
		}
	}
}
