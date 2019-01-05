package ViewUI;

import java.util.Scanner;

import center.UserCet;

public class ChangePwdUI extends AllUI{
	void show(String userName) {
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("请输入原密码：");
		String oldPwd = scanner.nextLine();
		System.out.println("请输入第一个新密码：");
		String newPwd1 = scanner.nextLine();
		System.out.println("请输入第二个新密码：");
		String newPwd2 = scanner.nextLine();
		userCet.changePwd(userName,oldPwd, newPwd1, newPwd2);
	}
}
