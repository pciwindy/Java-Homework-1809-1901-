package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class ChangeUserInfomationUI extends AllUI{
	void show() {
		int result=0;
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
				result=adminCet.updateUser(1, un, "M");
			}
			else if(flag.equals("2")){
				result=adminCet.updateUser(1, un, "F");
			}
			else{
				//System.out.println("性别输入错误!");
				result=4002;
			}
		} else if (studentChoice == 2) {
			System.out.println("请输入新的手机号：");
			String Userphp = scanner.nextLine();
			adminCet.updateUser(2, un, Userphp);
		} else {
			//System.out.println("输入错误！");
			result=4003;
		}
		
		switch(result) {
			case 4010:
				System.out.println("操作成功完成");
				break;
			case 4001:
				System.out.println("错误代码："+result);
				System.out.println("未找到该用户");
				break;
			case 4002:
				System.out.println("错误代码："+result);
				System.out.println("性别输入错误!");
				break;
			case 4003:
				System.out.println("错误代码："+result);
				System.out.println("输入错误！");
				break;
			case 4004:
				System.out.println("遇到未知问题，请联系管理员");
				System.out.println("位于：管理员-修改用户信息");
				break;
			default:
				System.out.println("遇到未知问题，请联系管理员");
				System.out.println("位于：管理员-修改用户信息");
				break;
		}
	}
}
