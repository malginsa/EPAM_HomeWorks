package HomeWork150928;

import java.time.Duration;
import java.util.Comparator;

// Lecture is a class with three comparators 

import java.util.Date;

import HomeWork150928.Lecture.Impression;

public class Lecture implements Comparable<Lecture>{

	enum Impression {
		MARVELOUS, GOOD, PERFECTLY
	}

	static class DurationComparator implements Comparator<Lecture> {

		@Override
		public int compare(Lecture o1, Lecture o2) {
			return o1.duration.compareTo(o2.duration);
		}
	}
	
	static class ImpressionComparator implements Comparator<Lecture> {

		@Override
		public int compare(Lecture o1, Lecture o2) {
			return o1.impression.compareTo(o2.impression);
		}
	}
	
	static class DateComparator implements Comparator<Lecture> {

		@Override
		public int compare(Lecture o1, Lecture o2) {
			return o1.date.compareTo(o2.date);
		}
	}
	
	public static final Comparator<Lecture> DURATION_COMPARATOR = 
		new DurationComparator();

	public static final Comparator<Lecture> IMPRESSION_COMPARATOR = 
		new ImpressionComparator();

	public static final Comparator<Lecture> DATE_COMPARATOR = 
		new DateComparator();
	
	private Date date;
	private Integer duration; // in minutes
	private Impression impression;

	public Lecture(java.util.Date date, int duration, Impression impression) {
		this.date = date;
		this.duration = duration;
		this.impression = impression;
	}

	@Override
	public String toString() {
		return date.getYear() + " " + date.getMonth() + " " + date.getDate() +
			"; " + duration + "; " + impression;

	}

	@Override
	public int compareTo(Lecture that) {
		return this.date.compareTo(that.date);
	}

}
