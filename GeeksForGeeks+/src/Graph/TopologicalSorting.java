package Graph;
import java.util.Stack;

/*
 * http://www.geeksforgeeks.org/topological-sorting/
 */
public class TopologicalSorting {

	// recursive dfs
	public void sortUtil(Vertex[] vertices, int v, boolean[] visited, Stack s) {
		visited[v] = true;
		for (Neighbour nbr = vertices[v].adjList; nbr != null; nbr = nbr.next)
			if (!visited[nbr.neighbourNum])
				sortUtil(vertices, nbr.neighbourNum, visited, s);
		s.push(v);
	}

	public void sort(Graph graph) {
		Vertex[] vertices = graph.getVertices();
		boolean[] visited = new boolean[vertices.length];
		Stack s = new Stack();
		// below loop is to ensure we cover all vertices in caseof disconnected graphs too
		for (int v = 0; v < visited.length; v++) {
			if (!visited[v]) 
				sortUtil(vertices, v, visited, s);
		}

		// Print contents of stack
		while (!s.isEmpty())
			System.out.print((int)s.pop());
	}

	public static void main(String[] args) {
		TopologicalSorting obj = new TopologicalSorting();
		Graph g = new Graph(6,"directed");
		g.addEdge(5, 2);
		g.addEdge(5, 0);
		g.addEdge(4, 0);
		g.addEdge(4, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 1);
		// print the adjacency list representation of the above graph
		g.printGraph();
		obj.sort(g);
	}
}
