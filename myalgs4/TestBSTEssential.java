package myalgs4;

import algs4.StdIn;

public class TestBSTEssential {

	public static void main(String[] args) {
		BSTEssential<String, Integer> st = new BSTEssential<>();
		StdIn.fromFile("data/tinyTale.txt");
		String[] words = StdIn.readAllStrings();
		for (String word: words) {
			Integer count = st.get(word);
			if (count == null) {
				st.put(word, 1);
			}
			else {
				st.put(word, count+1);
			}
		}
		st.drawTree();
	}
}
