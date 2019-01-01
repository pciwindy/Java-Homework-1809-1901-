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


public class UserLibrary implements ILibrary{
	private static UserLibrary instance=null;
	private HashMap<String, elementType> users=new HashMap<String, elementType>();
	private FileWriter writer;
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
		User u1=new User();
		u1.setGender("男");
		u1.setPassword("123456");
		u1.setPhoneNumber("10010");
		u1.setUsername("1001");
		users.put(u1.getUsername(), u1);
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
	
	public void insert(elementType etp) {//添加用户
		User us = (User)etp;
		users.put(us.getUsername(), us);
		save();
	}
	
	public void delete(elementType etp) {//删除用户
		User us = (User)etp;
		users.remove(us.getUsername());
		save();
	}
	
	public void update(elementType etp, int i, String w) {//修改用户信息
		User us = (User)etp;
		switch(i) {
		case 1:
			us.setGender(w);
			break;
		case 2:
			us.setPhoneNumber(w);
			break;
		case 3:
			us.setPassword(w);
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
	
	/*public void insert(elementType etp, String bookId) {
		// TODO Auto-generated method stub
		User us = (User)etp;
		us.getUsername();
		String b = bookId;
	}*/
	
	@Override
	public void update(elementType etp) {
		// TODO Auto-generated method stub
		
	}

}
