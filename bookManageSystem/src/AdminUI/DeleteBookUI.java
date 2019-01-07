package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class DeleteBookUI extends AllUI{
	void show() {
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入要删除书的名字：");
		String BookName = scanner.nextLine();
		System.out.println("请输入要删除书的ID：");
		String BookNo = scanner.nextLine();
		adminCet.deleteBook(BookName, BookNo);
		System.out.println("删除成功!");
	}
}
