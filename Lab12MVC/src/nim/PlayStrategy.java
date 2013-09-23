package nim;

/**
 * The Strategy that computer players use
 * @author eliu7
 *
 */
public interface PlayStrategy
{
	/**
	 * Returns number of tokens to take
	 * @param size
	 * @return
	 */
	public int takeTurn(int size);
	
	/**
	 * Returns a string representation
	 * @return
	 */
	public String toString();
}
