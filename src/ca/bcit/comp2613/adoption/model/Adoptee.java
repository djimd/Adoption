package ca.bcit.comp2613.adoption.model;
import ca.bcit.comp2613.adoption.model.SocialWorker;

public class Adoptee {
	private String id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Region region;
	private String birthYear;
	private String adoptionYear;
	private String ageAtAdoption;
	//private SocialWorker socialWorker;
	//private String SWfName;
	private SocialWorker socialWorker = new SocialWorker();
	
	public Adoptee(){
		
		
	}
	
	public Adoptee(String id, String firstName, String lastName, Gender gender,
			Region region, String birthYear, String adoptionYear, String ageAtAdoption,
			SocialWorker socialWorker) {
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
	
	public String getFirstName(){
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
	
	public Region getRegion() {
		return region;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
	public String getBirthYear() {
		return birthYear;
	}
	
	public void setBirthYear(String birthYear) {
		this.birthYear = birthYear;
	}
	
	public String getAdoptionYear() {
		return adoptionYear;
	}
	
	public void setAdoptionYear(String adoptionYear) {
		this.adoptionYear = adoptionYear;
	}
	
	public String getAgeAtAdoption() {
		return ageAtAdoption;
	}
	
	public void setAgeAtAdoption(String ageAtAdoption) {
		this.ageAtAdoption = ageAtAdoption;
	}
	
    public SocialWorker getSocialWorker() {
        socialWorker = SocialWorker.get(firstName);
        return socialWorker;
    }	
	public void setSocialWorker(SocialWorker socialWorker) {
		this.socialWorker = socialWorker;
	}

	@Override
	public String toString() {
		return "Adoptee [id=" + id + ", firstName=" + firstName + ", lastName="
				+ lastName + ", gender=" + gender + ", region=" + region
				+ ", birthYear=" + birthYear + ", adoptionYear=" + adoptionYear
				+ ", ageAtAdoption=" + ageAtAdoption + ", socialWorker=" + socialWorker + "]";
	}


	
}
