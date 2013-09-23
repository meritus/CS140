package characters;

import java.io.IOException;
import java.util.Random;
import java.util.logging.*;

import utility.SingleRandom;
import repository.Names;

/**
 * A monster character
 * 
 * @author Edison
 * 
 */
public class Monster
{

	private int sacks;
	private double strength, health;
	private String name;
	private static int counter = 0;
	private int id;
	private Logger log;
	private Handler handler;

	public final static double HEALTH_SCALE = 100.0;
	public final static double STRENGTH_SCALE = 10.0;
	public static final int MAX_HEALTH_POSSIBLE = (int) HEALTH_SCALE;
	public static final int MAX_STRENGTH_POSSIBLE = (int) STRENGTH_SCALE;
	public final double MAX_HEALTH;
	public final double MAX_STRENGTH;
	public static final int NUMBER_SACKS_TO_WIN = 10;
	public static final int MAX_SACKS_TO_START = 10;
	
	/**
	 * Creates a Monster with the following specs
	 */
	public Monster()
	{
		this(Names.getInstance().takeNames());
	}
	
	/**
	 * Creates a Monster with random strength and health
	 * @param name of the Monster
	 */
	public Monster(String name)
	{
		this(name, SingleRandom.getInstance().nextInt(MAX_SACKS_TO_START+1), SingleRandom.getInstance().nextInt(MAX_HEALTH_POSSIBLE)+1, SingleRandom.getInstance().nextInt(MAX_STRENGTH_POSSIBLE)+1);
	}

	/**
	 * Creates a Monster with the inputed stats
	 * @param name
	 * @param sacks
	 * @param health
	 * @param strength
	 */
	public Monster(String name, int sacks, double health, double strength)
	{
		counter++;
		id = counter;
		try
		{
			handler = new FileHandler("Monster" + id + ".txt");
			handler.setFormatter(new SimpleFormatter());
		} catch (IOException e)
		{
			e.printStackTrace();

		}
		log = Logger.getLogger("Monster" + id);
		log.addHandler(handler);
		log.setLevel(Level.ALL);
		this.sacks = Math.min(Math.max(sacks, 0), MAX_SACKS_TO_START);
		this.strength = Math.max(Math.min(strength, MAX_STRENGTH_POSSIBLE), 1);
		this.health = Math.max(Math.min(health, MAX_HEALTH_POSSIBLE), 1);
		this.name = name;
		MAX_HEALTH = Math.min(Math.max(health, 0), MAX_HEALTH_POSSIBLE);
		MAX_STRENGTH = Math.min(Math.max(strength, 0), MAX_STRENGTH_POSSIBLE);
	}

	// Accessor methods
	public double getStrength()
	{
		return strength;
	}

	public int getSacks()
	{
		return sacks;
	}

	public double getHealth()
	{
		return health;
	}

	public String getName()
	{
		return name;
	}

	// mutators
	public void setHealth(double health)
	{
		this.health = Math.min(Math.max(health, 0), MAX_HEALTH);
	}

	public void setStrength(double strength)
	{
		this.strength = Math.min(Math.max(strength, 0), MAX_STRENGTH);
	}

	public void setSacks(int sacks)
	{
		this.sacks = Math.min(Math.max(sacks, 0), MAX_SACKS_TO_START);
	}

	public void resetHealth()
	{
		this.health = MAX_HEALTH;
	}

	public void resetStrength()
	{
		this.strength = MAX_STRENGTH;
	}

	public void restoreHealth()
	{
		this.health = Math
				.min(MAX_HEALTH / STRENGTH_SCALE + health, MAX_HEALTH);
	}

	public void restoreStrength()
	{
		this.strength = Math.min(
				0.5 * MAX_STRENGTH / STRENGTH_SCALE + strength, MAX_STRENGTH);
	}

	public void reduceStrength()
	{
		this.strength = Math.max(
				strength - 0.5 * MAX_STRENGTH / STRENGTH_SCALE, 0);
	}

	/**
	 * gives one more sack
	 */
	public void incrementSacks()
	{
		sacks++;
	}

	/**
	 * removes one sack
	 */
	public void decrementSacks()
	{
		if(hasSacks())
			sacks--;
	}

	/**
	 * tests if Monster has sacks
	 * 
	 * @return true if sacks > 0
	 */
	public boolean hasSacks()
	{
		return sacks > 0;
	}

	/**
	 * tests if Monster has any strength
	 * 
	 * @return true if strength >0
	 */
	public boolean hasStrength()
	{
		return strength > 0.0;
	}

	/**
	 * tests if Monster is
	 * 
	 * @return true if health>0
	 */
	public boolean hasHealth()
	{
		return health > 0.0;
	}

	/**
	 * damages the Monster
	 * @param force the amount of damage
	 */
	public void sufferPoke(double force)
	{
		this.health = Math.max(health - force, 0);
		this.strength = Math.max(strength - force / STRENGTH_SCALE, 0);
	}

	/**
	 * @return a value to damage the Adventurer
	 */
	public double terrifyAdventurer()
	{
		log.info("Force of terrify = " + (strength/HEALTH_SCALE * health));
		return strength / HEALTH_SCALE;
	}

	public String toString()
	{
		return String.format("Name:  %s\nSacks:\t\t%d\nHealth:\t\t%.1f\nStrength:\t%.1f\n",
				name, sacks, health, strength);
	}

}
