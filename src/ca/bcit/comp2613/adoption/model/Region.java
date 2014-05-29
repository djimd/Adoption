package ca.bcit.comp2613.adoption.model;

public enum Region {
	AB("Alberta"), BC("British Columbia"), ON("Ontario"), QC("Quebec"); 
	
	private String description;
	Region(String description) {
		this.description = description;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
