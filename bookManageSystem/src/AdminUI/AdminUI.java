package AdminUI;

public class AdminUI{
	//ʹ��setUI�����ع�
	static AllUI a;
	public void setUI(AllUI b) {
		a=b;
		a.show();
	}
	//��ʾ���淽��
	public void show() {
		SelectUI seu=new SelectUI();
		setUI(seu);
	}
}
