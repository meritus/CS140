/*
   A program to illustrate the behavior and limitations of numeric types
*/


class NumericExample
{

   public static void main (String args[])
   {
      int    itemp;
      long   ltemp;
      float  ftemp;
      double dtemp;

      System.out.println("A Program to Illustrate the Behavior and Limitations of Numeric Types");      
      System.out.println();

      System.out.println("Largest valid int number (Integer.MAX_VALUE) =  " + Integer.MAX_VALUE);
      System.out.println("Smallest valid int number(Integer.MIN_VALUE) = " + Integer.MIN_VALUE);
      System.out.println();

      System.out.println("Let's experiment!");
      System.out.println("Are the above values really the upper and lower limits?");
      System.out.println();

      System.out.println("Let's print out the largest valid int number as a long:");
      ltemp = (long)Integer.MAX_VALUE;
      System.out.println("\tInteger.MAX_VALUE cast to long = \t " + ltemp);
      ltemp = ltemp + 1;
      System.out.println("Let's add one to it: \t\t\t\t " + ltemp);
      itemp = (int) ltemp;
      System.out.println("Now let's cast it back to an int:  \t\t" + itemp);
      System.out.println("Did you expect this answer?");
      System.out.println();

      System.out.println("Let's print out the smallest valid int number as a long:");
      ltemp = (long)Integer.MIN_VALUE;
      System.out.println("\tInteger.MIN_VALUE cast to long = \t" + ltemp);
      ltemp = ltemp - 1;
      System.out.println("Let's subtract one from it: \t\t\t" + ltemp);
      itemp = (int) ltemp;
      System.out.println("Now let's cast it back to an int:  \t\t " + itemp);
      System.out.println("Did you expect this answer?");
      System.out.println();

      System.out.println("What happens if we try to represent larger precision numbers with types of lower precision?");
      System.out.println();

      dtemp = Double.MAX_VALUE;
      System.out.println("The largest double number  (Double.MAX_VALUE) = " + dtemp);
      ftemp = (float)dtemp;
      itemp = (int)dtemp;
      System.out.println("If this number is cast to a float, the result = " + ftemp);
      System.out.println("If this number is cast to an int,  the result = " + itemp);     
      System.out.println();

      dtemp = Double.MIN_VALUE;
      System.out.println("The smallest double number (Double.MIN_VALUE) = " + dtemp);
      ftemp = (float)dtemp;
      itemp = (int)dtemp;
      System.out.println("If this number is cast to a float, the result = " + ftemp);
      System.out.println("If this number is cast to an int,  the result = " + itemp);     
   }

}
