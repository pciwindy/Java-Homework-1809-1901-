package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class ChangeUserInfomationUI extends AllUI{
	void show() {
		//修改用户信息
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入要修改信息的用户名：");
		String un = scanner.nextLine();
		System.out.println("请输入您的选项：");
		System.out.println("1、性别  2、手机号");
		int studentChoice = Integer.parseInt(scanner.nextLine());
		if (studentChoice == 1) {
			System.out.println("请选择性别：");
			System.out.println("1-男 2-女");
			String flag=scanner.nextLine();
			if(flag.equals("1")){
				//通过传入的参数更改
				adminCet.updateUser(1, un, "M");
			}
			else if(flag.equals("2")){
				//通过传入的参数更改
				adminCet.updateUser(1, un, "F");
			}
			else{
				System.out.println("输入错误!");
				System.out.println("未保存成功!");
			}
		} else if (studentChoice == 2) {
			System.out.println("请输入新的手机号：");
			String Userphp = scanner.nextLine();
			//通过传入的参数更改
			adminCet.updateUser(2, un, Userphp);
			System.out.println("修改成功！");
		} else {
			System.out.println("输入错误！");
		}
	}
}
