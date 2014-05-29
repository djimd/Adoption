package ca.bcit.comp2613.adoption.model;

public class Adoptee {
	private String id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private String region;
	private Integer birthYear;
	private Integer adoptionYear;
	private Integer ageAtAdoption;
	
	public Adoptee(){
		
	}
	
	public Adoptee(String id, String firstName, String lastName, Gender gender,
			String region, Integer birthYear, Integer adoptionYear,
			Integer ageAtAdoption) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.region = region;
		this.birthYear = birthYear;
		this.adoptionYear = adoptionYear;
		this.ageAtAdoption = ageAtAdoption;
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
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
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
