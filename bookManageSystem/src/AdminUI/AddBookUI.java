package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class AddBookUI extends AllUI{
	void show() {
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入书名：");
		String bookName = scanner.nextLine();
		System.out.println("请输入书号：");
		String bookNo = scanner.nextLine();
		System.out.println("请输入库存： ");
		int ku = Integer.parseInt(scanner.nextLine());
		result=adminCet.addBook(bookName, bookNo, ku);
		if(result==1010) {
			System.out.println("操作成功完成");
		}
		else {
			result=1001;
			System.out.println("错误代码："+result);
			System.out.println("添加该书失败");
		}
	}
}
