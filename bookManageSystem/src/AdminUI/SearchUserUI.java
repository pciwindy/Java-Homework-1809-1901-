package AdminUI;

import java.util.Scanner;

import center.AdminCet;
import dataBase.User;

public class SearchUserUI extends AllUI{
	void show(){
		User user;
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入需要查找的用户名：");
		String userName = scanner.nextLine();
		user=(User)AdminCet.searchUser(userName);
		
		if(user==null) {
			System.out.println("未找到用户");
		}
		else {
			System.out.println("用户名为： "+user.getUsername());
			System.out.println("性别为： "+user.getGender());
			System.out.println("手机号为: "+user.getPhoneNumber());
		}
	}
}
