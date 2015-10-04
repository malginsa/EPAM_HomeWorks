package HomeWork150928;

public class Dog {

	BrainState brainState = new BadMood(this);

	public void feed() {
		System.out.println("--> feed dog");
		brainState.feed();
	}

	public void stroke() {
		System.out.println("--> stroke dog");
		brainState.stroke();
	}
	
	
	void eat() {
		System.out.println("eats");
	}

	void wag() {
		System.out.println("wags");
	}

	void bark() {
		System.out.println("barks");		
	}

	void bite() {
		System.out.println("bites");
	}

}
