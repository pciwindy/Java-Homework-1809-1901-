package ViewUI;

import java.util.*;
import center.*;

public class BorrowUI extends AllUI{
	void show(String userName) {
		int result=0;
		Scanner scanner = new Scanner(System.in);
		UserCet userCet=new UserCet(userName);
		
		System.out.println("��������Ҫ�����ţ�");
		String bookId = scanner.nextLine();
		result=userCet.borrow(bookId);
		
		if(result==1010) {
			System.out.println("�����ɹ����");
		}
		else {
			System.out.println("������룺"+result);
			System.out.println("����ʧ��");
		}
	}
}
