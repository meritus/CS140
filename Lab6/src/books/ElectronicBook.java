package books;

public class ElectronicBook extends Book
{
	/**
	 * Holds the book format
	 */
	private String format;
	
	/**
	 * The default constructor
	 */
	public ElectronicBook(){
		this("The Oxford English Dictionary", 22000, 0, "pdf");
	}
	
	/**
	 * Makes an electronic book with a given format
	 * @param format
	 * 			type of electronic book
	 */
	public ElectronicBook(String format){
		this("The Oxford English Dictionary", 22000, 0, format);
	}
	
	/**
	 * Makes an electronic book with the following
	 * @param title
	 * @param pageCount
	 * @param bookmark
	 * @param format
	 */
	public ElectronicBook(String title, int pageCount, int bookmark, String format){
		super(title, pageCount, bookmark);
		this.format = format;
	}
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public ElectronicBook(ElectronicBook other){
		this(other.getTitle(), other.getPageCount(), other.getBookmark(), other.getFormat());
	}
	
	/**
	 * Returns the format
	 * @return
	 * 		format of electronic book
	 */
	public String getFormat(){
		return format;
	}
	
	@Override
	public Object clone(){
		ElectronicBook clone = null;
		clone = (ElectronicBook) super.clone();
		return clone;
	}
	
	
	/**
	 * Determines if this book is equal to other book
	 * 
	 * @return true when equal, false when not equal
	 */
	@Override
	public boolean equals(Object otherObject)
	{
		boolean isEqual = false;
		if (otherObject != null
				&& this.getClass().equals(otherObject.getClass()))
		{
			ElectronicBook other = (ElectronicBook) otherObject; 
			isEqual = getTitle().equals(other.getTitle()) && getPageCount() == other.getPageCount()
					&& getBookmark() == other.getBookmark() && format.equals(other.getFormat());
		}
		return isEqual;
	}
	
	/**
	 * Generates hash code for this book
	 * 
	 * @return hash code for this book
	 */
	@Override
	public int hashCode()
	{
		final int HASH_MULTIPLIER = 1601; // use a prime number

		int titleHashCode = 0;
		for (int i = 0; i < getTitle().length(); i++)
		{
			titleHashCode = titleHashCode + getTitle().charAt(i);
		}

		int pageCountHashCode = new Integer(getPageCount()).hashCode();
		int bookmarkHashCode = new Integer(getBookmark()).hashCode();
		
		int formatHashCode = 0;
		for (int i = 0; i < format.length(); i++)
		{
			formatHashCode = formatHashCode + format.charAt(i);
		}

		return HASH_MULTIPLIER * titleHashCode + 
				HASH_MULTIPLIER * pageCountHashCode +
				HASH_MULTIPLIER * bookmarkHashCode+
				HASH_MULTIPLIER * formatHashCode;
	}
	
	/**
	 * Returns a string representation of the object
	 * @return
	 * 		Description of ElectronicBook
	 */
	@Override
	public String toString(){
		return String.format("%s format = %s", super.toString(), format);
	}
	
	/**
	 * Tests that objects of this class can be created in different ways and
	 * that the overridden methods from Object work properly
	 * 
	 * @param args
	 *            - unused
	 */
	public static void main(String[] args)
	{
		// Create default books
		ElectronicBook defaultBook = new ElectronicBook(); // create via default constructor
		ElectronicBook defaultBookAlias = defaultBook; // create alias
		ElectronicBook copiedDefaultBook = (ElectronicBook) defaultBook.clone(); // create clone

		// Display default books
		System.out.println("\nBook created with default constructor:  \n"
				+ defaultBook);
		System.out.println("\nDefault book alias:  \n" + defaultBookAlias);
		System.out
				.println("\nClone of book created with default constructor:  \n"
						+ copiedDefaultBook);

		// Check properties of default books:
		// Original and alias will have same address: shallow NOT deep copy
		// Original and alias will have same contents, but NOT same address:
		// deep copy
		// To start, all will have same hash code since all have identical
		// contents
		System.out.print("\nDo default book and alias have same address?   ");
		System.out.println(defaultBook == defaultBookAlias);
		System.out.print("Do default book and clone have same address?   ");
		System.out.println(defaultBook == copiedDefaultBook);
		System.out.print("Are default book and clone equal?   ");
		System.out.println(defaultBook.equals(copiedDefaultBook));
		System.out.print("Do default book and alias have same hash code?   ");
		System.out.println(defaultBook.hashCode() == defaultBookAlias
				.hashCode());
		System.out.print("Do default book and clone have same hash code?   ");
		System.out.println(defaultBook.hashCode() == copiedDefaultBook
				.hashCode());

		// Create explicit value books
		ElectronicBook explicitValueBook = new ElectronicBook("The Really Big Book of Java", 2000, 0, "pdf");
		ElectronicBook explicitValueBookAlias = explicitValueBook;
		ElectronicBook copiedExplicitValueBook = (ElectronicBook) explicitValueBook.clone();

		// Display explicit value books
		System.out.println("\nBook created with explicit value constructor:\n"
				+ explicitValueBook);
		System.out.println("\nExplicit value book alias:\n"
				+ explicitValueBookAlias);
		System.out
				.println("\nClone of book created with explicit value constructor:\n"
						+ copiedExplicitValueBook);

		// Check properties of explicit value books:
		// Original and alias will have same address: shallow NOT deep copy
		// Original and alias will have same contents, but NOT same address:
		// deep copy
		// To start, all will have same hash code since all have identical
		// contents
		System.out
				.print("\nDo explicit value book and alias have same address?   ");
		System.out.println(explicitValueBook == explicitValueBookAlias);
		System.out
				.print("Do explicit value book and clone have same address?   ");
		System.out.println(explicitValueBook == copiedExplicitValueBook);
		System.out.print("Are explicit value book and clone equal?   ");
		System.out.println(explicitValueBook.equals(copiedExplicitValueBook));
		System.out
				.print("Do explicit value book and alias have same hash code?   ");
		System.out
				.println(explicitValueBook.hashCode() == explicitValueBookAlias
						.hashCode());
		System.out
				.print("Do explicit value book and clone have same hash code?   ");
		System.out
				.println(explicitValueBook.hashCode() == copiedExplicitValueBook
						.hashCode());

		// Change contents of alias and clone
		System.out.println("\nNow update the bookmarks and test again:  "
				+ "only update the alias and the clone");
		explicitValueBookAlias
				.setBookmark(explicitValueBookAlias.getBookmark() + 10);
		copiedExplicitValueBook.setBookmark(copiedExplicitValueBook
				.getBookmark() + 50);

		// Display explicit value books after changing contents
		System.out
				.println("\nNote that the book created with explicit value "
						+ "constructor has been updated even though only alias was changed:\n"
						+ explicitValueBook);
		System.out.println("\nExplicit value book alias:\n"
				+ explicitValueBookAlias);
		System.out
				.println("\nClone of book created with default constructor:\n"
						+ copiedExplicitValueBook);

		// Check properties of explicit value books:
		// Original and alias will have same address: shallow NOT deep copy
		// Original and clone will no longer have same contents, nor same
		// address:
		// deep copy
		// Only original and alias will have same hash code now that contents of
		// original and clone are different
		System.out
				.print("\nDo explicit value book and alias have same address?   ");
		System.out.println(explicitValueBook == explicitValueBookAlias);
		System.out
				.print("Do explicit value book and clone have same address?   ");
		System.out.println(explicitValueBook == copiedExplicitValueBook);
		System.out.print("Are explicit value book and clone equal?   ");
		System.out.println(explicitValueBook.equals(copiedExplicitValueBook));
		System.out
				.print("Do explicit value book and alias have same hash code?   ");
		System.out
				.println(explicitValueBook.hashCode() == explicitValueBookAlias
						.hashCode());
		System.out
				.print("Do explicit value book and clone have same hash code?   ");
		System.out
				.println(explicitValueBook.hashCode() == copiedExplicitValueBook
						.hashCode());
	}
	
}
