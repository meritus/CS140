package gui;

import game.Game;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.border.EtchedBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * This class serves as the CONTROLLER in the NewZorkGUI
 * It consists of the controls that the player can use in order to interact 
 *   with the MODEL
 * @author Rose Williams
 *
 */
public class Controller extends JPanel
{  
  // Instance Variables --------------------------------------------------------
  
  /**
   * MODEL
   * What this CONTROLLER will interact with
   */
  private Game game; 
  
  /**
   * VIEW
   * What will display aspects of the MODEL
   */
  private ViewPanel view; 

  /**
   * Subpanel of VIEW that will display aspects about the adventurer
   */
  private ViewSubPanel viewAdventurer;
  
  /**
   * Subpanel of VIEW that will display aspects about the monster
   */
  private ViewSubPanel viewMonster;
  
  /**
   * Button used to create a new adventurer
   */
  private JButton createAdventurer;
  
  /**
   * Button used to create a new monster
   */
  private JButton createMonster;
  
  /**
   * Button used to poke the monster
   */
  private JButton pokeMonster;
  
  // Listener Inner Classes ----------------------------------------------------

  // Objects of Listener classes are "registered" to GUI components and 
  //   implement listener interfaces by providing implementations for their
  //   event handler methods
  // When an event is fired that belongs to the component, the event handler 
  //  method, or callback, will then be run automatically
  // Note that an event handler is NEVER invoked explicitly
  
  /**
   * Objects of this class will listen to the create adventurer button
   *
   */
  class CreateAdventurerListener implements ActionListener
  {
    /**
     * When the create adventurer button is clicked by the user, this event 
     *   handler will create a new adventurer, update the adventurer part of the
     *   view, and enable the poke monster button if appropriate
     */
    public void actionPerformed(ActionEvent event)
    {
      //PLACE YOUR CODE HERE
    }
  }
  
  /**
   * Objects of this class will listen to the create monster button
   *
   */
  class CreateMonsterListener implements ActionListener
  {
    /**
     * When the create monster button is clicked by the user, this event 
     *   handler will create a new monster, update the monster part of theview, 
     *   and enable the poke monster button if appropriate
     */
    public void actionPerformed(ActionEvent event)
    {
      game.createNewMonster();
      viewMonster.updateView();
      if (game.hasAdventurer() && game.hasMonster() && game.monsterHasSacks())
        pokeMonster.setEnabled(true);
    }
  }
  
  /**
   * Objects of this class will listen to the poke monster button
   *
   */
  class PokeMonsterListener implements ActionListener
  {
    /**
     * When the poke monster button is clicked by the user, this event 
     *   handler will cause the monster to be poked by the adventurer, suffer
     *   its effects, disable the poke monster button if it has no more sacks, 
     *   and update the view
     */
    public void actionPerformed(ActionEvent event)
    {
      game.defendMonster(game.attackMonster());
      if (!game.monsterHasSacks())
        pokeMonster.setEnabled(false);
      viewMonster.updateView();
      viewAdventurer.updateView();
    }
  }
  
  // Constructors --------------------------------------------------------------
  
  /**
   * Initializes the game, creates the view and sends it the game, retrieves the
   *   subpanels from the view, creates and registers the buttons, and adds the
   *   buttons to this JPanel
   * @param game - the MODEL for this CONTROLLER
   */
  public Controller(Game game)
  {
    // Take in the MODEL and set it
  //PLACE YOUR CODE HERE
    
    // Take care of the VIEW:
    // Create the VIEW panel, send it the MODEL
    this.view = new ViewPanel(game);
    // Get the subpanels from the VIEW
    viewAdventurer = view.getAdventurer();
    viewMonster = view.getMonster();
    
    // Take care of this CONTROLLER:
    
    // Create the poke monster button and disable it
    pokeMonster = new JButton("Poke Monster");
    pokeMonster.setEnabled(false);
    
    
    // Create the buttons that create BOTH characters
    createAdventurer = new JButton("Create Adventurer");
    //PLACE YOUR CODE HERE
    
    // Create new listener objects for each button
    ActionListener createAdventurerListener = new CreateAdventurerListener();
    //PLACE YOUR CODE HERE
    ActionListener pokeMonsterListener = new PokeMonsterListener();
    
    // Register each listener with its button
    createAdventurer.addActionListener(createAdventurerListener);
    //PLACE YOUR CODE HERE  
    pokeMonster.addActionListener(pokeMonsterListener);
 
    // Instead of FlowLayout, set the layout manager to GridLayout and 
    //   prettify it
    this.setLayout(new GridLayout(3, 1, 0, 2));
    this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
    
    // Add the buttons to this panel
    this.add(createAdventurer);
    this.add(pokeMonster);
    //PLACE YOUR CODE HERE
  }
  
  /**
   * Return the VIEW panel
   * Note that it will be treated like a plain vanilla JPanel
   * @return the VIEW
   */
  public JPanel getView()
  {
	  return view;
  }
}
