package ViewUI;
import java.util.Scanner;

public class SelectUI extends AllUI{
	void show(String userName) throws InterruptedException {
		while(true) {
			SelectionUI su=new SelectionUI();
			UserUI.setUI(su,userName);
			Scanner scanner = new Scanner(System.in);
			String option = scanner.nextLine();
			switch (option) {
			case "1":
				BorrowUI b=new BorrowUI();
				UserUI.setUI(b,userName);
				break;
			case "2":
				RepayUI r=new RepayUI();
				UserUI.setUI(r,userName);
				break;
			case "3":
				SearchUI s=new SearchUI();
				UserUI.setUI(s,userName);
				break;
			case "4":
				ChangePwdUI c=new ChangePwdUI();
				UserUI.setUI(c,userName);
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
