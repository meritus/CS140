package nim;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JOptionPane;
import utility.SingleRandom;

/**
 * This class represents a game of nim
 * @author Michelle Hochman
 *
 */
public class Nim extends Observable
{
	  /**
	   * constant for number of players
	   */
  public static final int NUMBER_PLAYERS = 2;
  /**
   * constant for lower
   */
  public static final int DEFAULT_LOWER = 25;
  /**
   * constant for upper
   */
  //public static final int DEFAULT_UPPER = 375;
  public static final int DEFAULT_UPPER = 50;
  /**
   * constant for 1
   */
  public static final int ONE = 1;
  /**
   * constant for 2
   */
  public static final int TWO = 2;
  /**
   * constant for gui strategy
   */
  public static final int GUI_HUMAN_STRATEGY = 0;
  /**
   * constant for human strategy
   */
  public static final int HUMAN_STRATEGY = 1;
  /**
   * constant for computer strategy
   */
  public static final int COMPUTER_STRATEGIES = 2; //2 and higher
  //public static final int PLAYER2 = 1;

  /**
   * number of tokens
   */
  private int numberTokens; 
  /**
   * current player id
   */
  private int currentPlayer;
  
  /**
   * 
   */
  private static ArrayList<PlayStrategy> strategies;
  static
  {
    strategies = new ArrayList<PlayStrategy>();
    strategies.add(new GUIHuman());//Just a placeholder - does nothing
    strategies.add(new Human());
    strategies.add(new Frugal());
    strategies.add(new Greedy());
    strategies.add(new Guess());
    strategies.add(new Smart());
  }
  
  /**
   * array list of players
   */
  private ArrayList<Player> players;
  
  /**
   * default constructor for the nim class
   */
  public Nim()
  {
    this(
         strategies.get(SingleRandom.getInstance().nextInt(
           HUMAN_STRATEGY, strategies.size()-1)),
         strategies.get(SingleRandom.getInstance().nextInt(
           HUMAN_STRATEGY, strategies.size()-1)),
        SingleRandom.getInstance().nextInt(DEFAULT_LOWER, DEFAULT_UPPER)
        );
  }
  
  /**
   * constructor for the nim class taking in a strategy index
   * @param strategyIndex
   */
  public Nim(int strategyIndex)
  {
    this(
         strategies.get(strategyIndex), //Assume GUI_HUMAN or HUMAN
         strategies.get(
           SingleRandom.getInstance().nextInt(COMPUTER_STRATEGIES, 
                strategies.size()-1)),
         SingleRandom.getInstance().nextInt(DEFAULT_LOWER, DEFAULT_UPPER)
        );
  }
  
  /**
   * constructor for the nim class taking in a play strategy
   * @param pS1
   */
  public Nim(PlayStrategy pS1)
  {
    this(
         pS1,
         strategies.get(SingleRandom.getInstance().nextInt(
             HUMAN_STRATEGY, strategies.size()-1)),
         SingleRandom.getInstance().nextInt(DEFAULT_LOWER, DEFAULT_UPPER)
        );    
  }
  
  /**
   * constructor for the nim class taking in a play strategy and the number
   * of tokens
   * @param pS1
   * @param numberTokens
   */
  public Nim(PlayStrategy pS1, int numberTokens)
  {
    this(
         pS1,
         strategies.get(SingleRandom.getInstance().nextInt(
           HUMAN_STRATEGY, strategies.size()-1)),
         numberTokens
        ); 
  }
  
  /**
   * constructor for the nim class taking in two play strategies
   * @param pS1
   * @param pS2
   */
  public Nim(PlayStrategy pS1, PlayStrategy pS2)
  {
    this(
         pS1, 
         pS2, 
         SingleRandom.getInstance().nextInt(DEFAULT_LOWER, DEFAULT_UPPER)
        );
  }
  
  /**
   * constructor for the nim class taking in two play strategies and the
   * number of tokens
   * @param pS1
   * @param pS2
   * @param numberTokens
   */
  public Nim(PlayStrategy pS1, PlayStrategy pS2, int numberTokens)
  {
    players = new ArrayList<Player>();
    players.add(new Player(ONE, pS1));
    players.add(new Player(TWO, pS2));
    this.numberTokens = numberTokens; 
    currentPlayer = SingleRandom.getInstance().nextInt(players.size());
  }
  
  /**
   * predicate for game being over
   * @return
   */
	public boolean gameIsNotOver() 
	{
		return numberTokens > 0;
	}
	
	/**
	 * accessor for number of tokens
	 * @return
	 */
	public int getNumberTokens()
	{
	  return numberTokens;
	}
	
	/**
	 * accessor for current player
	 * @return
	 */
	public int getCurrentPlayer()
	{
	  return currentPlayer;
	}
	
	/**
	 * accessor for player
	 * @param index
	 * @return player
	 */
	public Player getPlayer(int index)
	{
	  return players.get(index);
	}
	
	/**
	 * accessor for next player
	 * @return next player
	 */
	public int getNextPlayer()
	{
	    return (++currentPlayer) % players.size();
	}
	
	/**
	 * mutator for setting the next player
	 */
	public void setNextPlayer()
	{
		setChanged();
		notifyObservers("Next");
	    currentPlayer = (++currentPlayer) % players.size();
	}
	
	/**
	 * mutator for removing tokens from numberTokens
	 * @param removed
	 */
	public void removeTokens(int removed)
	{
		setChanged();
		notifyObservers("Remove");
	    numberTokens -= removed;
	}
	
	public void newGame()
	{
		setChanged();
		notifyObservers("New");
	}
	
	/**
	 * mutator taking a turn
	 */
	public void takeTurn()
	{
	  removeTokens(getPlayer(getCurrentPlayer()).takeTurn(getNumberTokens()));
	}
	
	/**
	 * mutator for taking a turn
	 * @param pending
	 */
	public void takeTurn(int pending)
	{
	  removeTokens(pending);
	}
	
	/**
	 * mutator for showing who is first
	 */
	public void showWhoIsFirst()
	{
	   JOptionPane.showMessageDialog(null, 
	     getPlayer(getCurrentPlayer()) + " will take the first turn \n" +
	     getPlayer(getNextPlayer()) + " will take the next turn");
	}
	
	/**
	 * mutator for displaying the result
	 */
	public void displayResults()
	{
	  JOptionPane.showMessageDialog(null, 
	    getPlayer(getCurrentPlayer()) + " took last token, and is the loser\n" +
	    getPlayer(getNextPlayer()) + " is the winner!");
	}
		
	/**
	 * main method uses the default constructor to randomly generate a 
	 * PlayStrategy for each player by drawing from a collection of 
	 * PlayStrategy objects
	 * @param args
	 */
	public static void main(String[] args) 
	{ 
	  Nim nim = new Nim();
	  nim.showWhoIsFirst();
    nim.setNextPlayer(); //flip player twice
	  while(nim.gameIsNotOver())
	  {
	    nim.setNextPlayer();
	    nim.takeTurn();
	    System.out.println(nim);
	  }	 
	  nim.displayResults();
	}
	
	/**
	 * return a String representation of the class name
	 */
	public String toString()
	{
	  return 
	    String.format(
	        "%s:%ncurrent player is %s%nnumber of tokens left is %d",
	        getClass().getName(),
	        players.get(currentPlayer),
	        numberTokens	        
	      );
	}
}
