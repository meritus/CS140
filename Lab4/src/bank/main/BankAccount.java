package bank.main;

/**
 * This class simulates a working bankaccount
 * It's public mutators include withdraw, deposit
 * It's accessors include getBalance
 * @author eliu7
 *
 */
public class BankAccount
{
	/**
	 * The amount of money in bankaccount
	 */
	private double balance;

	/**
	 * The name of the BankAccount
	 */
	private String name;
	
	/**
	 * Keeps track of how many bankaccount are created
	 */
	private static int counter = 0;
	
	/**
	 * Default constructor that gives sets balance to 0
	 */
	public BankAccount()
	{
		this(0, "Anonymous");
	}

	/**
	 * Constructor that sets balance to an amount
	 * @param initialBalance amount to set balance
	 */
	public BankAccount(double balance)
	{
		this(balance, "Anonymous");
	}
	
	public BankAccount(double balace, String name){
		this.balance = balance;
		this.name = name;
		incrementCounter();
	}
	
	/**
	 * Increases counter by one
	 * This is static which means it doesn't need an instance to be called
	 * This is private which mean that it can only be called within this
	 * 	class
	 **/
	private static void incrementCounter(){
		counter++;
	}
	
	/**
	 * Gives the values of counter
	 * This can be called by it's class name because it is static
	 * It is public meaning it can be called outside this method
	 * @return number of bankaccount created 
	 */
	public static int getCounter(){
		return counter;
	}

	/**
	 * Gets the current balance of this bank account
	 * 
	 * @return current balance
	 */
	public double getBalance()
	{
		return balance;
	}
	
	/**
	 * Sets the balance of the bank account to balance
	 * @balance amount to set account balance to
	 */
	private void setBalance(double balance){
		this.balance = balance;
	}

	/**
	 * Adds money into bank account
	 * @param amount to add to balance
	 */
	public void deposit(double amount)
	{
		double newBalance = getBalance() + amount;
		setBalance(newBalance);
	}

	/**
	 * Takes money from bank account
	 * @param amount to take from bank account
	 */
	public void withdraw(double amount)
	{
		if(amount>getBalance())
			return;
		double newBalance = getBalance() - amount;
		setBalance(newBalance);
	}
	
	public boolean hasBalance(){
		return balance>0;
	}
	

}
