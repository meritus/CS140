package nim;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.JOptionPane;

/**
 * This class allows a real human being to play when the player is a human
 * @author Michelle Hochman
 */
public class Human implements PlayStrategy
{
  public Logger          logObj = Logger.getLogger("Human");
  private static Handler handler;
  
  /**
   * This is the default constructor
   */
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
	 * take in the number of tokens currently in the pile, and return the 
	 * number of tokens to remove
	 * @param size
	 * @return tokens
	 */
  @Override
  public int takeTurn(int numberTokens)
  {
    int removed = -1;
    while (removed < 0)
    {
      String in = JOptionPane.showInputDialog(null, 
          "Number to remove from " + numberTokens + ":");
      Scanner input = new Scanner(in);
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
    return removed;
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
