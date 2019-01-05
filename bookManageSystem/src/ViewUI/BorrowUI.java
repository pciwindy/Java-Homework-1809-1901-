package ViewUI;

import java.util.*;
import center.*;

public class BorrowUI extends AllUI{
	void show(String userName) {
		Scanner scanner = new Scanner(System.in);
		UserCet userCet=new UserCet();
		System.out.println("请输入需要借的书号：");
		String bookId = scanner.nextLine();
		userCet.borrow(userName,bookId);
	}
}
