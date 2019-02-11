package ViewUI;

import java.util.Scanner;

import center.UserCet;
import dataBase.Book;

public class SearchUI extends AllUI{
	void show(String userName) {
		Book book;
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		
		System.out.println("请输入需要查找的书号：");
		String bookNo = scanner.nextLine();
		book=(Book)userCet.search(bookNo);
		
		if(book==null) {
			System.out.println("未找到该书");
		}
		else {
			System.out.println("这本书的ID是： " + book.getBookId());
			System.out.println("这本书的名字是： " + book.getBookName());
			System.out.println("这本书还有 " + book.getNumber()+" 本");
		}
	}
}
