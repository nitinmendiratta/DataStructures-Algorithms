package Graph;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * https://www.youtube.com/watch?v=uT1p5Eiw9CE
 */
public class GraphTraversal {

	private void bfs(Graph graph, int start){
		Vertex[] vertices = graph.getVertices();
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[vertices.length];
		queue.add(start);
		System.out.println("\nSTARTING AT " + vertices[start].vertexName);

		while(!queue.isEmpty()){
			int vnum = (int) queue.remove();
			System.out.println("visiting " + vertices[vnum].vertexName);
			
			for (Neighbour nbr = vertices[vnum].adjList; nbr != null; nbr = nbr.next) {
				if (!visited[nbr.neighbourNum]) {
					queue.add(nbr.neighbourNum);
					visited[nbr.neighbourNum] = true;
					System.out.println("Adding: " + vertices[nbr.neighbourNum].vertexName + " from adj list of: " + vertices[vnum].vertexName);
				}
			}
		}
	}

	// recursive dfs
	public void dfsUtil(Vertex[] vertices, int v, boolean[] visited) {
		visited[v] = true;
		System.out.println("visiting " + vertices[v].vertexName);
		for (Neighbour nbr = vertices[v].adjList; nbr != null; nbr = nbr.next) {
			if (!visited[nbr.neighbourNum]) {
				System.out.println("\n" + vertices[v].vertexName + "--" + vertices[nbr.neighbourNum].vertexName);
				dfsUtil(vertices, nbr.neighbourNum, visited);
			}
		}
	}

	public void dfs(Graph graph) {
		Vertex[] vertices = graph.getVertices();
		boolean[] visited = new boolean[vertices.length];
		// below loop is to ensure we cover all vertices in caseof disconnected graphs too
		for (int v = 0; v < visited.length; v++) {
			if (!visited[v]) {
				System.out.println("\nSTARTING AT " + vertices[v].vertexName);
				dfsUtil(vertices, v, visited);
			}
		}
	}

	public static void main(String[] args) {
		GraphTraversal traverse = new GraphTraversal();
		Graph graph = new Graph(6,"directed");
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 3);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		// print the adjacency list representation of the above graph
		graph.printGraph();
		traverse.bfs(graph,0);
		//traverse.dfs(graph);
		//System.out.println("Traversal is:"+traverse.dfs(graph,0));
	}
}