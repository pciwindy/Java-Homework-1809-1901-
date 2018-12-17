package simulationBankSystem;

import java.util.*;

public class Bank {
	private double account;
	private User user;
	
	public static void main(String args[]) throws Exception {
		Bank bank=new Bank();
		bank.login();
		bank.operate();
		bank.close();
	}
	
	public void login() throws Exception {
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
	
	
	public void operate() throws Exception {
		Bank b=new Bank();
		b.user=user;
		boolean condition=true;
		while(condition){
			Scanner in=new Scanner(System.in);
			System.out.println("Account: "+user.getAccount());
			System.out.println("1.In");
			System.out.println("2.Out");
			System.out.println("3.I have");
			System.out.println("4.Register");
			System.out.println("5 Save");
			System.out.println("0.Exit");
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
				case 4:
				{
					b.register();
					break;
				}
				case 5:
				{
					b.close();
					break;
				}
				case 0:
				{
					System.out.println("Exited!Have a nice day!");
					condition=false;
					break;
				}
				default:
				{
					System.out.println("Input Error!");
					break;
				}
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
		System.out.println();
	}
	
	public void getMoney() {
		Scanner in=new Scanner(System.in);
		System.out.println("How much will you get?");
		double getMoney=in.nextDouble();
		if(user.getAccount()-getMoney<0){
			System.out.println("Failed! You don't have too much money!");
			System.out.println("You have "+user.getAccount());
			System.out.println();
		}
		else{
			account=user.getAccount()-getMoney;
			user.setAccount(account);
			System.out.println("Successed! You have "+user.getAccount()+" now!");
			System.out.println();
		}
		
	}
	
	public void howMuchIHave() {
		System.out.println("You have "+user.getAccount()+" now!");
		System.out.println();
	}
	
	public void register() throws Exception {
		User u=new User();
		Scanner scanner=new Scanner(System.in);
		System.out.println("Input your cardId");
		u.setCardId(scanner.nextLine());
		System.out.println("Input your UserName");
		u.setUserName(scanner.nextLine());
		System.out.println("Input your Password");
		u.setCardPwd(scanner.nextLine());
		System.out.println("Input your PhoneNumber");
		u.setCall(scanner.nextLine());
		System.out.println("Input money");
		u.setAccount(scanner.nextDouble());
		DBUtils dbUtil=DBUtils.getInstance();
		dbUtil.addUser(u);
	}
	
	private void close() throws Exception {
		DBUtils db=DBUtils.getInstance();
		db.update();
	}
}
