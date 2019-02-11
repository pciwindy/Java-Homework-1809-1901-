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
	
	public int addBook(String bookName,String bookNo,int ku) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		Book b =new Book();
		b.setBookName(bookName);
		b.setBookId(bookNo);
		b.setNumber(ku);
		boolean f=bookLibrary.insert(b);
		if(f==true){
			//System.out.println("�����ɹ����");
			return 1010;
		}
		else{
			//System.out.println("��Ӹ���ʧ��");
			return 1001;
		}
	}
	
	public int addUser(String userName,String phoneNumber,String Gender,String firstPwd,String secondPwd){//����û�
		if(firstPwd.equals(secondPwd)){
			User u=new User();
			u.setUsername(userName);
			u.setPhoneNumber(phoneNumber);
			u.setGender(Gender);
			u.setPassword(secondPwd);
			UserLibrary userlibrary=UserLibrary.getInstance();
			userlibrary.insert(u);
			//System.out.println("�����ɹ����");
			return 2010;
		}
		else{
			//System.out.println("������������벻ƥ��");
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
				//System.out.println("���������벻һ��");
				return 3001;
			}
		}
		else{
			//System.out.println("���������");
			return 3002;
		}
	}	
	
	public int updateUser(int choice,String un,String wantToChange) {
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(un);
		if(u==null){
			//System.out.println("δ�ҵ����û�");
			return 4001;
		}
		else {
			if(choice==1) {
				System.out.println("ԭ�����Ա�Ϊ�� "+u.getGender());
				userlibrary.update(u, 1, wantToChange);
				System.out.println("�µ��Ա�Ϊ��  "+u.getGender());
				return 4010;
			}
			if(choice==2) {
				System.out.println("ԭ�����ֻ���Ϊ�� "+u.getPhoneNumber());
				userlibrary.update(u, 2, wantToChange);
				System.out.println("�µ��ֻ���Ϊ: "+u.getPhoneNumber());
				return 4010;
			}
		}
		return 4004;
	}
	
	public int changePwd(String username,String oldPwd,String newPwd,String newPwd2){//�޸�����
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(username);
		if(u==null){
			//System.out.println("δ�ҵ����û�");
			return 5001;
		}
		else if(newPwd.equals(newPwd2)){
			if(oldPwd.equals(u.getPassword())){
				userlibrary.update(u, 3, newPwd2);
				//System.out.println("�����ɹ����");
				return 5010;
			}
			else{
				//System.out.println("���������");
				return 5002;
			}
		}
		else{
			//System.out.println("���������벻һ��");
			return 5003;
			
		}
	}
	
	public int deleteBook(String BookName,String BookNo) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		Book b = (Book)bookLibrary.getEtp(BookNo);
		boolean f=bookLibrary.delete(b);
		if(f==true){
			//System.out.println("�����ɹ����");
			return 6010;
		}
		else{
			//System.out.println("ɾ������ʧ��");
			return 6001;
		}
	}
	
	public int delUser(String userName,String userPhp){//ɾ���û�
		Scanner scanner=new Scanner(System.in);
		UserLibrary userlibrary=UserLibrary.getInstance();
		User u =(User)userlibrary.getEtp(userName);
		if(u==null){
			//System.out.println("�û�������");
			return 7001;
		}
		else if(u.getPhoneNumber().equals(userPhp)){
			System.out.println("�����Ҫɾ�����˻���(Y/N)");
			System.out.println( "�û���Ϊ :"+userName+" �û�����Ӧ�ֻ���Ϊ "+userPhp);
			String flags=scanner.nextLine();
			if(flags.equals("Y")||flags.equals("y")){
				userlibrary.delete(u);
				//System.out.println("�����ɹ����");
				return 7010;
			}
			else{
				//System.out.println("������ȡ��");
				return 7002;
			}
		}
		else{
			//System.out.println("�ֻ��Ŵ���");
			return 7003;
		}
	}
	
	/*
	 * searchBook������UserCet�����search����,���ڴ˲���ʾ�˷���
	*/
	
	public static elementType searchUser(String userName){
		UserLibrary userlibrary=UserLibrary.getInstance();
		User user=(User)userlibrary.getEtp(userName);
		if(user!=null){
			return user;
			//System.out.println("�û���Ϊ�� "+user.getUsername());
			//System.out.println("�Ա�Ϊ�� "+user.getGender());
			//System.out.println("�ֻ���Ϊ: "+user.getPhoneNumber());
		}
		else{
			return null;
			//System.out.println("������룺8001");
			//System.out.println("δ�ҵ����û�");
		}
	}
	
}
