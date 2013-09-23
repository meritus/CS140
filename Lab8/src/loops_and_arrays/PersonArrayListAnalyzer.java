package loops_and_arrays;

import java.util.*;

import loops_and_arrays.PersonArrayListStats;
import utility.*;

public class PersonArrayListAnalyzer
{
	/**
	 * Analyzes list and returns stats
	 * @param list
	 * @return
	 */
	public PersonArrayListStats analyze(ArrayList<Person> list)
	{
		int minAge = -1;
		int maxAge = -1;
		int indexFirstMin = -1;
		String firstYoungestName = null;
		int indexLastMin = -1;
		String lastYoungestName = null;
		int indexFirstMax = -1;
		String firstOldestName = null;
		int indexLastMax = -1;
		String lastOldestName = null;
		double averageAge = -1;
		double medianAge = -1;

		if (list != null && list.size() > 0)
		{
			ArrayList<Integer> ages = new ArrayList<Integer>();
			for (Person p : list)
				ages.add(p.getAge());
			IntListAnalyzer analyzer = new IntListAnalyzer();
			IntListStats ageStats = analyzer.analyze(ages);
			minAge = ageStats.getMinimum();
			maxAge = ageStats.getMaximum();

			indexFirstMin = ageStats.getFirstMinIndex();
			Person firstYoungest = list.get(indexFirstMin);
			firstYoungestName = firstYoungest.getFirstName() + " "
					+ firstYoungest.getLastName();

			indexLastMin = ageStats.getLastMinIndex();
			Person lastYoungest = list.get(indexLastMin);
			lastYoungestName = lastYoungest.getFirstName() + " "
					+ lastYoungest.getLastName();

			indexFirstMax = ageStats.getFirstMaxIndex();
			Person firstOldest = list.get(indexFirstMax);
			firstOldestName = firstOldest.getFirstName() + " "
					+ firstOldest.getLastName();

			indexLastMax = ageStats.getLastMaxIndex();
			Person lastOldest = list.get(indexLastMax);
			lastOldestName = lastOldest.getFirstName() + " "
					+ lastOldest.getLastName();

			averageAge = ageStats.getAverage();
			medianAge = ageStats.getMedian();
		}

		return new PersonArrayListStats(minAge, maxAge, firstYoungestName,
				indexFirstMin, lastYoungestName, indexLastMin, firstOldestName,
				indexFirstMax, lastOldestName, indexLastMax, averageAge,
				medianAge);
	}

}
