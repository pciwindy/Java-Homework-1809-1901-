package TelecomAccountSystemInVector;

//Running in Vector!
public class TelecomAccountSystem {
	public static void main(String[] args) {
		//TelecomUser用法：电话号码，费用
		TelecomUser telecomUser = new TelecomUser("10010",0.4);
		telecomUser.generateCommunicateRecord();
		telecomUser.printDetails();
	}
}
