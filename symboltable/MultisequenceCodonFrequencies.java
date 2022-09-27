//Nathan Nguyen
package symboltable;

import algs4.Count;
import algs4.StdIn;
import algs4.StdOut;
import myalgs4.AVLTreeST;
import myalgs4.BSTEssential;

public class MultisequenceCodonFrequencies {
	
	public static void main(String[] args) {
		
		AVLTreeST<String, AVLTreeST<String, Double>> frequencies = new AVLTreeST<>();
		AVLTreeST<String, Integer> codoncounts = new AVLTreeST<>();
		
		String[] textFilenames = {"data/SARSCoV2-S-gene-CA.txt", "data/SARSCoV2-S-gene-IL.txt", "data/SARSCoV2-S-gene-WH.txt"};
		
		BSTEssential<String, String> transl = new BSTEssential<>(); //initializes table for codon names and amounts
		StdIn.fromFile("data/codontranslation.txt");
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String[] fields = line.split("\\t");
			String codon = fields[0];
			String aaa = fields[1];
			transl.put(codon, aaa);
			codoncounts.put(codon, 0);
		}
		
		for(String filename : textFilenames) {
			StdIn.fromFile(filename);
			String text = StdIn.readAll();
			frequencies.put(filename, new AVLTreeST<String, Double>());
			
			int totalCodons = 0;
			for (int i = 0; i < text.length(); i+=3) {
				String codontext = text.substring(i, i+3);
				if(transl.get(codontext) != null) {
					codoncounts.put(codontext, codoncounts.get(codontext) + 1);
					totalCodons += 1;
				}
			}
			codoncounts.put("total",  totalCodons);
			
			for (String cckeys : codoncounts.keys()) {
				if(cckeys.equals("total")) {
					frequencies.get(filename).put(cckeys, (double) codoncounts.get(cckeys));
				} else {
					int total = codoncounts.get("total");
					double aminofreq = 100.0 * codoncounts.get(cckeys)/total;
					frequencies.get(filename).put(cckeys, aminofreq);
				}
			}
			
		}
		
		String[] leucodons = {"ctt", "ctc", "cta", "ctg", "tta", "ttg"};	
		for (String fkeys : frequencies.keys()) {
			StdOut.println(fkeys);
			for (String leu : leucodons) {	
				StdOut.printf("%s: %2.4f%%\n", leu, frequencies.get(fkeys).get(leu));
			}
			StdOut.println("Total Codons: " + frequencies.get(fkeys).get("total") + "\n");
		}
		
	}
}
