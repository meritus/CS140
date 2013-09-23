package nim;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import utility.MathHelper;
import utility.SingleRandom;

public class Smart implements PlayStrategy
{
	/**
	 * Logger
	 */
	public Logger logObj = Logger.getLogger("Smart");
	private static Handler handler;

	/**
	 * Constructor
	 */
	public Smart()
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
	 * Uses the smart method
	 */
	@Override
	public int takeTurn(int numberTokens)
	{
		int ret;
		if (MathHelper.isPowerOfTwo(numberTokens + 1))
		{
			ret = SingleRandom.getInstance().nextInt(1, numberTokens);
		} else
		{
			int pow = 1;
			while ((pow - 1) < numberTokens)
				pow *= 2;
			ret = (pow / 2) + 1;
		}
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
