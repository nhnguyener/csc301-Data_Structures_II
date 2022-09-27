package myalgs4;

import algs4.StdIn;
import algs4.StdOut;

public class WordFrequencies {

	public static void main(String[] args) {
		BSTEssential<String, Integer> frequencies = new BSTEssential<>();

		StdIn.fromFile("data/tinyTale.txt");
		String[] words = StdIn.readAllStrings();
		
		for (String word: words) {
			Integer frequency = frequencies.get(word);
			if (frequency == null) {
				frequencies.put(word, 1);
			}
			else {
				frequencies.put(word, frequency+1);
			}
		}
		
		for (String key: frequencies.keys()) {
			double percentage = 100.0*frequencies.get(key)/words.length;
			// StdOut.println(key + ": " + percentage + "%");
			StdOut.printf("%s: %6.2f%%\n", key, percentage);
		}
	}

}
