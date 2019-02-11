package ViewUI;

public class UserUI {
	static AllUI a;
	public static void setUI(AllUI b,String userName) throws InterruptedException {
		a=b;
		a.show(userName);
	}
	public static void show(String userName) throws InterruptedException {
		SelectUI seu=new SelectUI();
		setUI(seu,userName);
	}
}
