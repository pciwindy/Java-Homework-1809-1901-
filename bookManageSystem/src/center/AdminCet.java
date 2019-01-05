package center;
import java.util.Scanner;

import AdminUI.AdminUI;
import Library.*;
import ViewUI.LoginUI;
import dataBase.*;

public class AdminCet {
	//管理员登陆时调用，上层使用线程休眠所以需要抛出异常
	public void login(String userPassword) throws InterruptedException{
		AdminUI adminUI=new AdminUI();
		AdminLibrary adminLibrary = AdminLibrary.getInstance();
		if(adminLibrary.getPassword().equals(userPassword)){
			adminUI.show();
		}
		else{
			System.out.println("密码错误！");
			//失败返回用户界面
			LoginUI.show();
		}
	}
	
	//添加一名用户时调用
	public void addUser(String userName,String phoneNumber,String Gender,String firstPwd,String secondPwd){
		//判断两次密码输入是否相同
		if(firstPwd.equals(secondPwd)){
			//新建一个用户
			User u=new User();
			u.setUsername(userName);
			u.setPhoneNumber(phoneNumber);
			u.setGender(Gender);
			u.setPassword(secondPwd);
			UserLibrary userlibrary=UserLibrary.getInstance();
			//将封装好的用户加入库中
			userlibrary.insert(u);
			//需要重构--boolean判定！
			System.out.println("添加用户成功!");
		}
		else{
			System.out.println("输入的两次密码不匹配！");
		}
	}
	
	//删除用户时调用
	public void delUser(String userName,String userPhp){
		Scanner scanner=new Scanner(System.in);
		UserLibrary userlibrary=UserLibrary.getInstance();
		//拿到这个用户
		User u =(User)userlibrary.getEtp(userName);
		//空指针
		if(u==null){
			System.out.println("用户不存在！");
		}
		else if(u.getPhoneNumber().equals(userPhp)){
			//判断是否删除用户
			System.out.println("您真的要删除该账户吗？(Y/N)");
			System.out.println( "用户名为 :"+userName+" 用户名对应手机号为 "+userPhp);
			String flags=scanner.nextLine();
			if(flags.equals("Y")||flags.equals("y")){
				//需要重构--boolean判定！
				userlibrary.delete(u);
				System.out.println("删除成功！");
			}
			else{
				System.out.println("操作被取消！");
			}
		}
		else{
			//判断信息错误，取消删除
			System.out.println("手机号错误！");
		}
	}
	
	//修改密码时调用
	public void changePwd(String username,String oldPwd,String newPwd,String newPwd2){
		UserLibrary userlibrary=UserLibrary.getInstance();
		//拿到这个用户
		User u =(User)userlibrary.getEtp(username);
		//空指针
		if(u==null){
			System.out.println("该用户不存在！");
		}
		//两次新密码匹配
		else if(newPwd.equals(newPwd2)){
			if(oldPwd.equals(u.getPassword())){
				//调用更新函数-通过参数来进行密码更新
				//需要重构--boolean判定！
				userlibrary.update(u, 3, newPwd2);
				System.out.println("修改密码成功！");
			}
			else{
				System.out.println("旧密码错误！");
			}
		}
		else{
			System.out.println("输入的两次新密码不匹配！");
		}
	}
	
	//更新用户信息
	public void updateUser(int choice,String un,String wantToChange) {
		UserLibrary userlibrary=UserLibrary.getInstance();
		//拿到用户
		User u =(User)userlibrary.getEtp(un);
		//空指针
		if(u==null){
			System.out.println("用户不存在！");
		}
		else {
			//通过传入的参数来判断更新的位置
			if(choice==1) {
				System.out.println("原来的性别为： "+u.getGender());
				//需要重构--boolean判定！
				userlibrary.update(u, 1, wantToChange);
				System.out.println("新的性别为：  "+u.getGender());
			}
			if(choice==2) {
				System.out.println("原来的手机号为： "+u.getPhoneNumber());
				//需要重构--boolean判定！
				userlibrary.update(u, 2, wantToChange);
				System.out.println("新的手机号为: "+u.getPhoneNumber());
			}
		}
	}
	
	//添加书籍时调用
	public void addBook(String bookName,String bookNo,int ku) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		//新建一本书
		Book b =new Book();
		b.setBookName(bookName);
		b.setBookId(bookNo);
		b.setNumber(ku);
		//重构-返回UI层boolean结果，不在此层处理
		boolean f=bookLibrary.insert(b);
		if(f==true){
			System.out.println("成功添加该书！");
		}
		else{
			System.out.println("添加该书失败！");
		}
	}
	
	//删除书籍时使用
	public void deleteBook(String BookName,String BookNo) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		//拿到这本书
		Book b = (Book)bookLibrary.getEtp(BookNo);
		//重构-判断是否为空指针
		//重构-返回UI层boolean结果，不在此层处理
		boolean f=bookLibrary.delete(b);
		if(f==true){
			System.out.println("删除此书成功！");
		}
		else{
			System.out.println("删除此书失败！");
		}
	}
	
	//删除用户时使用
	public static void searchUser(String userName){
		UserLibrary userlibrary=UserLibrary.getInstance();
		//拿到用户
		User user=(User)userlibrary.getEtp(userName);
		//空指针
		if(user!=null){
			System.out.println("用户名为： "+user.getUsername());
			System.out.println("性别为： "+user.getGender());
			System.out.println("手机号为: "+user.getPhoneNumber());
		}
		else{
			System.out.println("用户不存在！");
		}
	}
	
	//修改管理员密码
	public void changeSUPassword(String oldPwd,String newPwdF,String newPwdS){
		AdminLibrary adminlibrary=AdminLibrary.getInstance();
		//旧密码匹配
		if(oldPwd.equals(adminlibrary.getPassword())){
			//两次新密码匹配
			if(newPwdF.equals(newPwdS)){
				adminlibrary.update(newPwdF);
			}
			else{
				System.out.println("两次新密码匹配错误！");
			}
		}
		else{
			System.out.println("旧密码错误！");
		}
	}
}
