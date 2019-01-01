package center;
import java.util.Scanner;

import Library.*;
import dataBase.*;
import view.*;

public class AdminCet {
	public void addUser(String userName,String phoneNumber,String Gender,String firstPwd,String secondPwd){//添加用户
		if(firstPwd.equals(secondPwd)){
			User u=new User();
			u.setUsername(userName);
			u.setPhoneNumber(phoneNumber);
			u.setGender(Gender);
			u.setPassword(secondPwd);
			UserLibrary userlibrary=UserLibrary.getInstance();
			userlibrary.insert(u);
		}
		else{
			System.out.println("Confirm second password failed!");
		}
	}
	
	public void delUser(String userName,String userPhp){//删除用户
		Scanner scanner=new Scanner(System.in);
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(userName);
		if(u==null){
			System.out.println("User doesn't exsists!");
		}
		else if(u.getPhoneNumber().equals(userPhp)){
			System.out.println("Do you want to delete this account?(Y/N) Username :"+userName+" Userphonenumber "+userPhp);
			String flags=scanner.nextLine();
			if(flags.equals("Y")||flags.equals("y")){
				userlibrary.delete(u);
				System.out.println("Success!");
			}
			else{
				System.out.println("Operate canceled!");
			}
		}
		else{
			System.out.println("Password wrong");
		}
	}
	
	public void changePwd(String username,String oldPwd,String newPwd,String newPwd2){//修改密码
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(username);
		if(u==null){
			System.out.println("user doesn't exsists!");
		}
		else if(newPwd.equals(newPwd2)){
			if(oldPwd.equals(u.getPassword())){
				userlibrary.update(u, 3, newPwd2);
			}
			else{
				System.out.println("Old password wrong!");
			}
		}
		else{
			System.out.println("New password compare to second-time is wrong!");
		}
	}
	
	public void updateUser(int choice,String un,String wantToChange) {
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(un);
		if(u==null){
			System.out.println("user doesn't exsists!");
		}
		else {
			if(choice==1) {
				System.out.println("Original Gender is "+u.getGender());
				userlibrary.update(u, 1, wantToChange);
				System.out.println("The new Gender is "+u.getGender());
			}
			if(choice==2) {
				System.out.println("Original PhoneNumber is "+u.getPhoneNumber());
				userlibrary.update(u, 2, wantToChange);
				System.out.println("The new PhoneNumber is "+u.getPhoneNumber());
			}
		}
	}
	
	public void addBook(String bookName,String bookNo,int ku) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		Book b =new Book();
		b.setBookName(bookName);
		b.setBookId(bookNo);
		b.setNumber(ku);
		bookLibrary.insert(b);
	}
	
	public void deleteBook(String BookName,String BookNo) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		Book b = (Book)bookLibrary.getEtp(BookNo);
		bookLibrary.delete(b);
	}
	
	public void changeSuPwd(String oldPwd,String newPwd,String newPwd2,String adminName){//修改密码
		AdminLibrary adminLibrary=AdminLibrary.getInstance();
		Admin a = (Admin)adminLibrary.getEtp(adminName);
		if(newPwd.equals(newPwd2)){
			if(oldPwd.equals(a.getPassword())) {
				adminLibrary.update(a,newPwd);
			}
			else {
				System.out.println("Old password wrong!");
			}
		}
		else{
			System.out.println("New password compare to second-time is wrong!");
		}
	}
}
