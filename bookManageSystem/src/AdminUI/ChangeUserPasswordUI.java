package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class ChangeUserPasswordUI extends AllUI{
	void show() {
		int result=0;
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
		result=adminCet.changePwd(username, oldPwd, newPwd, newPwd2);
		
		switch(result) {
			case 5010:
				System.out.println("�����ɹ����");
				break;
			case 5001:
				System.out.println("������룺"+result);
				System.out.println("δ�ҵ����û�");
				break;
			case 5002:
				System.out.println("������룺"+result);
				System.out.println("���������");
				break;
			case 5003:
				System.out.println("������룺"+result);
				System.out.println("���������벻һ��");
				break;
			default:
				System.out.println("����δ֪���⣬����ϵ����Ա");
				System.out.println("λ�ڣ�����Ա-�޸��û�����");
				break;
		}
	}
}
