package ca.bcit.comp2613.adoption.model;

public class AdoptiveMother {
	private String id;
	private String firstName;
	private String lastName;
	private String yearsWaiting;

	public AdoptiveMother(String id, String firstName, String lastName, String yearsWaiting) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.yearsWaiting = yearsWaiting;
	}

	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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
	
	public String getYearsWaiting() {
		return yearsWaiting;
	}
	
	public void setYearsWaiting(String yearsWaiting) {
		this.yearsWaiting = yearsWaiting;
	}

	@Override
	public String toString() {
		return "AdoptiveMother [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", yearsWaiting=" + yearsWaiting + "]";
	}
	
}

