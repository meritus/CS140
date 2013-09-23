package nim;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import utility.MathHelper;

/**
 * This concrete class encapsulates the strategy employed by a player of Nim in 
 *   which the player takes the amount of tokens that will leave a power of two 
 *   token -1 left, or a random number if it is not possible to do this
 */
public class Smart implements PlayStrategy
{
  private static final double BASE_2 = Math.log(2.0);
  private Logger               logObj = Logger.getLogger("Smart");
  private static Handler      handler;
  private PlayStrategy        random = new Guess();
  
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
   * Determines and returns the number of tokens to remove in this turn
   * If number of tokens is already power of two - 1, won't be able to leave
   *   that amount, so will guess instead
   */
  @Override
  public int takeTurn(int numberTokens)
  {
    int removed = 
          MathHelper.isPowerOfTwo(1 + numberTokens) ? 
            random.takeTurn(numberTokens) : 
            numberTokens - (int) Math.pow(
              2, Math.floor(Math.log(numberTokens) / BASE_2)) + 1;
    
    logObj.info("Computer takes " + removed + " stick(s)\n");
    return removed;
  }
  
  /** 
   * Returns String with the name of this strategy
   */
  @Override
  public String toString()
  {
    return String.format("%s", getClass().getName());
  }
}
