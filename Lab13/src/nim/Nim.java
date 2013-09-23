package nim;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import utility.SingleRandom;

/**
 * The Nim class models a game of Nim
 *
 */
public class Nim
{
  
  // Class Constants -----------------------------------------------------------
  
  /**
   * Smallest number of tokens in a default pile
   */
  public static final int DEFAULT_LOWER = 25;
  
  /**
   * Largest number of tokens in a default pile
   */
  public static final int DEFAULT_UPPER = 375;

  // Instance Variables --------------------------------------------------------
  
  /**
   * Current number of tokens in this game of Nim
   */
  private int numberTokens;
  
  /**
   * Current player in this game of Nim
   */
  private int currentPlayer;
  
  /**
   * Current list of players in this game of Nim
   */
  private ArrayList<Player> players;
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Creates Nim game with one Human player, one random Computer player, and a 
   * random number of tokens within the default bounds
   */
  public Nim() 
  {
    this(new Player(), new Player(Player.COMPUTER),
         SingleRandom.getInstance().nextInt(DEFAULT_LOWER, DEFAULT_UPPER));
  }
  
  /**
   * Creates Nim game with random types, and a 
   * random number of tokens within the default bounds
   * @param playerType - any type or just computer players
   */  
  public Nim(int playerType)
  {
    this(new Player(playerType), new Player(playerType),
         SingleRandom.getInstance().nextInt(DEFAULT_LOWER, DEFAULT_UPPER));
  }
  
  /**
   * Creates Nim game with two given players, and a given
   * number of tokens
   * All other constructors chain to here
   * @param p1 - player 1
   * @param p2 - player 2
   * @param - numberTokens in pile to start
   */  
  public Nim(Player p1, Player p2, int numberTokens)
  {
    players = new ArrayList<Player>();
    players.add(p1);
    players.add(p2);
    this.numberTokens = numberTokens; 
    currentPlayer = SingleRandom.getInstance().nextInt(players.size());
  }
  
  // Predicates ----------------------------------------------------------------
  
  /**
   * Determines whether or not this game is over
   * @return true when this game is over, false otherwise
   */
	public boolean gameIsNotOver() 
	{
		return numberTokens > 0;
	}
	
	// Accessors -----------------------------------------------------------------
	
	/**
	 * Gets current number of tokens remaining in this game of Nim
	 * @return current number of tokens
	 */
	public int getNumberTokens()
	{
	  return numberTokens;
	}
	
	/**
	 * Gets index of current player in this game of Nim
	 * @return index of current player in this game
	 */
	public int getCurrentPlayer()
	{
	  return currentPlayer;
	}
	
	/**
	 * Gets specific player in this game of Nim from players ArrayList given index
	 * @param index - 0 represents Player 1, 1 represents Player 2
	 * @return given player in this game of Nim
	 */
	public Player getPlayer(int index)
	{
	  return players.get(index);
	}
  
  // Mutators ------------------------------------------------------------------
  	
	/**
	 * Gets index of other player (not current player) in this game of Nim
	 * @return Player who has next turn
	 */
	public int getNextPlayer()
	{
	    return (currentPlayer+1) % players.size();
	}
	
	/**
	 * Sets index of next player in this game of Nim
	 */
	public void setNextPlayer()
	{
	  currentPlayer = (++currentPlayer) % players.size();
	}
	
	/**
	 * Remove given number of tokens from pile in this game of Nim
	 * @param removed
	 */
	public void removeTokens(int removed)
	{
	  numberTokens -= removed;
	}
	
	/**
	 * Have current player determine how many tokens to take
	 */
	public void takeTurn()
	{
	  takeTurn(getPlayer(getCurrentPlayer()).takeTurn(getNumberTokens()));
	  //removeTokens(getPlayer(getCurrentPlayer()).takeTurn(getNumberTokens()));
	}
	
	/**
	 * Overloaded method that removes given number of tokens from pile
	 * @param pending
	 */
	public void takeTurn(int pending)
	{
	  removeTokens(pending);
	}
  
  // Overridden Object class methods -------------------------------------------
  	
	/**
	 * Overridden Object class method that returns formatted string representation
	 *   of current state of this object
	 * @return formatted string representation of this object
	 */
	@Override
	public String toString()
  {
    return String.format(
      "%s:%ncurrent player is %s%nnumber of tokens left is %d",
      getClass().getName(),
      players.get(currentPlayer),
      numberTokens);
  }
	
	// Class methods -------------------------------------------------------------
	
	/**
	 * Creates an instance of this object (with random players and a random number 
	 *   of tokens within default bounds) with which to play a console version of
	 *   Nim
	 * @param args
	 */
	public static void main(String[] args) 
	{ 
	  
	  Player.addStrategy(new Cheat()); //exercise new method in the Player class
	  // Create Nim game object
	  // Note that since it is a local variable, it must be defined as final so
	  //   that the inner class methods have access to it
	  final Nim nim = new Nim(Player.ANY); // create Nim game object
	  
	  // Inner class -------------------------------------------------------------
	  
	  /**
	   * This inner class provides console output methods
	   * @author Rose Williams
	   *
	   */
	  class ConsoleOutput
	  {
	    /**
	     * Displays players with respect to turn
	     */
  	  public void showWhoIsFirst()
  	  {
  	    JOptionPane.showMessageDialog(null, 
  	      nim.getPlayer(
  	        nim.getCurrentPlayer()) + " will take the first turn \n" +
  	        nim.getPlayer(nim.getNextPlayer())    + " will take the next turn");
  	  }
  	  
      /**
       * Displays winner and loser
       */
  	  public void displayResults()
  	  {
  	    JOptionPane.showMessageDialog(null, 
  	      nim.getPlayer(
  	        nim.getCurrentPlayer()) + " took last token, and is the loser\n" +
  	        nim.getPlayer(nim.getNextPlayer()) + " is the winner!");
  	  }
  	  
  	  /**
  	   * Display state of game
  	   */
  	  public void displayState()
  	  {
  	    System.out.println(nim);
  	  }
	  }
	  // End Inner Class----------------------------------------------------------

	  // Create object for displaying output
	  ConsoleOutput output = new ConsoleOutput();
	  // Play game
	  output.displayState();
	  output.showWhoIsFirst(); // Display order of play
    nim.takeTurn(); 
	  while(nim.gameIsNotOver())
	  {
	    nim.setNextPlayer();
	    nim.takeTurn();
	    output.displayState();
	  }	 
	  output.displayResults();
	}	
}
