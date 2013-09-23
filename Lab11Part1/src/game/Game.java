package game;

import characters.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * This class serves as the MODEL in the NewZorkGUI It is a game that pits a
 * single adventurer against a single monster Note that each method delegates
 * its job to other objects (i.e., this game class is a wrapper that uses a
 * portion of the Zork classes)
 * 
 * 
 * @author Rose Williams
 * 
 */
public class Game
{
	// Class Variables
	// -----------------------------------------------------------

	/**
	 * Provides logging for our game
	 */
	public static Logger log;
	static
	{
		log = Logger.getLogger("Game");
	}

	// Instance Variables
	// --------------------------------------------------------

	/**
	 * Player's adventurer character. Must steal treasure from monster to win
	 */
	private Adventurer invader;

	/**
	 * Game character that has treasure
	 */
	private Monster citizen;

	// Constructors
	// --------------------------------------------------------------

	/**
	 * Constructs a new game having one adventurer and one monster
	 */
	public Game()
	{
		setUpLogging();
		invader = null;
		citizen = null;
	}

	// Class Methods
	// -------------------------------------------------------------

	/**
	 * Enables or disables logging
	 */
	private static void setUpLogging()
	{
		log.setLevel(Level.ALL);
		// log.setLevel(Level.OFF);
	}

	// Predicate Methods
	// ---------------------------------------------------------

	/**
	 * Determines whether or not an Adventurer has been created
	 * 
	 * @return Adventurer object status
	 */
	public boolean hasAdventurer()
	{
		return invader != null;
	}

	/**
	 * Determines whether or not a Monster has been created
	 * 
	 * @return Monster object status
	 */
	public boolean hasMonster()
	{
		return citizen!=null;
	}

	/**
	 * Determines whether or not this monster has sacks
	 * 
	 * @return true when has sacks, false when no sacks
	 */
	public boolean monsterHasSacks()
	{
		return citizen.hasSacks();
	}

	// Accessor Methods
	// ----------------------------------------------------------

	/**
	 * Returns formatted String representation of this adventurer
	 * 
	 * @return formatted String that represents the state of this adventurer
	 */
	public String aString()
	{
		return invader.toString();
	}

	/**
	 * Returns formatted String representation of this monster
	 * 
	 * @return formatted String that represents the state of this monster
	 */
	public String mString()
	{
		return citizen.toString();
	}

	/**
	 * Causes monster to roar at adventurer and get force of roar
	 * 
	 * @return force of roar
	 */
	public double attackAdventurer()
	{
		return citizen.terrifyAdventurer();
	}

	/**
	 * Causes adventurer to poke monster and gets force of poke
	 * 
	 * @return force of poke
	 */
	public double attackMonster()
	{
		return invader.pokeMonster();
	}

	// Mutator Methods
	// -----------------------------------------------------------
	/**
	 * Creates a new Adventurer
	 */
	public void createNewAdventurer()
	{
		// PLACE YOUR CODE HERE
	}

	/**
	 * Creates a new Monster
	 */
	public void createNewMonster()
	{
		citizen = new Monster();
	}

	/**
	 * Causes adventurer to suffer force of monster's roar
	 * 
	 * @param force
	 *            of monster's roar
	 */
	public void defendAdventurer(double force)
	{
		invader.sufferTerror(force);
		if (!(invader.hasStrength() && invader.hasHealth())
				&& invader.hasSacks())
		{
			// PLACE YOUR CODE HERE
		}
	}

	/**
	 * Causes monster to suffer force of adventurers poke
	 * 
	 * @param force
	 *            of adventurers poke
	 */
	public void defendMonster(double force)
	{
		// PLACE YOUR CODE HERE
		if (!(citizen.hasStrength() && citizen.hasHealth())
				&& citizen.hasSacks())
		{
			citizen.decrementSacks();
			citizen.restoreStrength();
			winRoundAdventurer();
		}
	}

	/**
	 * Causes adventurer to gain a sack of treasure after poking monster
	 */
	public void winRoundAdventurer()
	{
		invader.incrementSacks();
		invader.restoreHealth();
		invader.reduceStrength();
	}

	/**
	 * Causes monster to gain a sack of treasure after terrifying adventurer
	 */
	public void winRoundMonster()
	{
		// PLACE YOUR CODE HERE
	}

	// Overridden Object Methods
	// -------------------------------------------------
	/**
	 * Returns formatted String version indicating status of game elements
	 * 
	 * @return current state of adventurer and monster objects
	 */
	@Override
	public String toString()
	{
		return "Game Status:  \n" + invader.toString() + "\n"
				+ citizen.toString();
	}
}
