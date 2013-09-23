package testers;

import characters.Adventurer;
import characters.Monster;

public class Assignment2Tester2
{
	public static void main(String[] args)
	{

		Adventurer a = new Adventurer("adven",90.0,10.0);
		Monster m = new Monster("mon",10, 25,4);

		/*
		 * Repeat the following as long as BOTH of the following conditions
		 * hold: 1. the monster has sacks 2. the adventurer has health
		 */
		while (m.hasSacks() && a.hasHealth())
		{
			m.sufferPoke(a.pokeMonster());
		

		// Have the adventurer poke the monster and the monster receive the poke
		// Then, if the monster has no strength:

		System.out.println("\nAdventurer before gaining sack:\n" + a.toString());
		System.out.println("\nMonster before losing sack:\n" + m.toString());
		
		if(!m.hasStrength()){
			m.decrementSacks();
			m.restoreStrength();
			a.incrementSacks();
			a.restoreHealth();
			a.reduceStrength();
		}
		/*
		 * Decrement the monster's sacks and restore his/her strength Using the
		 * methods you've written: Increment the adventurer's sacks Restore the
		 * adventurer's health Reduce the adventurer's strength
		 */
		
		System.out.println("\nAdventurer after gaining sack\n" + a.toString());
		System.out.println("\nMonster after losing sack\n" + m.toString());
		
		/*
		 * After that, if the monster doesn't have any sacks Reset monster's
		 * strength Reset monster's health
		 */
		
		 System.out.println("\nMonster after reset\n" + m.toString());
	
		
		if (!m.hasSacks())
		{
			m.resetStrength();
			m.resetHealth();
		}
		
		/*
		 * Next, have the monster roar at the adventurer and have the adventurer
		 * receive the roar. Then, if the adventurer has sacks but no strength:
		 */
		
		a.sufferTerror(m.terrifyAdventurer());
		
		if (a.hasSacks() && (!a.hasStrength()))
		{
			a.decrementSacks();
			a.restoreStrength();
			m.incrementSacks();
			m.restoreHealth();
			m.reduceStrength();
		}
		
		System.out.println("\nAdventurer before losing sack\n" + a.toString());
		System.out.println("\nMonster before gaining sack\n" + m.toString());
		/*
		 * Decrement the adventurer's sacks Restore the adventurer's strength
		 * 
		 * Increment the monster's sacks Restore the monster's health Reduce the
		 * monster's strength
		 */
		System.out.println("\nAdventurer after losing sack\n" + a.toString());
		System.out.println("\nMonster after gaining sack\n" + m.toString());

		/*
		 * When either of the above conditions no longer holds, determine who
		 * won:
		 * 
		 * if the monster still has sacks, then the monster wins if the
		 * adventurer still has health, then the adventurer wins if neither is
		 * true, then something is wrong!
		 */
		}

		if (m.hasSacks())
			System.out.println("\nMonster Wins");
		if (a.hasHealth())
			System.out.println("\nAdventurer Wins");
		
		System.out.println("\nFinal Adventurer:\n" + a.toString());
		System.out.println("\nFinal Monster\n" + m.toString());

	}
}
