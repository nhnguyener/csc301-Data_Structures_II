//Nathan Nguyen
package symboltable;

import algs4.StdIn;
import algs4.StdOut;
import myalgs4.BSTEssential;

public class TranslateCodonToAA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTEssential<String, String> transl = new BSTEssential<>();
		StdIn.fromFile("data/codontranslation.txt");
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String[] fields = line.split("\\t");
			String codon = fields[0];
			String aaa = fields[1];
			transl.put(codon, aaa);
		}
		
		StdIn.fromFile("data/SARSCoV2-S-gene-IL.txt");
		String text = StdIn.readAll();
		for (int i = 0; i < text.length(); i+=3) {
			StdOut.print(transl.get(text.substring(i, i+3)) + " ");
		}
	}
}
