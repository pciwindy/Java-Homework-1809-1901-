package simulationBankSystem;

import java.util.*;
import java.io.*;

public class DBUtils {
	private static DBUtils instance=null;
	private LinkedHashMap<String,User> users=new LinkedHashMap<String,User>();
	private FileWriter writer;
	private FileReader reader;
	
	private DBUtils() throws Exception {
		getUsersFromInputStream("user.dat");
	}
	
	public static DBUtils getInstance() throws Exception {
		if(instance==null) {
			synchronized (DBUtils.class) {
				if(instance==null) {
					instance=new DBUtils();
				}
			}
		}
		return instance;
	}
	
	public void addUser(User u) {
		users.put(u.getCardId(), u);
	}
	
	public User getUser(String cardId) {
		User user=(User)users.get(cardId);
		return user;
	}
	
	public HashMap<String,User> getUsers(){
		return users;
	}
	
	public void getUsersFromInputStream(String fileName) throws Exception{
		reader=new FileReader(fileName);
		BufferedReader br=new BufferedReader(reader);
		String userString;
		while((userString=br.readLine())!=null) {
			processUserString(userString);
		}
		if(br!=null) {
			br.close();
		}
	}
	
	public void processUserString(String userString) {
		String[] userFields=userString.split(",");
		User u=new User();
		u.setCardId(userFields[0]);
		u.setCardPwd(userFields[1]);
		u.setUserName(userFields[2]);
		u.setCall(userFields[3]);
		u.setAccount(Double.parseDouble(userFields[4]));
		users.put(u.getCardId(), u);
		
	}
	
	public void update() throws Exception{
		Set<String> userSet=users.keySet();
		writer=new FileWriter("user.dat");
		BufferedWriter bfw=new BufferedWriter(writer);
		for(String cardId:userSet) {
			User u=(User)users.get(cardId);
			String uString=u.getCardId()+","+u.getCardPwd()+","+u.getUserName()+","+u.getCall()+","+u.getAccount()+"\r\n";
			bfw.write(uString);
		}
		if(bfw!=null) {
			bfw.close();
		}
	}
}