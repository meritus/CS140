package demesnes;

/**
 * Represents a chamber
 * 
 * @author Liu997
 * 
 *         It is acceptable for getLocation() to return an alias because
 *         location is immutable and cannot pose a safety risk
 */
public class Chamber
{
	/**
	 * represents no monster
	 */
	public static final int NONE = -1;
	/**
	 * visited status
	 */
	private boolean visited;
	/**
	 * Location of chamber
	 */
	private Location location;
	/**
	 * ID of monster at chamber
	 */
	private int monsterID;

	/**
	 * Default constructor
	 */
	public Chamber()
	{
		this(new Location(0, 0), NONE);
	}

	/**
	 * Explict value constructor
	 * 
	 * @param location
	 * @param visited
	 * @param monsterID
	 */
	public Chamber(Location location, int monsterID)
	{
		this.location = location;
		this.monsterID = monsterID;
	}

	/**
	 * Location of chamber
	 * 
	 * @return
	 */
	public Location getLocation()
	{
		return location;
	}

	/**
	 * Monster at chamber
	 * 
	 * @return
	 */
	public int getMonsterID()
	{
		return monsterID;
	}

	/**
	 * Status of chamber
	 * 
	 * @return
	 */
	public boolean hasVisited()
	{
		return visited;
	}

	/**
	 * Tests for monster
	 * 
	 * @return
	 */
	public boolean hasMonster()
	{
		return monsterID != NONE;
	}

	/**
	 * Tests for origin
	 * 
	 * @return
	 */
	public boolean isOrigin()
	{
		return location.isOrigin();
	}

	/**
	 * Sets chamber as visited
	 */
	public void setVisited()
	{
		visited = true;
	}

	/**
	 * Returns a string representation of chamber
	 */
	public String toString()
	{
		return String.format("%s: Visited:%b, Location:%s, %s",
				getClass().getName(), visited,
				"(" + location.getColumn() + ","+ location.getRow() + ")",
				monsterID == -1 ? "Has no monster"
				: "Has monster with id of" + monsterID);
	}
}
