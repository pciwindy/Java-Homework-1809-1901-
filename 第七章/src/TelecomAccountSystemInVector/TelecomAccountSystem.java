package TelecomAccountSystemInVector;

//Running in Vector!
public class TelecomAccountSystem {
	public static void main(String[] args) {
		//TelecomUser�÷����绰���룬����
		TelecomUser telecomUser = new TelecomUser("10010",0.4);
		telecomUser.generateCommunicateRecord();
		telecomUser.printDetails();
	}
}
