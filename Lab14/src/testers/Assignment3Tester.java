
package testers;

import characters.Adventurer;
import characters.Monster;
import utility.SingleRandom;

/**
 * Test modified Adventurer and Monster classes
 * @author Rose Williams
 *
 */
public class Assignment3Tester
{
  
  /**
   * Test that new SingleRandom randomly allocates
   *   health and strength to characters, and
   *   sacks to Monster
   * @param args
   */
  public static void main(String[] args)
  {
    //Test constructors
    //  Show that default Adventurer constructor
    //    creates Adventurer with 
    //    name "Anonymous", 0 sacks, 
    //    and random health and strength
    //  Show that default Monster constructor 
    //    creates Monster with 
    //    name "Anonymous", full sacks, 
    //    and random health, and strength
    
    SingleRandom.getInstance().setSeed(1601);
    
    int counter = 0;
    Adventurer a0 = new Adventurer();
    Monster m0 = new Monster();
    System.out.println(
        "Default adventurer0:  \n" + a0 
        + "Max Health = " + a0.MAX_HEALTH
        + ", Max Strength = " + a0.MAX_STRENGTH + 
        "\n\nDefault monster0:  \n" + m0 
        + "Max Health = " + m0.MAX_HEALTH
        + ", Max Strength = " + m0.MAX_STRENGTH +  "\n");

    counter++;
    System.out.println(counter);
    Adventurer a1 = new Adventurer();
    Monster m1 = new Monster();
    System.out.println(
        "Default adventurer1:  \n" + a1 
        + "Max Health = " + a1.MAX_HEALTH
        + ", Max Strength = " + a1.MAX_STRENGTH + 
        "\n\nDefault monster1:  \n" + m1 
        + "Max Health = " + m1.MAX_HEALTH
        + ", Max Strength = " + m1.MAX_STRENGTH +  "\n");
    
    counter++;
    System.out.println(counter);
    Adventurer a2 = new Adventurer();
    Monster m2 = new Monster();
    System.out.println(
        "Default adventurer2:  \n" + a2 
        + "Max Health = " + a2.MAX_HEALTH
        + ", Max Strength = " + a2.MAX_STRENGTH + 
        "\n\nDefault monster2:  \n" + m2 
        + "Max Health = " + m2.MAX_HEALTH
        + ", Max Strength = " + m2.MAX_STRENGTH +  "\n");
    
    //  Show that one parameter constructor creates Adventurer 
    //    with given name, 0 sacks, random health and strength
    //  Show that one parameter constructor creates Monster 
    //    with given name, random sacks, health, and strength
    
    counter++;
    System.out.println(counter);
    Adventurer naughty1 = new Adventurer("Naughty1");
    Monster happy1 = new Monster("Happy1");
    System.out.println(
        "Adventurer naughty1:  \n" + naughty1 
        + "Max Health = " + naughty1.MAX_HEALTH 
        + ", Max Strength = " + naughty1.MAX_STRENGTH + 
        "\n\nMonster happy1:  \n" + happy1 
        + "Max Health = " + happy1.MAX_HEALTH 
        + ", Max Strength = " + happy1.MAX_STRENGTH +  "\n");
    
    counter++;
    System.out.println(counter);
    Adventurer naughty2 = new Adventurer("Naughty2");
    Monster happy2 = new Monster("Happy2");
    System.out.println(
        "Adventurer naughty2:  \n" + naughty2 
        + "Max Health = " + naughty2.MAX_HEALTH 
        + ", Max Strength = " + naughty2.MAX_STRENGTH + 
        "\n\nMonster happy2:  \n" + happy2  
        + "Max Health = " + happy2.MAX_HEALTH  
        + ", Max Strength = " + happy2.MAX_STRENGTH +  "\n");
    
    counter++;
    System.out.println(counter);
    Adventurer naughty3 = new Adventurer("Naughty3");
    Monster happy3 = new Monster("Happy3");
    System.out.println(
        "Adventurer naughty3:  \n" + naughty3 
        + "Max Health = " + naughty3.MAX_HEALTH  
        + ", Max Strength = " + naughty3.MAX_STRENGTH + 
        "\n\nMonster happy3:  \n" + happy3  
        + "Max Health = " + happy3.MAX_HEALTH 
        + ", Max Strength = " + happy3.MAX_STRENGTH +  "\n"); 
  } 
}

