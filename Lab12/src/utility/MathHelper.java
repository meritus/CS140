package utility;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

/**
 * This class provides a place to put methods relating to math.
 * @author Michelle Hochman
 *
 */
public class MathHelper 
{
	/**
	 * This creates a constructor for the MathHelper class.
	 */
	public MathHelper()
	{
		
	}
	
	/**
	 * This method takes in an int arguments min
	 * and an int value unbounded, 
	 * and returns one of the two values.
	 * @param min
	 * @param unbounded
	 * @return value of min or unbounded
	 */
	public static int setBounds(int min, int unbounded)
	{
		int value;
		if (unbounded < min)
		{
			value = min;
		}
		else
		{
			value = unbounded;
		}
		return value;
	}

	/**
	 * This method takes in two int arguments min and max 
	 * and an int value unbounded, 
	 * and returns one of the three values.
	 * @param min
	 * @param max
	 * @param unbounded
	 * @return value of min, max, or unbounded
	 */
	public static int setBounds(int min, int max, int unbounded)
	{
		int value;
		if (unbounded < min)
		{
			value = min;
		}
		else if (unbounded > max)
		{
			value = max;
		}
		else
		{
			value = unbounded;
		}
		return value;
	}

	/**
	 * This method takes in two int arguments min and max 
	 * and a double value unbounded, 
	 * and returns one of the three values.
	 * @param min
	 * @param max
	 * @param unbounded
	 * @return the value of min, max, or unbounded
	 */
	public static double setBounds(int min, int max, double unbounded)
	{
		double value;
		if (unbounded < min)
		{
			value = min;
		}
		else if (unbounded > max)
		{
			value = max;
		}
		else
		{
			value = unbounded;
		}
		return value;
	}


	/**
	 * This method takes in an int arguments min
	 * and a double value max and unbounded, 
	 * and returns one of the three values.
	 * @param min
	 * @param max
	 * @param unbounded
	 * @return value of min, max, or unbounded
	 */
	public static double setBounds(int min, double max, double unbounded)
	{
		double value;
		if (unbounded < min)
		{
			value = min;
		}
		else if (unbounded > max)
		{
			value = max;
		}
		else
		{
			value = unbounded;
		}
		return value;
	}
	
	/**
	 * This method computes whether an incoming parameter is a power of 2.
	 * @param n
	 * @return true/false
	 */
	public static boolean isPowerOfTwo(int n)
	{
		n = Math.abs(n);
		while (n > 0 && n % 2==0)
		{
			n = n/2;
		}
		return n==1 ? true : false;
	}

}
