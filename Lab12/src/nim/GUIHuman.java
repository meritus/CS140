package nim;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

/**
 * This class is just a placeholder
 */

/**
 * This class is a GUI for the nim package that implements PlayStrategy
 * @author Michelle
 *
 */
public class GUIHuman implements PlayStrategy
{
  
/**
 * default constructor
 */
  public GUIHuman()
  {    
  }
  
  /**
   * take in the number of tokens currently in the pile, and return the 
   * number of tokens to remove
   */
  @Override
  public int takeTurn(int numberTokens)
  {
    return 0;
  }
  
  /**
   * return a String representation of the class name
   */
  @Override
  public String toString()
  {
    return String.format("%s", getClass().getName());
  }
}
