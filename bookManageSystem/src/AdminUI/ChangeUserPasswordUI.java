package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class ChangeUserPasswordUI extends AllUI{
	void show() {
		//����Աģʽ���޸��û�����
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������Ҫ�޸�������û�����");
		String username = scanner.nextLine();
		System.out.println("������ԭ���룺");
		String oldPwd = scanner.nextLine();
		System.out.println("������������");
		String newPwd = scanner.nextLine();
		System.out.println("���ٴ�����������");
		String newPwd2 = scanner.nextLine();
		//���÷���
		adminCet.changePwd(username, oldPwd, newPwd, newPwd2);
	}
}
