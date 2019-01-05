package Library;

import dataBase.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Set;


public class UserLibrary implements ILibrary{
	private static UserLibrary instance=null;
	private HashMap<String, elementType> users=new HashMap<String, elementType>();
	private FileWriter writer;
	private FileReader reader;
	public static UserLibrary getInstance() {
		if(instance == null) {
			synchronized(UserLibrary.class) {
				if(instance == null) {
					instance = new UserLibrary();
					return instance;
				}
			}
		}
		return instance;
	}
	
	private UserLibrary() {
		getUsersFromReader("user.txt"); 
	}
	
	private void getUsersFromReader(String fileName) {//需要有个来调用这个方法
		try {
			reader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(reader);
		String userString;
		try {
			while((userString=br.readLine()) != null){
				processUserString(userString);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void processUserString(String userString) {
		if(userString!=null) {
			String[] userFileds = userString.split(",");
			User u = new User();
			u.setUsername(userFileds[0]);
			u.setPassword(userFileds[1]);
			u.setGender(userFileds[2]);
			u.setPhoneNumber(userFileds[3]);
			users.put(u.getUsername(), u);
		}
		else {
			
		}
		
	}
	
	public void save() {//保存操作
		Set<String> userSet=users.keySet();
		try {
			writer = new FileWriter("user.txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bfw = new BufferedWriter(writer);
		for(String key:userSet) {
			User u =(User)users.get(key);
			String uString = u.getUsername()+","+u.getPassword()+","+u.getGender()+","+u.getPhoneNumber()+"\r\n";
			byte[] bytes = null;
			try {
				bytes = uString.getBytes("GBK");
			} catch (UnsupportedEncodingException e1) {
				e1.printStackTrace();
			}
			try {
				bfw.write(new String(bytes));
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
	
	public boolean insert(elementType etp) {//添加用户
		User us = (User)etp;
		users.put(us.getUsername(), us);
		save();
		return true;
	}
	
	public boolean delete(elementType etp) {//删除用户
		User us = (User)etp;
		String u = us.getUsername();
		BrLibrary brLibrary = BrLibrary.getInstance();
		Borrow borrow = (Borrow)brLibrary.getBrer(us.getUsername());
		if(borrow!=null) {
			String id = borrow.getBookId();
			String[] idArray = id.split(",");
			if (brLibrary.getBrer(u) != null && idArray.length == 1) {
				brLibrary.delete(id, u);
				users.remove(u);
				save();
				return true;
			} else if (brLibrary.getBrer(u) != null && idArray.length > 1) {
				for (int i = 0; i < idArray.length; i++) {
					brLibrary.delete(idArray[i], u);
					save();
				}
				users.remove(u);
				save();
				return true;
			} else {
				users.remove(u);
				save();
				return true;
			}
		}
		else {
			users.remove(u);
			save();
			return true;
		}
	}
	
	public void update(elementType etp, int i, String w) {//修改用户信息
		User us = (User)etp;
		switch(i) {
		case 1:
			us.setGender(w);
			save();
			break;
		case 2:
			us.setPhoneNumber(w);
			save();
			break;
		case 3:
			us.setPassword(w);
			save();
			break;
		}
		save();
	}
	
	public HashMap<String, elementType> getAlletps() {//返回所有信息
		return users;
	}
	
	public elementType getEtp(String id) {//返回一个用户的信息
		elementType etp = users.get(id);
		return etp;
	}
	
	public boolean update(elementType etp) {
		return false;
	}

}
