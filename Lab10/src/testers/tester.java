package testers;

import nim.*;


public class tester
{
	public static void main(String[] args)
	{
		Frugal frugal = new Frugal();
		Smart smart = new Smart();
		Nim nim = new Nim(frugal, smart, 2000);
		nim.showWhoIsFirst();
		nim.setNextPlayer(); // flip player twice
		while (nim.gameIsNotOver())
		{
			nim.setNextPlayer();
			nim.takeTurn();
			System.out.println(nim);
		}
		nim.displayResults();
	}
}
