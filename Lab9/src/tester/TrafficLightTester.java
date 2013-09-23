package tester;

import java.util.Calendar;
import java.util.GregorianCalendar;

import enum_and_strings.TrafficLight;

/**
 * This class will be used to test the TrafficLight enum
 * @author Rose Williams
 *
 */
public class TrafficLightTester
{
  /**
   * Verifies elements and methods of TrafficLight
   * @param args
   */
  public static void main(String[] args)
  {
    for( TrafficLight tL : TrafficLight.values())
    {
      System.out.printf("%n%nThe light is now %s", tL);
      System.out.printf("%nIt's duration is %d seconds", 
          tL.getTimeInterval());
      System.out.printf("%nNext, the light will be %s", tL.nextState());
    }
    String dateString = "Today's date is mm/dd/yyyy";
    GregorianCalendar cal = new GregorianCalendar();
    
    int month = cal.get(Calendar.MONTH)+1;
    dateString = dateString.replace("mm", month+"");
    
    int date = cal.get(Calendar.DATE);
    dateString = dateString.replace("dd", date+"");
    
    int year = cal.get(Calendar.YEAR);
    dateString = dateString.replace("yyyy", year+"");
    
    System.out.printf("%n%n%s", dateString);
  }
}


