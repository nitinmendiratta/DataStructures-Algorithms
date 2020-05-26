package Graph;
/*
 * http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 */
public class DetectCycleInaDirectedGraph {

	// recursive dfs
	public boolean isCyclicUtil(Vertex[] vertices, int v, boolean[] visited, boolean[] revStack) {

		if(visited[v] == false){
			visited[v] = true;
			revStack[v] = true;

			System.out.println("visiting " + vertices[v].vertexName);
			for (Neighbour nbr = vertices[v].adjList; nbr != null; nbr = nbr.next) {
				if (!visited[nbr.neighbourNum] && isCyclicUtil(vertices, nbr.neighbourNum, visited, revStack)) return true;
				else if(revStack[nbr.neighbourNum]) return true;
			}
		}
		System.out.println("Making false: "+v);
		revStack[v] = false;// while backtracking we make visited node freom revstack as false
		return false;
	}

	public boolean isCyclic(Graph graph) {
		Vertex[] vertices = graph.getVertices();
		boolean[] visited = new boolean[vertices.length];
		boolean[] revStack = new boolean[vertices.length];
		// below loop is to ensure we cover all vertices in caseof disconnected graphs too
		for (int v = 0; v < visited.length; v++)
			if (isCyclicUtil(vertices, v, visited,revStack)) return true;
		return false;
		}

		public static void main(String[] args) {
			DetectCycleInaDirectedGraph obj = new DetectCycleInaDirectedGraph();
			Graph g = new Graph(3,"directed");
			g.addEdge(0, 1);
			g.addEdge(0, 2);
			g.addEdge(1, 2);
			/*g.addEdge(2, 0);
			g.addEdge(2, 3);
			g.addEdge(3, 3);*/
			// print the adjacency list representation of the above graph
			g.printGraph();
			System.out.println("Cycle:"+obj.isCyclic(g));
		}
	}
