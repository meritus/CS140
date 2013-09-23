package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import nim.Nim;
import nim.Player;

/**
 * This class encapsulates the CONTROLLER in a game of Nim
 * @author Rose Williams
 */
public class ControlPanel extends JPanel
{
  // Class constants -----------------------------------------------------------
  
  // Logging
  private static Handler      handler;
  
  // Identifies players
  public static final int     PLAYER1 = 0;
  public static final int     PLAYER2 = 1;
  
  // Instance variables --------------------------------------------------------
  
  // Logging
  private Logger               logObj  = Logger.getLogger("Controller");
  
  // MODEL
  private Nim                 nim;
  
  // Buttons
  private JButton             newGame;
  private JButton             humanTurn;
  private JButton             computerTurn;
  
  // Spinner
  private JSpinner            spinner;
  private SpinnerModel        spinnerModel;
  
  // Label
  private JLabel              howMany;
  
  // Constructor ---------------------------------------------------------------

  /**
   * Creates control panel for game of Nim
   * @param nim
   */
  public ControlPanel(Nim nim)
  {
    // set up logging
    //output will go to file named in argument
    try
    {
      handler = new FileHandler("Nim.log");
      // SimpleFormatter produces plain text(as opposed to XML)
      handler.setFormatter(new SimpleFormatter());
      logObj.addHandler(handler);
      logObj.setLevel(Level.ALL);
    }
    catch (SecurityException e)
    {
      e.printStackTrace();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    
    // Inner Classes (Listener classes) ----------------------------------------
    
    class NewGameListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        newGame();
      }
    }
    
    class HumanListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        humanTurn();
      }
    }
    
    class ComputerListener implements ActionListener
    {
      public void actionPerformed(ActionEvent event)
      {
        computerTurn();
      }
    }
    
    // End Inner Classes -------------------------------------------------------
    
    //Prettify
    this.setBorder(BorderFactory.createRaisedBevelBorder());
    
    //Create model
    this.nim = nim;
    
    //New Game button
    newGame = new JButton();
    newGame.setLayout(new BorderLayout());
    newGame.add(BorderLayout.NORTH, new JLabel("New"));
    newGame.add(BorderLayout.SOUTH, new JLabel("Game"));
    ActionListener newGameListener = new NewGameListener();
    newGame.addActionListener(newGameListener);
    
    //Spinner
    spinnerModel = new SpinnerNumberModel(1, 1, nim.getNumberTokens() / 2, 1);
    spinner = new JSpinner(spinnerModel);
    
    //Human button
    humanTurn = new JButton();
    humanTurn.setLayout(new BorderLayout());
    humanTurn.add(BorderLayout.NORTH, new JLabel("Human:"));
    humanTurn.add(BorderLayout.SOUTH, new JLabel("Remove"));
    ActionListener removeListener = new HumanListener();
    humanTurn.addActionListener(removeListener);
    
    //Computer button
    computerTurn = new JButton();
    computerTurn.setLayout(new BorderLayout());
    computerTurn.add(BorderLayout.NORTH, new JLabel("Computer:"));
    computerTurn.add(BorderLayout.SOUTH, new JLabel("Remove"));
    ActionListener oKListener = new ComputerListener();
    computerTurn.addActionListener(oKListener);
    
    //Label
    howMany = new JLabel("How Many?");
    
    //Add components to panel
    this.add(newGame);
    this.add(howMany);
    this.add(spinner);
    this.add(humanTurn);
    this.add(computerTurn);
    
    //Take care of the VIEW part of the controller
    //Disable New Game button
    newGame.setEnabled(false);
    //Enable/Disable remaining buttons
    updateControls();
  }

  // Private Methods -----------------------------------------------------------
  
  /**
   * Manages turn for computer player
   */
  private void computerTurn()
  {
    nim.takeTurn();
    if (nim.gameIsNotOver())
    {
      nim.setNextPlayer();
      updateSpinner();
      updateControls();
    }
    else
    {
      finishGame();
    }
  }
  
  /**
   * Manages turn for human player
   */
  private void humanTurn()
  {
    int pending = (Integer) spinner.getValue();
    if (validate(pending)) 
    {
      nim.takeTurn(pending);
      logObj.info("Human takes " + pending + " sticks");
      if (nim.gameIsNotOver())
      {
        nim.setNextPlayer();
        updateControls();
      }
      else
      {
        finishGame();
      }
    }
  }
  
  /**
   * Validates number of tokens that human player wishes to remove
   */
  private boolean validate(int pending)
  {
    boolean validated = true;
    if ((nim.getNumberTokens() == 1 && pending != 1)
        || (pending < 1 || (nim.getNumberTokens() > 1 && pending > nim
            .getNumberTokens() / 2)))
    {
      JOptionPane.showMessageDialog(null, "You can only take between\n"
          + "1 and "
          + (nim.getNumberTokens() == 1 ? 1 : nim.getNumberTokens() / 2)
          + " sticks from the pile");
      validated = false;
    }
    return validated;
  }
  
  // Create new game and manage VIEW part of CONTROLLER ------------------------
  
  /**
   * Creates new game and manages VIEW part of controls for new game
   */
  private void newGame()
  {
    this.nim = new Nim(Player.COMPUTER);
    updateSpinner();
    updateControls();
    newGame.setEnabled(false);
  }
  
  // Manage VIEW part of CONTROLLER --------------------------------------------
  
  /**
   * Manages VIEW part of controls for end game (enable/disable)
   */
  private void finishGame()
  {
    spinner.setEnabled(false);
    humanTurn.setEnabled(false);
    computerTurn.setEnabled(false);
    newGame.setEnabled(true);
  }
  
  /**
   * Manages VIEW part of spinner control during game play
   * (i.e., values displayed by spinner)
   */
  private void updateSpinner()
  {
    int max = (nim.getNumberTokens() / 2 > 0 ? nim.getNumberTokens() / 2 : 1);
    spinnerModel = new SpinnerNumberModel(1, 1, max, 1);
    spinner.setModel(spinnerModel);
  }
  
  /**
   * Manages VIEW part of controls during game play (enable/disable)
   */
  private void updateControls()
  {
    spinner.setEnabled(nim.getCurrentPlayer() == PLAYER1 ? true : false);
    humanTurn.setEnabled(nim.getCurrentPlayer() == PLAYER1 ? true : false);
    computerTurn.setEnabled(nim.getCurrentPlayer() == PLAYER2 ? true : false);
  }
}