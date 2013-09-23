package nim;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;

/**
 * This concrete class encapsulates the strategy employed by a human player of 
 * Nim
 */
public class Human implements PlayStrategy
{
  private Logger          logObj = Logger.getLogger("Human");
  private static Handler handler;
  
  public Human()
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
   * @param numberTokens - number of tokens remaining in this game of Nim
   * @return number of tokens to remove from pile
   */
  @Override
  public int takeTurn(int numberTokens)
  {
    int removed = -1;
    while (removed < 0)
    {
      // Get input from user
      String in = JOptionPane.showInputDialog(null, 
          "Number to remove from " + numberTokens + ":");
      Scanner input = new Scanner(in);
      
      // validate input
      if (input.hasNextInt())
      {
        removed = input.nextInt();
        if ((numberTokens != 1 && (removed < 1 || removed > numberTokens / 2))
            || (numberTokens == 1 && removed != 1))
        {
          JOptionPane.showMessageDialog(null, "You can only take between\n"
              + "1 and " + (numberTokens == 1 ? 1 : numberTokens / 2)
              + " sticks from the pile");
          removed = -1;
        }
      }
      else
      {
        JOptionPane.showMessageDialog(null, "You did not enter an integer");
      }
    }
    logObj.info("Human takes " + removed + "\n");
    
    // return tokens to be removed
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
