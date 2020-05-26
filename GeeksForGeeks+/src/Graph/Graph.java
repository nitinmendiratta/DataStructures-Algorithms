package Graph;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/graph-and-its-representations/
 * https://www.youtube.com/watch?v=uT1p5Eiw9CE
 */
class Neighbour{
	int neighbourNum;
	Neighbour next;
	public Neighbour(int data, Neighbour nbr){
		this.neighbourNum = data;
		this.next = nbr;
	}
}

class Vertex{
	int vertexName;
	Neighbour adjList;
	public Vertex(int name, Neighbour list){
		vertexName = name;
		adjList = list;
	}
}

public class Graph{

	Vertex[] vertices;
	boolean undirected = true;

	public Graph(int vcount, String graphType){
		if (graphType.equals("directed")) undirected = false;
		vertices = new Vertex[vcount];
		for (int v = 0; v < vertices.length; v++) {
			vertices[v] = new Vertex(v, null);
		}
	}

	public void addEdge(int v1, int v2) throws IllegalStateException{
		vertices[v1].adjList = new Neighbour(v2, vertices[v1].adjList);
		if (undirected) {
			vertices[v2].adjList = new Neighbour(v1, vertices[v2].adjList);
		}
	}

	public Vertex[] getVertices(){
		return vertices;
	}

	public void printGraph() {
		System.out.println();
		for (int v = 0; v < vertices.length; v++) {
			System.out.print(vertices[v].vertexName);
			for (Neighbour nbr = vertices[v].adjList; nbr != null;nbr = nbr.next) {
				System.out.print(" --> " + vertices[nbr.neighbourNum].vertexName);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(5,"undirected");
		try{
			graph.addEdge(0, 1);
			graph.addEdge(0, 4);
			graph.addEdge(1, 2);
			graph.addEdge(1, 3);
			graph.addEdge(1, 4);
			graph.addEdge(2, 3);
			graph.addEdge(3, 4);
		}
		catch(Exception e){
			System.out.println("Issue in adding edge");
		}
		// print the adjacency list representation of the above graph
		graph.printGraph();
	}

	public boolean isEulerianCircuit() {
		// TODO Auto-generated method stub
		return false;
	}
}