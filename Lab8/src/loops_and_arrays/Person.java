package loops_and_arrays;

/**
 * This class holds a person's info
 * 
 * @author eliu7
 * 
 */
public class Person implements Cloneable, Comparable
{
	/**
	 * First Name
	 */
	private String firstName;
	/**
	 * Last Name
	 */
	private String lastName;
	/**
	 * enumed Gender
	 *
	 */
	public enum Gender{
		Male, Female
	}
	/**
	 * Person's gender
	 */
	private Gender gender;
	/**
	 * Person's age
	 */
	private int age;

	/**
	 * Explicit constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param gender
	 * @param age
	 */
	public Person(String firstName, String lastName, Gender gender, int age)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	/**
	 * Returns the full name of the person
	 */
	public String getName(){
		return lastName+", "+firstName;
	}

	/**
	 * @return the gender
	 */
	public Gender getGender()
	{
		return gender;
	}

	/**
	 * @param gender
	 *            the gender to set
	 */
	public void setGender(Gender gender)
	{
		this.gender = gender;
	}

	/**
	 * @return the age
	 */
	public int getAge()
	{
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age)
	{
		this.age = age;
	}
	
	/**
	 * Adds one to the age
	 */
	public void incrementAge(){
		age++;
	}

	/**
	 * returns a hashcode
	 */
	@Override
	public int hashCode()
	{
		final int PRIME = 31;
		int result = 1;
		result = PRIME * result + age;
		result = PRIME * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = PRIME * result + ((gender==null) ? 0 : gender.hashCode());
		result = PRIME * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}

	/**
	 * returns if equals
	 */
	@Override
	public boolean equals(Object obj)
	{
		boolean isEqual = false;
		if (obj != null && getClass().equals(obj.getClass()))
		{
			Person other = (Person) obj;
			isEqual = age == other.getAge()
					&& firstName.equals(other.getFirstName())
					&& lastName.equals(other.getLastName())
					&& gender == other.getGender();
		}
		return isEqual;
	}

	/**
	 * Returns a clone
	 */
	@Override
	public Object clone()
	{
		Person cloned = null;
		try
		{
			cloned = (Person) super.clone();
		} catch (CloneNotSupportedException e)
		{
			e.printStackTrace();
		}
		return cloned;
	}
	
	public int compareTo(Object obj){
		Person other = (Person) obj;
		int value = 0;
		if(age<other.age)
			value = -1;
		if(age==other.age)
			value=0;
		if(age>other.age)
			value=1;
		return value;
	}

	@Override
	public String toString()
	{
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", gender=" + gender + ", age=" + age + "]";
	}

	public static void main(String[] args)
	{
		Person one = new Person("Billy", "Bob", Gender.Male, 18);
		Person two = new Person("Albert", "Sung", Gender.Male, 23);
		Person cloneOne = (Person) one.clone();

		System.out
				.println("one and cloneOne are aliases: " + (one == cloneOne));
		System.out.println("one and cloneOne are equal: "
				+ one.equals(cloneOne));
		System.out.println("one and two are equal: " + one.equals(two));
		System.out.println();
		System.out.println("hashcode of one" + one.hashCode());
		System.out.println("hashcode of two" + two.hashCode());
		System.out.println("hashcode of cloneOne" + cloneOne.hashCode());
		System.out.println();
		System.out.println(one);
		System.out.println(two);
		System.out.println(cloneOne);
	}
}
