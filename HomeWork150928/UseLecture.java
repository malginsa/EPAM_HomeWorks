package HomeWork150928;

import java.util.List;

import HomeWork150928.Lecture.Impression;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

public class UseLecture {

	static private void PrintLectures(List<Lecture> lectures) {
		for (Lecture lecture : lectures) {
			System.out.println(lecture);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {

		List<Lecture> lectures = new LinkedList<>();

		lectures.add(new Lecture(new Date(2015, 9, 14), 210, Impression.GOOD));
		lectures.add(new Lecture(new Date(2015, 9, 15), 211, Impression.MARVELOUS));
		lectures.add(new Lecture(new Date(2015, 9, 17), 209, Impression.GOOD));
		lectures.add(new Lecture(new Date(2015, 9, 21), 210, Impression.MARVELOUS));
		lectures.add(new Lecture(new Date(2015, 9, 22), 220, Impression.MARVELOUS));
		lectures.add(new Lecture(new Date(2015, 9, 24), 204, Impression.PERFECTLY));
		lectures.add(new Lecture(new Date(2015, 9, 28), 209, Impression.GOOD));
		lectures.add(new Lecture(new Date(2015, 9, 29), 210, Impression.MARVELOUS));
		lectures.add(new Lecture(new Date(2015, 10, 01), 211, Impression.PERFECTLY));
		lectures.add(new Lecture(new Date(2015, 10, 05), 209, Impression.GOOD));
		lectures.add(new Lecture(new Date(2015, 10, 06), 210, Impression.MARVELOUS));

		Collections.shuffle(lectures);
		System.out.println("shuffled list of lectures:");
		PrintLectures(lectures);

		Collections.sort(lectures);
		System.out.println("sorted by natural order:");
		PrintLectures(lectures);

		Collections.shuffle(lectures);

		Collections.sort(lectures, Lecture.IMPRESSION_COMPARATOR);
		System.out.println("sorted by impression:");
		PrintLectures(lectures);

		Collections.sort(lectures, Lecture.DURATION_COMPARATOR);
		System.out.println("sorted by duration:");
		PrintLectures(lectures);

		Collections.sort(lectures, Lecture.DATE_COMPARATOR);
		System.out.println("sorted by date:");
		PrintLectures(lectures);

	}
}
