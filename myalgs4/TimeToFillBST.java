package myalgs4;

import java.util.Arrays;

import algs4.StdIn;
import algs4.StdOut;
import algs4.Stopwatch;

public class TimeToFillBST {

	public static void main(String[] args) {
		StdIn.fromFile("data/tale.txt");
		String[] words = StdIn.readAllStrings();
		
		Stopwatch timer;
		
		BSTEssential<String, Integer> frequencies = new BSTEssential<>();

		timer = new Stopwatch();
		for (String word: words) {
			Integer frequency = frequencies.get(word);
			if (frequency == null) {
				frequencies.put(word, 1);
			}
			else {
				frequencies.put(word, frequency+1);
			}
		}
		StdOut.println("Time to fill with words in book order: " + timer.elapsedTime());
		
		Arrays.sort(words);
		frequencies = new BSTEssential<>();
		timer = new Stopwatch();
		for (String word: words) {
			Integer frequency = frequencies.get(word);
			if (frequency == null) {
				frequencies.put(word, 1);
			}
			else {
				frequencies.put(word, frequency+1);
			}
		}
		StdOut.println("Time to fill with words in sorted order: " + timer.elapsedTime());
		
		
	}

}
