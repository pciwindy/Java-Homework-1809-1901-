package ViewUI;

import java.util.Scanner;

import center.UserCet;

public class SearchUI extends AllUI{
	void show(String userName) {
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("��������Ҫ���ҵ���ţ�");
		String bookNo = scanner.nextLine();
		userCet.search(bookNo);
	}
}
