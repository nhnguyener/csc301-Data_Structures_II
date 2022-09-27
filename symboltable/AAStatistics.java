//Nathan Nguyen
package symboltable;

import algs4.StdIn;
import algs4.StdOut;
import myalgs4.BSTEssential;

public class AAStatistics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BSTEssential<String, String> transl = new BSTEssential<>(); //pairs codon w abrv
		StdIn.fromFile("data/codontranslation.txt");
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String[] fields = line.split("\\t");
			String codon = fields[0];
			String aaa = fields[1];
			transl.put(codon, aaa);
		}
		
		BSTEssential<String, Integer> tcounter = new BSTEssential<>(); //initializes count
		StdIn.fromFile("data/codontranslation.txt");
		while (!StdIn.isEmpty()) {
			String tline = StdIn.readLine();
			String[] tfields = tline.split("\\t");
			String taaa = tfields[1];
			int tcount = 0;
			tcounter.put(taaa, tcount);
		}
		
		StdIn.fromFile("data/SARSCoV2-S-gene-CA.txt"); //updates count values
		String text = StdIn.readAll();
		int totalcount = 0;
		for (int i = 0; i < text.length(); i+=3) {
			String translabrv = transl.get(text.substring(i, i+3));
			tcounter.put(translabrv, tcounter.get(translabrv) + 1);
			totalcount++;
		}
		
		BSTEssential<String, Boolean> repeater = new BSTEssential<>(); //checks for repeated amino acids
		StdIn.fromFile("data/codontranslation.txt");
		while (!StdIn.isEmpty()) {
			String ttline = StdIn.readLine();
			String[] ttfields = ttline.split("\\t");
			String ttaaa = ttfields[1];
			repeater.put(ttaaa, false);
		}
		
		
		for (String key : transl.keys()) {
			//StdOut.println(key + " : " + transl.get(key));
			String faaa = transl.get(key);
			int aaacount = tcounter.get(faaa);
			double aaapercent = 100*tcounter.get(faaa)/(double)totalcount;
			if (!repeater.get(faaa))
				StdOut.printf("%s\t%d\t%2.4f%%\n", faaa, aaacount, aaapercent);
			repeater.put(faaa, true);
		}
		StdOut.println(totalcount);
		
	}
}