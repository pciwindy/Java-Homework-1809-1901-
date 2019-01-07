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
			System.out.println("该用户不存在！");
			LoginUI.show();
		} else if (user.getPassword().equals(userPassword)) {
			System.out.println("成功登陆——欢迎"+user.getUsername()+"先生");
			MainUI.show(username);
		} else {
			System.out.println("密码错误！");
			LoginUI.show();
		}
	}
	public void borrow(String userName, String id) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		brlibrary = BrLibrary.getInstance();
		boolean f = brlibrary.inserts(user.getUsername(), id);
		if(f == true) {
			System.out.println("借书成功!");
		}else {
			System.out.println("借书失败！");
		}
	}

	public void repay(String userName, String bookId) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		brlibrary = BrLibrary.getInstance();
		boolean f = brlibrary.delete(bookId, user.getUsername());
		if (f == true) {
			System.out.println("还书成功!");
		} else {
			System.out.println("还书失败！");
		}
	}

	public void search(String wantToSearch) {
		booklibrary = BookLibrary.getInstance();
		Book b = (Book) booklibrary.getEtp(wantToSearch);
		if (b == null) {
			System.out.println("这本书不存在！");
		} else {
			System.out.println("这本书的ID是： " + b.getBookId());
			System.out.println("这本书的名字是： " + b.getBookName());
			System.out.println("这本书还有 " + b.getNumber()+" 本");
		}
	}

	public void changePwd(String userName, String oPwd, String nPwdF, String nPwdS) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		if (user != null) {
			if (nPwdF.equals(nPwdS)) {
				if (user.getPassword().equals(oPwd)) {
					userlibrary.update(user, 3, nPwdS);
					System.out.println("成功修改密码！");
				} else {
					System.out.println("旧密码错误！");
				}
			} else {
				System.out.println("输入的两次密码不匹配！");
			}
		} else {
			System.out.println("该用户不存在！");
		}
	}
}
