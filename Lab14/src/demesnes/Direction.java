package demesnes;

/**
 * Direction of character
 * @author Liu997
 *
 */
public enum Direction
{
	NORTH(0, 1)
	{
		@Override
		public Direction next()
		{
			return EAST;
		}
	},
	EAST(1, 0)
	{
		@Override
		public Direction next()
		{
			return SOUTH;
		}
	},
	SOUTH(0, -1)
	{
		@Override
		public Direction next()
		{
			return WEST;
		}
	},
	WEST(-1, 0)
	{
		@Override
		public Direction next()
		{
			return NORTH;
		}
	};

	/**
	 * The horizontal offset for Location
	 */
	public final int horizontalOffset;
	/**
	 * The vertical offset for Location
	 */
	public final int verticalOffset;

	/**
	 * Explicit constructor
	 * @param horizontalOffset
	 * @param verticalOffset
	 */
	private Direction(int horizontalOffset, int verticalOffset)
	{
		this.horizontalOffset = horizontalOffset;
		this.verticalOffset = verticalOffset;
	}

	/**
	 * Gives the next direction
	 * @return
	 */
	public abstract Direction next();
	
	/**
	 * Gives horizontal offset
	 * @return
	 */
	public int getHorizontalOffset(){
		return horizontalOffset;
	}
	
	/**
	 * Gives vertical offset
	 * @return
	 */
	public int getVerticalOffset(){
		return verticalOffset;
	}
	
	/**
	 * Gives the oppostive of the direction
	 * @return
	 */
	public Direction opposite(){
		return next().next();
	}
	
	/**
	 * Returns a string representation of the object
	 */
	public String toString(){
		return name()+"\n";
	}
}
