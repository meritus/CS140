package nim;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

public interface PlayStrategy 
{

	/**
	 * take in the number of tokens currently in the pile, and return the 
	 * number of tokens to remove
	 * @param size
	 * @return tokens
	 */
	public int takeTurn(int size);
	
	/**
	 * return a String representation of the class name
	 * @return String representation
	 */
	public String toString();
}
