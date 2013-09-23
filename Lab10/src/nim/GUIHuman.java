package nim;

/**
 * This class is just a placeholder
 */

public class GUIHuman implements PlayStrategy
{
  
  public GUIHuman()
  {    
  }
  
  @Override
  public int takeTurn(int numberTokens)
  {
    return 0;
  }
  
  @Override
  public String toString()
  {
    return String.format("%s", getClass().getName());
  }
}
