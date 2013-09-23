package nim;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * This concrete class encapsulates the strategy employed by a player of Nim in 
 *   which the player only takes one token per turn
 */
public class Cheat implements PlayStrategy
{
  private Logger          logObj = Logger.getLogger("Frugal");
  private static Handler handler;
  
  public Cheat()
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
   */
  @Override
  public int takeTurn(int currentState)
  {
    logObj.info("Computer takes 1 stick\n");
    return currentState - 1;
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
