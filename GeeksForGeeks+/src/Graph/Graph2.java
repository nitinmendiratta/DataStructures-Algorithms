package Graph;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
/*
 * https://www.youtube.com/watch?v=uT1p5Eiw9CE
 */
class Neighbor2 {
	public int vertexNum;
	public Neighbor2 next;
	public Neighbor2(int vnum, Neighbor2 nbr) {
		this.vertexNum = vnum;
		next = nbr;
	}
}

class Vertex2 {
	String name;
	Neighbor2 adjList;
	Vertex2(String name, Neighbor2 neighbors) {
		this.name = name;
		this.adjList = neighbors;
	}
}

public class Graph2 {

	Vertex2[] vertices;

	public Graph2(String file) throws FileNotFoundException {

		Scanner sc = new Scanner(new File(file));   
		String graphType = sc.next();
		boolean undirected = true;
		if (graphType.equals("directed")) {
			undirected=false;
		}
		vertices = new Vertex2[sc.nextInt()];

		// read vertices
		for (int v=0; v < vertices.length; v++) {
			vertices[v] = new Vertex2(sc.next(), null);
		}

		// read edges
		while (sc.hasNext()) {
			// read vertex names and translate to vertex numbers
			int v1 = indexForName(sc.next());
			int v2 = indexForName(sc.next());

			// add v2 to front of v1's adjacency list and
			// add v1 to front of v2's adjacency list
			vertices[v1].adjList = new Neighbor2(v2, vertices[v1].adjList);
			if (undirected) {
				vertices[v2].adjList = new Neighbor2(v1, vertices[v2].adjList);
			}
		}
	}

	int indexForName(String name) {
		for (int v=0; v < vertices.length; v++) {
			if (vertices[v].name.equals(name)) {
				return v;
			}
		}
		return -1;
	}   

	// recursive dfs
	private void dfs(int v, boolean[] visited) {
		visited[v] = true;
		System.out.println("visiting " + vertices[v].name);
		for (Neighbor2 nbr=vertices[v].adjList; nbr != null; nbr=nbr.next) {
			if (!visited[nbr.vertexNum]) {
				System.out.println("\n" + vertices[v].name + "--" + vertices[nbr.vertexNum].name);
				dfs(nbr.vertexNum, visited);
			}
		}
	}

	public void dfs() {
		boolean[] visited = new boolean[vertices.length];
		for (int v=0; v < visited.length; v++) {
			if (!visited[v]) {
				System.out.println("\nSTARTING AT " + vertices[v].name);
				dfs(v, visited);
			}
		}
	}


	public void print() {
		System.out.println();
		for (int v=0; v < vertices.length; v++) {
			System.out.print(vertices[v].name);
			for (Neighbor2 nbr=vertices[v].adjList; nbr != null;nbr=nbr.next) {
				System.out.print(" --> " + vertices[nbr.vertexNum].name);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter graph input file name: ");
		String file = "/home/nitin/Desktop/DataStructures/GeeksForGeeks+/src/Graph/friendship.txt";//sc.nextLine();
		Graph2 graph = new Graph2(file);
		//graph.print();
		graph.dfs();
	}
}