package simulationBankSystem;

import java.util.*;

public class Bank {
	private double account;
	private User user;
	
	public static void main(String args[]) {
		Bank bank=new Bank();
		bank.login();
		bank.operate();
	}
	
	public void login() {
		DBUtils db=DBUtils.getInstance();
		Scanner in=new Scanner(System.in);
		System.out.println("Welcome to Bank System!");
		while(true) {
			System.out.println("Please input your CardId:");
			String inputCardId=in.nextLine();
			System.out.println("Please input your CardId's password");
			String inputPassword=in.nextLine();
			
			user=db.getUser(inputCardId);
			
			if(db.getUsers().containsKey(inputCardId)&&user.getCardPwd().equals(inputPassword)) {
				System.out.println("Welcome "+user.getUserName());
				break;
			}
			else {
				System.out.println("CardId or Password wrong!");
				continue;
			}
		}
	}
	
	
	public void operate() {
		Bank b=new Bank();
		Scanner in=new Scanner(System.in);
		System.out.println("Account: "+user.getAccount());
		account=user.getAccount();
		int flag=in.nextInt();
		switch(flag) {
			case 1:
			{
				b.inMoney();
				break;
			}
			case 2:
			{
				b.getMoney();
				break;
			}
			case 3:
			{
				b.howMuchIHave();
				break;
			}
			default:
			{
				System.out.println("Input Error!");
				break;
			}
		}
	}
	
	public void inMoney() {
		Scanner in=new Scanner(System.in);
		System.out.println("How much will you in?");
		double inMoney=in.nextDouble();
		account=user.getAccount()+inMoney;
		user.setAccount(account);
		System.out.println("Successed! You have "+user.getAccount()+" now!");
	}
	
	public void getMoney() {
		Scanner in=new Scanner(System.in);
		System.out.println("How much will you get?");
		double getMoney=in.nextDouble();
		account=user.getAccount()-getMoney;
		user.setAccount(account);
		System.out.println("Successed! You have "+user.getAccount()+" now!");
	}
	
	public void howMuchIHave() {
		System.out.println("You have "+user.getAccount()+" now!");
	}
}