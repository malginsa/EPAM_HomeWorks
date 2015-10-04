package HomeWork150928;

public class GoodMood implements BrainState {

	private static final int MAX_STROKES = 3;
	private int count;
	private Dog dog;
	
	GoodMood(Dog dog){
		this.dog = dog;
	}
	
	@Override
	public void feed() {
		dog.eat();
		dog.wag();
	}

	@Override
	public void stroke() {
		dog.wag();
		dog.bark();
		this.count++;
		if (count >= MAX_STROKES){
			dog.brainState = new BadMood(dog);
		}

	}
}