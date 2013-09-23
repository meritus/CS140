package characters;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import utility.SingleRandom;
/**
 * 
 * @author Edison
 * 
 */
public class Adventurer
{

	private int sacks;
	private double strength, health;
	private String name;
	private static int counter = 0;
	private int id;
	private Logger log;
	private Handler handler;

	static final double HEALTH_SCALE = 100.0;
	static final double STRENGTH_SCALE = 10.0;
	public static final int MAX_HEALTH_POSSIBLE = (int) HEALTH_SCALE;
	public static final int MAX_STRENGTH_POSSIBLE = (int) STRENGTH_SCALE;
	public final double MAX_HEALTH;
	public final double MAX_STRENGTH;
	public static final int NUMBER_SACKS_TO_WIN = 10;
	public static final int MAX_SACKS_TO_START = 10;

	/**
	 * Creates a Adventurer with the following specs
	 */
	public Adventurer()
	{
		this("Anonymous");
	}

	/**
	 * Creates a Adventurer with a given name and random strength and health
	 * @param name
	 */
	public Adventurer(String name)
	{
		this(name, SingleRandom.getInstance().nextInt(MAX_HEALTH_POSSIBLE)+1,
				SingleRandom.getInstance().nextInt(MAX_STRENGTH_POSSIBLE )+1
			);
	}

	/**
	 * Creates a Adventurer with the given stats and 0 sacks
	 * @param name
	 * @param health
	 * @param strength
	 */
	public Adventurer(String name, double health, double strength)
	{
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
		this.sacks = 0;
		this.strength = Math.max(Math.min(strength, MAX_STRENGTH_POSSIBLE), 1);
		this.health = Math.max(Math.min(health, MAX_HEALTH_POSSIBLE), 1);
		this.name = name;
		MAX_HEALTH = Math.min(Math.max(health, 0), MAX_HEALTH_POSSIBLE);
		MAX_STRENGTH = Math.min(Math.max(strength, 0), MAX_STRENGTH_POSSIBLE);
		log.info("Create Adventurer #" + id + this);
	}

	//Accessor methods
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

	//A few mutators
	public void setHealth(double health)
	{
		this.health = Math.min(Math.max(health, 0), MAX_HEALTH);
	}

	public void setStrength(double strength)
	{
		this.strength = Math.min(Math.max(strength, 0), MAX_STRENGTH);
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
		if(hasSacks())
			sacks--;
	}

	public void setSacks(int sacks)
	{
		this.sacks = Math.min(Math.max(sacks, 0), NUMBER_SACKS_TO_WIN);
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

	public double pokeMonster()
	{
		log.info("Force of poke = " + (strength/HEALTH_SCALE * health));
		return (strength / HEALTH_SCALE) * health;
	}

	public void sufferTerror(double force)
	{
		this.health = Math.max(health - force, 0);
		this.strength = Math.max(strength - STRENGTH_SCALE, 0);
	}

	public String toString()
	{
		return String.format("Name:  %s\nSacks:\t\t%d\nHealth:\t\t%.1f\nStrength:\t%.1f\n",
				name, sacks, health, strength);
	}

	public boolean hasSacksToWin()
	{
		return sacks >= NUMBER_SACKS_TO_WIN;
	}

}
