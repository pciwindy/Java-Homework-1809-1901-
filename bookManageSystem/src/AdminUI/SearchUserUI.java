package AdminUI;

import java.util.Scanner;

import center.AdminCet;
import dataBase.User;

public class SearchUserUI extends AllUI{
	void show(){
		User user;
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ���ҵ��û�����");
		String userName = scanner.nextLine();
		user=(User)AdminCet.searchUser(userName);
		
		if(user==null) {
			System.out.println("δ�ҵ��û�");
		}
		else {
			System.out.println("�û���Ϊ�� "+user.getUsername());
			System.out.println("�Ա�Ϊ�� "+user.getGender());
			System.out.println("�ֻ���Ϊ: "+user.getPhoneNumber());
		}
	}
}
