package nim;

/**
 * This interface is used to encapsulate the strategy employed by a player in 
 *   the game of Nim
 *
 */
interface PlayStrategy 
{
	int takeTurn(int currentState);
	String toString();
}