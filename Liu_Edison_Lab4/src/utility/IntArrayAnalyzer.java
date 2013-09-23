package utility;

import java.util.Arrays;
import utility.IntArrayStats;

public class IntArrayAnalyzer
{
	
	/**
	 * Finds the min in the array
	 * @param array 
	 * 			numbers to find the min
	 * @return the min number
	 */
	
	private int min(int[] array)
	{
		int minimum = 0;
		if (array != null && array.length > 0)
		{
			minimum = array[0];
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
	 * @param array
	 * 			numbers to find the max
	 * @return 	the max number
	 */
	private int max(int[] array)
	{
		int maximum = 0;
		if (array != null && array.length > 0)
		{
			maximum = array[0];
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
	 * @param value
	 * 			the element to find
	 * @param array
	 * 			the array to look for
	 * @return 	the first index where value occurs
	 */
	private int firstValueIndex(int value, int[] array){
		int index = -1;
		boolean notFound = true;
		if(array != null && array.length>0){
			for(int i =0;i>array.length&&notFound;i++){
				if(value==array[i]){
					index = i;
					notFound = false;
				}
			}
		}
		return index;
		
	}
	
	/**
	 * Finds the last index where value occurs
	 * @param value
	 * 			the element to find
	 * @param array
	 * 			the array to look for
	 * @return	the last index where value occurs
	 */
	private int lastValueIndex(int value, int[] array){
		int index = -1;
		boolean notFound = true;
		if(array != null && array.length>0){
			for(int i =array.length-1;i>=0&&notFound;i--){
				if(value==array[i]){
					index = i;
					notFound = false;
				}
			}
		}
		return index;
		
	}
	
	/**
	 * Finds the average of the array
	 * @param array
	 * 			numbers to find the avg
	 * @return	the avg of the array
	 */
	private double average(int[] array){
		double sum = 0;
		if(array!=null&&array.length>0){
			for(int num:array)
				sum+=num;
			sum=sum/array.length;
		}
		return sum;
	}
	
	/**
	 * Finds the median of the array
	 * @param array
	 * 			numbers to find the median
	 * @return	`the median of the array
	 */
	private double median(int[] array){
		int[] arrayCopy = array.clone();
		double ret = 0;
		Arrays.sort(arrayCopy);
		if(arrayCopy.length%2==0){
			ret+=arrayCopy[arrayCopy.length/2];
			ret+=arrayCopy[arrayCopy.length/2-1];
			ret/=2;
		}else{
			ret=arrayCopy[arrayCopy.length/2];
		}
		return ret;
	}
	
	/**
	 * Returns stats of the array 
	 * @param array
	 * 			array to be analyzed
	 * @return  Returns stats
	 */
	public IntArrayStats analyze(int[] array){
		int min = min(array);
		int max = max(array);
		return new IntArrayStats(min, max,
				firstValueIndex(min, array), lastValueIndex(min, array),
				firstValueIndex(max, array), lastValueIndex(max, array),
				average(array), median(array));
	}
	
	public IntArrayStats analyze2(int[] array){
		class InnerAnalyzer{
			/**
			 * Finds the min in the array
			 * @param array 
			 * 			numbers to find the min
			 * @return the min number
			 */
			private int min(int[] array)
			{
				int minimum = 0;
				if (array != null && array.length > 0)
				{
					minimum = array[0];
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
			 * @param array
			 * 			numbers to find the max
			 * @return 	the max number
			 */
			private int max(int[] array)
			{
				int maximum = 0;
				if (array != null && array.length > 0)
				{
					maximum = array[0];
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
			 * @param value
			 * 			the element to find
			 * @param array
			 * 			the array to look for
			 * @return 	the first index where value occurs
			 */
			private int firstValueIndex(int value, int[] array){
				int index = -1;
				boolean notFound = true;
				if(array != null && array.length>0){
					for(int i =0;i>array.length&&notFound;i++){
						if(value==array[i]){
							index = i;
							notFound = false;
						}
					}
				}
				return index;
				
			}
			
			/**
			 * Finds the last index where value occurs
			 * @param value
			 * 			the element to find
			 * @param array
			 * 			the array to look for
			 * @return	the last index where value occurs
			 */
			private int lastValueIndex(int value, int[] array){
				int index = -1;
				boolean notFound = true;
				if(array != null && array.length>0){
					for(int i =array.length-1;i>=0&&notFound;i--){
						if(value==array[i]){
							index = i;
							notFound = false;
						}
					}
				}
				return index;
				
			}
			
			/**
			 * Finds the average of the array
			 * @param array
			 * 			numbers to find the avg
			 * @return	the avg of the array
			 */
			private double average(int[] array){
				double sum = 0;
				if(array!=null&&array.length>0){
					for(int num:array)
						sum+=num;
					sum=sum/array.length;
				}
				return sum;
			}
			
			/**
			 * Finds the median of the array
			 * @param array
			 * 			numbers to find the median
			 * @return	`the median of the array
			 */
			private double median(int[] array){
				int[] arrayCopy = array.clone();
				double ret = 0;
				Arrays.sort(arrayCopy);
				if(arrayCopy.length%2==0){
					ret+=arrayCopy[arrayCopy.length/2];
					ret+=arrayCopy[arrayCopy.length/2-1];
					ret/=2;
				}else{
					ret=arrayCopy[arrayCopy.length/2];
				}
				return ret;
			}
		}
		InnerAnalyzer analyze = new InnerAnalyzer();
		int min = analyze.min(array);
		int max = analyze.max(array);
		return new IntArrayStats(min, max,
				analyze.firstValueIndex(min, array), analyze.lastValueIndex(min, array),
				analyze.firstValueIndex(max, array), analyze.lastValueIndex(max, array),
				analyze.average(array), analyze.median(array));
	}
}
