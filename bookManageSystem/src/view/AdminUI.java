package view;

import java.util.Scanner;
import center.*;

public class AdminUI {
	public static void show() {
		AdminCet adminCet = new AdminCet();
		while (true) {
			System.out.println("\t\t1.�����û�\t\t2.ɾ���û�");
			System.out.println("\t\t3.�޸��û�����\t\t4.�޸��û���Ϣ");
			System.out.println("\t\t5.���ͼ��\t\t6.ɾ��ͼ��");

			System.out.println("\t\t6.�޸Ĺ���Ա��Ϣ\t\t7.�޸Ĺ���Ա����");
			Scanner scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				System.out.println("�������û�����");
				String userName = scanner.nextLine();
				System.out.println("�������һ�����룺");
				String firstPwd = scanner.nextLine();
				System.out.println("������ڶ�������:");
				String secondPwd = scanner.nextLine();
				System.out.println("�������Ա�:");
				String Gender = scanner.nextLine();
				System.out.println("�������ֻ��ţ�");
				String phoneNumber = scanner.nextLine();
				adminCet.addUser(userName, phoneNumber, Gender, firstPwd, secondPwd);
				break;
			case "2":
				System.out.println("��������Ҫɾ�����û�����");
				String UserName = scanner.nextLine();
				System.out.println("�������ֻ��ţ�");
				String UserPhp = scanner.nextLine();
				adminCet.delUser(UserName, UserPhp);
				break;
			case "3":
				System.out.println("������Ҫ�޸�������û�����");
				String username = scanner.nextLine();
				System.out.println("������ԭ���룺");
				String oldPwd = scanner.nextLine();
				System.out.println("������������");
				String newPwd = scanner.nextLine();
				System.out.println("���ٴ�����������");
				String newPwd2 = scanner.nextLine();
				adminCet.changePwd(username, oldPwd, newPwd, newPwd2);
				break;
			case "4":
				System.out.println("������Ҫ�޸���Ϣ���û�����");
				String un = scanner.nextLine();
				System.out.println("����������ѡ�");
				System.out.println("1���Ա�  2���ֻ���");
				int studentChoice = Integer.parseInt(scanner.nextLine());
				if (studentChoice == 1) {
					System.out.println("�������Ա�");
					String UserGender = scanner.nextLine();
					adminCet.updateUser(1, un, UserGender);
				} else if (studentChoice == 2) {
					System.out.println("�������µ��ֻ��ţ�");
					String Userphp = scanner.nextLine();
					adminCet.updateUser(2, un, Userphp);
				} else {
					System.out.println("�������");
				}
				break;
			case "5":
				System.out.println("������������");
				String bookName = scanner.nextLine();
				System.out.println("��������ţ�");
				String bookNo = scanner.nextLine();
				System.out.println("��");
				int ku = Integer.parseInt(scanner.nextLine());
				adminCet.addBook(bookName, bookNo, ku);
				break;
			case "6":
				System.out.println("������Ҫɾ��������֣�");
				String BookName = scanner.nextLine();
				System.out.println("������Ҫɾ�����ID��");
				String BookNo = scanner.nextLine();
				adminCet.deleteBook(BookName, BookNo);
				break;
			case "7":
				System.out.println("������ԭ���룺");
				String yuan = scanner.nextLine();
				System.out.println("�������һ�������룺");
				String newPwd1 = scanner.nextLine();
				System.out.println("������ڶ��������룺");
				String newPwdS = scanner.nextLine();
				System.out.println("�������û�����");
				String admin = scanner.nextLine();
				adminCet.changeSuPwd(yuan, newPwd1, newPwdS, admin);
				break;
			}
		}

	}

}
