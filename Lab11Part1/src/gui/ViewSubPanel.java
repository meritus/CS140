package gui;

import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;

/**
 * Serves as a  sub panel of the view in which to display character status
 * Note that this object can display status of any character
 * @author Rose Williams
 *
 */
public class ViewSubPanel extends JPanel
{
  // Instance Variables --------------------------------------------------------

  /**
   * Returns a String containing character status
   */
  private CharacterStatus status;
  
  /**
   * This label will display the character status String
   */
  private JLabel viewModel;

  // Constructors --------------------------------------------------------------

  /**
   * Creates this JPanel with a Label
   * @param status
   */
  public ViewSubPanel(CharacterStatus status)
  {
    // Initialize the status object
    this.status = status;
    // Create the label with text from the status object
    viewModel = new JLabel(status.getStatus(), JLabel.LEFT);
    // Set the font to a monospaced type
    viewModel.setFont(new Font("Consolas", Font.BOLD, 12));
    // FlowLayout is the default layout manager for a JPanel
    // However, the default FlowLayout is constructed with centered alignment 
    //   and a default 5-unit horizontal and vertical gap
    // We will create a new Flow Layout object so that we can set our own
    //   horizontal alignment and horiz/vert gaps
    this.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 10));
    
    // add the label to the JPanel 
    // (remember that an object of this class IS a JPanel)
    // PLACE YOUR CODE HERE
  }
  
  /**
   * Updates the view when the model has changed
   */
  public void updateView()
  {
    // Use the setText method to change the text in the label
    viewModel.setText(status.getStatus());
  }
}