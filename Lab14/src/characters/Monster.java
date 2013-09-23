package characters;

import utility.SingleRandom;
import repository.MonsterNames;

/**
 * A monster character
 * 
 * @author Edison
 * 
 */
public class Monster extends Character
{
	/**
	 * The maximum amount of sacks to start with
	 */
	public static final int MAX_SACKS_TO_START = 10;
	
	/**
	 * Creates a Monster with a name from the Names repo
	 */
	public Monster()
	{
		this(MonsterNames.getInstance().takeNames());
	}

	/**
	 * Creates a Monster with random strength and health
	 * 
	 * @param name
	 *            of the Monster
	 */
	public Monster(String name)
	{
		this(name, SingleRandom.getInstance().nextInt(MAX_SACKS_TO_START + 1),
				SingleRandom.getInstance().nextInt(MAX_HEALTH_POSSIBLE) + 1,
				SingleRandom.getInstance().nextInt(MAX_STRENGTH_POSSIBLE) + 1);
	}

	/**
	 * Creates a Monster with the inputed stats
	 * 
	 * @param name
	 * @param sacks
	 * @param health
	 * @param strength
	 */
	public Monster(String name, int sacks, double health, double strength)
	{
		super(name, sacks, health, strength);
	}

	/**
	 * damages the Monster
	 * 
	 * @param force
	 *            the amount of damage
	 */
	public void sufferPoke(double force)
	{
		setHealth(Math.max(getHealth() - force, 0));
		setStrength(Math.max(getStrength() - force / STRENGTH_SCALE, 0));
	}

	/**
	 * @return a value to damage the Adventurer
	 */
	public double terrifyAdventurer()
	{
		log.info("Force of terrify = " + (getStrength() / HEALTH_SCALE * getHealth()));
		return getStrength() / HEALTH_SCALE;
	}

}
