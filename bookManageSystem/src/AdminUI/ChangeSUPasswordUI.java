package AdminUI;

import java.util.Scanner;
import center.AdminCet;



public class ChangeSUPasswordUI extends AllUI{
	void show(){
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入原密码：");
		String oldPwd = scanner.nextLine();
		System.out.println("请输入新密码");
		String newPwd = scanner.nextLine();
		System.out.println("请重新输入新密码");
		String newPwd2 = scanner.nextLine();
		
		result=adminCet.changeSUPassword(oldPwd, newPwd, newPwd2);
		
		switch(result) {
			case 3010:
				System.out.println("操作成功完成");
				break;
			case 3001:
				System.out.println("错误代码："+result);
				System.out.println("两次新密码不一样");
				break;
			case 3002:
				System.out.println("错误代码："+result);
				System.out.println("旧密码错误");
				break;
			default:
				System.out.println("遇到未知问题，请联系管理员");
				System.out.println("位于：管理员-修改管理员密码");
				break;
		}
	}
}
