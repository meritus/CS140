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

public class ViewPanel extends JPanel implements Observer
{
	private Nim nim;
	private static final BasicStroke wideStroke = new BasicStroke(8.0f);
	private static final Font font = new Font("Dialog", Font.BOLD, 18);
	private Stick[] sticks;
	private int numSticks;
	private String message;
	private Color[] colors =
	{ YELLOW, RED, WHITE, CYAN, GREEN, MAGENTA, ORANGE, PINK, BLUE, LIGHT_GRAY,
			GRAY };
	private String[] playerArray =
	{ "Human", "Computer" };

	// Omit DARK_GRAY and BLACK
	// NOTE THAT import static java.awt.Color.*;
	// allows us to write BLUE instead of Color.BLUE, etc.

	public ViewPanel()
	{
		/**
		 * this.nim = nim; this.numSticks = nim.getNumberTokens(); message =
		 * "#Sticks = " + numSticks + ", Current turn:  Player" +
		 * (nim.getCurrentPlayer() + 1); sticks = new Stick[numSticks]; int
		 * colorIndex = 0; for (int i = 0; i < sticks.length; i++) { sticks[i] =
		 * new Stick(colors[colorIndex++ % colors.length]); }
		 **/
		numSticks = 0;
		message = "";
		sticks = null;
	}

	public void updateView()
	{
		numSticks = nim.getNumberTokens();
		message = "#Sticks = " + numSticks + ", Current turn:  Player"
				+ (nim.getCurrentPlayer() + 1);
		repaint();
	}

	public void updateView(String message)
	{
		this.message = message;
		repaint();
	}

	public void setNumSticks()
	{
		numSticks = nim.getNumberTokens();
	}

	public void setMessage()
	{
		message = (numSticks > 0 ? "has Sticks" : "has no Sticks");
	}

	public void update(Observable model, Object arg)
	{
		this.nim = (Nim) model;
		setNumSticks();
		if (arg == "New")
		{
			newGame(nim);
		}
		setMessage();
		repaint();
	}

	public void newGame(Nim nim)
	{
		this.nim = nim;
		this.numSticks = nim.getNumberTokens();
		// message = "#Sticks = " + numSticks + ", Current turn:  Player"
		// + (nim.getCurrentPlayer() + 1);
		sticks = new Stick[numSticks];
		int colorIndex = 0;
		for (int i = 0; i < sticks.length; i++)
		{
			sticks[i] = new Stick(colors[colorIndex++ % colors.length]);
		}
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		Graphics2D graphics = (Graphics2D) g;
		graphics.setStroke(wideStroke);
		if (sticks != null)
		{
			for (int i = 0; i < numSticks; i++)
			{
				sticks[i].draw(graphics);
			}
		}
		graphics.setColor(WHITE);
		graphics.setFont(font);
		graphics.drawString(message, 10, 30);
	}
}
