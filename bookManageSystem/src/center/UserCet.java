package center;

import dataBase.*;
import Library.*;
import ViewUI.*;

public class UserCet {
	UserLibrary userlibrary;
	BrLibrary brlibrary;
	BookLibrary booklibrary;

	private User user;

	public void login(String username, String userPassword) throws InterruptedException {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(username);
		if (user == null) {
			System.out.println("���û������ڣ�");
			LoginUI.show();
		} else if (user.getPassword().equals(userPassword)) {
			System.out.println("�ɹ���½������ӭ"+user.getUsername()+"����");
			MainUI.show(username);
		} else {
			System.out.println("�������");
			LoginUI.show();
		}
	}
	public void borrow(String userName, String id) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		brlibrary = BrLibrary.getInstance();
		boolean f = brlibrary.inserts(user.getUsername(), id);
		if(f == true) {
			System.out.println("����ɹ�!");
		}else {
			System.out.println("����ʧ�ܣ�");
		}
	}

	public void repay(String userName, String bookId) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		brlibrary = BrLibrary.getInstance();
		boolean f = brlibrary.delete(bookId, user.getUsername());
		if (f == true) {
			System.out.println("����ɹ�!");
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}

	public void search(String wantToSearch) {
		booklibrary = BookLibrary.getInstance();
		Book b = (Book) booklibrary.getEtp(wantToSearch);
		if (b == null) {
			System.out.println("�Ȿ�鲻���ڣ�");
		} else {
			System.out.println("�Ȿ���ID�ǣ� " + b.getBookId());
			System.out.println("�Ȿ��������ǣ� " + b.getBookName());
			System.out.println("�Ȿ�黹�� " + b.getNumber()+" ��");
		}
	}

	public void changePwd(String userName, String oPwd, String nPwdF, String nPwdS) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		if (user != null) {
			if (nPwdF.equals(nPwdS)) {
				if (user.getPassword().equals(oPwd)) {
					userlibrary.update(user, 3, nPwdS);
					System.out.println("�ɹ��޸����룡");
				} else {
					System.out.println("���������");
				}
			} else {
				System.out.println("������������벻ƥ�䣡");
			}
		} else {
			System.out.println("���û������ڣ�");
		}
	}
}
