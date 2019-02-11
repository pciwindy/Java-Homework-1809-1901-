package ViewUI;

import java.util.Scanner;
import center.*;

public class RepayUI extends AllUI {
	void show(String userName) {
		int result=0;
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("请输入需要还的书号：");
		String BookId = scanner.nextLine();
		result=userCet.repay(BookId);
		
		switch(result) {
			case 3010:
				System.out.println("操作成功完成");
				break;
			case 3001:
				System.out.println("错误代码："+result);
				System.out.println("操作失败");
				break;
			default:
				System.out.println("遇到未知问题，请联系管理员");
				System.out.println("位于：用户-还书");
				break;
		}
	}
}
