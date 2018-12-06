package simulationBankSystem;

public class User {
	private String call;
	private String username;
	private String password;
	private String cardId;
	private double account;
	
	public String getCall() {
		return call;
	}
	
	public void setCall(String call) {
		this.call=call;
	}
	
	public double getAccount() {
		return account;
	}
	
	public void setAccount(double account) {
		this.account=account;
	}
	
	public String getUserName() {
		return username;
	}
	
	public void setUserName(String username) {
		this.username=username;
	}
	
	public String getCardId() {
		return cardId;
	}
	
	public void setCardId(String cardId) {
		this.cardId=cardId;
	}
	
	public String getCardPwd() {
		return password;
	}
	
	public void setCardPwd(String password) {
		this.password=password;
	}
}
