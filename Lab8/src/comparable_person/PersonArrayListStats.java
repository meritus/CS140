package comparable_person;

public class PersonArrayListStats
{
	/**
	 * the smallest age
	 */
	private int minValue;
	/**
	 * the oldest age
	 */
	private int maxValue;
	/**
	 * the first youngest name
	 */
	private Person firstMinElement;
	/**
	 * index of first youngest name
	 */
	private int indexFirstMin;
	/**
	 * last youngest name
	 */
	private Person lastMinElement;
	/**
	 * index of last youngest name
	 */
	private int indexLastMin;
	/**
	 * first oldest name
	 */
	private Person firstMaxElement;
	/**
	 * index of first oldest name
	 */
	private int indexFirstMax;
	/**
	 * last oldest name
	 */
	private Person lastMaxElement;
	/**
	 * index of last oldest name
	 */
	private int indexLastMax;
	/**
	 * the average age
	 */
	private double average;
	/**
	 * the median age
	 */
	private double median;

	/**
	 * @param minValue
	 * @param maxValue
	 * @param firstMinElement
	 * @param indexFirstMin
	 * @param lastMinElement
	 * @param indexLastMin
	 * @param firstMaxElement
	 * @param indexFirstMax
	 * @param lastMaxElement
	 * @param indexLastMax
	 * @param average
	 * @param median
	 */
	public PersonArrayListStats(int minValue, int maxValue,
			Person firstMinElement, int indexFirstMin,
			Person lastMinElement, int indexLastMin, Person firstMaxElement,
			int indexFirstMax, Person lastMaxElement, int indexLastMax,
			double average, double median)
	{
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.firstMinElement = firstMinElement;
		this.indexFirstMin = indexFirstMin;
		this.lastMinElement = lastMinElement;
		this.indexLastMin = indexLastMin;
		this.firstMaxElement = firstMaxElement;
		this.indexFirstMax = indexFirstMax;
		this.lastMaxElement = lastMaxElement;
		this.indexLastMax = indexLastMax;
		this.average = average;
		this.median = median;
	}

	/**
	 * @return the minValue
	 */
	public int getMinAge()
	{
		return minValue;
	}

	/**
	 * @return the maxValue
	 */
	public int getMaxAge()
	{
		return maxValue;
	}

	/**
	 * @return the firstMinElement
	 */
	public Person getFirstYoungestName()
	{
		return firstMinElement;
	}

	/**
	 * @return the indexFirstMin
	 */
	public int getIndexFirstMin()
	{
		return indexFirstMin;
	}

	/**
	 * @return the lastMinElement
	 */
	public Person getLastYoungestName()
	{
		return lastMinElement;
	}

	/**
	 * @return the indexLastMin
	 */
	public int getIndexLastMin()
	{
		return indexLastMin;
	}

	/**
	 * @return the firstMaxElement
	 */
	public Person getFirstOldestName()
	{
		return firstMaxElement;
	}

	/**
	 * @return the indexFirstMax
	 */
	public int getIndexFirstMax()
	{
		return indexFirstMax;
	}

	/**
	 * @return the lastMaxElement
	 */
	public Person getLastOldestName()
	{
		return lastMaxElement;
	}

	/**
	 * @return the indexLastMax
	 */
	public int getIndexLastMax()
	{
		return indexLastMax;
	}

	/**
	 * @return the average
	 */
	public double getAverageAge()
	{
		return average;
	}

	/**
	 * @return the median
	 */
	public double getMedianAge()
	{
		return median;
	}

	/**
	 * returns string representation of the object
	 */
	@Override
	public String toString()
	{
		return String
				.format("%s [minValue=%s, maxValue=%s,\n" +
						" firstMinElement=%s, lastMinElement=%s,\n" +
						" indexLastMin=%s, firstMaxElement=%s,\n" +
						" indexFirstMax=%s, lastMaxElement=%s,\n" +
						" indexLastMax=%s, average=%s, median=%s]",
						getClass().getName() ,minValue, maxValue,
						firstMinElement, lastMinElement,
						indexLastMin, firstMaxElement, indexFirstMax,
						lastMaxElement, indexLastMax, average, median);
	}
}
