package Graph;
/*
 * http://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 */
public class DetectCycleInUndirectedGraph {

	// recursive dfs
	public boolean isCyclicUtil(Vertex[] vertices, int v, boolean[] visited, int parent) {

		visited[v] = true;
		System.out.println("visiting " + vertices[v].vertexName);
		for (Neighbour nbr = vertices[v].adjList; nbr != null; nbr = nbr.next) {
			if (!visited[nbr.neighbourNum]){
				if(isCyclicUtil(vertices, nbr.neighbourNum, visited, v)) return true;
			}
			else if(nbr.neighbourNum != parent) return true;
		}
		return false;
	}

	public boolean isCyclic(Graph graph) {
		Vertex[] vertices = graph.getVertices();
		boolean[] visited = new boolean[vertices.length];
		// below loop is to ensure we cover all vertices in caseof disconnected graphs too
		for (int v = 0; v < visited.length; v++)
			if (!visited[v])
				if (isCyclicUtil(vertices, v, visited,-1)) return true;
		return false;
	}


	public static void main(String[] args) {
		DetectCycleInUndirectedGraph obj = new DetectCycleInUndirectedGraph();
		try{
			Graph g1 = new Graph(5,"undirected");
			g1.addEdge(1, 0);
			g1.addEdge(0, 2);
			g1.addEdge(2, 0);
			g1.addEdge(0, 3);
			g1.addEdge(3, 4);
			System.out.println("Cycle:"+obj.isCyclic(g1));
			System.out.println();

			Graph g2 = new Graph(3,"undirected");
			g2.addEdge(0, 1);
			g2.addEdge(1, 2);
			System.out.println("Cycle:"+obj.isCyclic(g2));
		}catch(Exception e){
			System.out.println("Exception: Issue in adding edge");
		}

	}
}
