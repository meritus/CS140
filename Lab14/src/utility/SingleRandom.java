package utility;

import java.util.Random;

/**
 * This class implements Singleton Pattern from Horstmann OOD & Patterns
 * Provides one random number generator to be used by all classes in a program
 * 
 */
public class SingleRandom
{
	/**
	 * Base
	 */
	private static final int BASE = 10;
	/**
	 * default max power
	 */
	public static final int DEFAULT_MAX_POWER = 7;
	/**
	 * represents a negative
	 */
	public static final int NEGATIVE = -1;
	/**
	 * represents a positive
	 */
	public static final int POSITIVE = 1;
	/**
	 * represents a random sign
	 */
	public static final int RANDOM_SIGN = 0;
	/**
	 * This is the single instance accessed by members of other classes via the
	 * getInstance() factory method
	 */
	private static SingleRandom instance;

	/**
	 * static initializer: This instantiates it once
	 */
	static
	{
		instance = new SingleRandom();
	}

	/**
	 * Holds a single instance of Random
	 */
	private Random generator;

	/**
	 * Default constructor Creates a private SingleRandom object Members of
	 * other classes cannot declare and instantiate it
	 */
	private SingleRandom()
	{
		generator = new Random();
	}

	/**
	 * Sets seed for pseudo-random calculation to incoming value Invoke for
	 * testing to get same random series for multiple runs Just a WRAPPER
	 * 
	 * @param seed
	 *            - starting seed for pseudo-random number generator
	 */
	public void setSeed(int seed)
	{
		generator.setSeed(seed);
	}

	/**
	 * Returns a pseudo-random integer number in the range of 0-upper non
	 * inclusive
	 * 
	 * @param upper
	 *            upper bound of numbers
	 * @return a random integer from 0 to upper non inclusive
	 */
	public int nextInt(int upper)
	{
		return nextInt(0, upper - 1);
	}

	/**
	 * Returns pseudo-random integer number in range lower to upper
	 * 
	 * @param lower
	 *            lower limit of random number generated
	 * @param upper
	 *            upper limit of random number generated
	 * @return integer in range lower to upper inclusive
	 */
	public int nextInt(int lower, int upper)
	{
		return generator.nextInt(upper - lower + 1) + lower;
	}

	/**
	 * Returns pseudo-random + or - double between 1 and DEFAULT_MAX_POWER^BASE
	 * 
	 * @return the required floating point number
	 */
	public double nextDouble()
	{
		return nextDouble(DEFAULT_MAX_POWER, RANDOM_SIGN);
	}

	/**
	 * Returns pseudo-random + or - double between 1 and DEFAULT_MAX_POWER^BASE
	 * 
	 * @param sign
	 *            the signs of the returned floating point number
	 * @return the required floating point number
	 */
	public double nextDouble(int sign)
	{
		return nextDouble(DEFAULT_MAX_POWER, sign);
	}

	/**
	 * Returns pseudo-random + or - double between 1 and maxPower^BASE
	 * 
	 * @param maxPower
	 *            the maximum power to raise base to
	 * @param sign
	 *            The signs of the returned floating point number
	 * @return a random floating point number
	 */
	public double nextDouble(int maxPower, int sign)
	{
		int temp = nextInt(1, maxPower);
		double multiplier = Math.pow(BASE, temp);
		return generator.nextDouble()
				* multiplier
				* (sign == RANDOM_SIGN ? (generator.nextBoolean() ? 1 : -1)
						: sign);
	}

	/**
	 * Factory method - gives out reference to single instance of class Cannot
	 * access otherwise
	 * 
	 * @return reference to random number generator
	 */
	public static SingleRandom getInstance()
	{
		return instance;
	}
}
