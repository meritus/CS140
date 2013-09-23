package books;

public class Course implements Cloneable
{
	/**
	 * Instance variable holding the course code
	 */
	private String courseCode;
	
	/**
	 * Instance variable holding the course name
	 */
	private String courseName;
	
	/**
	 * determines if it is grad or undergrad
	 */
	private Level level;
	
	public enum Level{
		UNDERGRADUATE,
		GRADUATE
	}
	
	public Course(){
		this("CS100", "Introduction to Computer Science", Level.UNDERGRADUATE);
	}
	
	public Course(String courseCode, String courseName){
		this(courseCode, courseName, Level.UNDERGRADUATE);
	}
	
	public Course(String courseCode, String courseName, Level level){
		this.courseCode = courseCode;
		this.courseName = courseName;
		this.level = level;
	}
	
	public Course(Course other){
		this(other.courseCode, other.courseName, other.level);
	}
	
	/**
	 * Returns the course code
	 * @return
	 */
	public String getCourseCode(){
		return courseCode;
	}
	
	/**
	 * Returns the course name
	 * @return
	 */
	public String getCourseName(){
		return courseName;
	}
	
	/**
	 * Returns the level of school
	 * @return
	 */
	public Level getLevel(){
		return level;
	}
	
	/**
	 * Generates independent copy of this book Note that protected access from
	 * the Object class is overridden with public In order to override this
	 * method, this class must implement Cloneable, and provide exception
	 * handling for the CloneNotSupportedException
	 * 
	 * @return Object: must cast to Course when using
	 */
	@Override
	public Object clone()
	{
		Course cloned = null;
		try
		{
			cloned = (Course) super.clone();
		} catch (CloneNotSupportedException e) 
		{
			e.printStackTrace();
		}
		return cloned;
	}
	
	/**
	 * Determines if this course is equal to other course
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
			Course other = (Course) otherObject; 
			isEqual = courseCode.equals(other.getCourseCode()) && courseName.equals(other.getCourseName())
					&& level == other.getLevel();
		}
		return isEqual;
	}
	
	/**
	 * Generates hash code for this course
	 * 
	 * @return hash code for this course
	 */
	@Override
	public int hashCode()
	{
		final int HASH_MULTIPLIER = 1601; // use a prime number

		int courseCodeHashCode = 0;
		for (int i = 0; i < courseCode.length(); i++)
		{
			courseCodeHashCode = courseCodeHashCode + courseCode.charAt(i);
		}
		
		int courseNameHashCode = 0;
		for (int i = 0; i < courseName.length(); i++)
		{
			courseNameHashCode = courseNameHashCode + courseName.charAt(i);
		}
		
		int levelHashCode = level.hashCode();

		return HASH_MULTIPLIER * courseCodeHashCode +
				HASH_MULTIPLIER * courseNameHashCode +
				HASH_MULTIPLIER * levelHashCode;
	}
	 
	/**
	 * Gives a string represenation of the object
	 * @return
	 * 		description of the course
	 */
	@Override
	public String toString()
	{
		return String.format("courseCode=%s, courseName=%s, level=%s",
				courseCode, courseName, level);
	}
	
	public static void main(String[] args){
		Course dCourse = new Course();
		Course course1 = new Course("Insomia101", "Living Without Sleep", Level.UNDERGRADUATE);
		
		System.out.println(dCourse);
		System.out.println(course1);
	}
	
}
