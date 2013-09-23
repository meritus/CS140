package testers;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

import utility.MathHelper;

public class TesterClass 
{
	public static void main(String[] args)
	{
		MathHelper mathHelp = new MathHelper();
		System.out.println(mathHelp.isPowerOfTwo(-1));
		System.out.println(mathHelp.isPowerOfTwo(2));
		System.out.println(mathHelp.isPowerOfTwo(3));
		System.out.println(mathHelp.isPowerOfTwo(4));
		System.out.println(mathHelp.isPowerOfTwo(5));
		System.out.println(mathHelp.isPowerOfTwo(6));
		System.out.println(mathHelp.isPowerOfTwo(7));
		System.out.println(mathHelp.isPowerOfTwo(8));
		
	}

}
