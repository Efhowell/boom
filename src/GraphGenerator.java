import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Random;
/**
 * Class to generated text files that represent unweighted graphs
 * 
 * @author Catie Baker
 */

public class GraphGenerator {
	public static void main(String[] args) {
		for(int vert = 5; vert<20; vert+=5) {
			for(int edges = 10; edges<=100; edges += 10) {
				double per = edges/100.0;
				GraphGenerator.writeUnweightedGraph(vert,per,"graph"+vert+"_"+edges+".txt");
			}
		}
	}


	/**
	 * Creates and writes an unweighted graph where each edge is included with the specified probability.
	 * Each vertex is named with an integer value, starting with 0
	 * @param numVertices the number of vertices in the graph
	 * @param edgeOdd the odds that each edge is in the graph
	 * @param file the file name to create and write the graph to
	 */
	public static void writeUnweightedGraph(int numVertices, double edgeOdd, String file) {
		try {
			FileWriter fw = new FileWriter(new File(file));
			HashSet<String> edges = new HashSet<String>();
			Random r = new Random();
			for(int i = 0; i<numVertices; i++) {
				for(int j = 0; j<numVertices; j++) {
					if(i != j) {
						double ran = Math.random();
						if(ran<edgeOdd) {
							String edge = i+","+j;
							if(!edges.contains(edge)) {
								edges.add(edge);
								fw.write(edge+"\n");
							}
						}
					}
				}
			}
			fw.close();
		} catch (IOException e) {
			System.out.println("Error writing to the file");
		}
	}

}
