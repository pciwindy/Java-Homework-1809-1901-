package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class DeleteUserUI extends AllUI{
	void show() {
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入您要删除的用户名：");
		String UserName = scanner.nextLine();
		System.out.println("请输入手机号：");
		String UserPhp = scanner.nextLine();
		adminCet.delUser(UserName, UserPhp);
		System.out.println("删除成功!");
	}
}
