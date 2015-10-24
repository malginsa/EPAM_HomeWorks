package HomeWork151022;

public class UseDB {

	public static void main(String[] args) {

//		int id = 1;
//		
//		Student t = DBManager.get(Student.class, id);
//		
//		if (null == t) {
//			System.out.println("no such student with id " + id);
//		} else {
//			System.out.println(t.name);
//		}

		Student t2 = new Student("4", "Robert", "3500");
		DBManager.save(Student.class, t2);

	}
}
