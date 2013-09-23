package parameterized_comparable_person;

import java.util.*;

import parameterized_comparable_person.Person.Gender;

import parameterized_comparable_person.PersonArrayListStats;
import utility.*;
/**
 * This class analyzes an arraylist of person to get stats
 * @author eliu7
 *
 */
public class PersonArrayListAnalyzer
{
	/**
	 * Holds the person objects
	 */
	ArrayList<Person> persons = new ArrayList<Person>();

	/**
	 * Explicit value constructor
	 * @param list
	 */
	public PersonArrayListAnalyzer(ArrayList<Person> list)
	{
		this.persons = list;
	}

	/**
	 * Analyzes list and returns stats
	 * 
	 * @param list
	 * @return
	 */
	public PersonArrayListStats analyze()
	{
		int minAge = -1;
		int maxAge = -1;
		int indexFirstMin = -1;
		Person firstMinElement = null;
		int indexLastMin = -1;
		Person lastMinElement = null;
		int indexFirstMax = -1;
		Person firstMaxElement = null;
		int indexLastMax = -1;
		Person lastMaxElement = null;
		double averageAge = -1;
		double medianAge = -1;

		if (persons != null && persons.size() > 0)
		{
			
			minAge = min().getAge();
			maxAge = max().getAge();

			indexFirstMin = firstPersonIndex(min());
			firstMinElement = persons.get(indexFirstMin);

			indexLastMin = lastPersonIndex(min());
			lastMinElement = persons.get(indexLastMin);

			indexFirstMax = firstPersonIndex(max());
			firstMaxElement = persons.get(indexFirstMax);

			indexLastMax = lastPersonIndex(max());
			lastMaxElement = persons.get(indexLastMax);

			averageAge = average();
			medianAge = median();
		}

		return new PersonArrayListStats(minAge, maxAge, firstMinElement,
				indexFirstMin, lastMinElement, indexLastMin, firstMaxElement,
				indexFirstMax, lastMaxElement, indexLastMax, averageAge,
				medianAge);
	}

	private Person min()
	{
		Person minimum = null;
		if (persons != null && persons.size() > 0)
		{
			minimum = persons.get(0);
			for (Person num : persons)
			{
				if (num.compareTo(minimum) < 0)
					minimum = num;
			}
		}
		return minimum;
	}

	private Person max()
	{
		Person max = null;
		if (persons != null && persons.size() > 0)
		{
			max = persons.get(0);
			for (Person num : persons)
			{
				if (num.compareTo(max) > 0)
					max = num;
			}
		}
		return max;
	}

	private int firstPersonIndex(Person p)
	{
		int index = -1;
		boolean notFound = true;
		if (persons != null && persons.size() > 0)
		{
			for (int i = 0; i < persons.size() && notFound; i++)
			{
				if (persons.get(i).compareTo(p) == 0)
				{
					index = i;
					notFound = false;
				}
			}
		}
		return index;

	}

	private int lastPersonIndex(Person p)
	{
		int index = -1;
		if (persons != null && persons.size() > 0)
		{
			for (int i = 0; i < persons.size(); i++)
			{
				if (persons.get(i).compareTo(p) == 0)
				{
					index = i;
				}
			}
		}
		return index;
	}

	private double average()
	{
		double sum = 0;
		if (persons != null && persons.size() > 0)
		{
			for (Person p : persons)
			{
				sum += p.getAge();
			}
		}
		return sum / persons.size();
	}

	private double median()
	{
		ArrayList<Person> personCopy = (ArrayList<Person>) persons.clone();
		Collections.sort(personCopy);
		double ret = 0;
		if (persons != null && persons.size() > 0)
		{
			if (personCopy.size() % 2 == 0)
			{
				ret += personCopy.get(personCopy.size() / 2).getAge();
				ret += personCopy.get(personCopy.size() / 2 - 1).getAge();
				ret /= 2;
			} else
			{
				ret = personCopy.get(personCopy.size() / 2).getAge();
			}
		}
		return ret;

	}

}
