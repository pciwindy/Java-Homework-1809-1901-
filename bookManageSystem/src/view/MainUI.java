package view;
import java.util.Scanner;
import center.*;
public class MainUI {
	public static void show(String userName) {
		while(true) {
			System.out.println("-----------------------------图书管理系统---------------------------------");
			System.out.println("\t\t1.借书\t\t2.归还图书");
			System.out.println("\t\t3.查找图书\t\t4.修改用户密码");
			System.out.println("\t\t0.退出系统\t\t");
			System.out.println("--------------------------------------------------------------------------");
			Scanner scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			UserCet userCet = new UserCet();
			String Username = userName;

			switch (option) {
			case "1":
				System.out.println("请输入需要借的书号：");
				String bookName = scanner.nextLine();

				userCet.borrow(Username, bookName);
				break;
			case "2":
				System.out.println("请输入需要还的书号：");
				String BookName = scanner.nextLine();
				userCet.repay(Username, BookName);
				break;
			case "3":
				System.out.println("请输入需要查找的书号：");
				String bookNo = scanner.nextLine();
				userCet.search(bookNo);
				break;
			case "4":
				System.out.println("请输入需要修改的用户名：");
				String User = scanner.nextLine();
				System.out.println("请输入原密码：");
				String oldPwd = scanner.nextLine();
				System.out.println("请输入第一个新密码：");
				String newPwd1 = scanner.nextLine();
				System.out.println("请输入第二个新密码：");
				String newPwd2 = scanner.nextLine();
				userCet.changePwd(Username, oldPwd, newPwd1, newPwd2);
				break;
			case "0":
				System.out.println("退出系统");
				break;
			}

		}
		
	}
}
