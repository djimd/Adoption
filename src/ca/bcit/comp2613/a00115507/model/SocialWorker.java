package ca.bcit.comp2613.a00115507.model;

public class SocialWorker {
	private Long id;
	private String firstName;
	private String lastName;
	private String gender;
	private String region;
	
	public SocialWorker(Long id, String firstName, String lastName,
			String gender, String region) {
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

	@Override
	public String toString() {
		return "SocialWorker [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", region="
				+ region + "]";
	}
	
	
}