package AdminUI;

import java.util.Scanner;
import center.AdminCet;



public class ChangeSUPasswordUI extends AllUI{
	void show(){
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������ԭ���룺");
		String oldPwd = scanner.nextLine();
		System.out.println("������������");
		String newPwd = scanner.nextLine();
		System.out.println("����������������");
		String newPwd2 = scanner.nextLine();
		
		result=adminCet.changeSUPassword(oldPwd, newPwd, newPwd2);
		
		switch(result) {
			case 3010:
				System.out.println("�����ɹ����");
				break;
			case 3001:
				System.out.println("������룺"+result);
				System.out.println("���������벻һ��");
				break;
			case 3002:
				System.out.println("������룺"+result);
				System.out.println("���������");
				break;
			default:
				System.out.println("����δ֪���⣬����ϵ����Ա");
				System.out.println("λ�ڣ�����Ա-�޸Ĺ���Ա����");
				break;
		}
	}
}
