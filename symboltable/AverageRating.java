package symboltable;

import algs4.SequentialSearchST;
import algs4.StdIn;
import algs4.StdOut;

public class AverageRating {

	public static void main(String[] args) {
		SequentialSearchST<String, Double> ratings = new SequentialSearchST<>();
		/*
		 * Outstanding	3
		 * Excellent	2.5
		 * Very good	2
		 * Good			1.5
		 * Fair			1
		 * Poor			0.5
		 * Avoid		0
		 */
		double score;
		StdIn.fromFile("data/ratings.txt");
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			
			if (line.equals("Outstanding"))
				score = 3;
			else if (line.equals("Excellent"))
				score = 2.5;
			else if (line.equals("Very good"))
				score = 2;
			else if (line.equals("Good"))
				score = 1.5;
			else if (line.equals("Fair"))
				score = 1;
			else if (line.equals("Poor"))
				score = 0.5;
			else
				score = 0;
			
			ratings.put(line, score);
		}
		
		double total = 0;
		double count = 0;
		
		for (String review : ratings.keys()) {
			//StdOut.println("Rating: " + review);
			total += ratings.get(review);
			//StdOut.println("Score: " + ratings.get(review));
			count++;
		}
		
		double avgScore = total/count;
		
		StdOut.println("Total Score:	" + total);
		StdOut.println("Total Reviews: 	" + count);
		StdOut.println("Average Score:	" + avgScore);

	}

}
