package bank.main;

import java.util.Scanner;

/**
 * Change record:
 * 
 * From Java Outside In, Cambridge University Press (2003) Copyright 2003 Bill
 * Campbell and Ethan Bolker Modified 2005 Margaret Iwobi - text book provided
 * Terminal class replaced by System.out for output and Java's Scanner class for
 * input Modified 2007 Eric Sabbah Modified 2012 Rose Williams - cleaned up
 * javadoc, added default constructor
 * 
 * -----------------------------------------------------------------------------
 * 
 * A Bank object simulates the behavior of a simple bank/ATM. It contains a
 * Scanner object and two BankAccount objects.
 * 
 * Its single public method is open, which opens the Bank for business,
 * prompting the customer for input.
 * 
 * To create a Bank and open it for business issue the command
 * <code>java Bank</code>.
 * 
 * @author Eric Sabbah
 * @see BankAccount
 * @version 1
 * 
 */
public class Bank
{
	/**
	 * Name of this bank
	 */
	private String bankName;

	/**
	 * This bank's customer input mechanism
	 */
	private Scanner atm;

	/**
	 * This bank's account #1
	 */
	private BankAccount account1;

	/**
	 * This bank's account #2
	 */
	private BankAccount account2;

	/**
	 * Initial balance for all banks
	 */
	private static final int INITIAL_BALANCE = 200;

	/**
	 * Help message for all banks
	 */
	private static final String HELPSTRING = "Transactions: exit, help, deposit, withdraw, balance";

	/**
	 * Default constructor Sets name of bank to default value
	 */
	public Bank()
	{
		this("First Bank of the Rich and Mighty (i.e., NOT YOU)");
	}

	/**
	 * Construct a Bank with the given name. Create two new BankAccounts, each
	 * with a starting balance of initialBalance.
	 * 
	 * @param name
	 *            the name of the Bank
	 * 
	 */
	public Bank(String name)
	{
		bankName = name;
		atm = new Scanner(System.in);
		account1 = new BankAccount(INITIAL_BALANCE);
		account2 = new BankAccount(INITIAL_BALANCE);
	}

	/**
	 * Open the Bank for business
	 * 
	 * Send a whichAccount message prompting for a BankAccount number, then send
	 * a processTransactionsForAccount message to do the work
	 * 
	 */
	public void open()
	{
		System.out.println("Welcome to " + bankName);
		boolean bankIsOpen = true;
		while (bankIsOpen)
		{
			BankAccount account = this.whichAccount();
			if (account == null)
			{
				bankIsOpen = false;
			} else
			{
				this.processTransactionsForAccount(account);
			}
		}
		System.out.println("Goodbye from " + bankName);
	}

	/**
	 * Prompt the user for an account number and return the corresponding
	 * BankAccount object Return null when
	 * 
	 * Return null when the Bank is about to close
	 * 
	 * @return the account that is chosen, or null
	 * 
	 */
	private BankAccount whichAccount()
	{
		System.out.println("Account number (1 or 2), 0 to shut down: ");
		int accountNumber = atm.nextInt();
		if (accountNumber == 1)
		{
			return account1;
		} else if (accountNumber == 2)
		{
			return account2;
		} else if (accountNumber == 0)
		{
			return null;
		} else
		{
			System.out.println("No account numbered " + accountNumber
					+ "; try again");
			return this.whichAccount();
		}
	}

	/**
	 * Prompt the user for transaction to process Then send an appropriate
	 * message to account
	 * 
	 * @param account
	 *            - the BankAccount being processed
	 * 
	 */
	private void processTransactionsForAccount(BankAccount account)
	{
		System.out.println(HELPSTRING);

		boolean moreTransactions = true;
		while (moreTransactions)
		{
			System.out.println("transaction: ");
			String command = atm.next();
			if (command.equals("exit"))
			{
				moreTransactions = false;
			} else if (command.equals("help"))
			{
				System.out.println(HELPSTRING);
			} else if (command.equals("deposit"))
			{
				System.out.println("how much? ");
				int amount = atm.nextInt();
				account.deposit(amount);
			} else if (command.equals("withdraw"))
			{
				System.out.println("how much? ");
				int amount = atm.nextInt();
				account.withdraw(amount);
			} else if (command.equals("balance"))
			{
				System.out.println(account.getBalance());
			} else
			{
				System.out.println("sorry, unknown transaction");
			}
		}
	}

	/**
	 * The Bank simulation program begins here when the user issues the command
	 * <code>java Bank</code>.
	 * 
	 * @param args
	 *            the command line arguments (ignored)
	 */
	public static void main(String[] args)
	{
		Bank javaBank = new Bank("Engulf and Devour");
		javaBank.open();
	}
}
