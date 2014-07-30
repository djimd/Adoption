package ca.bcit.comp2613.adoption;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import ca.bcit.comp2613.adoption.model.*;
import ca.bcit.comp2613.adoption.util.*;


public class TestDriver {
    
	public static void main(String[] args) throws IOException {

		Adoptee adoptee = new Adoptee(){
			//@Override
			@SuppressWarnings("unused")
            public void generateAdoptee() throws IOException /*throws AdopteeException */{
				Random rand = new Random();
				int randInt = rand.nextInt();
				
				if (randInt % 20 == 0) { 				// modulus - means 5% of the time							
					ArrayList<Adoptee> adoptees = SearchAndCreateHelper.createAdoptees();
					SearchAndCreateHelper.printAdoptees(adoptees);	
	/*				try {
						throw new AdopteeException(randInt);
					} catch (AdopteeException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}	*/	
				}
			}
		};
		
		
		try{
		
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
			
		} catch (AdopteeFirstNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
	
    

	
}
