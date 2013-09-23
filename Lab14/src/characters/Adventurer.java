package characters;

import repository.AdventurerNames;
import utility.SingleRandom;

/**
 * An adventurer character
 * 
 * @author Edison Liu
 * 
 */
public class Adventurer extends Character
{
	/**
	 * winning number of sacks
	 */
	public static final int NUMBER_SACKS_TO_WIN = 10;
	

	/**
	 * Creates a Adventurer with the following specs
	 */
	public Adventurer()
	{
		this(AdventurerNames.getInstance().takeNames());
	}

	/**
	 * Creates a Adventurer with a given name and random strength and health
	 * 
	 * @param name
	 */
	public Adventurer(String name)
	{
		this(name, SingleRandom.getInstance().nextInt(MAX_HEALTH_POSSIBLE) + 1,
				SingleRandom.getInstance().nextInt(MAX_STRENGTH_POSSIBLE) + 1);
	}

	/**
	 * Creates a Adventurer with the given stats and 0 sacks
	 * 
	 * @param name
	 * @param health
	 * @param strength
	 */
	public Adventurer(String name, double health, double strength)
	{
		super(name, 0, health, strength);
		
	}

	/**
	 * Returns force of poke
	 * @return power of poke
	 */
	public double pokeMonster()
	{
		log.info("Force of poke = " + (getStrength() / HEALTH_SCALE * getHealth()));
		return (getStrength() / HEALTH_SCALE) * getHealth();
	}

	/**
	 * Suffers from monster terror
	 * @param force force to suffer
	 */
	public void sufferTerror(double force)
	{
		setHealth(Math.max(getHealth() - force, 0));
		setStrength(Math.max(getStrength() - STRENGTH_SCALE, 0));
	}

	/**
	 * Determines if character is winner
	 * @return true if character has won
	 */
	public boolean hasSacksToWin()
	{
		return getSacks() >= NUMBER_SACKS_TO_WIN;
	}

}
