package loops_and_arrays;

public class PersonArrayListStats
{
	/**
	 * the smallest age
	 */
	private int minAge;
	/**
	 * the oldest age
	 */
	private int maxAge;
	/**
	 * the first youngest name
	 */
	private String firstYoungestName;
	/**
	 * index of first youngest name
	 */
	private int indexFirstMin;
	/**
	 * last youngest name
	 */
	private String lastYoungestName;
	/**
	 * index of last youngest name
	 */
	private int indexLastMin;
	/**
	 * first oldest name
	 */
	private String firstOldestName;
	/**
	 * index of first oldest name
	 */
	private int indexFirstMax;
	/**
	 * last oldest name
	 */
	private String lastOldestName;
	/**
	 * index of last oldest name
	 */
	private int indexLastMax;
	/**
	 * the average age
	 */
	private double averageAge;
	/**
	 * the median age
	 */
	private double medianAge;

	/**
	 * @param minAge
	 * @param maxAge
	 * @param firstYoungestName
	 * @param indexFirstMin
	 * @param lastYoungestName
	 * @param indexLastMin
	 * @param firstOldestName
	 * @param indexFirstMax
	 * @param lastOldestName
	 * @param indexLastMax
	 * @param averageAge
	 * @param medianAge
	 */
	public PersonArrayListStats(int minAge, int maxAge,
			String firstYoungestName, int indexFirstMin,
			String lastYoungestName, int indexLastMin, String firstOldestName,
			int indexFirstMax, String lastOldestName, int indexLastMax,
			double averageAge, double medianAge)
	{
		this.minAge = minAge;
		this.maxAge = maxAge;
		this.firstYoungestName = firstYoungestName;
		this.indexFirstMin = indexFirstMin;
		this.lastYoungestName = lastYoungestName;
		this.indexLastMin = indexLastMin;
		this.firstOldestName = firstOldestName;
		this.indexFirstMax = indexFirstMax;
		this.lastOldestName = lastOldestName;
		this.indexLastMax = indexLastMax;
		this.averageAge = averageAge;
		this.medianAge = medianAge;
	}

	/**
	 * @return the minAge
	 */
	public int getMinAge()
	{
		return minAge;
	}

	/**
	 * @return the maxAge
	 */
	public int getMaxAge()
	{
		return maxAge;
	}

	/**
	 * @return the firstYoungestName
	 */
	public String getFirstYoungestName()
	{
		return firstYoungestName;
	}

	/**
	 * @return the indexFirstMin
	 */
	public int getIndexFirstMin()
	{
		return indexFirstMin;
	}

	/**
	 * @return the lastYoungestName
	 */
	public String getLastYoungestName()
	{
		return lastYoungestName;
	}

	/**
	 * @return the indexLastMin
	 */
	public int getIndexLastMin()
	{
		return indexLastMin;
	}

	/**
	 * @return the firstOldestName
	 */
	public String getFirstOldestName()
	{
		return firstOldestName;
	}

	/**
	 * @return the indexFirstMax
	 */
	public int getIndexFirstMax()
	{
		return indexFirstMax;
	}

	/**
	 * @return the lastOldestName
	 */
	public String getLastOldestName()
	{
		return lastOldestName;
	}

	/**
	 * @return the indexLastMax
	 */
	public int getIndexLastMax()
	{
		return indexLastMax;
	}

	/**
	 * @return the averageAge
	 */
	public double getAverageAge()
	{
		return averageAge;
	}

	/**
	 * @return the medianAge
	 */
	public double getMedianAge()
	{
		return medianAge;
	}

	/**
	 * returns string representation of the object
	 */
	@Override
	public String toString()
	{
		return String
				.format("PersonArrayListStats [minAge=%s, maxAge=%s, firstYoungestName=%s, lastYoungestName=%s, indexLastMin=%s, firstOldestName=%s, indexFirstMax=%s, lastOldestName=%s, indexLastMax=%s, averageAge=%s, medianAge=%s]",
						minAge, maxAge, firstYoungestName, lastYoungestName,
						indexLastMin, firstOldestName, indexFirstMax,
						lastOldestName, indexLastMax, averageAge, medianAge);
	}
}
