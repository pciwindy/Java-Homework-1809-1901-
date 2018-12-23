package view;

import java.util.Scanner;

public class MainUI {
	public static void show() {
		System.out.println("1-×¢²á£»2-ÐÞ¸ÄÃÜÂë£»3-Ñ¡¿Î£»4-µÇÂ¼£»0-ÍË³ö");
		Scanner scanner = new Scanner(System.in);
		String option = scanner.nextLine();
		switch (option) {
		case "1":
			RegisterUI.show();
			break;
		case "2":
			ModifyPasswordUI.show();
			break;
		case "3":
			//new CourseSelection().show();
			break;
		case "4":
			LoginUI.show();
		}
	}
}
