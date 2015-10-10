package HomeWork151001;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

// 

public class Genome {

	public static int GENOME_SIZE = 2_000;

	public static char[] letters = { 'A', 'C', 'G', 'T' };

	char[] sequence;
	
	class Entry implements Comparable<Entry>{
		
		String word;
		long position;
		
		public Entry(String word, long position) {
			this.word = word;
			this.position = position;
		}

		@Override
		public int compareTo(Entry that) {
			return this.word.compareTo(that.word);
		}
		
		boolean equals(Entry that){
			return this.word.equals(that.word);
		}
	}
	

	public void generateSequence() {
		Random random = new Random();
		sequence = new char[GENOME_SIZE];

		for (int i = 0; i < sequence.length; i++) {
			sequence[i] = letters[random.nextInt(letters.length)];
		}
	}

	public void SearchDuplicatesBruteForce(char[] data, int M) {
		for (int i = 0; i < data.length - 2 * M + 1; i++) {
			for (int j = i + M; j < data.length - M + 1; j++) {
				int k = i;
				int m = j;
				int n = 0;
				while ((data[k++] == data[m++]) && (++n < M)) {}
				if (n == M)
					System.out.println("Match at " + i + " and " + j);
			}
		}
	}

	public void searchDuplicatesSorting(char[] data, int M) {
		List<Entry> list = new LinkedList<>();
		
		for (int i = 0; i < data.length - M + 1; i++) {
			String word = new String(data, i, M);
			list.add(new Entry(word, i));
		}
		
		Collections.sort(list);
		
		Iterator<Entry> it = list.iterator();
		Entry last = it.next();
		while (it.hasNext()) {
			Entry current = it.next();
			if (current.equals(last)) {
				System.out.println("Match at " + last.position + 
					" and " + current.position);
			}
			last = current;
		}

	}

	public static void main(String[] args) {
		Genome genome = new Genome();
//		genome.SearchDuplicatesBruteForce(new char[] { 'A', 'A', 'C', 'T', 'A', 'A', 'C' }, 3);

		genome.generateSequence();
		System.out.println("BruteForce:");
		genome.SearchDuplicatesBruteForce(genome.sequence, 10);
		System.out.println();

		System.out.println("DuplicatesSorting:");
		genome.searchDuplicatesSorting(genome.sequence, 10);
		System.out.println();

	}
}
