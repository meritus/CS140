package bank.unit_tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import bank.main.BankAccount;

public class BankAccountUnitTest
{
	@Before
	public void setUp() throws Exception
	{
	}

	@Test
	public void testBankAccount()
	{
		BankAccount account = new BankAccount();
		assertEquals(
				"Balance of account created by first constructor should be 0",
				0.0, account.getBalance(), 0.001);// last argument is acceptable
													// error for floating type
	}

	@Test
	public void testBankAccountDouble()
	{
		BankAccount account = new BankAccount(100.50);
		//allows for a error of 0.001 for the floating point type
		assertEquals("Balance should be 100.50 after using constructor",
				100.50, account.getBalance(), 0.001);
	}

	@Test
	public void testWithdraw()
	{
		BankAccount account = new BankAccount(100.0);
		account.withdraw(101.0);
		//should not allow withdraw to be greater than balance
		assertEquals("A valid withdrawal should reduce the balance correctly",
				100.0, account.getBalance(), 0.001);// last argument is acceptable
													// error for floating type
		// What should an invalid withdrawal do??
		// Does the BankAccount withdraw() method handle it properly?

	}

	@Test
	public void testGetBalance()
	{
		BankAccount account = new BankAccount(123.45);
		//Tests account to equal 123.45 with 0.001 allowed for error
		assertEquals("The value should be equal to the amount passed in",
				123.45, account.getBalance(), 0.001);
	}

	@Test
	public void testDeposit()
	{
		BankAccount account = new BankAccount(100.0);
		account.deposit(50.0); //balance should be 150.0 now
		assertEquals("The value should be 150.0 now after deposit of 50.0",
				150.0, account.getBalance(), 0.001);
	}
	
	@Test
	public void testCounterWorking()
	{
		assertEquals("Makes sure counter is 0",
				0, BankAccount.getCounter());
		BankAccount one = new BankAccount();
		BankAccount two = new BankAccount();
		assertEquals("Makes sure counter is incrementing",
				2, BankAccount.getCounter());
	}

	@Test
	public void testHasBalance()
	{
		//Should be false
		BankAccount account = new BankAccount();
		assertFalse(account.hasBalance());
		
		//Should be True
		BankAccount account2 = new BankAccount(100.0);
		assertTrue(account2.hasBalance());
	}
}
