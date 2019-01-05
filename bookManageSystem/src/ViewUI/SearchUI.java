package ViewUI;

import java.util.Scanner;

import center.UserCet;

public class SearchUI extends AllUI{
	void show(String userName) {
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("请输入需要查找的书号：");
		String bookNo = scanner.nextLine();
		userCet.search(bookNo);
	}
}
