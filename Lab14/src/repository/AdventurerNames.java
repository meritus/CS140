package repository;

public class AdventurerNames extends Names
{
	/**
	 * Starting names
	 */
	private static final String[] NAMES = new String[]
	{ "Thutmose", "Darius", "Alexander", "Ch'in", "Pompey", "Julius",
	      "Atilla", "Charlemagne", "Hrorekr", "Genghis", "Napoleon", "Naughty" };
	/**
	 * Holds the instance of MonsterNames
	 */
	private static final AdventurerNames INSTANCE;
	static
	{
		INSTANCE = new AdventurerNames();
	}

	/**
	 * Private constructor
	 */
	private AdventurerNames()
	{
		super(NAMES);
	}

	/**
	 * Gives reference to a single instance of names - user is unable to create
	 * without
	 * 
	 * @return reference to Names instance
	 */
	public static AdventurerNames getInstance()
	{
		return INSTANCE;
	}
}
