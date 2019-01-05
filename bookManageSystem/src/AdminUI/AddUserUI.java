package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class AddUserUI extends AllUI{
	void show() {
		//添加用户
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入用户名：");
		String userName = scanner.nextLine();
		System.out.println("请输入密码：");
		String firstPwd = scanner.nextLine();
		System.out.println("请重新输入密码:");
		String secondPwd = scanner.nextLine();
		System.out.println("请输入手机号：");
		String phoneNumber = scanner.nextLine();
		//填写性别
		while(true){
			System.out.println("请选择性别:");
			System.out.println("1-女 2-男");
			String Gender = scanner.nextLine();
			if(Gender.equals("1")){
				//调用方法
				adminCet.addUser(userName, phoneNumber, "F", firstPwd, secondPwd);
				break;
			}
			else if(Gender.equals("2")){
				//调用方法
				adminCet.addUser(userName, phoneNumber, "M", firstPwd, secondPwd);
				break;
			}
			else{
				System.out.println("选择错!");
			}
		}
	}
}
