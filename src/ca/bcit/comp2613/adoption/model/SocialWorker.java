package ca.bcit.comp2613.adoption.model;

public class SocialWorker {
	private String id;
	private String firstName;
	private String lastName;
	private Region region;
	private Adoptee adoptee;
	
	public SocialWorker(){
		
	}
	
	public SocialWorker(String id, String firstName, String lastName, Region region) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.region = region;
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
				+ ", lastName=" + lastName + ", region="
				+ region + ", adoptee=" + adoptee + "]";
	}

    public static SocialWorker get(String firstName2) {
        // TODO Auto-generated method stub
        return null;
    }
	
	
}

