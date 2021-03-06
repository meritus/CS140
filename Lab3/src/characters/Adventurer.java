package characters;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * 
 * @author Edison
 * 
 */
public class Adventurer {

	private int sacks;
	private double strength, health;
	private String name;
	private static int counter = 0;
	private int id;
	private Logger log;
	private Handler handler;
	
	
	final static double HEALTH_SCALE=100.0;
	final static double STRENGTH_SCALE=10.0;
	public static final int MAX_HEALTH_POSSIBLE=(int)HEALTH_SCALE;
	public static final int MAX_STRENGTH_POSSIBLE=(int)STRENGTH_SCALE;
	public final double MAX_HEALTH;
	public final double MAX_STRENGTH;
	public static final int NUMBER_SACKS_TO_WIN = 10;
	public static final int MAX_SACKS_TO_START = 10;
	

	public Adventurer(){
		this("Anonymous", 100.0, 10.0);	
	}

	public Adventurer(String name, double health, double strength) 
	{
		counter++;
		id = counter;
		try{
			handler = new FileHandler("Adventurer" + id + ".txt");
			handler.setFormatter(new SimpleFormatter());
		}
		catch(IOException e){
			e.printStackTrace();
			log = Logger.getLogger("Adventurer"+id);
			log.addHandler(handler);
			log.setLevel(Level.ALL);
		}
		
		this.sacks = 0;
		this.strength = Math.max(Math.min(strength,MAX_STRENGTH_POSSIBLE),1);
		this.health = Math.max(Math.min(health,MAX_HEALTH_POSSIBLE),1);
		this.name = name;
		MAX_HEALTH = Math.min(Math.max(health,0), MAX_HEALTH_POSSIBLE);
		MAX_STRENGTH = Math.min(Math.max(strength,0), MAX_STRENGTH_POSSIBLE);
	}

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

	public void setHealth(double health) 
	{
		this.health = Math.min(Math.max(health,0), MAX_HEALTH);
	}

	public void setStrength(double strength) 
	{
		this.strength = Math.min(Math.max(strength,0), MAX_STRENGTH);
	}

	public void incrementSacks() 
	{
		sacks++;
	}

	public void decrementSacks() 
	{
		sacks--;
	}

	public void setSacks(int sacks){
		this.sacks=Math.min(Math.max(sacks, 0), NUMBER_SACKS_TO_WIN);
	}

	public void resetHealth(){
		this.health=MAX_HEALTH;
	}

	public void resetStrength(){
		this.strength=MAX_STRENGTH;
	}

	public void restoreHealth(){
		this.health=Math.min(MAX_HEALTH/STRENGTH_SCALE+health, MAX_HEALTH);
	}

	public void restoreStrength(){
		this.strength=Math.min(0.5*MAX_STRENGTH/STRENGTH_SCALE+strength, MAX_STRENGTH);
	}

	public void reduceStrength(){
		this.strength=Math.max(strength-0.5*MAX_STRENGTH/STRENGTH_SCALE, 0);
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

	public double pokeMonster(){
		return (strength/HEALTH_SCALE)*health;	
	}

	public void sufferTerror(double force){
		this.health=Math.max(health-force,0);	
		this.strength=Math.max(strength-STRENGTH_SCALE,0);
	}

	public String toString(){
		return "Name:  "+name+"\nHealth: \t\t"+health+"\nStrength:\t\t "+strength+"\nSacks: \t\t\t"
			+sacks;
	}

	public boolean hasSacksToWin(){
		return sacks>=NUMBER_SACKS_TO_WIN;
	}

}
