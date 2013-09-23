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
	public static double setBounds(int min, double max, double unbounded)
	{
		return Math.max(min, Math.min(max, unbounded));
	}

	/**
	 * Sets the bounds on a value
	 * 
	 * @param min
	 *            The min of the value
	 * @param unbounded
	 *            The value
	 * @return a bounded version of the value
	 */
	public static int setBounds(int min, int unbounded)
	{
		return Math.max(min, unbounded);
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
	public static int setBounds(int min, int max, int unbounded)
	{
		return Math.max(min, Math.min(max, unbounded));
	}
}
