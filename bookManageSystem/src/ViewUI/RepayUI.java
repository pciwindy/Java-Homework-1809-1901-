package ViewUI;

import java.util.Scanner;
import center.*;

public class RepayUI extends AllUI {
	void show(String userName) {
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("��������Ҫ������ţ�");
		String BookId = scanner.nextLine();
		userCet.repay(userName,BookId);
	}
}
