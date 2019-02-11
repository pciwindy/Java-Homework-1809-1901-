package ViewUI;

import java.util.*;
import center.*;

public class BorrowUI extends AllUI{
	void show(String userName) {
		int result=0;
		Scanner scanner = new Scanner(System.in);
		UserCet userCet=new UserCet(userName);
		
		System.out.println("请输入需要借的书号：");
		String bookId = scanner.nextLine();
		result=userCet.borrow(bookId);
		
		if(result==1010) {
			System.out.println("操作成功完成");
		}
		else {
			System.out.println("错误代码："+result);
			System.out.println("操作失败");
		}
	}
}
