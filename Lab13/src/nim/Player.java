package nim;

import java.util.ArrayList;
import utility.SingleRandom;

/**
 * This class encapsulates a Player in the game of Nim
 * Each player employs a PlayStrategy
 * @author Rose Williams
 *
 */
public class Player
{
  // Class Constants -----------------------------------------------------------
  
  /**
   * Index of human PlayStrategy
   */
  public static final int HUMAN = 0; // Default strategy
  
  /**
   * Minimum index that includes all strategies
   */
  public static final int ANY = 0;      // 0 and higher
  
  /**
   * Minimum index that includes all computer strategies only
   */
  public static final int COMPUTER = 1; //1 and higher
  
  // Class Variables -----------------------------------------------------------
  /**
   * ArrayList that encapsulates all built-in strategies that can be employed 
   *   by a Player
   * It is possible to add new strategies during game play  
   */
  private static ArrayList<PlayStrategy> strategies;
  static
  {
    strategies = new ArrayList<PlayStrategy>();
    strategies.add(new Human());
    strategies.add(new Frugal());
    strategies.add(new Greedy());
    strategies.add(new Guess());
    strategies.add(new Smart());
  }
  
  // Instance Variables --------------------------------------------------------
  
  /**
   * Concrete strategy employed by this Player
   */
  private PlayStrategy strategy;
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Creates default (human) player
   */
  public Player()
  {
    this(strategies.get(HUMAN));
  }
  
  /**
   * Creates player with appropriate strategy given player type
   * @param playerType
   */
  public Player(int playerType)
  {
    this(strategies.get(SingleRandom.getInstance().
      nextInt(playerType, strategies.size()-1)));
  }
  
  /**
   * Creates player with given strategy
   * All constructors chain to here
   * @param strategy
   */
  public Player(PlayStrategy strategy)
  {
    this.strategy = strategy;
  }
  
  // Accessor methods ----------------------------------------------------------
  
  /**
   * Gets strategy of this player
   * @return player strategy
   */
  public PlayStrategy getStrategy()
  {
    return strategy;
  }
  
  /**
   * Delegates turn to strategy object, returns number of tokens that this
   *   player should remove from pile during this turn
   * @param tokens - current number of tokens in pile
   * @return number of tokens to remove
   */
  public int takeTurn(int tokens)
  {
    return strategy.takeTurn(tokens);
  }
  
  /**
   * Overridden Object class method that returns String representation of this 
   *   player's state
   * @return String describing state of this player
   */
  @Override
  public String toString()
  {
    return String.format("%s:  %s", getClass().getName(), strategy);
  }
  
  // Class methods -------------------------------------------------------------
  /**
   * Adds a new strategy to the ArrayList of strategies available to a Player
   * @param newStrategy
   */
  public static void addStrategy(PlayStrategy newStrategy)
  {
    strategies.add(newStrategy);
  }
}
