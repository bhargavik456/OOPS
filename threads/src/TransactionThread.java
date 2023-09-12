
public class TransactionThread extends Thread {
	private Account account;
	private String name;
	private TransactionType type;
	private double amt;
	public TransactionThread(Account account, String name, 
				TransactionType type, double amt) {
		this.account = account;
		this.name = name;
		this.type = type;
		this.amt = amt;
	}
	
	@Override
	public void run() {
		if(TransactionType.CREDIT == type) {
			account.deposit(name, amt);
		} else if(TransactionType.DEBIT == type) {
			account.withdraw(name, amt);
		}
	}
}
