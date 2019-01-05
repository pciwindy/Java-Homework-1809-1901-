package center;
import java.util.Scanner;

import AdminUI.AdminUI;
import Library.*;
import ViewUI.LoginUI;
import dataBase.*;

public class AdminCet {
	//����Ա��½ʱ���ã��ϲ�ʹ���߳�����������Ҫ�׳��쳣
	public void login(String userPassword) throws InterruptedException{
		AdminUI adminUI=new AdminUI();
		AdminLibrary adminLibrary = AdminLibrary.getInstance();
		if(adminLibrary.getPassword().equals(userPassword)){
			adminUI.show();
		}
		else{
			System.out.println("�������");
			//ʧ�ܷ����û�����
			LoginUI.show();
		}
	}
	
	//���һ���û�ʱ����
	public void addUser(String userName,String phoneNumber,String Gender,String firstPwd,String secondPwd){
		//�ж��������������Ƿ���ͬ
		if(firstPwd.equals(secondPwd)){
			//�½�һ���û�
			User u=new User();
			u.setUsername(userName);
			u.setPhoneNumber(phoneNumber);
			u.setGender(Gender);
			u.setPassword(secondPwd);
			UserLibrary userlibrary=UserLibrary.getInstance();
			//����װ�õ��û��������
			userlibrary.insert(u);
			//��Ҫ�ع�--boolean�ж���
			System.out.println("����û��ɹ�!");
		}
		else{
			System.out.println("������������벻ƥ�䣡");
		}
	}
	
	//ɾ���û�ʱ����
	public void delUser(String userName,String userPhp){
		Scanner scanner=new Scanner(System.in);
		UserLibrary userlibrary=UserLibrary.getInstance();
		//�õ�����û�
		User u =(User)userlibrary.getEtp(userName);
		//��ָ��
		if(u==null){
			System.out.println("�û������ڣ�");
		}
		else if(u.getPhoneNumber().equals(userPhp)){
			//�ж��Ƿ�ɾ���û�
			System.out.println("�����Ҫɾ�����˻���(Y/N)");
			System.out.println( "�û���Ϊ :"+userName+" �û�����Ӧ�ֻ���Ϊ "+userPhp);
			String flags=scanner.nextLine();
			if(flags.equals("Y")||flags.equals("y")){
				//��Ҫ�ع�--boolean�ж���
				userlibrary.delete(u);
				System.out.println("ɾ���ɹ���");
			}
			else{
				System.out.println("������ȡ����");
			}
		}
		else{
			//�ж���Ϣ����ȡ��ɾ��
			System.out.println("�ֻ��Ŵ���");
		}
	}
	
	//�޸�����ʱ����
	public void changePwd(String username,String oldPwd,String newPwd,String newPwd2){
		UserLibrary userlibrary=UserLibrary.getInstance();
		//�õ�����û�
		User u =(User)userlibrary.getEtp(username);
		//��ָ��
		if(u==null){
			System.out.println("���û������ڣ�");
		}
		//����������ƥ��
		else if(newPwd.equals(newPwd2)){
			if(oldPwd.equals(u.getPassword())){
				//���ø��º���-ͨ�������������������
				//��Ҫ�ع�--boolean�ж���
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
	
	//�����û���Ϣ
	public void updateUser(int choice,String un,String wantToChange) {
		UserLibrary userlibrary=UserLibrary.getInstance();
		//�õ��û�
		User u =(User)userlibrary.getEtp(un);
		//��ָ��
		if(u==null){
			System.out.println("�û������ڣ�");
		}
		else {
			//ͨ������Ĳ������жϸ��µ�λ��
			if(choice==1) {
				System.out.println("ԭ�����Ա�Ϊ�� "+u.getGender());
				//��Ҫ�ع�--boolean�ж���
				userlibrary.update(u, 1, wantToChange);
				System.out.println("�µ��Ա�Ϊ��  "+u.getGender());
			}
			if(choice==2) {
				System.out.println("ԭ�����ֻ���Ϊ�� "+u.getPhoneNumber());
				//��Ҫ�ع�--boolean�ж���
				userlibrary.update(u, 2, wantToChange);
				System.out.println("�µ��ֻ���Ϊ: "+u.getPhoneNumber());
			}
		}
	}
	
	//����鼮ʱ����
	public void addBook(String bookName,String bookNo,int ku) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		//�½�һ����
		Book b =new Book();
		b.setBookName(bookName);
		b.setBookId(bookNo);
		b.setNumber(ku);
		//�ع�-����UI��boolean��������ڴ˲㴦��
		boolean f=bookLibrary.insert(b);
		if(f==true){
			System.out.println("�ɹ���Ӹ��飡");
		}
		else{
			System.out.println("��Ӹ���ʧ�ܣ�");
		}
	}
	
	//ɾ���鼮ʱʹ��
	public void deleteBook(String BookName,String BookNo) {
		BookLibrary bookLibrary = BookLibrary.getInstance();
		//�õ��Ȿ��
		Book b = (Book)bookLibrary.getEtp(BookNo);
		//�ع�-�ж��Ƿ�Ϊ��ָ��
		//�ع�-����UI��boolean��������ڴ˲㴦��
		boolean f=bookLibrary.delete(b);
		if(f==true){
			System.out.println("ɾ������ɹ���");
		}
		else{
			System.out.println("ɾ������ʧ�ܣ�");
		}
	}
	
	//ɾ���û�ʱʹ��
	public static void searchUser(String userName){
		UserLibrary userlibrary=UserLibrary.getInstance();
		//�õ��û�
		User user=(User)userlibrary.getEtp(userName);
		//��ָ��
		if(user!=null){
			System.out.println("�û���Ϊ�� "+user.getUsername());
			System.out.println("�Ա�Ϊ�� "+user.getGender());
			System.out.println("�ֻ���Ϊ: "+user.getPhoneNumber());
		}
		else{
			System.out.println("�û������ڣ�");
		}
	}
	
	//�޸Ĺ���Ա����
	public void changeSUPassword(String oldPwd,String newPwdF,String newPwdS){
		AdminLibrary adminlibrary=AdminLibrary.getInstance();
		//������ƥ��
		if(oldPwd.equals(adminlibrary.getPassword())){
			//����������ƥ��
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
