package center;

import dataBase.*;
import Library.*;
import ViewUI.*;

public class UserCet {
	UserLibrary userlibrary;
	BrLibrary brlibrary;
	BookLibrary booklibrary;
	private User user;

	//��½
	public void login(String username, String userPassword) throws InterruptedException {
		userlibrary = UserLibrary.getInstance();
		//�õ��û�
		user = (User) userlibrary.getEtp(username);
		//�û��ǿ�
		if (user == null) {
			System.out.println("���û������ڣ�");
			//���ص�½
			LoginUI.show();
		} else if (user.getPassword().equals(userPassword)) {
			System.out.println("�ɹ���½������ӭ"+user.getUsername()+"����");
			//��ʾ������
			MainUI.show(username);
		} else {
			System.out.println("�������");
			//��ʾ��½����
			LoginUI.show();
		}
	}
	
	//����
	public void borrow(String userName, String id) {
		userlibrary = UserLibrary.getInstance();
		//�õ��û�
		user = (User) userlibrary.getEtp(userName);
		brlibrary = BrLibrary.getInstance();
		//�ع�--����UI��boolean��������ڴ˲㴦��
		boolean f = brlibrary.inserts(user.getUsername(), id);
		if(f == true) {
			System.out.println("����ɹ�!");
		}else {
			System.out.println("����ʧ�ܣ�");
		}
	}
	
	//����
	public void repay(String userName, String bookId) {
		userlibrary = UserLibrary.getInstance();
		//�õ��û�
		user = (User) userlibrary.getEtp(userName);
		brlibrary = BrLibrary.getInstance();
		//�ع�--����UI��boolean��������ڴ˲㴦��
		boolean f = brlibrary.delete(bookId, user.getUsername());
		if (f == true) {
			System.out.println("����ɹ�!");
		} else {
			System.out.println("����ʧ�ܣ�");
		}
	}
	
	//����
	public void search(String wantToSearch) {
		booklibrary = BookLibrary.getInstance();
		//�õ���
		Book b = (Book) booklibrary.getEtp(wantToSearch);
		//��ָ��
		if (b == null) {
			System.out.println("�Ȿ�鲻���ڣ�");
		} else {
			System.out.println("�Ȿ���ID�ǣ� " + b.getBookId());
			System.out.println("�Ȿ��������ǣ� " + b.getBookName());
			System.out.println("�Ȿ�黹�� " + b.getNumber()+" ��");
		}
	}
	
	//�޸��û�
	public void changePwd(String userName, String oPwd, String nPwdF, String nPwdS) {
		userlibrary = UserLibrary.getInstance();
		//�õ��û�
		user = (User) userlibrary.getEtp(userName);
		//��ָ��
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
