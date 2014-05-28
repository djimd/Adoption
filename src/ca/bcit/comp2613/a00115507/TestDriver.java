package ca.bcit.comp2613.a00115507;

import java.util.ArrayList;

import ca.bcit.comp2613.a00115507.model.*;
import ca.bcit.comp2613.a00115507.util.*;

public class TestDriver {

	public static void main(String[] args) {
		
		
		ArrayList<Adoptee> adoptees = CreateHelper.createAdoptees();
		CreateHelper.printAdoptees(adoptees);
		
		System.out.println("---------------");
		ArrayList<Adoptee> adopteesByFirstName = CreateHelper.searchAdopteesByFirstName(adoptees, "PUBLISHING");
		CreateHelper.printAdoptees(adopteesByFirstName);
		
		System.out.println("---------------");
		ArrayList<Adoptee> adopteesByFirstNameRegex = CreateHelper.searchAdopteesByFirstNameRegex(adoptees, "WO.*");
		CreateHelper.printAdoptees(adopteesByFirstNameRegex);
	}

}
