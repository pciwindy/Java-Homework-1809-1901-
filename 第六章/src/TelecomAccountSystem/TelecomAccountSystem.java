package TelecomAccountSystem;

public class TelecomAccountSystem {
	public static void main(String[] args) {
		//TelecomUser�÷����绰���룬���ã�ȡ��ģʽ<-˼����
		TelecomUser telecomUser = new TelecomUser("10010",0.4,2);
		telecomUser.generateCommunicateRecord();
		telecomUser.printDetails();
	}
}
