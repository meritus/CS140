package nim;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import utility.SingleRandom;

public class Guess implements PlayStrategy
{
	/**
	 * Logger
	 */
	public Logger logObj = Logger.getLogger("Guess");
	private static Handler handler;

	public Guess()
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
	 * Uses the greedy method of taking half of the tokens
	 */
	@Override
	public int takeTurn(int numberTokens)
	{
		int ret = numberTokens;
		if(numberTokens!=1)
			ret = SingleRandom.getInstance().nextInt(1, numberTokens/2);
		return ret;
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
