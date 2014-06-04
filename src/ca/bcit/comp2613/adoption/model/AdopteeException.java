package ca.bcit.comp2613.adoption.model;

public class AdopteeException extends TestException {

	private static final long serialVersionUID = 1L;
	
	private int randInt;
	
	public AdopteeException(int randInt) {
		this.randInt = randInt;
	}
	
	public int getRandInt() {
		return randInt;
	}
	
	public void setRandInt(int randInt) {
		this.randInt = randInt;
	}
	
}
