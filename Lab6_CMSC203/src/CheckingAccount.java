
public class CheckingAccount extends BankAccount{
	
	final static double FEE = .15;
	
	public CheckingAccount(String n, int am) {
		
		super(n, am);
		setAccountNumber(getAccountNumber() + "-10");
	}
	
	@Override
	public boolean withdraw(double amount) {
		
		return super.withdraw(amount + FEE);
	}
}
