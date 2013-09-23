package utility;

public class IntListStats
{
	/**
	 * the minimum
	 */
	private int minimum;
	/**
	 * the maximum
	 */
	private int maximum;
	/**
	 * index of first minimum
	 */
	private int firstMinIndex;
	/**
	 * index of the last minimum
	 */
	private int lastMinIndex;
	/**
	 * index of the first max
	 */
	private int firstMaxIndex;
	/**
	 * index of the last max
	 */
	private int lastMaxIndex;
	/**
	 * The avg
	 */
	private double average;
	/**
	 * the median
	 */
	private double median;

	/**
	 * Creates a constructor with the following fields
	 * 
	 * @param minimum
	 * @param maximum
	 * @param firstMinIndex
	 * @param lastMinIndex
	 * @param lastMaxIndex
	 * @param average
	 * @param median
	 */
	public IntListStats(int minimum, int maximum, int firstMinIndex,
			int lastMinIndex, int firstMaxIndex, int lastMaxIndex,
			double average, double median)
	{
		this.minimum = minimum;
		this.maximum = maximum;
		this.firstMinIndex = firstMinIndex;
		this.lastMinIndex = lastMinIndex;
		this.firstMaxIndex = firstMaxIndex;
		this.lastMaxIndex = lastMaxIndex;
		this.average = average;
		this.median = median;
	}

	/**
	 * @return the minimum
	 */
	public int getMinimum()
	{
		return minimum;
	}

	/**
	 * @return the maximum
	 */
	public int getMaximum()
	{
		return maximum;
	}

	/**
	 * @return the firstMinIndex
	 */
	public int getFirstMinIndex()
	{
		return firstMinIndex;
	}

	/**
	 * @return the lastMinIndex
	 */
	public int getLastMinIndex()
	{
		return lastMinIndex;
	}

	/**
	 * @return the firstMaxIndex
	 */
	public int getFirstMaxIndex()
	{
		return firstMaxIndex;
	}

	/**
	 * @return the lastMaxIndex
	 */
	public int getLastMaxIndex()
	{
		return lastMaxIndex;
	}

	/**
	 * @return the average
	 */
	public double getAverage()
	{
		return average;
	}

	/**
	 * @return the median
	 */
	public double getMedian()
	{
		return median;
	}

	@Override
	public String toString()
	{
		return String
				.format("minimum=%s\nmaximum=%s\nfirstMinIndex=%s\nlastMinIndex=%s\nlastMaxIndex=%s\naverage=%.2f\nmedian=%.2f",
						minimum, maximum, firstMinIndex, lastMinIndex,
						lastMaxIndex, average, median);
	}

}
