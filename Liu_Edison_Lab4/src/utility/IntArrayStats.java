package utility;

public class IntArrayStats
{
	private int minimum;
	private int maximum;
	private int firstMinIndex;
	private int lastMinIndex;
	private int firstMaxIndex;
	private int lastMaxIndex;
	private double average;
	private double median;
	
	/**
	 * Creates a constructor with the following fields
	 * @param minimum
	 * @param maximum
	 * @param firstMinIndex
	 * @param lastMinIndex
	 * @param lastMaxIndex
	 * @param average
	 * @param median
	 */
	public IntArrayStats(int minimum, int maximum, int firstMinIndex,
			int lastMinIndex, int firstMaxIndex, int lastMaxIndex, double average, double median)
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

	@Override
	public String toString()
	{
		return String
				.format("minimum=%s\nmaximum=%s\nfirstMinIndex=%s\nlastMinIndex=%s\nlastMaxIndex=%s\naverage=%.2f\nmedian=%.2f",
						minimum, maximum, firstMinIndex, lastMinIndex,
						lastMaxIndex, average, median);
	}
	
	
	
	
}
