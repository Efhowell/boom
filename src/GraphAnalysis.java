import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GraphAnalysis {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("What is the file with the graph to check?");
		String filename = input.nextLine();
		System.out.println("What is the format you want to store the graph in?");
		System.out.println("list or matrix");
		String type = input.nextLine();
		Graph<String> g = null;
		if("list".equals(type)) {
			g = new GraphList<String>(readFile(filename));
		}
		else if("matrix".equals(type)) {
			g = new GraphMatrix<String>(readFile(filename));
		}
		else {
			System.out.println("Invalid graph format");
			System.exit(1);
		}
		input.close();
		
		long start = System.currentTimeMillis();
		ArrayList<Set<String>> cliques = new ArrayList<Set<String>>(findAllCliques(g));
		long end = System.currentTimeMillis();
		
		
		Collections.sort(cliques, (a,b) -> {
			return Integer.compare(a.size(), b.size()); 
		});
		System.out.println("Calculation took "+(end-start)+" milliseconds");
		System.out.println("There are "+cliques.size()+" cliques in the graph.");
		for(Set<String> clique : cliques) {
			System.out.println("Clique of size "+clique.size()+": "+clique.toString().substring(1,clique.toString().length()-1));
		}
		
	}
	
	public static List<Pair<String, String>> readFile(String filename) {
		return null;
	}
	
	public static <E> Set<Set<E>> findAllCliques(Graph<E> g) {
		return null;
	}
	
	public static <E> boolean checkIfClique(Graph<E> g, Set<E> vertices) {
		return false;
	}
}
