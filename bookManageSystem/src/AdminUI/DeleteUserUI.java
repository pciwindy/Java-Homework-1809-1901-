package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class DeleteUserUI extends AllUI{
	void show() {
		//ɾ���û�
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("��������Ҫɾ�����û�����");
		String UserName = scanner.nextLine();
		System.out.println("�������ֻ��ţ�");
		String UserPhp = scanner.nextLine();
		//���÷���
		adminCet.delUser(UserName, UserPhp);
		System.out.println("ɾ���ɹ�!");
	}
}
