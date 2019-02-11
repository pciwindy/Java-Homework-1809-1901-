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
			//System.out.println("操作成功完成");
			return 1010;
		}else {
			//System.out.println("操作失败");
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
					//System.out.println("操作成功完成");
					return 2010;
				} else {
					//System.out.println("旧密码错误");
					return 2001;
				}
			} else {
				//System.out.println("两次新密码不一样");
				return 2002;
			}
		} else {
			//System.out.println("未找到该用户");
			return 2003;
		}
	}
	
	public void login(String username, String userPassword) throws InterruptedException {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(username);
		if (user == null) {
			System.out.println("该用户不存在！");
			LoginUI.show();
		} else if (user.getPassword().equals(userPassword)) {
			System.out.println("成功登陆——欢迎"+user.getUsername()+"先生");
			UserUI.show(username);
		} else {
			System.out.println("密码错误！");
			LoginUI.show();
		}
	}

	public int repay(String bookId) {
		userlibrary = UserLibrary.getInstance();
		user = (User) userlibrary.getEtp(userName);
		brlibrary = BrLibrary.getInstance();
		boolean f = brlibrary.delete(bookId, user.getUsername());
		if (f == true) {
			//System.out.println("操作成功完成");
			return 3010;
		} else {
			//System.out.println("还书失败");
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
			//System.out.println("这本书的ID是： " + b.getBookId());
			//System.out.println("这本书的名字是： " + b.getBookName());
			//System.out.println("这本书还有 " + b.getNumber()+" 本");
		}
	}

}
