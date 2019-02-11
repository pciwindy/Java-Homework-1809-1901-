package center;

import dataBase.*;
import Library.*;
import ViewUI.*;

public class UserCet {
	UserLibrary userlibrary;
	BrLibrary brlibrary;
	BookLibrary booklibrary;

	private User user;
	private String userName;
	
	public UserCet(String UserName) {
		this.userName=UserName;
	}

	public UserCet() {
		//Only for login;
	}
	
	public int borrow(String id) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		brlibrary = BrLibrary.getInstance();
		boolean f = brlibrary.inserts(user.getUsername(), id);
		if(f == true) {
			//System.out.println("�����ɹ����");
			return 1010;
		}else {
			//System.out.println("����ʧ��");
			return 1001;
		}
	}
	
	public int changePwd(String oPwd, String nPwdF, String nPwdS) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		if (user != null) {
			if (nPwdF.equals(nPwdS)) {
				if (user.getPassword().equals(oPwd)) {
					userlibrary.update(user, 3, nPwdS);
					//System.out.println("�����ɹ����");
					return 2010;
				} else {
					//System.out.println("���������");
					return 2001;
				}
			} else {
				//System.out.println("���������벻һ��");
				return 2002;
			}
		} else {
			//System.out.println("δ�ҵ����û�");
			return 2003;
		}
	}
	
	public void login(String username, String userPassword) throws InterruptedException {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(username);
		if (user == null) {
			System.out.println("���û������ڣ�");
			LoginUI.show();
		} else if (user.getPassword().equals(userPassword)) {
			System.out.println("�ɹ���½������ӭ"+user.getUsername()+"����");
			UserUI.show(username);
		} else {
			System.out.println("�������");
			LoginUI.show();
		}
	}

	public int repay(String bookId) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		brlibrary = BrLibrary.getInstance();
		boolean f = brlibrary.delete(bookId, user.getUsername());
		if (f == true) {
			//System.out.println("�����ɹ����");
			return 3010;
		} else {
			//System.out.println("����ʧ��");
			return 3001;
		}
	}

	public elementType search(String wantToSearch) {
		booklibrary = BookLibrary.getInstance();
		Book b = (Book) booklibrary.getEtp(wantToSearch);
		if (b == null) {
			return null;
		} else {
			return b;
			//System.out.println("�Ȿ���ID�ǣ� " + b.getBookId());
			//System.out.println("�Ȿ��������ǣ� " + b.getBookName());
			//System.out.println("�Ȿ�黹�� " + b.getNumber()+" ��");
		}
	}

}
