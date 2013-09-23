package nim;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import utility.MathHelper;
import utility.SingleRandom;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

/**
 * Smart – player takes enough tokens to leave number of tokens that is power 
 * of 2, minus 1 if possible, otherwise uses same strategy as Guess
 * @author Michelle
 *
 */
public class Smart implements PlayStrategy
{
	 public Logger          logObj = Logger.getLogger("Frugal");
	  private static Handler handler;
	  
	  /**
	   * This is the default constructor
	   */
	  public Smart()
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
	    int ret;
	    if(numberTokens == 1)
	    {
	    	ret = 1;
	    }
	    else if(MathHelper.isPowerOfTwo(1+numberTokens))
	    {
	    	ret = SingleRandom.getInstance().nextInt(1, numberTokens/2);
	    }
	    else
	    {
	    	int pow = 1;
	    	while(pow-1 < numberTokens)
	    	{
	    		pow = pow * 2;
	    	}
	    	ret = (pow/2)+1;
	    }
	    logObj.info("Computer takes" + ret + "sticks\n");
	    return ret;
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
