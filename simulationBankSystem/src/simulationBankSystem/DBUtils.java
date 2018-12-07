package simulationBankSystem;

import java.util.*;

public class DBUtils {
	private static DBUtils instance=null;
	private HashMap<String,User> users=new HashMap<String,User>();
	
	private DBUtils() {
		//Add Users u1
		User u1=new User();
		u1.setCall("10001");
		u1.setUserName("小明");
		u1.setCardId("1001");
		u1.setCardPwd("admin");
		u1.setAccount(10000);
		users.put(u1.getCardId(), u1);
		
		//Add Users u1
		User u2=new User();
		u2.setCall("10086");
		u2.setUserName("小王");
		u2.setCardId("1002");
		u2.setCardPwd("admin");
		u2.setAccount(10000);
		users.put(u2.getCardId(), u2);
		
		//Add Users u1
		User u3=new User();
		u3.setCall("10000");
		u3.setUserName("小红");
		u3.setCardId("1003");
		u3.setCardPwd("admin");
		u3.setAccount(10000);
		users.put(u3.getCardId(), u3);
	}
	
	public static DBUtils getInstance() {
		if(instance==null) {
			synchronized (DBUtils.class) {
				if(instance==null) {
					instance=new DBUtils();
				}
			}
		}
		return instance;
	}
	
	public User getUser(String cardId) {
		User user=(User)users.get(cardId);
		return user;
	}
	
	public HashMap<String,User> getUsers(){
		return users;
	}
}
