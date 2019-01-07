package AdminUI;

import java.util.Scanner;

import ViewUI.LoginUI;

public class AdminUI{
	static AllUI a;
	public void setUI(AllUI b) {
		a=b;
		a.show();
	}
	public void show() {
		SelectUI seu=new SelectUI();
		setUI(seu);
	}
	
}
