package books;

/**
 * This class models a very basic book Values for title and pageCount are
 * immutable
 * (class invariant: getBookmark() <= getPageCount())
 * 
 * @author Rose Williams
 * 
 */
public class Book implements Cloneable
{
	// Instance Variables ---------------------------------------------------//

	/**
	 * Title of this book
	 */
	private String title;

	/**
	 * Total number of pages in this book
	 */
	private int pageCount;

	/**
	 * Page currently being read of this book When value is zero: indicates book
	 * has not yet been opened
	 */
	private int bookmark;

	// Constructors ----------------------------------------------------------//

	/**
	 * Default constructor Creates blank book having 250 pages
	 */
	public Book()
	{
		this("Blank", 250, 0);
	}

	/**
	 * An Explicit Value Constructor Takes in values for title and pageCount,
	 * uses default value for bookmark
	 * 
	 * @param title
	 *            - Used to set title of this book
	 * @param pageCount
	 *            - Used to set total number of pages in this book
	 *            (precondition: title.length() > 0, pageCount > 0)
	 *            (postcondition: object created in valid state)
	 */
	public Book(String title, int pageCount)
	{
		this(title, pageCount, 0);
	}

	/**
	 * Explicit Value Constructor Note that other constructors chain to this one
	 * Takes in values for title, pageCount and bookmark
	 * 
	 * @param title
	 *            - Used to set title of this book
	 * @param pageCount
	 *            - Used to set total number of pages in this book
	 * @param bookmark
	 *            - Used to set page currently being read in this book
	 *            (precondition: title.length() > 0, pageCount > 0, bookmark >=
	 *            0) (postcondition: object created in valid state)
	 */
	public Book(String title, int pageCount, int bookmark)
	{
		this.title = title;
		// should check for values <= 0 next and throw exception if invalid
		this.pageCount = pageCount;
		this.bookmark = bookmark;
	}

	/**
	 * Copy constructor: creates an independent copy of another object of this
	 * class
	 * 
	 * @param other
	 *            - Book object that will be copied (precondition: other book is
	 *            valid Book object) (postcondition: this book independent copy
	 *            of other book, and this book created in valid state)
	 */
	public Book(Book other)

	{
		this.title = other.title;
		this.pageCount = other.pageCount;
		this.bookmark = other.bookmark;
	}

	// Predicates ------------------------------------------------------------//

	/**
	 * Determines if book has been completely read
	 * 
	 * @return true if completely read, false otherwise
	 */
	public boolean hasBeenRead()
	{
		return bookmark == pageCount;
	}

	// Accessors ----------------------------	//TODO---------------------------------//

	/**
	 * Returns the title of this book
	 * 
	 * @return the title of this book
	 */
	public String getTitle()
	{
		return title;
	}

	/**
	 * Returns the pageCount of this book
	 * 
	 * @return the total number of pages in this book
	 */
	public int getPageCount()
	{
		return pageCount;
	}

	/**
	 * Returns the current value of the bookmark for this book
	 * 
	 * @return the bookmark indicating the current page being read of this book
	 */
	public int getBookmark()
	{
		return bookmark;
	}

	/**
	 * Returns the fractional portion that has been read of this book
	 * 
	 * Value returned will be: 0 <= range <= 1
	 * 
	 * @return the portion of this book that has been read
	 */
	public double computeCompleted()
	{
		return bookmark / (double) pageCount;
	}

	// Mutators --------------------------------------------------------------//

	/**
	 * Updates bookmark to current page being read in this book
	 * 
	 * @param - newPageNumber being read in this book that is used to update
	 *        bookmark
	 */
	public void setBookmark(int newPageNumber)
	{
		bookmark = newPageNumber;
	}

	// Overridden methods from the Object class ------------------------------//

	/**
	 * Generates independent copy of this book Note that protected access from
	 * the Object class is overridden with public In order to override this
	 * method, this class must implement Cloneable, and provide exception
	 * handling for the CloneNotSupportedException
	 * 
	 * @return Object: must cast to Book when using
	 */
	@Override
	public Object clone()
	{
		Book cloned = null;
		try
		// Exception handling
		{
			// Pretty simple since everything is either primitive or immutable
			cloned = (Book) super.clone();
		} catch (CloneNotSupportedException e) // Exception handling
		{
			// shouldn't happen because we implemented Cloneable
			e.printStackTrace();
		}
		return cloned;
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
			Book other = (Book) otherObject; // NOTE CAST
			isEqual = title.equals(other.title) && pageCount == other.pageCount
					&& bookmark == other.bookmark;
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
		for (int i = 0; i < title.length(); i++)
		{
			titleHashCode = titleHashCode + title.charAt(i);
		}

		int pageCountHashCode = new Integer(pageCount).hashCode();
		int bookmarkHashCode = new Integer(bookmark).hashCode();

		return HASH_MULTIPLIER * titleHashCode + HASH_MULTIPLIER
				* pageCountHashCode + HASH_MULTIPLIER * bookmarkHashCode;
	}

	/**
	 * Return formatted String representation of this book
	 * 
	 * @return formatted String representation of the current state of this book
	 */
	@Override
	public String toString()
	{
		return String.format("Book type:  %s, " + "%s, "
				+ "%d total pages, is " + "currently up to page %d, "
				+ "and is %.1f%% completed", getClass().getName(), title,
				pageCount, bookmark, (computeCompleted() * 100));
	}

	// Tester: Initial tests ------------------------------------------------//
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
		Book defaultBook = new Book(); // create via default constructor
		Book defaultBookAlias = defaultBook; // create alias
		Book copiedDefaultBook = (Book) defaultBook.clone(); // create clone

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
		Book explicitValueBook = new Book("The Really Big Book of Java", 2000,
				0);
		Book explicitValueBookAlias = explicitValueBook;
		Book copiedExplicitValueBook = (Book) explicitValueBook.clone();

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
