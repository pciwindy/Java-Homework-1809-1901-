package ViewUI;
import java.util.Scanner;

public class MainUI {
	static AllUI a;
	public static void setUI(AllUI b,String userName) {
		a=b;
		a.show(userName);
	}
	public static void show(String userName) throws InterruptedException {
		SelectionUI su=new SelectionUI();
		while(true) {
			setUI(su,userName);
			Scanner scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				BorrowUI b=new BorrowUI();
				setUI(b,userName);
				break;
			case "2":
				RepayUI r=new RepayUI();
				setUI(r,userName);
				break;
			case "3":
				SearchUI s=new SearchUI();
				setUI(s,userName);
				break;
			case "4":
				ChangePwdUI c=new ChangePwdUI();
				setUI(c,userName);
				break;
			case "0":
				System.out.println("欢迎您再次使用！");
				Thread.sleep(2000);
				LoginUI.show();
				break;
			default:
				System.out.println("输入错误！");
				break;
			}
		}
	}
}
