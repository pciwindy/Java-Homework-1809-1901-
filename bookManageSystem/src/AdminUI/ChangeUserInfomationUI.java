package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class ChangeUserInfomationUI extends AllUI{
	void show() {
		int result=0;
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
				result=adminCet.updateUser(1, un, "M");
			}
			else if(flag.equals("2")){
				result=adminCet.updateUser(1, un, "F");
			}
			else{
				//System.out.println("�Ա��������!");
				result=4002;
			}
		} else if (studentChoice == 2) {
			System.out.println("�������µ��ֻ��ţ�");
			String Userphp = scanner.nextLine();
			adminCet.updateUser(2, un, Userphp);
		} else {
			//System.out.println("�������");
			result=4003;
		}
		
		switch(result) {
			case 4010:
				System.out.println("�����ɹ����");
				break;
			case 4001:
				System.out.println("������룺"+result);
				System.out.println("δ�ҵ����û�");
				break;
			case 4002:
				System.out.println("������룺"+result);
				System.out.println("�Ա��������!");
				break;
			case 4003:
				System.out.println("������룺"+result);
				System.out.println("�������");
				break;
			case 4004:
				System.out.println("����δ֪���⣬����ϵ����Ա");
				System.out.println("λ�ڣ�����Ա-�޸��û���Ϣ");
				break;
			default:
				System.out.println("����δ֪���⣬����ϵ����Ա");
				System.out.println("λ�ڣ�����Ա-�޸��û���Ϣ");
				break;
		}
	}
}
