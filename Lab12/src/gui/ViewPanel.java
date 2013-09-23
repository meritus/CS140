package gui;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import static java.awt.Color.*;
import nim.Nim;
import graphics.Stick;

import java.util.Observable;
import java.util.Observer;

/**
 * This class extends JPanel
 * @author Michelle Hochman
 *
 */
public class ViewPanel extends JPanel implements Observer
{
	/**
	 * nim object
	 */
    private Nim nim;
    /**
     * constant for wideStroke
     */
	private static final BasicStroke wideStroke = new BasicStroke(8.0f);
	/**
	 * constant for font
	 */
	private static final Font font = new Font("Dialog",Font.BOLD, 18); 
	/**
	 * stick array
	 */
	private Stick[] sticks;
	/**
	 * instance variable for number of sticks
	 */
	private int numSticks;
	/**
	 * message instance
	 */
	private String message;
	
	private String[] playerArray = {"Human", "Computer"};
	/**
	 * color enum
	 */
	private Color[] colors = {YELLOW, RED, WHITE, CYAN, GREEN, MAGENTA, 
			ORANGE, PINK, BLUE, LIGHT_GRAY, GRAY};
	// Omit DARK_GRAY and BLACK
	// NOTE THAT import static java.awt.Color.*;
	// allows us to write BLUE instead of Color.BLUE, etc.

	/**
	 * constructor
	 * @param nim
	 */
	public ViewPanel() 
	{
	  /**this.nim = nim;
	  this.numSticks = nim.getNumberTokens(); 
	  message = "#Sticks = " + numSticks + 
	    ", Current turn:  Player" + (nim.getCurrentPlayer() +1);
	  sticks = new Stick[numSticks];
	  int colorIndex = 0;
	  for(int i = 0; i < sticks.length; i++) 
	  {
	    sticks[i] = new Stick(colors[colorIndex++%colors.length]);
	  }*/
		this.numSticks = 0;
		message = "";
		sticks = null;
	}

	/**
	 * mutator for updating the view
	 */
	public void updateView() 
	{
		numSticks = nim.getNumberTokens();
    message = "#Sticks = " + numSticks + 
        ", Current turn:  Player" + (nim.getCurrentPlayer() +1);
		repaint();
	}
	
	/**
	 * mutator for updating the view
	 */
	public void updateView(String message)
	{
	  this.message = message;
	  repaint();
	}
	
	/**
	 * mutator for a new game
	 */
	public void newGame(Nim nim)
	{
	  this.nim = nim;
	  this.numSticks = nim.getNumberTokens();
	  //message = "#Sticks = " + numSticks + ", Current turn:  Player" + (nim.getCurrentPlayer() +1);
	  sticks = new Stick[numSticks];
	  int colorIndex = 0;
    for(int i = 0; i < sticks.length; i++) 
    {
      sticks[i] = new Stick(colors[colorIndex++%colors.length]);
    }
	}
	
	/**
	 * get the number of tokens from the MODEL,
	 * use it to set the numSticks instance variable
	 */
	public void setNumSticks()
	{
		numSticks = nim.getNumberTokens();
	}
	
	/**
	 * Set the value of the message according to whether there are sticks or not
	 */
	public void setMessage()
	{
		message = (numSticks > 0 ? "There are" + numSticks + "sticks" : "There are no sticks");
	}
	
	public void update(Observable model, Object arg)
	{
		this.nim = (Nim)model;
		setNumSticks();
		if(arg == "New")
		{
			newGame(nim);
		}
		setMessage();
		repaint();
	}
	
	/**
	 * mutator for painting the component
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		Graphics2D graphics = (Graphics2D)g;
		graphics.setStroke(wideStroke);
		if (sticks != null) {
			for(int i = 0; i < numSticks; i++)	
			{
				sticks[i].draw(graphics);
			}
		}
		graphics.setColor(WHITE);
		graphics.setFont(font);
		graphics.drawString(message, 10, 30);
	}	
}
