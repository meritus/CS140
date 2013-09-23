package demesnes;

public enum Wall
{
	BLANK, DOOR;
	
	/**
	 * Wall has door
	 * @return
	 */
	public boolean hasDoor(){
		return this.equals(DOOR);
	}
	
	/**
	 * returns string representation
	 */
	@Override
	public String toString(){
		return name();
	}
}
