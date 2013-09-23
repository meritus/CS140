package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import static java.awt.Color.*;
import nim.Nim;
import graphics.Stick;

/**
 * This class encapsulates the VIEW in a game of Nim
 * It uses the built-in Observer pattern from the Java API
 *
 */
public class ViewPanel extends JPanel implements Observer
{
  //Class Constants ------------------------------------------------------------
  private static final BasicStroke wideStroke = new BasicStroke(8.0f);
  private static final Font font = new Font("Dialog",Font.BOLD, 18); 
  
  // Instance variables --------------------------------------------------------
  private String[] playerArray = {"Human", "Computer"};
	private Nim nim;
	private Stick[] sticks;
	private int numSticks; 
	private String message;
	private Color[] colors = {YELLOW, RED, WHITE, CYAN, GREEN, MAGENTA, 
			ORANGE, PINK, BLUE, LIGHT_GRAY, GRAY};
	// Omit DARK_GRAY and BLACK
	// NOTE THAT import static java.awt.Color.*;
	// allows us to write BLUE instead of Color.BLUE, etc. 
	
	// Constructor ---------------------------------------------------------------
	
	/**
	 * Creates VIEW panel for game of Nim
	 */
	public ViewPanel()
	{
	  // wait for update() to find out about MODEL
	  numSticks = 0;
	  message = "";
	  sticks = null;
	}
	
	// Private methods -----------------------------------------------------------
	
	/**
	 * Updates number of sticks to be displayed on this VIEW panel
	 */
	private void setNumSticks()
	{
	   this.numSticks = nim.getNumberTokens();
	}
	
	/**
	 * Updates message to be displayed on this VIEW panel
	 */
	private void setMessage()
	{
    if (numSticks > 0)
    {
      message = "#Sticks = " + numSticks + 
        ", Current turn:  " + playerArray[nim.getCurrentPlayer()];
    }
	  else 
    {
      message = 
       playerArray[nim.getCurrentPlayer()] + " loses, " +
       playerArray[nim.getNextPlayer()] + " wins!";
    }
	}
    
	/**
	 * Creates new pile of sticks to be displayed on this VIEW panel
	 */
	private void newGame()
	{
	  sticks = new Stick[numSticks];
	  int colorIndex = 0;
	  for(int i = 0; i < sticks.length; i++) 
	  {
	    sticks[i] = new Stick(colors[colorIndex++%colors.length]);
	  }
	}
	
  // Observer Implementation ---------------------------------------------------
	
	/**
	 * Responsible for updating the VIEW whenever the MODEL changes
	 * @param model - the Observable MODEL
	 * @param arg - provides information from the MODEL about what changed
	 */
	public void update (Observable model, Object arg)
	{
	  this.nim = (Nim) model;
	  setNumSticks();
	  if (((String)arg).equals("New"))
	  {
	    newGame();
	  }
	  setMessage();
	  repaint();
	}
	
	// Overridden JComponent Method ----------------------------------------------
	
	/**
	 * Encapsulates the drawing instructions for this panel
	 */
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		// Create backdrop
		g.setColor(BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		// Recover 2D Graphics context and modify "pen" width
		Graphics2D graphics = (Graphics2D)g;
		graphics.setStroke(wideStroke);
		
		// Draw all the sticks in the pile
		if (sticks != null) 
		{
			for(int i = 0; i < numSticks; i++)	
			{
				sticks[i].draw(graphics);
			}
		}
		
		// Modify "pen" and display message
		graphics.setColor(WHITE);
		graphics.setFont(font);
		graphics.drawString(message, 10, 30);
	}	
}
