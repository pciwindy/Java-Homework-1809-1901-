package ViewUI;
import center.*;
import java.util.Scanner;

public class LoginUI {
	public static void show() throws InterruptedException {
	Scanner scanner;
	String userName;
	String userPassword;
	UserCet userCet;
	AdminCet adminCet;
	System.out.println("请输入用户名");
	scanner = new Scanner(System.in);
	userName=scanner.nextLine();
	System.out.println("请输入密码");
	userPassword = scanner.nextLine();
	if(userName.equals("admin")==true){
		adminCet =new AdminCet();
		adminCet.login(userPassword);
	}
	else{
		userCet = new UserCet();
		userCet.login(userName, userPassword);// 传到Biz中帐户名和密码
	}
	}
}
