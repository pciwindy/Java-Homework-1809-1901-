package Library;

import dataBase.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Set;

public class AdminLibrary {
	private static AdminLibrary instance=null;
	private HashMap<String, elementType> admins=new HashMap<String, elementType>();
	private FileWriter writer;
	private Admin admin;
	public AdminLibrary() {
		
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
	
	public void save() {//保存操作
		Set<String> adminSet=admins.keySet();
		try {
			writer = new FileWriter("user.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bfw = new BufferedWriter(writer);
		for(String key:adminSet) {
			Admin u =(Admin)admins.get(key);
			String uString = u.getAdminName()+","+u.getPassword()+"\r\n";
			try {
				bfw.write(uString);
				//bfw.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(bfw != null) {
			try {
				bfw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void update(elementType etp, String w) {//修改信息
		admin.setPassword(w);
		save();
	}
	public elementType getEtp(String id) {
		return admin;
	}

}
