//Nathan Nguyen
package symboltable;

import algs4.StdIn;
import algs4.StdOut;
import myalgs4.BSTEssential;

public class CharacterFrequencies {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTEssential<Character, Double> frequencies = new BSTEssential<>();
		StdIn.fromFile("data/tale.txt");
		String text = StdIn.readAll();
		
		
		//StdOut.print(text); //trouble shooting
		/*
		int c = 0;
		for (int i = 0; i < text.length(); i++) {
			StdOut.print(text.charAt(i));
			if (text.charAt(i) == 'z')
				c++;
		}
		StdOut.print("COUNT: " + c);
		*/
		
		for (int i = 0; i < text.length(); i++) {
			char letter = text.charAt(i);
			Double frequency = frequencies.get(letter);
			if (frequency == null)
				frequencies.put(letter, 1.0);
			else
				frequencies.put(letter, frequency + 1);
		}
		
		/* trouble shooting
		int o = frequencies.get('z');
		int tl = text.length();
		double ans = ((double)o/tl);
		StdOut.print(o + "\n" + tl + "\n");
		StdOut.println(ans);
		*/
		
		for (char key : frequencies.keys()) {
			double per = 100*frequencies.get(key)/text.length();
			StdOut.printf("%c: %6.2f%%\n", key, per);
		}
		
	}
	
}
