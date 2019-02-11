package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class DeleteUserUI extends AllUI{
	void show() {
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("请输入您要删除的用户名：");
		String UserName = scanner.nextLine();
		System.out.println("请输入手机号：");
		String UserPhp = scanner.nextLine();
		result=adminCet.delUser(UserName, UserPhp);
		
		switch(result) {
			case 7010:
				System.out.println("操作成功完成");
				break;
			case 7001:
				System.out.println("错误代码："+result);
				System.out.println("用户不存在");
				break;
			case 7002:
				System.out.println("错误代码："+result);
				System.out.println("操作被取消");
				break;
			case 7003:
				System.out.println("错误代码："+result);
				System.out.println("手机号错误");
				break;
			default:
				System.out.println("遇到未知问题，请联系管理员");
				System.out.println("位于：管理员-删除用户");
				break;
		}
	}
}
