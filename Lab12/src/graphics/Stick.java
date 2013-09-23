package graphics;

/**
*
*Michelle Hochman
*mhochma1@binghamton.edu
*Lab 10
*/

import java.awt.Color;
import java.awt.Graphics2D;
import utility.SingleRandom;

/**
 * This class represents a stick
 * @author Michelle
 *
 */
public class Stick
{
	/**
	 * low x
	 */
	private int lowx;
	/**
	 * low y
	 */
	private int lowy;
	/**
	 *high x
	 */
	private int hix;
	/**
	 * high y
	 */
	private int hiy;
	/**
	 * color
	 */
	private Color color;
	/**
	 * angle
	 */
	private double angle;

	/**
	 * constructor for stick class
	 * @param color
	 */
	public Stick(Color color)
	{
		this.color = color;
		throwStick();
	}
	
	/**
	 * mutator that 'throws a stick'
	 */
	public void throwStick()
	{
		lowx = 
		  (int)Math.round(100+200*SingleRandom.getInstance().nextDoubleWrapper());
		lowy = 
		  (int)Math.round( 50+200*SingleRandom.getInstance().nextDoubleWrapper());
		angle = 180*SingleRandom.getInstance().nextDoubleWrapper();
		
		hix = (int)Math.round(lowx + 100*Math.cos(Math.toRadians(angle)));
		hiy = (int)Math.round(lowy + 100*Math.sin(Math.toRadians(angle)));
	}
	
	/**
	 * mutator for gui
	 * @param g
	 */
	public void draw(Graphics2D g)
	{
		Color col = g.getColor();
		g.setColor(color);
		g.drawLine(lowx,lowy,hix,hiy);
		g.setColor(col);		
	}
}
