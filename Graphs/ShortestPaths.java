//Nathan Nguyen
package Graphs;

import algs4.Graph;
import algs4.BreadthFirstPaths;
import algs4.StdIn;
import algs4.StdOut;

public class ShortestPaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StdIn.fromFile("data/VertexNumbers.txt");
		int vertices = 0;
		while (!StdIn.isEmpty()) {
			StdIn.readLine();
			vertices++;
		}
		Graph G = new Graph(vertices);
		
		StdIn.fromFile("data/Edges.txt");
		int va;
		int vb;
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String[] fields = line.split(" ");
			va = Integer.parseInt(fields[0]);
			vb = Integer.parseInt(fields[1]);
			G.addEdge(va, vb);
		}
		
		StdIn.fromFile("data/PathQuery.txt");
		int u;
		int v;
		while (!StdIn.isEmpty()) {
			String line = StdIn.readLine();
			String[] fields = line.split(" ");
			u = Integer.parseInt(fields[0]);
			v = Integer.parseInt(fields[1]);
			BreadthFirstPaths B = new BreadthFirstPaths(G, u);
			StdOut.print(u + " connected to " + v + "? ");
			if (B.hasPathTo(v)) {
				StdOut.println("Yes, by the path " + B.pathTo(v));
			} else {
				StdOut.println("No!");
			}
		}
	}

}
