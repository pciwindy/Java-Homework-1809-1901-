package view;
import center.*;
import java.util.Scanner;

public class LoginUI {
	public static void show() {
	Scanner scanner;
	String userName;
	String userPassword;
	UserCet userCet;
	System.out.println("�������û���");
	scanner = new Scanner(System.in);
	userName=scanner.nextLine();
	System.out.println("����������");
	userPassword = scanner.nextLine();
	userCet=new UserCet();
	userCet.login(userName,userPassword);//����Biz���ʻ���������
}
}
