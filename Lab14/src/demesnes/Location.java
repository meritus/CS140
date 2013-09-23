package demesnes;

/**
 * The Location class describes a place on a 2D map
 * 
 * @author Liu997
 * 
 *         Location is immutable because there are no mutators ie: setColumn()
 *         or setRow()
 * 
 *         We do not need a clone method because the instances of location
 *         cannot be change therefore not risking any unsafe circumstances
 */
public class Location
{
	/**
	 * Holds current column location
	 */
	private int column;
	/**
	 * Holds current row location
	 */
	private int row;

	/**
	 * Default constructor
	 */
	public Location()
	{
		this(0, 0);
	}

	/**
	 * Explicit value constructor
	 */
	public Location(int column, int row)
	{
		this.column = column;
		this.row = row;
	}

	/**
	 * Copy constructor
	 */
	public Location(Location location)
	{
		this(location.getColumn(), location.getRow());
	}

	/**
	 * Copy constructor
	 */
	public Location(Location location, Direction travelDirection)
	{
		this(location.getColumn() + travelDirection.horizontalOffset, location
				.getRow() + travelDirection.verticalOffset);
	}

	/**
	 * Returns current column
	 * 
	 * @return
	 */
	public int getColumn()
	{
		return column;
	}

	/**
	 * Returns current row
	 * 
	 * @return
	 */
	public int getRow()
	{
		return row;
	}

	/**
	 * Tests if location is at origin
	 * 
	 * @return
	 */
	public boolean isOrigin()
	{
		return column == 0 && row == 0;
	}

	/**
	 * Tests another object for equality
	 */
	@Override
	public boolean equals(Object other)
	{
		boolean equal = false;
		if (other.getClass() == getClass())
		{
			Location otherLoc = (Location) other;
			equal = otherLoc.row == row && otherLoc.column == column;
		}
		return equal;
	}

	/**
	 * Returns a hashcode
	 */
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + column;
		result = prime * result + row;
		return result;
	}

	/**
	 * Returns a string representation of the location
	 */
	@Override
	public String toString()
	{
		return String.format("%s: Column:%d, Row:%d", getClass().getName(),
				column, row);
	}

}
