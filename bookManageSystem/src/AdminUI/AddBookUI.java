package AdminUI;

import java.util.Scanner;

import center.AdminCet;

public class AddBookUI extends AllUI{
	void show() {
		int result=0;
		AdminCet adminCet = new AdminCet();
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("������������");
		String bookName = scanner.nextLine();
		System.out.println("��������ţ�");
		String bookNo = scanner.nextLine();
		System.out.println("�������棺 ");
		int ku = Integer.parseInt(scanner.nextLine());
		result=adminCet.addBook(bookName, bookNo, ku);
		if(result==1010) {
			System.out.println("�����ɹ����");
		}
		else {
			result=1001;
			System.out.println("������룺"+result);
			System.out.println("��Ӹ���ʧ��");
		}
	}
}
