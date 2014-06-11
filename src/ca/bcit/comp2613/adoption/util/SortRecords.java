package ca.bcit.comp2613.adoption.util;

public class SortRecords implements Comparable<SortRecords> {
	private String firstName;
	private String lastName;
	public SortRecords(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public String toString() {
		
		return lastName + ", " + firstName;
	}
	@Override
	public int compareTo(SortRecords o) {
		int retval = this.getLastName().compareTo(o.getLastName());
		if (retval == 0) {
			retval = this.getFirstName().compareTo(o.getFirstName());
		}
		return retval;
	}

	
}