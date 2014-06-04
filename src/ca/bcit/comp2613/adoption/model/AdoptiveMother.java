package ca.bcit.comp2613.adoption.model;

public class AdoptiveMother {
	private Long id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Integer yearsWaiting;

	public AdoptiveMother(Long id, String firstName, String lastName,
			Gender gender, Integer yearsWaiting) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.yearsWaiting = yearsWaiting;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public Integer getYearsWaiting() {
		return yearsWaiting;
	}
	
	public void setYearsWaiting(Integer yearsWaiting) {
		this.yearsWaiting = yearsWaiting;
	}

	@Override
	public String toString() {
		return "AdoptiveMother [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender
				+ ", yearsWaiting=" + yearsWaiting + "]";
	}
	
}

