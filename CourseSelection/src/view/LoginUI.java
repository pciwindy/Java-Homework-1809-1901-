package view;

import java.util.Scanner;

import biz.StudentBiz;

public class LoginUI {	

	public static void show() {
		Scanner scanner;
		String studentName;
		String studentPassword;
		StudentBiz studentBiz;
		System.out.println("«Î ‰»Î—ß∫≈£∫");
		scanner = new Scanner(System.in);
		studentName = scanner.nextLine();
		System.out.println("«Î ‰»Î√‹¬Î£∫");
		studentPassword = scanner.nextLine();
		studentBiz = new StudentBiz();
		studentBiz.login(studentName, studentPassword);
	}
}
