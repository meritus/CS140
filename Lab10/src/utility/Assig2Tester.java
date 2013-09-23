package utility;

import java.util.Arrays;


public class Assig2Tester
{
	public static void main(String[] args){
		int[] nullArr = null;
		int[] emptyArr = {};
		int[] random50Arr = new int[50];
		int[] random51Arr = new int[51];
		SingleRandom rand = SingleRandom.getInstance();
		rand.setSeed(1607);
		for(int i=0;i<random50Arr.length;i++)
			random50Arr[i]=rand.nextInt(1,10);
		
		for(int i=0;i<random51Arr.length;i++)
			random51Arr[i]=rand.nextInt(1,10);
		
		IntListAnalyzer analyzer = new IntListAnalyzer();
		
		System.out.println("Random array of length 50"+Arrays.toString(random50Arr));
		//System.out.println(analyzer.analyze2(random50Arr));
		
		System.out.println("\n\nRandom array of length 51"+Arrays.toString(random51Arr));
		//System.out.println(analyzer.analyze2(random51Arr));
	}
}
