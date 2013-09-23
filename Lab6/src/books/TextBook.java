package books;

public class TextBook extends Book
{
	private boolean required;
	private Course course;
	
	/**
	 * default constructor
	 */
	public TextBook(){
		this("Lined Notebook", 250, 0, true, new Course());
	}
	
	/**
	 * Creates a textbook
	 * @param title
	 * @param pageCount
	 * @param course
	 */
	public TextBook(String title, int pageCount, Course course){
		this(title, pageCount, 0, true, course);
	}
	
	/**
	 * Creates a textbook
	 * @param title
	 * @param pageCount
	 * @param bookmark
	 * @param required
	 * @param course
	 */
	public TextBook(String title, int pageCount, int bookmark, boolean required, Course course){
		super(title, pageCount, bookmark);
		this.required = required;
		this.course = course;
	}
	
	/**
	 * Copy constructor
	 * @param other
	 */
	public TextBook(TextBook other){
		this(other.getTitle(), other.getPageCount(), other.getBookmark(), other.isRequired(), other.getCourse());
	}
	
	/**
	 * Tests if book is required
	 * @return
	 * 		true if book is required
	 */
	public boolean isRequired(){
		return required;
	}
	
	/**
	 * Returns a copy of the course
	 * @return
	 * 		course of textbook
	 */
	public Course getCourse(){
		return (Course) course.clone();
	}
	
	/**
	 * Returns a deep copy of the object
	 */
	@Override
	public Object clone(){
		TextBook clone = null;
		clone = (TextBook) super.clone();
		clone.course = (Course) course.clone();
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
			TextBook other = (TextBook) otherObject; // NOTE CAST
			isEqual = getTitle().equals(other.getTitle()) && getPageCount() == other.getPageCount()
					&& getBookmark() == other.getBookmark() && required == other.isRequired()
					&& course.equals(other.getCourse());
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
		
		int courseHashCode = course.hashCode();
		
		int requiredHashCode = new Boolean(required).hashCode();

		return HASH_MULTIPLIER * titleHashCode +
				HASH_MULTIPLIER	* pageCountHashCode +
				HASH_MULTIPLIER * bookmarkHashCode +
				HASH_MULTIPLIER * courseHashCode +
				HASH_MULTIPLIER * requiredHashCode;
	}

	@Override
	public String toString()
	{
		return String.format("%s, required=%s, course=%s", super.toString(), required,
				course);
	}
	
	public static void main(String[] args){
		// Create default books
		TextBook defaultBook = new TextBook(); // create via default constructor
		TextBook defaultBookAlias = defaultBook; // create alias
		TextBook copiedDefaultBook = (TextBook) defaultBook.clone(); // create clone

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
		TextBook explicitValueBook = new TextBook("The Really Big TextBook of Java", 2000,
				0, false, new Course());
		TextBook explicitValueBookAlias = explicitValueBook;
		TextBook copiedExplicitValueBook = (TextBook) explicitValueBook.clone();

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
