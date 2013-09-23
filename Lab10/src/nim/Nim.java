package nim;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import utility.SingleRandom;

/**
 * The game logic
 * 
 */
public class Nim
{
	/**
	 * number of players
	 */
	public static final int NUMBER_PLAYERS = 2;
	/**
	 * default lower
	 */
	public static final int DEFAULT_LOWER = 25;
	/**
	 * default upper
	 */
	public static final int DEFAULT_UPPER = 375;
	/**
	 * integer representing 1?
	 */
	public static final int ONE = 1;
	/**
	 * integer representing 2?
	 */
	public static final int TWO = 2;
	/**
	 * GUI Human Strategy
	 */
	public static final int GUI_HUMAN_STRATEGY = 0;
	/**
	 * Human Strategy
	 */
	public static final int HUMAN_STRATEGY = 1;

	/**
	 * number of tokens
	 */
	private int numberTokens;
	/**
	 * current player
	 */
	private int currentPlayer;

	/**
	 * list of strategies
	 */
	private static ArrayList<PlayStrategy> strategies;
	static
	{
		strategies = new ArrayList<PlayStrategy>();
		strategies.add(new GUIHuman());// Just a placeholder - does nothing
		strategies.add(new Human());
		strategies.add(new Frugal());
		strategies.add(new Greedy());
		strategies.add(new Guess());
		strategies.add(new Smart());
	}

	/**
	 * players
	 */
	private ArrayList<Player> players;

	/**
	 * default constructor
	 */
	public Nim()
	{
		this(strategies.get(SingleRandom.getInstance().nextInt(1,
				strategies.size() - 1)), strategies.get(SingleRandom
				.getInstance().nextInt(1, strategies.size() - 1)), SingleRandom
				.getInstance().nextInt(DEFAULT_LOWER, DEFAULT_UPPER));
	}

	/**
	 * constructor
	 * @param strategyIndex
	 */
	public Nim(int strategyIndex)
	{
		this(strategies.get(strategyIndex), strategies.get(SingleRandom
				.getInstance().nextInt(2, strategies.size() - 1)), SingleRandom
				.getInstance().nextInt(DEFAULT_LOWER, DEFAULT_UPPER));
	}

	/**
	 * constructor
	 * @param pS1
	 */
	public Nim(PlayStrategy pS1)
	{
		this(pS1, strategies.get(SingleRandom.getInstance().nextInt(2,
				strategies.size() - 1)), SingleRandom.getInstance().nextInt(
				DEFAULT_LOWER, DEFAULT_UPPER));
	}

	/**
	 * constructor
	 * @param pS1
	 * @param numberTokens
	 */
	public Nim(PlayStrategy pS1, int numberTokens)
	{
		this(pS1, strategies.get(SingleRandom.getInstance().nextInt(1,
				strategies.size() - 1)), numberTokens);
	}

	/**
	 * constructor
	 * @param pS1
	 * @param pS2
	 */
	public Nim(PlayStrategy pS1, PlayStrategy pS2)
	{
		this(pS1, pS2, SingleRandom.getInstance().nextInt(DEFAULT_LOWER,
				DEFAULT_UPPER));
	}
	/**
	 * constructor
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
	 * predicate
	 * @return
	 */
	public boolean gameIsNotOver()
	{
		return numberTokens > 0;
	}
	/**
	 * getter
	 * @return
	 */
	public int getNumberTokens()
	{
		return numberTokens;
	}
	/**
	 * getter
	 * @return
	 */
	public int getCurrentPlayer()
	{
		return currentPlayer;
	}
	/**
	 * getter
	 * @param index
	 * @return
	 */
	public Player getPlayer(int index)
	{
		return players.get(index);
	}
	/**
	 * getter
	 * @return
	 */
	public int getNextPlayer()
	{
		return (++currentPlayer) % players.size();
	}
	/**
	 * mutator
	 */
	public void setNextPlayer()
	{
		currentPlayer = (++currentPlayer) % players.size();
	}
	/**
	 * mutator
	 * @param removed
	 */
	public void removeTokens(int removed)
	{
		numberTokens -= removed;
	}
	/**
	 * mutator
	 */
	public void takeTurn()
	{
		removeTokens(getPlayer(getCurrentPlayer()).takeTurn(getNumberTokens()));
	}
	/**
	 * mutator
	 * @param pending
	 */
	public void takeTurn(int pending)
	{
		removeTokens(pending);
	}
	/**
	 * shows message
	 */
	public void showWhoIsFirst()
	{
		JOptionPane.showMessageDialog(null, getPlayer(getCurrentPlayer())
				+ " will take the first turn \n" + getPlayer(getNextPlayer())
				+ " will take the next turn");
	}
	
	/**
	 * shows message
	 */
	public void displayResults()
	{
		JOptionPane.showMessageDialog(null, getPlayer(getCurrentPlayer())
				+ " took last token, and is the loser\n"
				+ getPlayer(getNextPlayer()) + " is the winner!");
	}
	
	public static void main(String[] args)
	{
		Nim nim = new Nim();
		nim.showWhoIsFirst();
		nim.setNextPlayer(); // flip player twice
		while (nim.gameIsNotOver())
		{
			nim.setNextPlayer();
			nim.takeTurn();
			System.out.println(nim);
		}
		nim.displayResults();
	}
	
	/**
	 * returns a string representation
	 */
	public String toString()
	{
		return String.format(
				"%s:%ncurrent player is %s%nnumber of tokens left is %d",
				getClass().getName(), players.get(currentPlayer), numberTokens);
	}
}
