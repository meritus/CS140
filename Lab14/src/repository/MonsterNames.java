package repository;

public class MonsterNames extends Names
{
	/**
	 * Starting names
	 */
	private static final String[] NAMES = new String[]
	{ "Inky", "Binky", "Blinky", "Dinky", "Jinky", "Pinky", "Slinky", "Stinky",
			"Blimpy", "Gimpy", "Limpy", "Wimpy", "Dorky", "Beeky", "Geeky",
			"Gadget", "Didget", "Fidget", "Gidget", "Widget" };
	/**
	 * Holds the instance of MonsterNames
	 */
	private static final MonsterNames INSTANCE;
	static
	{
		INSTANCE = new MonsterNames();
	}

	/**
	 * Private constructor
	 */
	private MonsterNames()
	{
		super(NAMES);
	}

	/**
	 * Gives reference to a single instance of names - user is unable to create
	 * without
	 * 
	 * @return reference to Names instance
	 */
	public static MonsterNames getInstance()
	{
		return INSTANCE;
	}
}
