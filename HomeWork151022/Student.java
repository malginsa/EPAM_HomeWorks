package HomeWork151022;

public class Student {
	String id;
	String name;
	String stip;

	public Student(String id, String name, String stip) {
		this.id = id;
		this.name = name;
		this.stip = stip;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStip() {
		return stip;
	}

	public void setStip(String stip) {
		this.stip = stip;
	}

}
