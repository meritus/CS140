package utility;

/**
 * This class will be used to tailor Math class methods to suit our purposes
 *   more closely
 * @author Rose Williams
 *
 */
public class MathHelper
{
  /**
   * Default constructor - do nothing
   * No instance variables, like Math class
   */
  MathHelper()
  {
    
  }
  
  /**
   * Modifies incoming value to be confined to given range if necessary
   * @param min - lower bound of range
   * @param unbounded - value to be kept within given range
   * @return value within given range
   */
  public static int setBounds(int min, int unbounded)
  {
    return Math.max(min, unbounded);
  }
  
  /**
   * Modifies incoming value to be confined to given range if necessary
   * (Precondition:  min <= max)
   * (Postcondition:  return value >= min && <= max)
   * @param min - lower bound of range
   * @param max - upper bound of range
   * @param unbounded - value to be kept within given range
   * @return bounded value
   */
  public static int setBounds(int min, int max, int unbounded)
  {
    return Math.max(min, Math.min(max, unbounded)); 
  }
  
  /**
   * Modifies incoming value to be confined to given range if necessary
   * (Precondition:  min <= max)
   * (Postcondition:  return value >= min && <= max)
   * @param min - lower bound of range
   * @param max - upper bound of range
   * @param unbounded - value to be kept within given range
   * @return bounded value
   */
  public static double setBounds(int min, int max, double unbounded)
  {
    return Math.max(min, Math.min(max, unbounded)); 
  }
  
  /**
   * Modifies incoming value to be confined to given range if necessary
   * (Precondition:  min <= max)
   * (Postcondition:  return value >= min && <= max)
   * @param min - lower bound of range
   * @param max - upper bound of range
   * @param unbounded - value to be kept within given range
   * @return bounded value
   */
  public static double setBounds(int min, double max, double unbounded)
  {
    return Math.max(min, Math.min(max, unbounded)); 
  }
  
  /**
   * Determines if given value is a power of two
   * @param n - given value
   * @return true if value is power of two, false otherwise
   */
  public static boolean isPowerOfTwo(int n)
  {
    n = Math.abs(n);
    while(n > 0 && n % 2 == 0)
        n /= 2;
    return n == 1;
  }
}
