package enum_and_strings;

public enum Wall
{
	BLANK(){

		@Override
		public boolean hasDoor()
		{
			return false;
		}
		
	},
	DOOR(){

		@Override
		public boolean hasDoor()
		{
			return true;
		}
		
	};
	
	public abstract boolean hasDoor();
	
	/**
	 * returns string representation
	 */
	@Override
	public String toString(){
		return super.toString()+" "+hasDoor();
	}
}
