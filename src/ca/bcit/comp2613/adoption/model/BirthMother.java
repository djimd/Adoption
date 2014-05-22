package ca.bcit.comp2613.adoption.model;

public class BirthMother {
	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private Integer ageAtAdoption;
	private Integer reasonForAdoption;
	
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
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public Integer getAgeAtAdoption() {
		return ageAtAdoption;
	}
	
	public void setAgeAtAdoption(Integer ageAtAdoption) {
		this.ageAtAdoption = ageAtAdoption;
	}
	
	public Integer getReasonForAdoption() {
		return reasonForAdoption;
	}
	
	public void setReasonForAdoption(Integer reasonForAdoption) {
		this.reasonForAdoption = reasonForAdoption;
	}

	@Override
	public String toString() {
		return "BirthMother [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender
				+ ", ageAtAdoption=" + ageAtAdoption + ", reasonForAdoption="
				+ reasonForAdoption + "]";
	}	
}
