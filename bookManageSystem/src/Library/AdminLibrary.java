package Library;

import dataBase.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class AdminLibrary {
	private static AdminLibrary instance=null;
	private StringBuffer admins=new StringBuffer();
	private FileWriter writer;
	private FileReader reader;
	private Admin admin=new Admin();
	private AdminLibrary() {
		admins.append(admin.getAdminName()+",");
		admins.append(admin.getPassword());
		getAdminFromReader("admin.txt");
	}
	public static AdminLibrary getInstance() {
		if(instance == null) {
			synchronized(AdminLibrary.class) {
				if(instance == null) {
					instance = new  AdminLibrary();
					return instance;
				}
			}
		}
		return instance;
	}
	
	private void getAdminFromReader(String fileName) {//read
		try {
			reader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		String adminString;
		try {
			while((adminString=br.readLine()) != null){
				processAdminString(adminString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void processAdminString(String adminString) {
		String[] files = adminString.split(",");
		admin.setAdminName(files[0]);
		admin.setPassword(files[1]);
	}
	
	public void save() {//保存操作
		try {
			writer = new FileWriter("admin.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bfw = new BufferedWriter(writer);
		
			String adString = admins.toString()+"\r\n";
			byte[] bytes = null;
			try {
				bytes = adString.getBytes("GBK");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			try {
				bfw.write(new String(bytes));
			} catch (IOException e) {
				e.printStackTrace();
			}
		if(bfw != null) {
			try {
				bfw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(String w) {//修改密码
		admin.setPassword(w);
		admins.setLength(0);
		admins.append("admin,");
		admins.append(w);
		save();
		System.out.println("成功修改管理员密码！");
	}
	public elementType getEtp(String id) {
		return admin;
	}
	public String getPassword() {
		return admin.getPassword();
	}

}
