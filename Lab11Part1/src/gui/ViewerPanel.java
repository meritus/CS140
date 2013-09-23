package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.util.logging.Logger;
import java.util.logging.Level;
import repository.CharacterImage;
//Additional imports here

// JPanel is a subclass of JComponent and 
//  has more capabilities than JComponent,
//  so we can use it instead of JComponent
public class ViewerPanel extends JPanel
{  
	//-- Class variables --------------------------------------------------------	

  /**
   * Gets Logger object
   */
	public static Logger log;
  static
  {
    log = Logger.getLogger("ViewerPanel");
  }
  
	//-- Instance constants -----------------------------------------------------

  //panel width 
  public final int WIDTH;  
  
  //panel height
  public final int HEIGHT; 
  
  //generic character image
  private CharacterImage character; 
  // Other declarations here
  
  //-- Constructors -----------------------------------------------------------

  /**
   *  Creates a panel with a given width and height 
   *  @param width
   *  @param height
   */
  public ViewerPanel(int width, int height)
  {    
  	setUpLogging();
  	log.info("Viewer Panel");
  	
    WIDTH = width;
    HEIGHT = height;
    
    // Coordinates place character in middle of the screen
    // Modify as necessary for your own characters
    // WATCH OUT FOR INTEGER DIVISION when it gets more complicated!!
    character = new CharacterImage(WIDTH/2, HEIGHT/2);
    // create other objects here
  }

  //-- Class Methods ---------------------------------------------------

  private static void setUpLogging()
  {
    log.setLevel(Level.ALL);     
    //log.setLevel(Level.OFF);
  }  

  //-- Instance Methods -------------------------------------------------------
  // This method is never invoked directly
  // Responsible for "painting" panel
  public void paintComponent(Graphics g)
  {
    log.info("BEGIN paintComponent");
  	// Invoke superclass methods first:  superclass is a JPanel
    super.paintComponent(g);
    
    // Set color and fill rectangle for backdrop
    g.setColor(Color.BLACK);
    g.fillRect(0, 0, getWidth(), getHeight());

    // Cast to Graphics2D
    Graphics2D g2 = (Graphics2D) g; 
    
    //Draw the character image 
    character.draw(g2);  
    // Invoke draw() method for other object here
    // Watch out for order of operations 
  } 
}