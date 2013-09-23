package nim;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

/**
 * This class represents a play of the game nim
 * @author Michelle Hochman
 *
 */
public class Player
{
  /**
   * id of the player
   */
  private int id;
  /**
   * player strategy
   */
  private PlayStrategy strategy;
  
  /**
   * constructor for the player class
   * @param id
   * @param strategy
   */
  public Player(int id, PlayStrategy strategy)
  {
    this.id = id;
    this.strategy = strategy;
  }
  
  /**
   * accessor for the strategy variable
   * @return
   */
  public PlayStrategy getStrategy()
  {
    return strategy;
  }
  
  /**
   * take in the number of tokens currently in the pile, and return the 
   * number of tokens to remove
   * @param tokens
   * @return tokens
   */
  public int takeTurn(int tokens)
  {
    return strategy.takeTurn(tokens);
  }
  
  /**
   * return a String representation of the class name
   */
  public String toString()
  {
    return String.format("%s%d:  %s", getClass().getName(), id, strategy);
  }
}
