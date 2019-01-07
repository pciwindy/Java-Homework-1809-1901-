package AdminUI;

import java.util.Scanner;

import center.UserCet;

public class SearchBookUI extends AllUI{
	void show(){
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("请输入需要查找的书号：");
		String bookNo = scanner.nextLine();
		userCet.search(bookNo);
	}
}
