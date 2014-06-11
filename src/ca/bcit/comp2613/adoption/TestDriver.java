package ca.bcit.comp2613.adoption;

import java.util.ArrayList;
import java.util.Random;

import ca.bcit.comp2613.adoption.model.*;
import ca.bcit.comp2613.adoption.util.*;


public class TestDriver {

	public static void main(String[] args) {
/*		//Original code before the Exceptions
		Adoptee adoptee = new Adoptee();
		SocialWorker socialWorker = new SocialWorker(); 
		
		//Create relationship between adoptee and socialWorker.
		adoptee.setSocialWorker(socialWorker);
		socialWorker.setAdoptee(adoptee); 
		
		ArrayList<Adoptee> adoptees = SearchAndCreateHelper.createAdoptees();
		SearchAndCreateHelper.printAdoptees(adoptees);	

		System.out.println("---------------");
		//ArrayList<Adoptee> adopteesByFirstName = SearchAndCreateHelper.searchAdopteesByFirstName(adoptees, "PUBLISHING");
		ArrayList<Adoptee> adopteesByFirstName = SearchAndCreateHelper.searchAdopteesByFirstName(adoptees, "PATRICIA");
		SearchAndCreateHelper.printAdoptees(adopteesByFirstName);
		
		System.out.println("---------------");
		//ArrayList<Adoptee> adopteesByFirstNameRegex = SearchAndCreateHelper.searchAdopteesByFirstNameRegex(adoptees, "WO.*");
		ArrayList<Adoptee> adopteesByFirstNameRegex = SearchAndCreateHelper.searchAdopteesByFirstNameRegex(adoptees, "KAT.*");
		SearchAndCreateHelper.printAdoptees(adopteesByFirstNameRegex);					
*/		
	

		Adoptee adoptee = new Adoptee(){
			//@Override
			public void generateAdoptee() throws TestException{
				Random rand = new Random();
				int randInt = rand.nextInt();
				
				if (randInt % 20 == 0) { 				// modulus - means 5% of the time							
					ArrayList<Adoptee> adoptees = SearchAndCreateHelper.createAdoptees();
					SearchAndCreateHelper.printAdoptees(adoptees);	
					throw new AdopteeException(randInt);		
				}
			}
		};
		
		
		try{
			//Adoptee adoptee = new Adoptee();
			SocialWorker socialWorker = new SocialWorker(); 
			
			ArrayList<Adoptee> adoptees = SearchAndCreateHelper.createAdoptees();
			SearchAndCreateHelper.printAdoptees(adoptees);	
			
			SearchAndCreateHelper.showComparableExample(SearchAndCreateHelper.createAdoptees());
			
			//Create relationship between adoptee and socialWorker.
			adoptee.setSocialWorker(socialWorker);
			socialWorker.setAdoptee(adoptee); 		
			
			
			System.out.println("---------------");
			//ArrayList<Adoptee> adopteesByFirstName = CreateHelper.searchAdopteesByFirstName(adoptees, "PUBLISHING");
			ArrayList<Adoptee> adopteesByFirstName = SearchAndCreateHelper.searchAdopteesByFirstName(adoptees, "PATRICIA");
			SearchAndCreateHelper.printAdoptees(adopteesByFirstName);
			
			System.out.println("---------------");
			//ArrayList<Adoptee> adopteesByFirstNameRegex = CreateHelper.searchAdopteesByFirstNameRegex(adoptees, "WO.*");
			ArrayList<Adoptee> adopteesByFirstNameRegex = SearchAndCreateHelper.searchAdopteesByFirstNameRegex(adoptees, "KAT.*");
			SearchAndCreateHelper.printAdoptees(adopteesByFirstNameRegex);	
			
		} catch (TestException e){
			e.printStackTrace(); // welcome to printing the stacktrace
		}
		

	}
}
