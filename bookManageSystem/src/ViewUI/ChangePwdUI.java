package ViewUI;

import java.util.Scanner;

import center.UserCet;

public class ChangePwdUI extends AllUI{
	void show(String userName) {
		int result=0;
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet(userName);
		
		System.out.println("������ԭ���룺");
		String oldPwd = scanner.nextLine();
		System.out.println("�����������룺");
		String newPwd1 = scanner.nextLine();
		System.out.println("���������������룺");
		String newPwd2 = scanner.nextLine();
		result=userCet.changePwd(oldPwd, newPwd1, newPwd2);
		
		switch(result) {
			case 2010:
				System.out.println("�����ɹ����");
				break;
			case 2001:
				System.out.println("������룺"+result);
				System.out.println("���������");
				break;
			case 2002:
				System.out.println("������룺"+result);
				System.out.println("���������벻һ��");
				break;
			case 2003:
				System.out.println("������룺"+result);
				System.out.println("δ�ҵ����û�");
				break;
			default:
				System.out.println("����δ֪���⣬����ϵ����Ա");
				System.out.println("λ�ڣ��û�-�޸�����");
				break;
		}
	}
}
