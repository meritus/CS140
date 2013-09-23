package enum_and_strings;

/**
 * Simple three-value traffic light model
 * @author Rose Williams
 *
 */
public enum TrafficLight
{
  RED("GREEN", 20), 
  GREEN("YELLOW",15),
  YELLOW("RED", 5);
  
  /**
   * Constant-specific instance variable
   * Models light duration
   */
  private int timeInterval;
  
  /**
   * Holds nextLight
   */
  private String nextLight;
  /**
   * Explicit value constructor used to set
   *   value of timeInterval instance variable
   * @param timeInterval
   */
  private TrafficLight(String nextLight, int timeInterval)
  {
    this.timeInterval = timeInterval;
    this.nextLight = nextLight;
  }
  
  /**
   * Returns next light in sequence
   * @return next light
   */
  //public abstract TrafficLight nextState();

  /**
   * Returns duration in seconds of this traffic light
   * @return timeInterval
   */
  public int getTimeInterval()
  {
    return timeInterval;
  }
  
  public String toString(){
	  String name = name();
	  Character firstLetter = name.charAt(0);
	  String tail = name.substring(1);
	  return firstLetter.toString()+tail.toLowerCase();
  }
  
  public TrafficLight nextState(){
	  return valueOf(nextLight);
  }
}






