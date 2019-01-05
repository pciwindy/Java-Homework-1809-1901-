package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class ChangeUserPasswordUI extends AllUI{
	void show() {
		//管理员模式下修改用户密码
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入要修改密码的用户名：");
		String username = scanner.nextLine();
		System.out.println("请输入原密码：");
		String oldPwd = scanner.nextLine();
		System.out.println("请输入新密码");
		String newPwd = scanner.nextLine();
		System.out.println("请再次输入新密码");
		String newPwd2 = scanner.nextLine();
		//调用方法
		adminCet.changePwd(username, oldPwd, newPwd, newPwd2);
	}
}
