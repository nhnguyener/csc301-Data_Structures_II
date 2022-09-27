//Nathan Nguyen
package symboltable;

import algs4.StdIn;
import algs4.StdOut;
import myalgs4.AVLTreeST;
import algs4.Queue;

public class CountCodonFollowers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdIn.fromFile("data/codonlist.txt");
		AVLTreeST<String, Queue<Integer>> codonq = new AVLTreeST<>();
		String[] codonlist = new String[64];
		int codoncount = 0;
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			Queue<Integer> pos = new Queue<Integer>();
			codonq.put(line, pos);
			codonlist[codoncount] = line;
			codoncount++;
		}
		
		StdIn.fromFile("data/SARSCoV2-S-gene-WH.txt");
		String text = StdIn.readAll(); //"atgtttgtttttcttgtttttttgccactagtctctagtcagtgtgttaatcttacaaccagaact";
		for (int i = 0; i < text.length(); i+=3) {
			String codon = text.substring(i, i+3);
			codonq.get(codon).enqueue(i);
		}
		
		/*
		StdOut.println("gtt: " + codonq.get("gtt"));
		for (int j = 0; j < codonq.get("gtt").size(); j++) {
			int currentpos = codonq.get("gtt").dequeue();
			StdOut.println(text.substring(currentpos+3, currentpos+6));
		}
		*/
		
		for (int i = 0; i < codonlist.length; i++) {
			AVLTreeST<String, Boolean> codonpresent = new AVLTreeST<>();
			if (!(codonq.get(codonlist[i]).isEmpty())) {
				
				for (int j = 0; j < codonq.get(codonlist[i]).size(); j++) {
					int curpos = codonq.get(codonlist[i]).dequeue();
					if (!codonlist[i].equals("taa")) {
						String follower = text.substring(curpos+3, curpos+6);
						codonpresent.put(follower, true);
					}
					//StdOut.print(codonlist[i] + ": ");
					//StdOut.println(text.substring(curpos+3, curpos+6));
				} 
				StdOut.println(codonlist[i] + " has " + codonpresent.size() + " different followers.");
				
			} else 
				StdOut.println(codonlist[i] + " is not present in the sequence.");
			
		}
		/*
		for (String keys : codonq.keys()) {
			StdOut.println(keys + " " + codonq.get(keys));
		}
		*/
	}

}
