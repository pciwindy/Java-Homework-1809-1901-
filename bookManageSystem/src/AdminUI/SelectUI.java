package AdminUI;
import java.util.Scanner;
import ViewUI.LoginUI;

public class SelectUI extends AllUI{
	void show(){
		while (true) {
			AdminShowUI asu=new AdminShowUI();
			AdminUI.setUI(asu);
			Scanner scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				AddUserUI adu=new AddUserUI();
				AdminUI.setUI(adu);
				break;
			case "2":
				DeleteUserUI deu=new DeleteUserUI();
				AdminUI.setUI(deu);
				break;
			case "3":
				ChangeUserPasswordUI cupd=new ChangeUserPasswordUI();
				AdminUI.setUI(cupd);
				break;
			case "4":
				ChangeUserInfomationUI cui=new ChangeUserInfomationUI();
				AdminUI.setUI(cui);
				break;
			case "5":
				AddBookUI adb=new AddBookUI();
				AdminUI.setUI(adb);
				break;
			case "6":
				DeleteBookUI dtb=new DeleteBookUI();
				AdminUI.setUI(dtb);
				break;
			case "7":
				SearchBookUI sbu=new SearchBookUI();
				AdminUI.setUI(sbu);
				break;
			case "8":
				SearchUserUI suu=new SearchUserUI();
				AdminUI.setUI(suu);
				break;
			case "9":
				ChangeSUPasswordUI csup=new ChangeSUPasswordUI();
				AdminUI.setUI(csup);
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
