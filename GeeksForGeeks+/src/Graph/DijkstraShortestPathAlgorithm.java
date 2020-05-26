package Graph;
/*
 * http://www.geeksforgeeks.org/greedy-algorithms-set-6-dijkstras-shortest-path-algorithm/
 */
public class DijkstraShortestPathAlgorithm {

	// A utility function to find the vertex with minimum distance value, from the set of vertices not yet included in shortest path tree
	int minDistance(int dist[], boolean sptSet[]){
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = 0;
		for (int v = 0; v < dist.length; v++){
			if (sptSet[v] == false && dist[v] <= min){
				min = dist[v]; min_index = v;
			}
		}
		return min_index;
	}

	public void dijkstra(int graph[][], int src){
		int V = graph.length;
		int dist[] = new int[V];     // The output array.  dist[i] will hold the shortest distance from src to i
		// sptSet[i] will true if vertex i is included in shortest path tree or shortest distance from src to i is finalized
		boolean sptSet[] = new boolean[V]; 
		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++)		dist[i] = Integer.MAX_VALUE;
		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V-1; count++){
			// Pick the minimum distance vertex from the set of vertices not yet processed. u is always equal to src in first iteration.
			int u = minDistance(dist, sptSet);
			// Mark the picked vertex as processed
			sptSet[u] = true;
			// Update dist value of the adjacent vertices of the picked vertex.
			for (int v = 0; v < V; v++)
				// Update dist[v] only if is not in sptSet, there is an edge from u to v, and total weight of path from src to  v 
				// through u is smaller than current value of dist[v]
				if (!sptSet[v] && (graph[u][v] != 0) && (dist[u] != Integer.MAX_VALUE) && (dist[u]+graph[u][v]) < dist[v])
					dist[v] = dist[u] + graph[u][v];
		}
		printSolution(dist, V);
	}
	// A utility function to print the constructed distance array
	public void printSolution(int dist[], int n){
		System.out.println("Vertex   Distance from Source\n");
		for (int i = 0; i < dist.length; i++)
			System.out.println(i+" , "+dist[i]);
	}

	public static void main(String[] args) {
		DijkstraShortestPathAlgorithm obj = new DijkstraShortestPathAlgorithm();
		int graph[][] = {
				{0, 4, 0, 0, 0, 0, 0, 8, 0},
				{4, 0, 8, 0, 0, 0, 0, 11, 0},
				{0, 8, 0, 7, 0, 4, 0, 0, 2},
				{0, 0, 7, 0, 9, 14, 0, 0, 0},
				{0, 0, 0, 9, 0, 10, 0, 0, 0},
				{0, 0, 4, 0, 10, 0, 2, 0, 0},
				{0, 0, 0, 14, 0, 2, 0, 1, 6},
				{8, 11, 0, 0, 0, 0, 1, 0, 7},
				{0, 0, 2, 0, 0, 0, 6, 7, 0}
		};
		obj.dijkstra(graph, 0);
	}
}
