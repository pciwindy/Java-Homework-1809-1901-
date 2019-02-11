package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class DeleteBookUI extends AllUI{
	void show() {
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入要删除书的名字：");
		String BookName = scanner.nextLine();
		System.out.println("请输入要删除书的ID：");
		String BookNo = scanner.nextLine();
		result=adminCet.deleteBook(BookName, BookNo);
		
		if(result==6010) {
			System.out.println("操作成功完成");
		}
		else {
			System.out.println("错误代码："+result);
			System.out.println("删除此书失败");
		}
	}
}
