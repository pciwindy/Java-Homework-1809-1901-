package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class SearchUserUI extends AllUI{
	void show(){
		//�����û�
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������Ҫ���ҵ��û�����");
		String userName = scanner.nextLine();
		//���÷���
		AdminCet.searchUser(userName);
	}
}
