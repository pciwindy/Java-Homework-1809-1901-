package ViewUI;

import java.util.Scanner;

import center.UserCet;

public class ChangePwdUI extends AllUI{
	void show(String userName) {
		int result=0;
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet(userName);
		
		System.out.println("请输入原密码：");
		String oldPwd = scanner.nextLine();
		System.out.println("请输入新密码：");
		String newPwd1 = scanner.nextLine();
		System.out.println("请重新输入新密码：");
		String newPwd2 = scanner.nextLine();
		result=userCet.changePwd(oldPwd, newPwd1, newPwd2);
		
		switch(result) {
			case 2010:
				System.out.println("操作成功完成");
				break;
			case 2001:
				System.out.println("错误代码："+result);
				System.out.println("旧密码错误");
				break;
			case 2002:
				System.out.println("错误代码："+result);
				System.out.println("两次新密码不一样");
				break;
			case 2003:
				System.out.println("错误代码："+result);
				System.out.println("未找到该用户");
				break;
			default:
				System.out.println("遇到未知问题，请联系管理员");
				System.out.println("位于：用户-修改密码");
				break;
		}
	}
}
