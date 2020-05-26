package Medium;
import java.util.*;

import Helper.*;
/*
 * https://leetcode.com/problems/clone-graph/
 */
public class M_0133_CloneGraph {

	// BFS
	public GraphNode cloneGraph(GraphNode GraphNode) {
		if (GraphNode == null) return null;

		GraphNode newGraphNode = new GraphNode(GraphNode.val); //new GraphNode for return
		HashMap<Integer, GraphNode> map = new HashMap(); //store visited GraphNodes

		map.put(newGraphNode.val, newGraphNode); //add first GraphNode to HashMap

		LinkedList<GraphNode> queue = new LinkedList(); //to store **original** GraphNodes need to be visited
		queue.add(GraphNode); //add first **original** GraphNode to queue

		while (!queue.isEmpty()) { //if more GraphNodes need to be visited
			GraphNode currGraphNode = queue.pop(); //search first GraphNode in the queue
			for (GraphNode neighbor : currGraphNode.neighbors) {
				if (!map.containsKey(neighbor.val)) { //add to map and queue if this GraphNode hasn't been searched before
					map.put(neighbor.val, new GraphNode(neighbor.val));
					queue.add(neighbor);
				}
				// Map will give you new GraphNode
				map.get(currGraphNode.val).neighbors.add(map.get(neighbor.val)); //add neighbor to new created GraphNodes
			}
		}

		return newGraphNode;
	}
	
	// DFS
	public GraphNode cloneGraphDFS(GraphNode GraphNode) {
		if (GraphNode == null) return null;

		HashMap<Integer, GraphNode> map = new HashMap(); //store visited GraphNodes	
		return cloneGraphUtil(GraphNode, map);
	}
	
	public GraphNode cloneGraphUtil(GraphNode start, HashMap<Integer, GraphNode> map) {

		if (start == null) return null;
        
        if (map.containsKey(start.val)) {
            return map.get(start.val);
        }
        // create copy of the GraphNode
        GraphNode clone = new GraphNode(start.val);
        map.put(start.val, clone);
        
        for (GraphNode neighbor : start.neighbors) {
            clone.neighbors.add(cloneGraphUtil(neighbor, map));
        }
        return clone;
	}
	
	public static void main(String[] args) {
		M_0133_CloneGraph obj = new M_0133_CloneGraph();
		Graph graph = new Graph(true);
		graph.addEdge(0,1);
		graph.addEdge(1,0);
		graph.addEdge(1,3);
		graph.addEdge(1,2);
		graph.addEdge(2,4);

		graph.printGraph();
		obj.cloneGraph(graph.graph.neighbors.get(0));
		obj.cloneGraphDFS(graph.graph.neighbors.get(0));
	}
}
