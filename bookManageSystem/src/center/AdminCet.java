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
			System.out.println("�������");
			LoginUI.show();
		}
	}
	
	public void addUser(String userName,String phoneNumber,String Gender,String firstPwd,String secondPwd){//����û�
		if(firstPwd.equals(secondPwd)){
			User u=new User();
			u.setUsername(userName);
			u.setPhoneNumber(phoneNumber);
			u.setGender(Gender);
			u.setPassword(secondPwd);
			UserLibrary userlibrary=UserLibrary.getInstance();
			userlibrary.insert(u);
			System.out.println("����û��ɹ�!");
		}
		else{
			System.out.println("������������벻ƥ�䣡");
		}
	}
	
	public void delUser(String userName,String userPhp){//ɾ���û�
		Scanner scanner=new Scanner(System.in);
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(userName);
		if(u==null){
			System.out.println("�û������ڣ�");
		}
		else if(u.getPhoneNumber().equals(userPhp)){
			System.out.println("�����Ҫɾ�����˻���(Y/N)");
			System.out.println( "�û���Ϊ :"+userName+" �û�����Ӧ�ֻ���Ϊ "+userPhp);
			String flags=scanner.nextLine();
			if(flags.equals("Y")||flags.equals("y")){
				userlibrary.delete(u);
				System.out.println("ɾ���ɹ���");
			}
			else{
				System.out.println("������ȡ����");
			}
		}
		else{
			System.out.println("�ֻ��Ŵ���");
		}
	}
	
	public void changePwd(String username,String oldPwd,String newPwd,String newPwd2){//�޸�����
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(username);
		if(u==null){
			System.out.println("���û������ڣ�");
		}
		else if(newPwd.equals(newPwd2)){
			if(oldPwd.equals(u.getPassword())){
				userlibrary.update(u, 3, newPwd2);
				System.out.println("�޸�����ɹ���");
			}
			else{
				System.out.println("���������");
			}
		}
		else{
			System.out.println("��������������벻ƥ�䣡");
		}
	}
	
	public void updateUser(int choice,String un,String wantToChange) {
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(un);
		if(u==null){
			System.out.println("�û������ڣ�");
		}
		else {
			if(choice==1) {
				System.out.println("ԭ�����Ա�Ϊ�� "+u.getGender());
				userlibrary.update(u, 1, wantToChange);
				System.out.println("�µ��Ա�Ϊ��  "+u.getGender());
			}
			if(choice==2) {
				System.out.println("ԭ�����ֻ���Ϊ�� "+u.getPhoneNumber());
				userlibrary.update(u, 2, wantToChange);
				System.out.println("�µ��ֻ���Ϊ: "+u.getPhoneNumber());
			}
		}
	}
	
	public void addBook(String bookName,String bookNo,int ku) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		Book b =new Book();
		b.setBookName(bookName);
		b.setBookId(bookNo);
		b.setNumber(ku);
		boolean f=bookLibrary.insert(b);
		if(f==true){
			System.out.println("�ɹ���Ӹ��飡");
		}
		else{
			System.out.println("��Ӹ���ʧ�ܣ�");
		}
	}
	
	public void deleteBook(String BookName,String BookNo) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		Book b = (Book)bookLibrary.getEtp(BookNo);
		boolean f=bookLibrary.delete(b);
		if(f==true){
			System.out.println("ɾ������ɹ���");
		}
		else{
			System.out.println("ɾ������ʧ�ܣ�");
		}
	}
	
	public static void searchUser(String userName){
		UserLibrary userlibrary=UserLibrary.getInstance();
		User user=(User)userlibrary.getEtp(userName);
		if(user!=null){
			System.out.println("�û���Ϊ�� "+user.getUsername());
			System.out.println("�Ա�Ϊ�� "+user.getGender());
			System.out.println("�ֻ���Ϊ: "+user.getPhoneNumber());
		}
		else{
			System.out.println("�û������ڣ�");
		}
	}
	
	public void changeSUPassword(String oldPwd,String newPwdF,String newPwdS){
		AdminLibrary adminlibrary=AdminLibrary.getInstance();
		if(oldPwd.equals(adminlibrary.getPassword())){
			if(newPwdF.equals(newPwdS)){
				adminlibrary.update(newPwdF);
			}
			else{
				System.out.println("����������ƥ�����");
			}
		}
		else{
			System.out.println("���������");
		}
	}
}
