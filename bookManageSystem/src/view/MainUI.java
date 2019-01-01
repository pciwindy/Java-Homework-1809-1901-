package view;
import java.util.Scanner;
import center.*;
public class MainUI {
	public static void show(String userName) {
		while(true) {
			System.out.println("-----------------------------ͼ�����ϵͳ---------------------------------");
			System.out.println("\t\t1.����\t\t2.�黹ͼ��");
			System.out.println("\t\t3.����ͼ��\t\t4.�޸��û�����");
			System.out.println("\t\t0.�˳�ϵͳ\t\t");
			System.out.println("--------------------------------------------------------------------------");
			Scanner scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			UserCet userCet = new UserCet();
			String Username = userName;

			switch (option) {
			case "1":
				System.out.println("��������Ҫ�����ţ�");
				String bookName = scanner.nextLine();

				userCet.borrow(Username, bookName);
				break;
			case "2":
				System.out.println("��������Ҫ������ţ�");
				String BookName = scanner.nextLine();
				userCet.repay(Username, BookName);
				break;
			case "3":
				System.out.println("��������Ҫ���ҵ���ţ�");
				String bookNo = scanner.nextLine();
				userCet.search(bookNo);
				break;
			case "4":
				System.out.println("��������Ҫ�޸ĵ��û�����");
				String User = scanner.nextLine();
				System.out.println("������ԭ���룺");
				String oldPwd = scanner.nextLine();
				System.out.println("�������һ�������룺");
				String newPwd1 = scanner.nextLine();
				System.out.println("������ڶ��������룺");
				String newPwd2 = scanner.nextLine();
				userCet.changePwd(Username, oldPwd, newPwd1, newPwd2);
				break;
			case "0":
				System.out.println("�˳�ϵͳ");
				break;
			}

		}
		
	}
}
