package utility;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import utility.IntListStats;

public class IntListAnalyzer
{

	/**
	 * Finds the min in the array
	 * 
	 * @param array
	 *            numbers to find the min
	 * @return the min number
	 */

	private int min(ArrayList<Integer> array)
	{
		int minimum = -1;
		if (array != null && array.size() > 0)
		{
			minimum = array.get(0);
			for (int num : array)
			{
				if (num < minimum)
					minimum = num;
			}
		}
		return minimum;
	}

	/**
	 * Finds the max in the array
	 * 
	 * @param array
	 *            numbers to find the max
	 * @return the max number
	 */
	private int max(ArrayList<Integer> array)
	{
		int maximum = -1;
		if (array != null && array.size() > 0)
		{
			maximum = array.get(0);
			for (int num : array)
			{
				if (num > maximum)
					maximum = num;
			}
		}
		return maximum;
	}

	/**
	 * Finds the first index where value occurs
	 * 
	 * @param value
	 *            the element to find
	 * @param array
	 *            the array to look for
	 * @return the first index where value occurs
	 */
	private int firstValueIndex(int value, ArrayList<Integer> array)
	{
		int index = -1;
		boolean notFound = true;
		if (array != null && array.size() > 0)
		{
			for (int i = 0; i < array.size() && notFound; i++)
			{
				if (value == array.get(i))
				{
					index = i;
					notFound = false;
				}
			}
		}
		return index;

	}

	/**
	 * Finds the last index where value occurs
	 * 
	 * @param value
	 *            the element to find
	 * @param array
	 *            the array to look for
	 * @return the last index where value occurs
	 */
	private int lastValueIndex(int value, ArrayList<Integer> array)
	{
		int index = -1;
		boolean notFound = true;
		if (array != null && array.size() > 0)
		{
			for (int i = array.size() - 1; i >= 0 && notFound; i--)
			{
				if (value == array.get(i))
				{
					index = i;
					notFound = false;
				}
			}
		}
		return index;

	}

	/**
	 * Finds the average of the array
	 * 
	 * @param array
	 *            numbers to find the avg
	 * @return the avg of the array
	 */
	private double average(ArrayList<Integer> array)
	{
		double sum = 0;
		if (array != null && array.size() > 0)
		{
			for (int num : array)
				sum += num;
			sum = sum / array.size();
		}
		return sum;
	}

	/**
	 * Finds the median of the array
	 * 
	 * @param array
	 *            numbers to find the median
	 * @return `the median of the array
	 */
	private double median(ArrayList<Integer> array)
	{
		ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
		double ret = 0;
		Collections.sort(arrayCopy);
		if (arrayCopy.size() % 2 == 0)
		{
			ret += arrayCopy.get(arrayCopy.size() / 2);
			ret += arrayCopy.get(arrayCopy.size() / 2 - 1);
			ret /= 2;
		} else
		{
			ret = arrayCopy.get(arrayCopy.size() / 2);
		}
		return ret;
	}

	/**
	 * Returns stats of the array
	 * 
	 * @param array
	 *            array to be analyzed
	 * @return Returns stats
	 */
	public IntListStats analyze(ArrayList<Integer> array)
	{
		int min = min(array);
		int max = max(array);
		return new IntListStats(min, max, firstValueIndex(min, array),
				lastValueIndex(min, array), firstValueIndex(max, array),
				lastValueIndex(max, array), average(array), median(array));
	}

	public IntListStats analyze2(ArrayList<Integer> array)
	{
		class InnerAnalyzer
		{
			/**
			 * Finds the min in the array
			 * 
			 * @param array
			 *            numbers to find the min
			 * @return the min number
			 */
			private int min(ArrayList<Integer> array)
			{
				int minimum = -1;
				if (array != null && array.size() > 0)
				{
					minimum = array.get(0);
					for (int num : array)
					{
						if (num < minimum)
							minimum = num;
					}
				}
				return minimum;
			}

			/**
			 * Finds the max in the array
			 * 
			 * @param array
			 *            numbers to find the max
			 * @return the max number
			 */
			private int max(ArrayList<Integer> array)
			{
				int maximum = -1;
				if (array != null && array.size() > 0)
				{
					maximum = array.get(0);
					for (int num : array)
					{
						if (num > maximum)
							maximum = num;
					}
				}
				return maximum;
			}

			/**
			 * Finds the first index where value occurs
			 * 
			 * @param value
			 *            the element to find
			 * @param array
			 *            the array to look for
			 * @return the first index where value occurs
			 */
			private int firstValueIndex(int value, ArrayList<Integer> array)
			{
				int index = -1;
				boolean notFound = true;
				if (array != null && array.size() > 0)
				{
					for (int i = 0; i > array.size() && notFound; i++)
					{
						if (value == array.get(i))
						{
							index = i;
							notFound = false;
						}
					}
				}
				return index;

			}

			/**
			 * Finds the last index where value occurs
			 * 
			 * @param value
			 *            the element to find
			 * @param array
			 *            the array to look for
			 * @return the last index where value occurs
			 */
			private int lastValueIndex(int value, ArrayList<Integer> array)
			{
				int index = -1;
				boolean notFound = true;
				if (array != null && array.size() > 0)
				{
					for (int i = array.size() - 1; i >= 0 && notFound; i--)
					{
						if (value == array.get(i))
						{
							index = i;
							notFound = false;
						}
					}
				}
				return index;

			}

			/**
			 * Finds the average of the array
			 * 
			 * @param array
			 *            numbers to find the avg
			 * @return the avg of the array
			 */
			private double average(ArrayList<Integer> array)
			{
				double sum = 0;
				if (array != null && array.size() > 0)
				{
					for (int num : array)
						sum += num;
					sum = sum / array.size();
				}
				return sum;
			}

			/**
			 * Finds the median of the array
			 * 
			 * @param array
			 *            numbers to find the median
			 * @return `the median of the array
			 */
			private double median(ArrayList<Integer> array)
			{
				ArrayList<Integer> arrayCopy = (ArrayList<Integer>) array.clone();
				double ret = 0;
				Collections.sort(arrayCopy);
				if (arrayCopy.size() % 2 == 0)
				{
					ret += arrayCopy.get(arrayCopy.size() / 2);
					ret += arrayCopy.get(arrayCopy.size() / 2 - 1);
					ret /= 2;
				} else
				{
					ret = arrayCopy.get(arrayCopy.size() / 2);
				}
				return ret;
			}
		}

		InnerAnalyzer analyze = new InnerAnalyzer();
		int min = analyze.min(array);
		int max = analyze.max(array);
		return new IntListStats(min, max, analyze.firstValueIndex(min, array),
				analyze.lastValueIndex(min, array), analyze.firstValueIndex(
						max, array), analyze.lastValueIndex(max, array),
				analyze.average(array), analyze.median(array));

	}
}
