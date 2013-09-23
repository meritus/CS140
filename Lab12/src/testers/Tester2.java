package testers;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

import nim.Frugal;
import nim.Nim;
import nim.Smart;

public class Tester2 
{
	public static void main(String[] args)
	{
	  Frugal frugal = new Frugal();
	  Smart smart = new Smart();
	  Nim nim = new Nim(frugal, smart, 2000);
	  nim.showWhoIsFirst();
	  nim.setNextPlayer(); //flip player twice
	  while(nim.gameIsNotOver())
	  {
	    nim.setNextPlayer();
	    nim.takeTurn();
	    System.out.println(nim);
	  }	 
	  nim.displayResults();
	}
}
