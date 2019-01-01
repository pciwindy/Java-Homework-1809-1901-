package center;
import dataBase.*;
import view.*;
import center.*;
import Library.*;

public class UserCet {
	UserLibrary userlibrary;
	BrLibrary brlibrary;
	BookLibrary booklibrary;
	
	private User user;
	private Admin admin=new Admin();
	public void login(String username,String userPassword){
		if(username.equals("admin")==false){
			userlibrary=UserLibrary.getInstance();
			user=(User)userlibrary.getEtp(username);
			if(user==null){
				System.out.println("It don't exsists!");
			}
			else if(user.getPassword().equals(userPassword)){
				System.out.println("Success!");
				MainUI.show(user.getUsername());
			}
			else{
				System.out.println("Password error!");
				LoginUI.show();
			}
		}
		else{
			if(admin.getPassword().equals(userPassword)){
				AdminUI.show();
			}
			else{
				System.out.println("Password error!");
				LoginUI.show();
			}
		}
	}
	
	public void borrow(String userName,String id){
		brlibrary=BrLibrary.getInstance();
		Borrow borrow =new Borrow();
		borrow.setUsername(userName);
		borrow.setBookId(id);
		brlibrary.insert(borrow);
	}
	
	public void repay(String userName,String bookId){
		brlibrary=BrLibrary.getInstance();
		brlibrary.delete(bookId,userName);
	}
	
	public void search(String wantToSearch){
		booklibrary=BookLibrary.getInstance();
		booklibrary.getEtp(wantToSearch);
		System.out.println("Success!");
	}
	
	public void changePwd(String userName,String oPwd,String nPwdF,String nPwdS){
		userlibrary=UserLibrary.getInstance();
		user=(User)userlibrary.getEtp(userName);
		if(nPwdF.equals(nPwdF)){//??
			userlibrary=UserLibrary.getInstance();
			userlibrary.update(user,3,nPwdS);
			//userlibrary.save();
			System.out.println("Success!");
		}
		else{
			System.out.println("Failed!New password is not equal with origional password!");
		}
	}
	
	
}
