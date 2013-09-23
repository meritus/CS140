package characters;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import utility.MathHelper;

/**
 * An adventurer character
 * 
 * @author Edison
 * 
 *         Invariant (getStrength() > 0) (getSacks() > 0)
 */
public class Character
{

	/**
	 * highest health can be
	 */
	public static final double HEALTH_SCALE = 100.0;
	/**
	 * highest strength can be
	 */
	public static final double STRENGTH_SCALE = 10.0;
	/**
	 * max health
	 */
	public static final int MAX_HEALTH_POSSIBLE = (int) HEALTH_SCALE;
	/**
	 * max strength
	 */
	public static final int MAX_STRENGTH_POSSIBLE = (int) STRENGTH_SCALE;

	/**
	 * max health for instance
	 */
	public final double MAX_HEALTH;
	/**
	 * max strength for instance
	 */
	public final double MAX_STRENGTH;

	/**
	 * number of sacks
	 */
	private int sacks;
	/**
	 * strength
	 */
	private double strength;
	/**
	 * health
	 */
	private double health;
	/**
	 * name of character
	 */
	private String name;

	/**
	 * keeps track of how many Adventurers are made
	 */
	private static int counter = 0;
	/**
	 * Individual id of Adventurer
	 */
	private int id;
	/**
	 * Provides logging functionality
	 */
	protected Logger log;
	/**
	 * Handles requests
	 */
	private Handler handler;

	/**
	 * Explicit constructor
	 * 
	 * @param name
	 * @param sacks
	 * @param health
	 * @param strength
	 */
	public Character(String name, int sacks, double health, double strength)
	{
		MAX_HEALTH = MathHelper.setBounds(0, MAX_HEALTH_POSSIBLE, health);
		MAX_STRENGTH = MathHelper.setBounds(0, MAX_STRENGTH_POSSIBLE, strength);
		this.sacks = MathHelper.setBounds(0, sacks);
		this.strength = MAX_STRENGTH;
		this.health = MAX_HEALTH;
		this.name = name;
		counter++;
		id = counter;
		try
		{
			handler = new FileHandler("Adventurer" + id + ".txt");
			handler.setFormatter(new SimpleFormatter());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		log = Logger.getLogger("Adventurer" + id);
		log.addHandler(handler);
		log.setLevel(Level.ALL);
		log.info("Create Adventurer #" + id + this);
	}

	/**
	 * returns strength
	 * 
	 * @return
	 */
	public double getStrength()
	{
		return strength;
	}

	/**
	 * returns number of sacks
	 * 
	 * @return
	 */
	public int getSacks()
	{
		return sacks;
	}

	/**
	 * returns health
	 * 
	 * @return
	 */
	public double getHealth()
	{
		return health;
	}

	/**
	 * returns name
	 * 
	 * @return
	 */
	public String getName()
	{
		return name;
	}

	/**
	 * Sets health while keeping in bounds
	 * 
	 * @param health
	 */
	public void setHealth(double health)
	{
		this.health = MathHelper.setBounds(0, MAX_HEALTH, health);
	}

	/**
	 * Sets strength while keeping in bounds
	 * 
	 * @param strength
	 */
	public void setStrength(double strength)
	{
		this.strength = MathHelper.setBounds(0, MAX_STRENGTH, strength);
	}

	/**
	 * Adds once sack
	 */
	public void incrementSacks()
	{
		sacks++;
	}

	/**
	 * Removes one sack only if Adventurer has sacks
	 */
	public void decrementSacks()
	{
		if (hasSacks())
			sacks--;
	}

	/**
	 * Sets amount of sacks
	 * 
	 * @param sacks
	 *            amount to set sacks
	 */
	public void setSacks(int sacks)
	{
		this.sacks = MathHelper.setBounds(0, sacks);
	}

	/**
	 * Sets health back to normal
	 */
	public void resetHealth()
	{
		this.health = MAX_HEALTH;
	}

	/**
	 * Sets strength back to normal
	 */
	public void resetStrength()
	{
		this.strength = MAX_STRENGTH;
	}

	/**
	 * Restores health
	 */
	public void restoreHealth()
	{
		this.health = Math
				.min(MAX_HEALTH / STRENGTH_SCALE + health, MAX_HEALTH);
	}

	/**
	 * Restores strength
	 */
	public void restoreStrength()
	{
		this.strength = Math.min(
				0.5 * MAX_STRENGTH / STRENGTH_SCALE + strength, MAX_STRENGTH);
	}

	/**
	 * Reduces strength based on formula
	 */
	public void reduceStrength()
	{
		this.strength = Math.max(
				strength - 0.5 * MAX_STRENGTH / STRENGTH_SCALE, 0);
	}

	/**
	 * tests if Adventurer has sacks
	 * 
	 * @return true if sacks > 0
	 */
	public boolean hasSacks()
	{
		return sacks > 0.0;
	}

	/**
	 * tests if user has any strength
	 * 
	 * @return true if strength >0
	 */
	public boolean hasStrength()
	{
		return strength > 0.0;
	}

	/**
	 * tests if user is stun
	 * 
	 * @return true if health>0
	 */
	public boolean hasHealth()
	{
		return health > 0.0;
	}

	/**
	 * Returns a string representation of the character
	 */
	@Override
	public String toString()
	{
		return String.format(
				"%s \nName:  %s\nID: %d\nSacks:\t\t%d\nHealth:\t\t%.1f\n"
						+ "Strength:\t%.1f\n", getClass().getName(), name, id,
				sacks, health, strength);
	}
}
