package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class AddUserUI extends AllUI{
	void show() {
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�������û�����");
		String userName = scanner.nextLine();
		System.out.println("�������һ�����룺");
		String firstPwd = scanner.nextLine();
		System.out.println("������ڶ�������:");
		String secondPwd = scanner.nextLine();
		System.out.println("�������ֻ��ţ�");
		String phoneNumber = scanner.nextLine();
		while(true){
			System.out.println("��ѡ���Ա�:");
			System.out.println("1-Ů 2-��");
			String Gender = scanner.nextLine();
			if(Gender.equals("1")){
				result=adminCet.addUser(userName, phoneNumber, "F", firstPwd, secondPwd);
				break;
			}
			else if(Gender.equals("2")){
				result=adminCet.addUser(userName, phoneNumber, "M", firstPwd, secondPwd);
				break;
			}
			else {
				result=2002;
				break;
			}
		}
		switch(result) {
			case 2010:
				System.out.println("�����ɹ����");
				break;
			case 2001:
				System.out.println("������룺"+result);
				System.out.println("������������벻ƥ��");
				break;
			case 2002:
				System.out.println("������룺"+result);
				System.out.println("�Ա��������");
				break;
			default:
				System.out.println("����δ֪���⣬����ϵ����Ա");
				System.out.println("λ�ڣ�����Ա-����û�");
				break;
		}
	}
}
