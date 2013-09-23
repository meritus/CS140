package nim;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * This class encapsulates the frugal strategy when the player is a computer
 * @author Michelle Hochman
 *
 */
public class Frugal implements PlayStrategy
{
  public Logger          logObj = Logger.getLogger("Frugal");
  private static Handler handler;
  
  /**
   * This is the default constructor
   */
  public Frugal()
  {
    // creates this handler
    // output will go to file named in argument
    try
    {
      handler = new FileHandler("Nim.log");
      // SimpleFormatter produces plain text(as opposed to XML)
      handler.setFormatter(new SimpleFormatter());
      logObj.addHandler(handler);
      logObj.setLevel(Level.ALL);
    }
    catch (SecurityException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
  
  /**
   * take in the number of tokens currently in the pile, and return the 
   * number of tokens to remove
   * @param size
   * @return tokens
   */
  @Override
  public int takeTurn(int numberTokens)
  {
    logObj.info("Computer takes 1 stick\n");
    return 1;
  }
  
  /**
	* return a String representation of the class name
	* @return String representation
	*/
  @Override
  public String toString()
  {
    return String.format("%s", getClass().getName());
  }
}
