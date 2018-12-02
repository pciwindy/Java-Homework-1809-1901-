package TelecomAccountSystem;

public class TelecomAccountSystem {
	public static void main(String[] args) {
		//TelecomUser用法：电话号码，费用，取整模式<-思考中
		TelecomUser telecomUser = new TelecomUser("10010",0.4,2);
		telecomUser.generateCommunicateRecord();
		telecomUser.printDetails();
	}
}
