package nim;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Frugal implements PlayStrategy
{
	/**
	 * Logger
	 */
	public Logger logObj = Logger.getLogger("Frugal");
	private static Handler handler;

	/**
	 * constructor
	 */
	public Frugal()
	{
		// creates this handler
		// output will go to file named in argument
		try
		{
			handler = new FileHandler("Nim.log");
			// SimpleFormatter produces plain text(as opposed to XML)
			handler.setFormatter(new SimpleFormatter());
			logObj.addHandler(handler);
			logObj.setLevel(Level.ALL);
		} catch (SecurityException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Uses the frugal method of taking only 1 token
	 */
	@Override
	public int takeTurn(int numberTokens)
	{
		logObj.info("Computer takes 1 stick\n");
		return 1;
	}

	/**
	 * returns a string representation of the object
	 */
	@Override
	public String toString()
	{
		return String.format("%s", getClass().getName());
	}
}
