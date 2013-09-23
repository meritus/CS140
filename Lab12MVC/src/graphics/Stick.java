package graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import utility.SingleRandom;

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
	
	public void draw(Graphics2D g)
	{
		Color col = g.getColor();
		g.setColor(color);
		g.drawLine(lowx,lowy,hix,hiy);
		g.setColor(col);		
	}
}
