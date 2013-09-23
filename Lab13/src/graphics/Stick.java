package graphics;

import static java.awt.Color.BLUE;
import static java.awt.Color.CYAN;
import static java.awt.Color.GRAY;
import static java.awt.Color.GREEN;
import static java.awt.Color.LIGHT_GRAY;
import static java.awt.Color.MAGENTA;
import static java.awt.Color.ORANGE;
import static java.awt.Color.PINK;
import static java.awt.Color.RED;
import static java.awt.Color.WHITE;
import static java.awt.Color.YELLOW;

import java.awt.Color;
import java.awt.Graphics2D;
import utility.SingleRandom;

/**
 * This class models a simple colored stick
 */
public class Stick
{
	private int lowx;
	private int lowy;
	private int hix;
	private int hiy;
	private Color color;
	private double angle;

	public Stick(Color color)
	{
		this.color = color;
		throwStick();
	}
	
  /**
   * Compute coordinates and angle of stick
   */
	public void throwStick()
	{
		lowx = 
		    (int)Math.round(100+200*SingleRandom.getInstance().nextDoubleWrapper());
		lowy = 
		    (int)Math.round( 50+200*SingleRandom.getInstance().nextDoubleWrapper());
		angle = 
		    180*SingleRandom.getInstance().nextDoubleWrapper();
		
		hix = (int)Math.round(lowx + 100*Math.cos(Math.toRadians(angle)));
		hiy = (int)Math.round(lowy + 100*Math.sin(Math.toRadians(angle)));
	}
	
	/**
	 * Draws stick given graphics context
	 * @param g - graphics context
	 */
	public void draw(Graphics2D g)
	{
	  // Use instance variable color
		g.setColor(color); 
		g.drawLine(lowx,lowy,hix,hiy);	
	}
	
	/**
	 *  Overrides Object class method
	 *  @return String representation of this stick
	 */
	@Override
	public String toString()
	{
	  return String.format(
	    "%s, color = %-33s, " +
	    "lowx = %3d, lowy =  %3d, hix = %3d, hiy = %3d, angle = %5.1f", 
	    getClass().getName(), color, lowx, lowy, hix, hiy, angle);
	}
	
	/** 
	 * Builtin tester method for sanity checking computations
	 * @param args
	 */
	public static void main(String[] args)
	{
	  Color[] colors = {YELLOW, RED, WHITE, CYAN, GREEN, MAGENTA, 
	      ORANGE, PINK, BLUE, LIGHT_GRAY, GRAY};
	  int colorIndex = 0;
	  Stick stick;
	  for (int i = 0; i < 50; i ++)
	  {
	     stick = new Stick(colors[colorIndex++%colors.length]);
	     System.out.println(stick);
	  }
	}
}
