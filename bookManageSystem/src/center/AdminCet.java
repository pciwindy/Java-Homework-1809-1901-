package center;
import java.util.Scanner;

import AdminUI.AdminUI;
import Library.*;
import ViewUI.LoginUI;
import dataBase.*;

public class AdminCet {
	public void login(String userPassword) throws InterruptedException{
		AdminUI adminUI=new AdminUI();
		AdminLibrary adminLibrary = AdminLibrary.getInstance();
		if(adminLibrary.getPassword().equals(userPassword)){
			adminUI.show();
		}
		else{
			System.out.println("密码错误！");
			LoginUI.show();
		}
	}
	
	public int addBook(String bookName,String bookNo,int ku) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		Book b =new Book();
		b.setBookName(bookName);
		b.setBookId(bookNo);
		b.setNumber(ku);
		boolean f=bookLibrary.insert(b);
		if(f==true){
			//System.out.println("操作成功完成");
			return 1010;
		}
		else{
			//System.out.println("添加该书失败");
			return 1001;
		}
	}
	
	public int addUser(String userName,String phoneNumber,String Gender,String firstPwd,String secondPwd){//添加用户
		if(firstPwd.equals(secondPwd)){
			User u=new User();
			u.setUsername(userName);
			u.setPhoneNumber(phoneNumber);
			u.setGender(Gender);
			u.setPassword(secondPwd);
			UserLibrary userlibrary=UserLibrary.getInstance();
			userlibrary.insert(u);
			//System.out.println("操作成功完成");
			return 2010;
		}
		else{
			//System.out.println("输入的两次密码不匹配");
			return 2001;
		}
	}
	
	public int changeSUPassword(String oldPwd,String newPwdF,String newPwdS){
		AdminLibrary adminlibrary=AdminLibrary.getInstance();
		if(oldPwd.equals(adminlibrary.getPassword())){
			if(newPwdF.equals(newPwdS)){
				adminlibrary.update(newPwdF);
				return 3010;
			}
			else{
				//System.out.println("两次新密码不一样");
				return 3001;
			}
		}
		else{
			//System.out.println("旧密码错误");
			return 3002;
		}
	}	
	
	public int updateUser(int choice,String un,String wantToChange) {
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(un);
		if(u==null){
			//System.out.println("未找到该用户");
			return 4001;
		}
		else {
			if(choice==1) {
				System.out.println("原来的性别为： "+u.getGender());
				userlibrary.update(u, 1, wantToChange);
				System.out.println("新的性别为：  "+u.getGender());
				return 4010;
			}
			if(choice==2) {
				System.out.println("原来的手机号为： "+u.getPhoneNumber());
				userlibrary.update(u, 2, wantToChange);
				System.out.println("新的手机号为: "+u.getPhoneNumber());
				return 4010;
			}
		}
		return 4004;
	}
	
	public int changePwd(String username,String oldPwd,String newPwd,String newPwd2){//修改密码
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(username);
		if(u==null){
			//System.out.println("未找到该用户");
			return 5001;
		}
		else if(newPwd.equals(newPwd2)){
			if(oldPwd.equals(u.getPassword())){
				userlibrary.update(u, 3, newPwd2);
				//System.out.println("操作成功完成");
				return 5010;
			}
			else{
				//System.out.println("旧密码错误");
				return 5002;
			}
		}
		else{
			//System.out.println("两次新密码不一样");
			return 5003;
			
		}
	}
	
	public int deleteBook(String BookName,String BookNo) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		Book b = (Book)bookLibrary.getEtp(BookNo);
		boolean f=bookLibrary.delete(b);
		if(f==true){
			//System.out.println("操作成功完成");
			return 6010;
		}
		else{
			//System.out.println("删除此书失败");
			return 6001;
		}
	}
	
	public int delUser(String userName,String userPhp){//删除用户
		Scanner scanner=new Scanner(System.in);
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(userName);
		if(u==null){
			//System.out.println("用户不存在");
			return 7001;
		}
		else if(u.getPhoneNumber().equals(userPhp)){
			System.out.println("您真的要删除该账户吗？(Y/N)");
			System.out.println( "用户名为 :"+userName+" 用户名对应手机号为 "+userPhp);
			String flags=scanner.nextLine();
			if(flags.equals("Y")||flags.equals("y")){
				userlibrary.delete(u);
				//System.out.println("操作成功完成");
				return 7010;
			}
			else{
				//System.out.println("操作被取消");
				return 7002;
			}
		}
		else{
			//System.out.println("手机号错误");
			return 7003;
		}
	}
	
	/*
	 * searchBook调用了UserCet里面的search方法,故在此不显示此方法
	*/
	
	public static elementType searchUser(String userName){
		UserLibrary userlibrary=UserLibrary.getInstance();
		User user=(User)userlibrary.getEtp(userName);
		if(user!=null){
			return user;
			//System.out.println("用户名为： "+user.getUsername());
			//System.out.println("性别为： "+user.getGender());
			//System.out.println("手机号为: "+user.getPhoneNumber());
		}
		else{
			return null;
			//System.out.println("错误代码：8001");
			//System.out.println("未找到该用户");
		}
	}
	
}
