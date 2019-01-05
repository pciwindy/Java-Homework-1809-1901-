package AdminUI;

import java.util.Scanner;
import center.AdminCet;



public class ChangeSUPasswordUI extends AllUI{
	void show(){
		//修改管理员密码
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入原密码：");
		String oldPwd = scanner.nextLine();
		System.out.println("请输入新密码");
		String newPwd = scanner.nextLine();
		System.out.println("请再次输入新密码");
		String newPwd2 = scanner.nextLine();
		//调用方法
		adminCet.changeSUPassword(oldPwd, newPwd, newPwd2);
	}
}
