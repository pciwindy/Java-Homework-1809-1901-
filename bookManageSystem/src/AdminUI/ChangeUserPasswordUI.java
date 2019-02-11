package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class ChangeUserPasswordUI extends AllUI{
	void show() {
		int result=0;
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
		result=adminCet.changePwd(username, oldPwd, newPwd, newPwd2);
		
		switch(result) {
			case 5010:
				System.out.println("操作成功完成");
				break;
			case 5001:
				System.out.println("错误代码："+result);
				System.out.println("未找到该用户");
				break;
			case 5002:
				System.out.println("错误代码："+result);
				System.out.println("旧密码错误");
				break;
			case 5003:
				System.out.println("错误代码："+result);
				System.out.println("两次新密码不一样");
				break;
			default:
				System.out.println("遇到未知问题，请联系管理员");
				System.out.println("位于：管理员-修改用户密码");
				break;
		}
	}
}
