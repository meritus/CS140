package gui;

import game.Game;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * This class serves as the VIEW in the NewZorkGUI
 * It creates an area where aspects of the MODEL can be displayed
 * @author Rose Williams
 *
 */
public class ViewPanel extends JPanel
{
  // Instance Variables --------------------------------------------------------

  /**
   * MODEL
   * What this VIEW will show
   */
  private Game game;
  
  /**
   * SubPanel of this VIEW
   * Will show info about Adventurer portion of MODEL
   */
  private ViewSubPanel viewAdventurer;
  
  /**
   * SubPanel of this VIEW
   * Will show info about Monster portion of MODEL
   */
  private ViewSubPanel viewMonster;

  // Inner Classes -------------------------------------------------------------
  
  /**
   * Inner class that implements CharacterStatus interface
   * Will generate and return Adventurer status
   */
  class AdventurerStatus implements CharacterStatus
  {
    /**
     * Returns String showing info about adventurer portion of MODEL
     * Note that all information requests go through MODEL
     */
    public String getStatus()
    {
      String status = "No Adventurer Defined";
      if (game.hasAdventurer())
      {
        // Get adventurer status from MODEL
        status = game.aString();
      }
      return status;
    }    
  }

  /**
   * Inner class that implements CharacterStatus interface
   * Will generate and return Monster status
   */
  class MonsterStatus implements CharacterStatus
  {
    /**
     * Returns String showing info about monster portion of MODEL
     * Note that all information requests go through MODEL
     */
    public String getStatus()
    {
      //PLACE YOUR CODE HERE
    }
  }  
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Creates this JPanel as well as the subpanels that reside within it
   * @param game
   */
  public ViewPanel(Game game)
  {
    // Initialize MODEL
    this.game = game; 
    
    // Create subpanels
    // Note that each takes in an appropriate CharacterStatus object
    viewAdventurer = new ViewSubPanel(new AdventurerStatus());
    //PLACE YOUR CODE HERE
    
    // Set the layout manager of this JPanel to BorderLayout, and add the
    //   adventurer subpanel to the top, and the monster subpanel to the bottom
    this.setLayout(new BorderLayout());
    this.add(viewAdventurer, BorderLayout.NORTH);
    //PLACE YOUR CODE HERE
  }
  
  // Accessor Methods ----------------------------------------------------------
  
  /**
   * Return adventurer subpanel
   * @return adventurer subpanel
   */
  public ViewSubPanel getAdventurer()
  {
    return viewAdventurer;
  }
  
  /**
   * Return monster subpanel
   * @return monster subpanel
   */
  public ViewSubPanel getMonster()
  {
    //PLACE YOUR CODE HERE
  }  
}
