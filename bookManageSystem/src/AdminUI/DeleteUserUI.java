package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class DeleteUserUI extends AllUI{
	void show() {
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("��������Ҫɾ�����û�����");
		String UserName = scanner.nextLine();
		System.out.println("�������ֻ��ţ�");
		String UserPhp = scanner.nextLine();
		result=adminCet.delUser(UserName, UserPhp);
		
		switch(result) {
			case 7010:
				System.out.println("�����ɹ����");
				break;
			case 7001:
				System.out.println("������룺"+result);
				System.out.println("�û�������");
				break;
			case 7002:
				System.out.println("������룺"+result);
				System.out.println("������ȡ��");
				break;
			case 7003:
				System.out.println("������룺"+result);
				System.out.println("�ֻ��Ŵ���");
				break;
			default:
				System.out.println("����δ֪���⣬����ϵ����Ա");
				System.out.println("λ�ڣ�����Ա-ɾ���û�");
				break;
		}
	}
}
