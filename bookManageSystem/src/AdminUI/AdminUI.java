package AdminUI;

public class AdminUI{
	static AllUI a;
	public static void setUI(AllUI b) {
		a=b;
		a.show();
	}
	public static void show() {
		SelectUI seu=new SelectUI();
		setUI(seu);
	}
	
}
