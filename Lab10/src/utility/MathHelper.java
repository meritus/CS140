package utility;

public class MathHelper
{
	/**
	 * Empty constructor
	 */
	public MathHelper()
	{
	}

	/**
	 * Sets the bounds on a value
	 * 
	 * @param min
	 *            The min of the value
	 * @param max
	 *            The max of the value
	 * @param unbounded
	 *            The value
	 * @return a bounded version of the value
	 */
	public static double setBounds(int min, int max, double unbounded)
	{
		return Math.max(min, Math.min(max, unbounded));
	}
	
	/**
	 * Tests is n is a power of two
	 * @param n
	 * @return
	 */
	public static boolean isPowerOfTwo(int n){
		int num = Math.abs(n);
		while(n >0 && n%2==0){
			num=num/2;
		}
		return num==1;
	}
}
