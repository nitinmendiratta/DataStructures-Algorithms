package Helper;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/graph-and-its-representations/
 * https://www.youtube.com/watch?v=uT1p5Eiw9CE
 * Another implementation: https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/Graph.java
 * A user define class to represent a graph. 
 * A graph is an array of adjacency lists. Size of array will be V (number of vertices in graph)
 * */

public class Graph { 
	// Each GraphNode maps to a list of all his neighbors
	public boolean directed;
	public GraphNode graph;

	public Graph(boolean directed) {
	    this.directed = directed;
	    graph = new GraphNode();
	}

	public void addEdge(int source, int destination) {

	    GraphNode sourceGraphNode = getGraphNode(source);
	    GraphNode destinationGraphNode = getGraphNode(destination);

	    sourceGraphNode.neighbors.add(destinationGraphNode);

	    // If a graph is undirected, we want to add an edge from destination to source as well
	    if (!directed) {
	    	destinationGraphNode.neighbors.add(sourceGraphNode);
	    }
	}

	public GraphNode getGraphNode(int source) {
		Iterator<GraphNode> iterator = graph.neighbors.iterator();
	    while (iterator.hasNext()) {
	    	GraphNode curr = iterator.next();
	        if (curr.val == source) {
	            return curr;
	        }
	    }
	    GraphNode newGraphNode = new GraphNode(source);
	    graph.neighbors.add(newGraphNode);
	    return newGraphNode;
	}
	
	public void printGraph() {
	    for (GraphNode GraphNode : graph.neighbors) {
	        System.out.print(GraphNode.val + "--->");
	        for (GraphNode neighbor : GraphNode.neighbors) {
	            System.out.print(neighbor.val + " ");
	        }
	        System.out.println();
	    }
	}

	public boolean hasEdge(int source, int destination) {
		Iterator<GraphNode> iterator = getGraphNode(source).neighbors.iterator();
	    while (iterator.hasNext()) {
	    	GraphNode curr = iterator.next();
	        if (curr.val == destination) {
	            return true;
	        }
	    }
	    return false;
	}

	// Driver program to test above functions 
	public static void main(String args[]) { 
		Graph graph = new Graph(true);
        graph.addEdge(0,1);
        graph.addEdge(1,0);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(2,4);

        graph.printGraph();

        System.out.println(graph.hasEdge(1,0));
        System.out.println(graph.hasEdge(3,4));
	} 
}