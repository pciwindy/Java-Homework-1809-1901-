package AdminUI;

import java.util.Scanner;
import center.AdminCet;



public class ChangeSUPasswordUI extends AllUI{
	void show(){
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ԭ���룺");
		String oldPwd = scanner.nextLine();
		System.out.println("������������");
		String newPwd = scanner.nextLine();
		System.out.println("���ٴ�����������");
		String newPwd2 = scanner.nextLine();
		
		adminCet.changeSUPassword(oldPwd, newPwd, newPwd2);
	}
}
