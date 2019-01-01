package view;

import java.util.Scanner;
import center.*;

public class AdminUI {
	public static void show() {
		AdminCet adminCet = new AdminCet();
		while (true) {
			System.out.println("\t\t1.增加用户\t\t2.删除用户");
			System.out.println("\t\t3.修改用户密码\t\t4.修改用户信息");
			System.out.println("\t\t5.添加图书\t\t6.删除图书");

			System.out.println("\t\t6.修改管理员信息\t\t7.修改管理员密码");
			Scanner scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				System.out.println("请输入用户名：");
				String userName = scanner.nextLine();
				System.out.println("请输入第一个密码：");
				String firstPwd = scanner.nextLine();
				System.out.println("请输入第二个密码:");
				String secondPwd = scanner.nextLine();
				System.out.println("请输入性别:");
				String Gender = scanner.nextLine();
				System.out.println("请输入手机号：");
				String phoneNumber = scanner.nextLine();
				adminCet.addUser(userName, phoneNumber, Gender, firstPwd, secondPwd);
				break;
			case "2":
				System.out.println("请输入您要删除的用户名：");
				String UserName = scanner.nextLine();
				System.out.println("请输入手机号：");
				String UserPhp = scanner.nextLine();
				adminCet.delUser(UserName, UserPhp);
				break;
			case "3":
				System.out.println("请输入要修改密码的用户名：");
				String username = scanner.nextLine();
				System.out.println("请输入原密码：");
				String oldPwd = scanner.nextLine();
				System.out.println("请输入新密码");
				String newPwd = scanner.nextLine();
				System.out.println("请再次输入新密码");
				String newPwd2 = scanner.nextLine();
				adminCet.changePwd(username, oldPwd, newPwd, newPwd2);
				break;
			case "4":
				System.out.println("请输入要修改信息的用户名：");
				String un = scanner.nextLine();
				System.out.println("请输入您的选项：");
				System.out.println("1、性别  2、手机号");
				int studentChoice = Integer.parseInt(scanner.nextLine());
				if (studentChoice == 1) {
					System.out.println("请输入性别：");
					String UserGender = scanner.nextLine();
					adminCet.updateUser(1, un, UserGender);
				} else if (studentChoice == 2) {
					System.out.println("请输入新的手机号：");
					String Userphp = scanner.nextLine();
					adminCet.updateUser(2, un, Userphp);
				} else {
					System.out.println("输入错误！");
				}
				break;
			case "5":
				System.out.println("请输入书名：");
				String bookName = scanner.nextLine();
				System.out.println("请输入书号：");
				String bookNo = scanner.nextLine();
				System.out.println("库");
				int ku = Integer.parseInt(scanner.nextLine());
				adminCet.addBook(bookName, bookNo, ku);
				break;
			case "6":
				System.out.println("请输入要删除书的名字：");
				String BookName = scanner.nextLine();
				System.out.println("请输入要删除书的ID：");
				String BookNo = scanner.nextLine();
				adminCet.deleteBook(BookName, BookNo);
				break;
			case "7":
				System.out.println("请输入原密码：");
				String yuan = scanner.nextLine();
				System.out.println("请输入第一个新密码：");
				String newPwd1 = scanner.nextLine();
				System.out.println("请输入第二个新密码：");
				String newPwdS = scanner.nextLine();
				System.out.println("请输入用户名：");
				String admin = scanner.nextLine();
				adminCet.changeSuPwd(yuan, newPwd1, newPwdS, admin);
				break;
			}
		}

	}

}
