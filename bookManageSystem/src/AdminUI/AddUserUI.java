package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class AddUserUI extends AllUI{
	void show() {
		//����û�
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("�������û�����");
		String userName = scanner.nextLine();
		System.out.println("���������룺");
		String firstPwd = scanner.nextLine();
		System.out.println("��������������:");
		String secondPwd = scanner.nextLine();
		System.out.println("�������ֻ��ţ�");
		String phoneNumber = scanner.nextLine();
		//��д�Ա�
		while(true){
			System.out.println("��ѡ���Ա�:");
			System.out.println("1-Ů 2-��");
			String Gender = scanner.nextLine();
			if(Gender.equals("1")){
				//���÷���
				adminCet.addUser(userName, phoneNumber, "F", firstPwd, secondPwd);
				break;
			}
			else if(Gender.equals("2")){
				//���÷���
				adminCet.addUser(userName, phoneNumber, "M", firstPwd, secondPwd);
				break;
			}
			else{
				System.out.println("ѡ���!");
			}
		}
	}
}
