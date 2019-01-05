package AdminUI;

public class AdminUI{
	//使用setUI方法重构
	static AllUI a;
	public void setUI(AllUI b) {
		a=b;
		a.show();
	}
	//显示界面方法
	public void show() {
		SelectUI seu=new SelectUI();
		setUI(seu);
	}
}
