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
	System.out.println("�������û���");
	scanner = new Scanner(System.in);
	userName=scanner.nextLine();
	System.out.println("����������");
	userPassword = scanner.nextLine();
	if(userName.equals("admin")==true){
		adminCet =new AdminCet();
		adminCet.login(userPassword);
	}
	else{
		userCet = new UserCet();
		userCet.login(userName, userPassword);// ����Biz���ʻ���������
	}
	}
}
