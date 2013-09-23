package nim;

/**
 * Player of the game
 * 
 * 
 */
public class Player
{
	/**
	 * id of the player
	 */
	private int id;
	/**
	 * the strategy of the player
	 */
	private PlayStrategy strategy;

	/**
	 * Constructor
	 * @param id
	 * @param strategy
	 */
	public Player(int id, PlayStrategy strategy)
	{
		this.id = id;
		this.strategy = strategy;
	}

	/**
	 * Returns the strategy of player
	 * @return
	 */
	public PlayStrategy getStrategy()
	{
		return strategy;
	}

	/**
	 * Returns number of tokens to take
	 * @param tokens
	 * @return
	 */
	public int takeTurn(int tokens)
	{
		return strategy.takeTurn(tokens);
	}

	/**
	 * Returns a string representation
	 */
	public String toString()
	{
		return String.format("%s%d:  %s", getClass().getName(), id, strategy);
	}
}
