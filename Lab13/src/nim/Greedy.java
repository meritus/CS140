package nim;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


/**
 * This concrete class encapsulates the strategy employed by a player of Nim in 
 *   which the player takes as many tokens as possible per turn
 */public class Greedy implements PlayStrategy
{
  private Logger          logObj = Logger.getLogger("Greedy");
  private static Handler handler;
  
  public Greedy()
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
    int removed = 1;
    if (currentState > 1)
    {
      removed = currentState / 2;
    }
    
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
