package Helper;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/breadth-first-traversal-for-a-graph/
 * http://www.geeksforgeeks.org/depth-first-traversal-for-a-graph/
 * https://www.youtube.com/watch?v=uT1p5Eiw9CE
 */
public class GraphTraversal {

	private void bfs(GraphNode start){

		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		HashMap<Integer, GraphNode> visited = new HashMap(); //store visited GraphNodes

		queue.add(start);
		System.out.println("\nSTARTING AT " + start.val);

		while(!queue.isEmpty()){
			GraphNode curr = queue.remove();

			for (GraphNode neighbor : curr.neighbors) {

				if (!visited.containsKey(neighbor.val)) {
					queue.add(neighbor);
					visited.put(neighbor.val, neighbor);
					System.out.println("Visiting: " + neighbor.val + " from adj list of: " + curr.val);
				}
			}
		}
	}

	// recursive dfs
	public void dfsUtil(GraphNode start, HashMap<Integer, GraphNode> map) {

		for (GraphNode neighbor : start.neighbors) {

			if (!map.containsKey(neighbor.val)) {
				map.put(neighbor.val, neighbor);
				System.out.println("Visiting: " + neighbor.val + " from adj list of: " + start.val);
				dfsUtil(neighbor, map);
			}
		}
	}

	public void dfs(GraphNode start) {

		HashMap<Integer, GraphNode> map = new HashMap(); //store visited GraphNodes
		System.out.println("\nSTARTING AT " + start.val);
		dfsUtil(start, map);
	}

	public static void main(String[] args) {
		GraphTraversal traverse = new GraphTraversal();
		Graph obj = new Graph(true);
		GraphNode graph = obj.graph;
		obj.addEdge(0, 1);
		obj.addEdge(0, 2);
		obj.addEdge(1, 3);
		obj.addEdge(2, 3);
		obj.addEdge(3, 4);
		obj.addEdge(4, 5);
		// print the adjacency list representation of the above graph
		obj.printGraph();
		System.out.println("<-----BFS------>");
		traverse.bfs(obj.graph.neighbors.get(0));
		System.out.println();
		System.out.println("<-----DFS------>");
		traverse.dfs(obj.graph.neighbors.get(0));
		//System.out.println("Traversal is:"+traverse.dfs(graph,0));
	}
}