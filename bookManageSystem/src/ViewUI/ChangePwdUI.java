package ViewUI;

import java.util.Scanner;

import center.UserCet;

public class ChangePwdUI extends AllUI{
	void show(String userName) {
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("������ԭ���룺");
		String oldPwd = scanner.nextLine();
		System.out.println("�������һ�������룺");
		String newPwd1 = scanner.nextLine();
		System.out.println("������ڶ��������룺");
		String newPwd2 = scanner.nextLine();
		userCet.changePwd(userName,oldPwd, newPwd1, newPwd2);
	}
}
