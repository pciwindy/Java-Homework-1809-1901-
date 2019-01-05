package AdminUI;

import java.util.Scanner;

import ViewUI.LoginUI;

public class SelectUI extends AllUI{
	//将switch-case语句独立
	//!用户层没有重构!
	AdminUI Adu=new AdminUI();
	void show(){
		while (true) {
			AdminShowUI asu=new AdminShowUI();
			Adu.setUI(asu);
			Scanner scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				AddUserUI adu=new AddUserUI();
				Adu.setUI(adu);
				break;
			case "2":
				DeleteUserUI deu=new DeleteUserUI();
				Adu.setUI(deu);
				break;
			case "3":
				ChangeUserPasswordUI cupd=new ChangeUserPasswordUI();
				Adu.setUI(cupd);
				break;
			case "4":
				ChangeUserInfomationUI cui=new ChangeUserInfomationUI();
				Adu.setUI(cui);
				break;
			case "5":
				AddBookUI adb=new AddBookUI();
				Adu.setUI(adb);
				break;
			case "6":
				DeleteBookUI dtb=new DeleteBookUI();
				Adu.setUI(dtb);
				break;
			case "7":
				SearchBookUI sbu=new SearchBookUI();
				Adu.setUI(sbu);
				break;
			case "8":
				SearchUserUI suu=new SearchUserUI();
				Adu.setUI(suu);
				break;
			case "9":
				ChangeSUPasswordUI csup=new ChangeSUPasswordUI();
				Adu.setUI(csup);
				break;
			case "10":
				System.out.println("欢迎您再次使用！");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				try {
					LoginUI.show();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				break;
			default:
				System.out.println("输入错误!");
				break;
			}
		}
	}
}
