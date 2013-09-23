package repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import utility.SingleRandom;

public class Names {
	
	private static String[] monNames = new String[] {"Dinky", "Dorky", "Geeky", "Stinky", "Blinky"};
	private static final int LIST_LENGTH = monNames.length;
	private static final Names instance;
	static{
		instance = new Names();
	}
	
	private ArrayList<String> listNames;
	
	private Names(){
		listNames = new ArrayList<String>(Arrays.asList(monNames));
	}
	
	/**
	 * Gives reference to a single instance of names -
	 *  user is unable to create without
	 * @return reference to Names instance 
	 */
	public static Names getInstance(){
		return instance;
	}
	
	/**
	 * Gives number of names started out with
	 * @return length of name list
	 */
	public int getMaxNamesToStart(){
		return LIST_LENGTH;
	}
	
	/**
	 * Gives number of names in the current list
	 * @return size of current list
	 */
	public int getCurrentNumberOfNames(){
		return listNames.size();
	}
	
	/**
	 * Returns the name at the index
	 * @param index number in list 
	 * (precondition) index<getCurrentNumberOfNames()
	 * (precondition) index>=0
	 * @return String of name
	 */
	public String getName(int index){
		return listNames.get(index);
	}
	
	/**
	 * Returns the index of name
	 * @param name element to be tested
	 * @return index of name or -1 if not in list
	 */
	public int findName(String name){
		return listNames.indexOf(name);
	}
	
	/**
	 * Checks if name is in list
	 * @param name element to be tested
	 * @return true if name is in list 
	 */
	public boolean hasName(String name){
		return listNames.contains(name);
	}
	
	/**
	 * Tests if list has any names
	 * @return true if size of list > 0
	 */
	public boolean hasNames(){
		return !listNames.isEmpty();
	}
	
	/**
	 * Gives a name in the list and reloads
	 * the list of the no names exist
	 * @return one name in the list
	 */
	public String takeNames(){
		if(!hasNames())
			resetNames();
		int randNum = SingleRandom.getInstance().nextInt(listNames.size());
		return listNames.remove(randNum);
	}
	
	/**
	 * Adds a name to the list
	 * @param name element to add into list
	 */
	public void addName(String name){
		listNames.add(name);
	}
	
	/**
	 * Replaces a name in the list by index
	 * @param index where to place element
	 * @param name element to be placed
	 */
	public void replaceName(int index, String name){
		listNames.set(index, name);
	}
	
	/**
	 * Replace a name in the list by another name
	 * @param oldName element to replace
	 * @param newName element to add to list
	 */
	public void replaceName(String oldName, String newName){
		listNames.set(listNames.indexOf(oldName), newName);
	}
	
	/**
	 * Clears the list
	 */
	public void eraseNames(){
		listNames.clear();
	}
	
	/**
	 * Resets the list to original array
	 */
	public void resetNames(){
		listNames = new ArrayList<String>(Arrays.asList(monNames));
	}
	
	public String toString(){
		return listNames.toString();
	}
}
