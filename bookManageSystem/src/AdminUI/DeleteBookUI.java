package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class DeleteBookUI extends AllUI{
	void show() {
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������Ҫɾ��������֣�");
		String BookName = scanner.nextLine();
		System.out.println("������Ҫɾ�����ID��");
		String BookNo = scanner.nextLine();
		adminCet.deleteBook(BookName, BookNo);
		System.out.println("ɾ���ɹ�!");
	}
}
