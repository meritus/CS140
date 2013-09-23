package repository;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.BasicStroke;
//Put additional imports here
//i.e., shapes, lines, points, etc.

// Nested packages
// Note that importing java.awt.geom would NOT include classes
// Inner classes
// Note that we do NOT import the inner class
import java.awt.geom.Arc2D; // We will be using Arc2D.Double
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * This class models a generic character in the game of NewZork
 * 
 * @author Rose Williams
 * 
 */
public class CharacterImage
{
	// Class Constants
	// -----------------------------------------------------------

	// Are there certain feature sizes that remain constant?
	// Are there other feature sizes that can be defined relative to them?
	// Are there colors or color schemes to be defined?
	// Should these numbers be replaced by formulas?
	// Add or replace as needed
	public final static int SCALE1 = 36; // Face size * (1/3)
	public final static int SCALE2 = 72; // Face size * (2/3)
	public final static int SCALE3 = 108; // Face width and height
	public final static int PEN_WIDTH = 2; // Will be more visible than default

	// Instance Variables
	// --------------------------------------------------------

	// You can use variables to represent EITHER
	// the top-left corner of the bounding boxes surrounding your character OR
	// the coordinate of the midpoint of your character
	// My coords start at midpoint of character
	// Note: just make all calculations relative to it and document
	private double xLeft;
	private double yTop;

	// Constructors
	// --------------------------------------------------------------

	/**
	 * Create Character Image object with x,y reference point This reference
	 * point starts at the middle of the character
	 */
	public CharacterImage(double xLeft, double yTop)
	{
		this.xLeft = xLeft;
		this.yTop = yTop;
	}

	// Instance methods
	// ----------------------------------------------------------

	// Accessors
	// -----------------------------------------------------------------

	/**
	 * Gets x coordinate of reference point
	 * 
	 * @return x coordinate
	 */
	public double getXLeft()
	{
		return xLeft;
	}

	/**
	 * Gets y coordinate of reference point
	 * 
	 * @return y coordinate
	 */
	public double getYTop()
	{
		return yTop;
	}

	// Drawing Methods
	// -----------------------------------------------------------

	// First draw your character on graph paper
	// Then work out size and placement relationships

	/**
	 * Draw character image instructions
	 * 
	 * @param g2
	 *            Graphics 2D context
	 */
	public void draw(Graphics2D g2)
	{
		// think of g2 as a well-equipped drawing kit

		// Insert drawing instructions for generic character,
		// or invoke methods for drawing each part

		// Here's my instructions for a generic character
		// Replace w/instructions for drawing your generic character after
		// running
		// Watch out for order of operations:
		// each set of features will obscure portions of features drawn
		// previously!
		// (i.e.,That's why legs have to be drawn first)

		// Get a pen and set its thickness
		BasicStroke penWidth = new BasicStroke(PEN_WIDTH); // This is > default
		g2.setStroke(penWidth);

		// Delegate the drawing tasks to the helper methods
		// Note that you must send the "virtual drawing kit" to each of them
		drawBody(g2);
		drawArms(g2);
		drawLegs(g2);
		drawFace(g2);
		drawEyes(g2); // leave out for truly generic character
		drawMouth(g2); // leave out for truly generic character
	}

	// Instance Helper Methods
	// ---------------------------------------------------

	/**
	 * Draw legs instructions
	 * 
	 * @param g2
	 *            Graphics 2D context
	 */
	private void drawLegs(Graphics2D g2)
	{
		// Use rectangles to model, create them first
		// Right leg
		Rectangle2D.Double leg1 = new Rectangle2D.Double(xLeft, yTop + SCALE2,
				SCALE1, 2 * SCALE2);
		// Left leg
		Rectangle2D.Double leg2 = new Rectangle2D.Double(xLeft - SCALE1, yTop
				+ SCALE2, SCALE1, 2 * SCALE2);

		// Set pen to desired thickness and color
		g2.setStroke(new BasicStroke(1.5F));
		g2.setColor(Color.GRAY);

		g2.fill(leg1); // Fill rectangle with set color
		g2.fill(leg2); // Fill rectangle with set color
		g2.setColor(Color.DARK_GRAY); // Change pen color
		g2.draw(leg1); // Outline leg with set color
		g2.draw(leg2); // Outline leg with set color
	}

	private void drawBody(Graphics2D g2)
	{
		Point2D.Double pt1 = new Point2D.Double(xLeft - SCALE3, yTop - SCALE2);
		Point2D.Double pt2 = new Point2D.Double(xLeft + SCALE3, yTop - SCALE2);
		Point2D.Double pt3 = new Point2D.Double(xLeft, yTop + SCALE2);
		Line2D.Double line1 = new Line2D.Double(pt1, pt2);
		Line2D.Double line2 = new Line2D.Double(pt2, pt3);
		Line2D.Double line3 = new Line2D.Double(pt3, pt1);
		g2.setStroke(new BasicStroke(1.5F));
		g2.setColor(Color.GRAY);
		g2.draw(line1);
		g2.draw(line2);
		g2.draw(line3);
	}

	private void drawArms(Graphics2D g2)
	{
		Rectangle2D.Double arm1 = new Rectangle2D.Double(xLeft - SCALE3 - SCALE1, yTop
				- SCALE2, SCALE1, SCALE2);
		Rectangle2D.Double arm2 = new Rectangle2D.Double(xLeft + SCALE3, yTop
				- SCALE2, SCALE1, SCALE2);
		g2.setStroke(new BasicStroke(1.5F));
		g2.setColor(Color.GRAY);
		g2.fill(arm1);
		g2.fill(arm2);
		g2.setColor(Color.DARK_GRAY);
		g2.draw(arm1);
		g2.draw(arm2);
	}

	/**
	 * Draw face instructions
	 * 
	 * @param g2
	 *            Graphics 2D context
	 */
	private void drawFace(Graphics2D g2)
	{
		// Use circle to model:
		// In Java must use Ellipse2D.Double class, where width == height
		Ellipse2D.Double face = new Ellipse2D.Double(xLeft - ((SCALE3) / 2),
				yTop - 2 * SCALE2, SCALE3, SCALE3);

		// Set pen color
		g2.setColor(Color.CYAN);

		g2.fill(face); // Fill circle with set color
		g2.setColor(Color.LIGHT_GRAY); // Change pen color
		g2.draw(face); // Outline circle with set color
	}

	/**
	 * Draw eyes instructions Can leave out for generic character
	 * 
	 * @param g2
	 *            Graphics 2D context
	 */
	private void drawEyes(Graphics2D g2)
	{
		int eyeSpace = SCALE1 / 4; // Half size of space between eyes
		int eyeWidth = SCALE1 / 4 * 3;
		int eyeHeight = SCALE1 / 2;
		int eyeLevel = SCALE1 + (eyeHeight / 5); // y postion offset

		// Use ellipse to model
		Ellipse2D.Double leftEye = new Ellipse2D.Double(xLeft - eyeWidth
				- eyeSpace, (yTop - eyeLevel) - SCALE2, eyeWidth, eyeHeight);
		Ellipse2D.Double rightEye = new Ellipse2D.Double(xLeft + eyeSpace, yTop
				- eyeLevel - SCALE2, eyeWidth, eyeHeight);

		// Set pen color
		g2.setColor(Color.GRAY);

		g2.fill(leftEye); // Fill ellipse with set color
		g2.fill(rightEye); // Fill ellipse with set color
		g2.setColor(Color.LIGHT_GRAY); // Change pen color
		g2.draw(leftEye); // Outline ellipse with set color
		g2.draw(rightEye); // Outline ellipse with set color
	}

	/**
	 * Draw mouth instructions Can leave this out for generic character
	 * 
	 * @param g2
	 *            Graphics 2D context
	 */
	private void drawMouth(Graphics2D g2)
	{
		final int HALF_SCALE = SCALE1 / 2; // x position offset
		int mouthLevel = HALF_SCALE + (HALF_SCALE / 5); // y position offset

		// Smile!
		// Use arc to model: open not closed
		Arc2D.Double mouth = new Arc2D.Double(xLeft - HALF_SCALE, yTop
				- mouthLevel - SCALE2, SCALE1, SCALE1, 180, 180, Arc2D.OPEN);

		// Make it the color you like
		g2.setColor(Color.LIGHT_GRAY);
		// Draw arc with set color
		g2.draw(mouth); // Draw arc with set color
	}
}