package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class DeleteBookUI extends AllUI{
	void show() {
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������Ҫɾ��������֣�");
		String BookName = scanner.nextLine();
		System.out.println("������Ҫɾ�����ID��");
		String BookNo = scanner.nextLine();
		result=adminCet.deleteBook(BookName, BookNo);
		
		if(result==6010) {
			System.out.println("�����ɹ����");
		}
		else {
			System.out.println("������룺"+result);
			System.out.println("ɾ������ʧ��");
		}
	}
}
