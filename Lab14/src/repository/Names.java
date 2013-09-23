package repository;

import java.util.ArrayList;
import java.util.Arrays;

import utility.SingleRandom;

/**
 * This class wraps the ArrayList class to provide functionality for the storing
 * and dispensing of Monster names
 * 
 * @author Edison Liu
 * 
 */
public class Names
{
	/**
	 * Array of names
	 */
	private final String[] NAMES;
	/**
	 * Starting list length
	 */
	private final int MAX_NAMES_TO_START;

	/**
	 * The list that keeps track of Names
	 */
	private ArrayList<String> listNames;

	public Names(String[] names)
	{
		NAMES = names;
		MAX_NAMES_TO_START = NAMES.length;
		listNames = new ArrayList<String>(Arrays.asList(NAMES));
	}

	/**
	 * Gives number of names started out with
	 * 
	 * @return length of name list
	 */
	public int getMaxNamesToStart()
	{
		return MAX_NAMES_TO_START;
	}

	/**
	 * Gives number of names in the current list
	 * 
	 * @return size of current list
	 */
	public int getCurrentNumberOfNames()
	{
		return listNames.size();
	}

	/**
	 * Returns the name at the index
	 * 
	 * @param index
	 *            number in list (precondition) index<getCurrentNumberOfNames()
	 *            (precondition) index>=0
	 * @return String of name
	 */
	public String getName(int index)
	{
		return listNames.get(index);
	}

	/**
	 * Returns the index of name
	 * 
	 * @param name
	 *            element to be tested
	 * @return index of name or -1 if not in list
	 */
	public int findName(String name)
	{
		return listNames.indexOf(name);
	}

	/**
	 * Checks if name is in list
	 * 
	 * @param name
	 *            element to be tested
	 * @return true if name is in list
	 */
	public boolean hasName(String name)
	{
		return listNames.contains(name);
	}

	/**
	 * Tests if list has any names
	 * 
	 * @return true if size of list > 0
	 */
	public boolean hasNames()
	{
		return !listNames.isEmpty();
	}

	/**
	 * Gives a name in the list and reloads the list of the no names exist
	 * 
	 * @return one name in the list
	 */
	public String takeNames()
	{
		if (!hasNames())
			resetNames();
		int randNum = SingleRandom.getInstance().nextInt(listNames.size());
		return listNames.remove(randNum);
	}

	/**
	 * Adds a name to the list
	 * 
	 * @param name
	 *            element to add into list
	 */
	public void addName(String name)
	{
		listNames.add(name);
	}

	/**
	 * Replaces a name in the list by index
	 * 
	 * @param index
	 *            where to place element
	 * @param name
	 *            element to be placed
	 */
	public void replaceName(int index, String name)
	{
		listNames.set(index, name);
	}

	/**
	 * Replace a name in the list by another name
	 * 
	 * @param oldName
	 *            element to replace
	 * @param newName
	 *            element to add to list
	 */
	public void replaceName(String oldName, String newName)
	{
		listNames.set(listNames.indexOf(oldName), newName);
	}

	/**
	 * Clears the list
	 */
	public void eraseNames()
	{
		listNames.clear();
	}

	/**
	 * Resets the list to original array
	 */
	public void resetNames()
	{
		listNames = new ArrayList<String>(Arrays.asList(NAMES));
	}

	/**
	 * Returns a string representation of the List
	 */
	@Override
	public String toString()
	{
		return getClass().getName() + ":\n" + listNames.toString();
	}
}
