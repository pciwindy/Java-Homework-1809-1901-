package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class SearchUserUI extends AllUI{
	void show(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入需要查找的用户名：");
		String userName = scanner.nextLine();
		AdminCet.searchUser(userName);
	}
}
