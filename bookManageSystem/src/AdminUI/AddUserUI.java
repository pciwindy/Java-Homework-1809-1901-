package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class AddUserUI extends AllUI{
	void show() {
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入用户名：");
		String userName = scanner.nextLine();
		System.out.println("请输入第一个密码：");
		String firstPwd = scanner.nextLine();
		System.out.println("请输入第二个密码:");
		String secondPwd = scanner.nextLine();
		System.out.println("请输入手机号：");
		String phoneNumber = scanner.nextLine();
		while(true){
			System.out.println("请选择性别:");
			System.out.println("1-女 2-男");
			String Gender = scanner.nextLine();
			if(Gender.equals("1")){
				result=adminCet.addUser(userName, phoneNumber, "F", firstPwd, secondPwd);
				break;
			}
			else if(Gender.equals("2")){
				result=adminCet.addUser(userName, phoneNumber, "M", firstPwd, secondPwd);
				break;
			}
			else {
				result=2002;
				break;
			}
		}
		switch(result) {
			case 2010:
				System.out.println("操作成功完成");
				break;
			case 2001:
				System.out.println("错误代码："+result);
				System.out.println("输入的两次密码不匹配");
				break;
			case 2002:
				System.out.println("错误代码："+result);
				System.out.println("性别输入错误");
				break;
			default:
				System.out.println("遇到未知问题，请联系管理员");
				System.out.println("位于：管理员-添加用户");
				break;
		}
	}
}
