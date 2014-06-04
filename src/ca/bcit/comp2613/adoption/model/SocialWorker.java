package ca.bcit.comp2613.adoption.model;

public class SocialWorker {
	private Long id;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Region region;
	private Adoptee adoptee;
	
	public SocialWorker(){
		
	}
	
	public SocialWorker(Long id, String firstName, String lastName,
			Gender gender, Region region) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.region = region;
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
	
	public Region getRegion() {
		return region;
	}
	
	public void setRegion(Region region) {
		this.region = region;
	}
	
	public void setAdoptee(Adoptee adoptee) {
		this.adoptee = adoptee;
	}

	@Override
	public String toString() {
		return "SocialWorker [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", region="
				+ region + ", adoptee=" + adoptee + "]";
	}
	
	
}
