package utility;

import java.util.Random;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/


/**
 * This class implements Singleton Pattern from Horstmann OOD & Patterns
 * Provides one random number generator to be used by all classes in a program
 *
 */
public class SingleRandom  
{
	/**
	 * A base of 10 to muliply a power by
	 */
	private static final int BASE = 10;
	
	/**
	 * A default max power
	 */
	public static final int DEFAULT_MAX_POWER = 7;
	
	/**
	 * A constant representing -1
	 */
	public static final int NEGATIVE = -1;
	
	/**
	 * A constant representing 1
	 */
	public static final int POSITIVE = 1;
	
	/**
	 * A constant representing 0, giving a random sign (either 1 or -1)
	 */
	public static final int RANDOM_SIGN = 0;
	
  // Static Variables
  
  //This is the single instance accessed by members of
  //  other classes via the getInstance() factory method
  private static SingleRandom  instance;  
  static //static initializer:  This instantiates it once
  {
    instance = new SingleRandom();
  }

  // Instance Variables
  private Random generator;  //This field remains hidden

  
  // Default and other Constructors
 
  /**
   * Default constructor
   * Creates a private SingleRandom object 
   * Members of other classes cannot declare and instantiate it
   */
  private SingleRandom()
  {
    generator = new Random();
  }
    
  // Instance methods 
  /**
   * Sets seed for pseudo-random calculation to incoming value
   * Invoke for testing to get same random series for multiple runs
   * Just a WRAPPER
   * @param seed - starting seed for pseudo-random number generator
   */
  public void setSeed(int seed)  
  {
    generator.setSeed(seed);
  }

  
  /**
   * Returns pseudo-random integer number in range 0 to range-1
   * @param range upper limit of random number generated, exclusive
   * Just a WRAPPER
   * @return  integer in range 0 to range-1 inclusive
   */
  public int nextInt(int range)
  {
    return generator.nextInt(range);
  }
  

  // Static methods  
  
  /**
   * Factory method - gives out reference to single instance of class
   * Cannot access otherwise
   * @return reference to random number generator
   */
  public static SingleRandom getInstance() 
  {
    return instance;
  }
  
  /**
   * Creates a random method that generates a random number
   * in the range of lower to upper
   * @param lower
   * @param upper
   * @return random number in range lower to upper
   */
  public int nextInt(int lower, int upper)
  {
	  return lower + generator.nextInt((upper+1)-lower);
  }
  
  /**
   * Generates a random number by getting a random double value and 
   * multiplying it by the a positive or negative number and by a 
   * base power DEFAULT_MAX_POWER and a sign value RANDOM_SIGN.
   * @return random double value
   */
  public double nextDouble()
  {
	  return nextDouble(DEFAULT_MAX_POWER, RANDOM_SIGN);
  }
  
  /**
   * Generates a random number by getting a random double value and 
   * multiplying it by the a positive or negative number and by 
   * parameters maxPower and sign.
   * @param maxPower
   * @param sign
   * @return random double value
   */
  public double nextDouble(int maxPower, int sign)
  {
	  double num;
	  if (sign == RANDOM_SIGN)
	  {
		  num = generator.nextDouble() * (Math.pow(BASE, 
					 (1 + generator.nextInt((maxPower+1)-1))) * 
					 (generator.nextBoolean() ? 1: -1));
	  }
	  else
	  {
		  num = generator.nextDouble() * (Math.pow(BASE, 
					 (1 + generator.nextInt((maxPower+1)-1))) * 
					 (sign));
	  }
	  return num;
  }
  
  /**
   * Generates a random number by getting a random double value and 
   * multiplying it by the a positive or negative number and by a
   * parameter sign.
   * @param sign
   * @return random double value
   */
  public double nextDouble(int sign)
  {
	  return nextDouble(DEFAULT_MAX_POWER, sign);
  }
  
  /**
   * Wrapper method for the nextDouble method
   * @return wrapped double 
   */
  public double nextDoubleWrapper()
  {
	  return generator.nextDouble();
  }
  
}