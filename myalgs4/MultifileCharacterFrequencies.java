package myalgs4;

/**
 * This application program uses a two-level symbol table to
 * count and store the frequencies of letters from different
 * text files.  A two-level symbol table is one where there
 * is a first level symbol table whose values are symbol tables.
 * 
 * In this program, the key for the first level table is a
 * text filename.  Each value paired with that filename is itself
 * a second level table where the key is a character and the
 * value is that character's frequency in the file.  
 *
 * Written by John Rogers for Data Structures II
 **/
import algs4.StdIn;
import algs4.StdOut;

public class MultifileCharacterFrequencies {

	public static void main(String[] args) {
		// Declare and initialize the two-level symbol table described above.
		AVLTreeST<String, AVLTreeST<Character, Integer>> frequencies = new AVLTreeST<>();
		// Declare and initialize a one-level symbol table for the lengths
		// of the texts in each file.
		AVLTreeST<String, Integer> textLengths = new AVLTreeST<>();
		// Create an array of the text filenames.  
		String[] textFilenames = {"data/tale.txt", "data/warandpeace.txt", "data/voyageofthebeagle.txt"};
		
		for (String filename: textFilenames) {
			StdIn.fromFile(filename);
			// In the second-level symbol table, create a 
			// first-level symbol table for this file.
			frequencies.put(filename, new AVLTreeST<Character, Integer>());
			String text = StdIn.readAll();
			textLengths.put(filename, text.length());
			for (int i = 0; i < text.length(); i++) {
				Character c = text.charAt(i);
				Integer frequency = frequencies.get(filename).get(c);
				if (frequency == null) frequency = 0;
				frequencies.get(filename).put(c, frequency+1);
			}
		}
		
		Character[] vowels = {'a', 'e', 'i', 'o', 'u'};
		for (Character vowel: vowels) {
			StdOut.println("Frequencies for '" + vowel + "'");
			for (String filename: textFilenames) {
				Integer frequency = frequencies.get(filename).get(vowel);
				double percentage = 100.0 * frequency / textLengths.get(filename);
				StdOut.printf("%-25s\t%6.2f\n", filename, percentage);
			}
		}
	}
}
