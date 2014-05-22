package ca.bcit.comp2613.adoption.model;

public class Adoptee {
	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String region;
	private Integer birthYear;
	private Integer adoptionYear;
	private Integer ageAtAdoption;
	
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
	
	public String getRegion() {
		return region;
	}
	
	public void setRegion(String region) {
		this.region = region;
	}
	
	public Integer getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}
	
	public Integer getAdoptionYear() {
		return adoptionYear;
	}
	
	public void setAdoptionYear(Integer adoptionYear) {
		this.adoptionYear = adoptionYear;
	}
	
	public Integer getAgeAtAdoption() {
		return ageAtAdoption;
	}
	
	public void setAgeAtAdoption(Integer ageAtAdoption) {
		this.ageAtAdoption = ageAtAdoption;
	}

	@Override
	public String toString() {
		return "Adoptee [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", region=" + region
				+ ", birthYear=" + birthYear + ", adoptionYear=" + adoptionYear
				+ ", ageAtAdoption=" + ageAtAdoption + "]";
	}
}
