package ViewUI;

import java.util.*;
import center.*;

public class BorrowUI extends AllUI{
	void show(String userName) {
		Scanner scanner = new Scanner(System.in);
		UserCet userCet=new UserCet();
		System.out.println("��������Ҫ�����ţ�");
		String bookId = scanner.nextLine();
		userCet.borrow(userName,bookId);
	}
}
