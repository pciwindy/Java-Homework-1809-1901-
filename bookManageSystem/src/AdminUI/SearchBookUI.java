package AdminUI;

import java.util.Scanner;

import center.UserCet;

public class SearchBookUI extends AllUI{
	void show(){
		//�����鼮
		Scanner scanner = new Scanner(System.in);
		UserCet userCet = new UserCet();
		System.out.println("��������Ҫ���ҵ���ţ�");
		String bookNo = scanner.nextLine();
		//�������û�ҵ�����ķ���
		userCet.search(bookNo);
	}
}
