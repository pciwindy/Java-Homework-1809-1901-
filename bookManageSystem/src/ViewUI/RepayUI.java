package ViewUI;

import java.util.Scanner;
import center.*;

public class RepayUI extends AllUI {
	void show(String userName) {
		int result=0;
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("��������Ҫ������ţ�");
		String BookId = scanner.nextLine();
		result=userCet.repay(BookId);
		
		switch(result) {
			case 3010:
				System.out.println("�����ɹ����");
				break;
			case 3001:
				System.out.println("������룺"+result);
				System.out.println("����ʧ��");
				break;
			default:
				System.out.println("����δ֪���⣬����ϵ����Ա");
				System.out.println("λ�ڣ��û�-����");
				break;
		}
	}
}
