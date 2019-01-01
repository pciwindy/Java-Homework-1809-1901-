package view;
import center.*;
import java.util.Scanner;

public class LoginUI {
	public static void show() {
	Scanner scanner;
	String userName;
	String userPassword;
	UserCet userCet;
	System.out.println("请输入用户名");
	scanner = new Scanner(System.in);
	userName=scanner.nextLine();
	System.out.println("请输入密码");
	userPassword = scanner.nextLine();
	userCet=new UserCet();
	userCet.login(userName,userPassword);//传到Biz中帐户名和密码
}
}
