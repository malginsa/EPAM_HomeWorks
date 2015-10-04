package HomeWork150928;

public class BadMood implements BrainState {

	private Dog dog;

	public BadMood(Dog dog) {
		this.dog = dog;
	}

	@Override
	public void feed() {
		dog.eat();
		dog.brainState = new GoodMood(dog);
	}

	@Override
	public void stroke() {
		dog.bite();
	}

}
