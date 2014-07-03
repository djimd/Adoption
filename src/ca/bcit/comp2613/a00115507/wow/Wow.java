package ca.bcit.comp2613.a00115507.wow;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
//import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

//import org.apache.log4j.Logger;

/**
 * 
 * @author Henry
 * 
 *         Copy this package to your repo (a package can copied via 1) highlighting the package
 *         folder, 2) right click and then 3) copy).  If that fails, copy the files one by one ;)
 *         
 *         
 *         WoW - World Of Warcraft questions
 *         
 * 
 *         1) Modify the Race enum to include HUMAN 
 *         
 *         2) Implement rollCharacters (generates 100 Random Characters) PROPERLY
 *         
 *         3) Sort the characters by level, strength, armour 
 *         
 *         4) Print out the characters in a
 *         readable format (modify printCharacters)
 *         
 *         5) Implement checkAndRemoveAnyHordeSpies (hint: ORCs are Horde)
 *         
 *         6) Print out the
 *         characters again after we remove those pesky Horde spies
 *         
 *         7) Modify checkForPandaren : If we have any Pandaren races in our characters list, throw a DontHaveTheExpansionException
 *         
 *         8) Bonus: read the comments of the method: myCharactersAfterMyArchNemesisHacksIntoMyAccount and implement getLevelOfMissingCharacter
 *         
 *         When you are finished, please commit this package as
 *         ca.bcit.comp2613.<your student id>.wow in your GitHub project folder 
 *         note that package name should *always* be lowercase 
 *         
 *        
 */
public class Wow {
	private static Random rand = new Random();
	public static void main(String[] args) {
		
		ArrayList<Character> characters = rollCharacters();
		Comparator<Character> characterComparator = createCharacterComparator();
		Collections.sort(characters, characterComparator);
		
		System.out.println("Level\tStrength   Armour   Race");
		printCharacters(characters);
        System.out.println(" \n\n");        
        
		checkAndRemoveAnyHordeSpies(characters);
		
        System.out.println("Characters Excluding ORCs\n");		
        System.out.println("Level\tStrength   Armour   Race");		
		printCharacters(characters);
		
		try{
		    checkForPandaren(characters);
		}catch (DontHaveTheExpansionException e){
		    e.printStackTrace();
		}
		
		getLevelOfMissingCharacter(); 
	}

	

	private static Race getRandomRace() {
		Race retval = null;
		Race[] races = Race.values();		
		retval = races[rand.nextInt(races.length)];
		return retval;
	}
	
	private static int getRandomLevel() {
		return rand.nextInt(85)+1; // TODO is this right? 
		                         //***CHANGED 101 to 85 and add +1 so it starts at 1 - 85.
		                         //*** nextInt(85) is 0 - 84 but adding +1 becomes 1-85
	}

	private static int getRandomStrength() {
		return rand.nextInt(101); // returns a number between 0 and 100
	}
	
	private static int getRandomArmour() {
		return rand.nextInt(101); // returns a number between 0 and 100
	}
	
	private static ArrayList<Character> rollCharacters() {
		// TODO create 100 Random Characters 
				// The Race's assigned should be pretty random
				// Each Character's  
				// level must be 1-85
				// strength, 0-100
				// armour, 0-100
				// find and fix the bug
		ArrayList<Character> retval = new ArrayList<Character>();
		for (int i = 0; i < 100; i++) {
			Race race = getRandomRace();
			int level = getRandomLevel();
			int strength = getRandomStrength();
			int armour = getRandomArmour();
			Character character = new Character(race, level, strength, armour);
			retval.add(character);
		}
		return retval;
	}

	

	private static Comparator<Character> createCharacterComparator() {
		
		return new Comparator<Character>() {
			@Override
			public int compare(Character character1, Character character2) {
				// TODO compares Characters by level, strength and armour
				// note that this soln isn't quite correct,
				// find the bug and fix it
	            // ***CHANAGED .getLevel() to the appropriate item, strength, armour.
			    // ***ADDED Integer.valueOf to the character2 compareTo statement.

				int retval = Integer.valueOf(character1.getLevel()).compareTo(Integer.valueOf(character2.getLevel()));
				if (retval == 0) {
					retval = Integer.valueOf(character1.getStrength()).compareTo(Integer.valueOf(character2.getStrength()));
					if (retval == 0) {
						retval = Integer.valueOf(character1.getArmour()).compareTo(Integer.valueOf(character2.getArmour()));
					}
				}
				return retval;
			}
		};
	}

	private static void checkAndRemoveAnyHordeSpies(ArrayList<Character> characters) {
		// TODO loop through each character in the characters list
		// if the character is of Race: ORC, remove that character from the
		// list
	    // ***CHANGED Race.DRAENEI to Race.ORC.

		Iterator<Character> iterator = characters.iterator();
		while (iterator.hasNext()) {
			Character character = iterator.next();
			if (character.getRace() == Race.ORC) { //TODO not quite right is it?
				iterator.remove();
			}
		}
	}

	private static void printCharacters(ArrayList<Character> characters) {
		for (Character character : characters) {
			//TODO how do I print out the character's armour?
	        //****ADDED character.getAmour() to fix problem.
	        System.out.println(character.getLevel() + "\t" + character.getStrength() + "\t   " + character.getArmour() + "\t    " + character.getRace());
//			System.out.println("Level: " + character.getLevel() + ", Strength " + character.getStrength() + ", Amour " + character.getArmour() + ",  Race: " + character.getRace());
		}

	}
	
	private static void checkForPandaren(ArrayList<Character> characters) throws DontHaveTheExpansionException{
		// TODO if there are any PANDAREN races in our List, throw a DontHaveTheExpansionException
		// hint, you should change this method signature
	    //***CREATED CLASS DontHaveTheExpansionException class; add try, throw new, finally; add try catch in main.
	    try{
	        for(Character character:characters){
	            if(character.getRace() == Race.PANDAREN){
	                throw new DontHaveTheExpansionException();   
	            }
	        }
	    }finally{
	        
	    }
	}
	
	
	/**
	 * Bonus Question (2% of overall grade)
	 * So here's the scenario:
	 * I have 85 characters in my WoW account.  Ironically enough, each character's level is unique
	 * i.e. I have a Level1, Level2, Level3 ... Level85 characters (although in a shuffled order)
	 * Then one day, my arch-nemesis hacks into my account and DELETEs only one of my characters.
	 * Write a program that finds out which character level he DELETEd.
	 * Maximum marks will be given for efficiency.  It is possible to solve this problem by looping through
	 * the arraylist just **ONCE**
	 * Also note, that although this isn't necessarily a Java question, this is a permutation of an interview question
	 * used by a few Fortune 100 companies.  
	 * 
	 * Its a true *computer science* question
	 * Also note that if you can solve this question, most likely you have a greater computer science
	 * mind than 90% of the instructors at BCIT and you're bored silly of this course because its too easy for you ;)
	 * 
	 * And just for the record, it took me *OVER* half an hour to solve this.  Its tricky ;)
	 */
	public static ArrayList<Character> myCharactersAfterMyArchNemesisHacksIntoMyAccount() {
		ArrayList<Character> retval = new ArrayList<Character>();
		for (int i = 1; i <= 85; i++) {
			Character character = new Character(Race.ORC, i, i, i);
			retval.add(character);

		}
		Collections.shuffle(retval);
		// then my archNemesis randomly DELETE's one of my characters
		Random random = new Random();
		int randIndex = random.nextInt(86);
		retval.remove(randIndex);	

		return retval;
	}
	
	// TODO
	// Your turn!
	// implement getLevelOfMissingCharacter
	public static int getLevelOfMissingCharacter() {
		ArrayList<Character> characters = myCharactersAfterMyArchNemesisHacksIntoMyAccount();
		// from the characters above, find out which Level character is missing
		int sumLevelAfterHack = 0;
		int sumLevelBeforeHack = 0;
		int difference = 0;
		
		//SUM the levels after the hack.
        for (Character character : characters) {
            sumLevelAfterHack += (character.getLevel());
            //System.out.println(character.getLevel());
        }
		
        //SUM the levels before the hack.
        for(int i=1; i<=85; i++){
            sumLevelBeforeHack += i;
        }
        
        //System.out.println("\n The sum of the levels before the hack = " + sumLevelBeforeHack);
        //System.out.println("\n The sum of the levels before the hack = " + sumLevelAfterHack);		
        
		difference = sumLevelBeforeHack - sumLevelAfterHack;
		System.out.println("\nThe character level which was deleted is level " + difference + '.');
		
		return -1;
	}

}