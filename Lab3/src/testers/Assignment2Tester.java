package testers;
import characters.Adventurer;
import characters.Monster;
/**
 * Tester class for Adventurer and Monster
 * @author Rose Williams
 *
 */
public class Assignment2Tester
{
  /**
   * Create instances of Adventurer and Monster
   * Test their constructors and methods
   * Make sure that values are bound when appropriate
   * @param args
   */
  public static void main(String[] args)
  {
    //Test constructors
    //  Show defaults
    Adventurer a0 = new Adventurer();
    Monster m0 = new Monster();
    int counter = 0;
    String divider = "__________________________________________________";
    
    counter++;
    System.out.println(counter);
    //  Note direct access to MAX_HEALTH and MAX_STRENGTH because 
    //    they are PUBLIC instance constants
    System.out.println(
        "Default adventurer:  \n" + a0 + "Max Health = " 
        + a0.MAX_HEALTH + ", Max Strength = " + a0.MAX_STRENGTH 
        + "\nDefault monster:  \n" + m0 + "Max Health = " 
        + m0.MAX_HEALTH + ", Max Strength = " + m0.MAX_STRENGTH +  "\n");

    counter++;
    System.out.println(counter);
    // Show that negative values are rejected, set to 1 instead
    Adventurer aNeg = new Adventurer("ANeg", -1, -1);
    Monster mNeg = new Monster("MNeg", -1, -1, -1);
    System.out.println(
        "Negative value adventurer:  \n" + aNeg + "Max Health = " 
        + aNeg.MAX_HEALTH + ", Max Strength = " + aNeg.MAX_STRENGTH + 
        "\nNegative value monster:  \n" + mNeg + "Max Health = " 
        + mNeg.MAX_HEALTH + ", Max Strength = " + mNeg.MAX_STRENGTH + "\n");

    counter++;
    System.out.println(counter);
    //  Show that values over upper limit are rejected, 
    //    set to upper limit instead
    Adventurer aOver = new Adventurer("AOver", 100.1, 10.1);
    Monster mOver = new Monster("MOver", 11, 100.1, 10.1);
    System.out.println(
        "Over limit value adventurer:  \n" + aOver + "Max Health = " 
        + aOver.MAX_HEALTH + ", Max Strength = " + aOver.MAX_STRENGTH + 
        "\nOver limit value monster:  \n" + mOver + "Max Health = "
        + mOver.MAX_HEALTH + ", Max Strength = " + mOver.MAX_STRENGTH + "\n");
    
    counter++;
    System.out.println(counter);    
    //  Show that normal values are accepted, including those around "edges"
    Adventurer aLowest = new Adventurer(
        "ALowest", 0, 0); //Should force health and strength values to 1
    Monster mLowest = new Monster(
        "MLowest", 0, 0, 0);    //Should force health and strength values to 1
    System.out.println(
        "Lowest value adventurer:  \n" + aLowest + "Max Health = " 
        + aLowest.MAX_HEALTH + ", Max Strength = " + aLowest.MAX_STRENGTH +
        "\nLowest value monster:  \n" + mLowest + "Max Health = " 
        + mLowest.MAX_HEALTH + ", Max Strength = " + mLowest.MAX_STRENGTH 
        + "\n");
       
    counter++;
    System.out.println(counter);
    Adventurer aLower = new Adventurer(
        "ALower", 1, 1);  //values are acceptable
    Monster mLower = new Monster(
        "MLower", 1, 1, 1);     //values are acceptable
    System.out.println(
        "Lower value adventurer:  \n" + aLower + "Max Health = " 
        + aLower.MAX_HEALTH + ", Max Strength = " + aLower.MAX_STRENGTH +
        "\nLower value monster:  \n" + mLower + "Max Health = " 
        + mLower.MAX_HEALTH + ", Max Strength = " + mLower.MAX_STRENGTH + "\n");    
    
    counter++;
    System.out.println(counter);
    Adventurer aHighest = new Adventurer(
        "AHighest", 100, 10); //values are highest allowable
    Monster mHighest = new Monster(
        "MHighest", 10, 100, 10);  //values are highest allowable
    System.out.println(
        "Highest value adventurer:  \n" + aHighest + "Max Health = " 
        + aHighest.MAX_HEALTH + ", Max Strength = " + aHighest.MAX_STRENGTH +
        "\nHighest value monster:  \n" + mHighest + "Max Health = " 
        + mHighest.MAX_HEALTH + ", Max Strength = " + mHighest.MAX_STRENGTH 
        + "\n");        
 
    counter++;
    System.out.println(counter);
    Adventurer aHigher = new Adventurer(
        "AHigher", 99, 9); //Values are acceptably high
    Monster mHigher = new Monster(
        "MHigher", 9, 99, 9);  //Values are acceptably high
    System.out.println(
        "Higher value adventurer:  \n" + aHigher + "Max Health = " 
        + aHigher.MAX_HEALTH + ", Max Strength = " + aHigher.MAX_STRENGTH +
        "\nHigher value monster:  \n" + mHigher + "Max Health = " 
        + mHigher.MAX_HEALTH + ", Max Strength = " + mHigher.MAX_STRENGTH 
        + "\n");        

    counter++;
    System.out.println(counter);
    Adventurer aMid = new Adventurer("AMid", 50, 5); //Values are midrange
    Monster mMid = new Monster("MMid", 5, 50, 5);  //Values are midrange
    System.out.println(
        "Mid value adventurer:  \n" + aMid + "Max Health = "  + aMid.MAX_HEALTH 
        + ", Max Strength = " + aMid.MAX_STRENGTH +
        "\nMid value monster:  \n" + mMid + "Max Health = " + mMid.MAX_HEALTH 
        + ", Max Strength = " + mMid.MAX_STRENGTH + "\n");            
    
    counter++;
    System.out.println(counter);
    //  Test accessors (that haven't been tested already)
    System.out.println(
        "Mid value adventurer accessors:  \nname = " + aMid.getName() 
        + ", sacks = " + aMid.getSacks() + ", health = " + aMid.getHealth() 
        + ", strength = " + aMid.getStrength() 
        + ", poke force = " + aMid.pokeMonster() +
        "\nMid value monster accessors:  \nname = " + mMid.getName() 
        + ", sacks = " + mMid.getSacks() + ", health = " + mMid.getHealth() 
        + ", strength = " + mMid.getStrength() 
        + ", roar force = " + mMid.terrifyAdventurer() + "\n");
    
    counter++;
    System.out.println(counter);
    //  Test predicate methods
    System.out.println(
        "Lowest value adventurer: \n" 
        + ((aLowest.hasSacks()) ? "has" : "has no") + " sacks, "
        + (aLowest.hasHealth() ? "has" : "has no") + " health, " 
        + (aLowest.hasStrength() ? "has" : "has no") + " strength, and " 
        + (aLowest.hasSacksToWin() ? "has" : "does not have") 
        + " enough sacks to win" + 
        "\nLowest value monster: \n" 
        + ((mLowest.hasSacks()) ? "has" : "has no") + " sacks, " 
        + (mLowest.hasHealth() ? "has" : "has no") + " health, and " 
        + (mLowest.hasStrength() ? "has" : "has no") + " strength\n");
       
    counter++;
    System.out.println(counter);    
    System.out.println(
        "Highest value adventurer: \n" 
        + (aHighest.hasSacks() ? "has" : "has no" + " sacks, ") 
        + (aHighest.hasHealth() ? "has" : "has no") + " health, " 
        + (aHighest.hasStrength() ? "has" : "has no") + " strength, and " 
        + (aHighest.hasSacksToWin() ? "has" : "does not have") 
        + " enough sacks to win" + 
        "\nHighest value monster : \n" 
        + ((mHighest.hasSacks()) ? "has" : "has no") + " sacks, " 
        + (mHighest.hasHealth() ? "has" : "has no") + " health, and " 
        + (mHighest.hasStrength() ? "has" : "has no") + " strength\n");    
    
    
    counter++;
    System.out.println(counter);
    aHighest.setSacks(Adventurer.NUMBER_SACKS_TO_WIN);
    System.out.println(
        "After setting sacks to NUMBER_SACKS_TO_WIN, " 
        + "highest value adventurer: \n"
        + (aHighest.hasSacks() ? "has" : "has no") + " sacks, " 
        + (aHighest.hasHealth() ? "has" : "has no") 
        + " health, " 
        + (aHighest.hasStrength() ? "has" : "has no") 
        + " strength, and " 
        + (aHighest.hasSacksToWin() ? "has" : "does not have") 
        + " enough sacks to win\n"); 

    
    counter++;
    System.out.println(counter);    
    System.out.println(
        "Mid value adventurer: \n" 
        + ((aMid.hasSacks()) ? "has" : "has no") + " sacks, " 
        + (aMid.hasHealth() ? "has" : "has no") + " health, " 
        + (aMid.hasStrength() ? "has" : "has no") + " strength, and " 
        + (aMid.hasSacksToWin() ? "has" : "does not have") 
        + " enough sacks to win" + 
        "\nMid value monster : \n" 
        + ((mMid.hasSacks()) ? "has" : "has no") + " sacks, "
        + (mMid.hasHealth() ? "has" : "has no") + " health, and "
        + (mMid.hasStrength() ? "has" : "has no") + " strength\n");    
    
    //  Test mutators
    
    counter++;
    System.out.println(counter);    
    aMid.incrementSacks();
    aMid.reduceStrength();
    System.out.println(
        "Mid value adventurer " 
        + "after incrementing sacks and reducing strength:  \n" + aMid);
    
    counter++;
    System.out.println(counter);
    aMid.sufferTerror(mMid.terrifyAdventurer());
    System.out.println(
        "Mid value adventurer after suffering terror: \n" + aMid);
    
    counter++;
    System.out.println(counter);
    aMid.decrementSacks();
    aMid.restoreHealth();
    aMid.restoreStrength();
    System.out.println(
        "Mid value adventurer after decrementing sacks " 
        + "and restoring health and strength: \n" + aMid);
    
    counter++;
    System.out.println(counter);
    aMid.setSacks(11);
    aMid.setHealth(80);
    aMid.setStrength(8);
    System.out.println(
        "Mid value adventurer after setting sacks to 11, " 
        + "health to 80, and strength to 8: \n" + aMid);
    
    counter++;
    System.out.println(counter);
    aMid.setSacks(-1);
    aMid.setHealth(-1);
    aMid.setStrength(-1);
    System.out.println(
        "Mid value adventurer after setting sacks to -1, "
        + "health to -1, and strength to -1: \n" + aMid);    
    
    counter++;
    System.out.println(counter);
    aMid.setSacks(8);
    aMid.setHealth(40);
    aMid.setStrength(4);
    System.out.println(
        "Mid value adventurer after setting sacks to 8, "
        + "health to 40, and strength to 4:  \n" + aMid);
    
    counter++;
    System.out.println(counter);
    aMid.resetHealth();
    aMid.resetStrength();
    System.out.println(
        "Mid value adventurer after resetting health and strength:  \n" + aMid);
    
    counter++;
    System.out.println(counter);
    mMid.incrementSacks();
    mMid.reduceStrength();
    System.out.println(
        "Mid value monster after incrementing sacks and reducing strength:  \n" 
        + mMid);
    
    counter++;
    System.out.println(counter);
    mMid.sufferPoke(aMid.pokeMonster());
    System.out.println("Mid value monster after suffering poke:  \n" + mMid);
    
    counter++;
    System.out.println(counter);
    mMid.decrementSacks();
    mMid.restoreHealth();
    mMid.restoreStrength();
    System.out.println(
        "Mid value monster after decrementing sacks "
        + "and restoring health and strength:  \n" + mMid);
    
    counter++;
    System.out.println(counter);
    mMid.setSacks(11);
    mMid.setHealth(80);
    mMid.setStrength(8);
    System.out.println("Mid value monster after setting sacks to 11, "
        + "health to 80, and strength to 8:  \n" + mMid);
    
    counter++;
    System.out.println(counter);
    mMid.setSacks(-1);
    mMid.setHealth(-1);
    mMid.setStrength(-1);
    System.out.println("Mid value monster after setting sacks to -1, "
        + "health to -1, and strength to -1:  \n" + mMid);  
    
    counter++;
    System.out.println(counter);
    mMid.setSacks(8);
    mMid.setHealth(40);
    mMid.setStrength(4);
    System.out.println("Mid value monster after setting sacks to 8, "
        + "health to 40, and strength to 4:  \n" + mMid);    
    
    counter++;
    System.out.println(counter);
    mMid.resetHealth();
    mMid.resetStrength();
    System.out.println(
        "Mid value monster after resetting health and strength:  \n" + mMid);  
    
    counter++;
    System.out.println(divider);
    System.out.println(counter + " (LOOP OUTPUT)");      
    for (int i=0; i<7; i++)
    {      
      aMid.sufferTerror(Monster.MAX_STRENGTH_POSSIBLE);
      System.out.println(
          "Mid value adventurer after suffering (max)terror:  \n"  + aMid);
    }
    
    counter++;
    System.out.println(divider);
    System.out.println(counter + " (LOOP OUTPUT)");
    for (int i=0; i<12; i++)
    {
      aMid.restoreHealth();
      aMid.restoreStrength();
      System.out.println(
          "Mid value adventurer after restoring health and strength: \n"  
          + aMid);
    }
    
    counter++;
    System.out.println(divider);
    System.out.println(counter + " (LOOP OUTPUT)");
    for (int i=0; i<12; i++)
    {  
      aMid.reduceStrength();
      System.out.println("Mid value adventurer after reducing strength:  \n"  
      + aMid);
    }
    
    counter++;
    System.out.println(divider);
    System.out.println(counter + " (LOOP OUTPUT)");    
    for (int i=0; i<7; i++)
    {      
      mMid.sufferPoke(Adventurer.MAX_STRENGTH_POSSIBLE);
      System.out.println("Mid value monster after suffering (max)terror:  \n" 
      + mMid);
    }
    
    counter++;
    System.out.println(divider);
    System.out.println(counter + " (LOOP OUTPUT)");    
    for (int i=0; i<12; i++)
    {
      mMid.restoreHealth();
      mMid.restoreStrength();
      System.out.println(
          "Mid value monster after restoring health and strength:  \n"  + mMid);
    }
    
    counter++;
    System.out.println(divider);
    System.out.println(counter + " (LOOP OUTPUT)");
    for (int i=0; i<12; i++)
    {  
      mMid.reduceStrength();
      System.out.println(
          "Mid value monster after reducing strength:  \n"  + mMid);
    }
  } 
}
