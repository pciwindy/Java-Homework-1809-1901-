package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class AddBookUI extends AllUI{
	void show() {
		//添加书籍
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入书名：");
		String bookName = scanner.nextLine();
		System.out.println("请输入书号：");
		String bookNo = scanner.nextLine();
		System.out.println("请输入库存： ");
		int ku = Integer.parseInt(scanner.nextLine());
		//传入业务层
		adminCet.addBook(bookName, bookNo, ku);
	}
}
