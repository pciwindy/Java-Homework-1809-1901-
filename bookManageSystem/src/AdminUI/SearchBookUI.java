package AdminUI;

import java.util.Scanner;

import center.UserCet;

public class SearchBookUI extends AllUI{
	void show(){
		//查找书籍
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("请输入需要查找的书号：");
		String bookNo = scanner.nextLine();
		//调用了用户业务处理层的方法
		userCet.search(bookNo);
	}
}
