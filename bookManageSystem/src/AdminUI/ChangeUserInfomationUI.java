package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class ChangeUserInfomationUI extends AllUI{
	void show() {
		//�޸��û���Ϣ
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������Ҫ�޸���Ϣ���û�����");
		String un = scanner.nextLine();
		System.out.println("����������ѡ�");
		System.out.println("1���Ա�  2���ֻ���");
		int studentChoice = Integer.parseInt(scanner.nextLine());
		if (studentChoice == 1) {
			System.out.println("��ѡ���Ա�");
			System.out.println("1-�� 2-Ů");
			String flag=scanner.nextLine();
			if(flag.equals("1")){
				//ͨ������Ĳ�������
				adminCet.updateUser(1, un, "M");
			}
			else if(flag.equals("2")){
				//ͨ������Ĳ�������
				adminCet.updateUser(1, un, "F");
			}
			else{
				System.out.println("�������!");
				System.out.println("δ����ɹ�!");
			}
		} else if (studentChoice == 2) {
			System.out.println("�������µ��ֻ��ţ�");
			String Userphp = scanner.nextLine();
			//ͨ������Ĳ�������
			adminCet.updateUser(2, un, Userphp);
			System.out.println("�޸ĳɹ���");
		} else {
			System.out.println("�������");
		}
	}
}
