package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class AddBookUI extends AllUI{
	void show() {
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		System.out.println("������������");
		String bookName = scanner.nextLine();
		System.out.println("��������ţ�");
		String bookNo = scanner.nextLine();
		System.out.println("�������棺 ");
		int ku = Integer.parseInt(scanner.nextLine());
		adminCet.addBook(bookName, bookNo, ku);
	}
}
