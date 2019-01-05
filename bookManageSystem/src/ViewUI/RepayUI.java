package ViewUI;

import java.util.Scanner;
import center.*;

public class RepayUI extends AllUI {
	void show(String userName) {
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("请输入需要还的书号：");
		String BookId = scanner.nextLine();
		userCet.repay(userName,BookId);
	}
}
