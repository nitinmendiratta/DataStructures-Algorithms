package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/reconstruct-itinerary/
 */
public class M_0332_ReconstructItinerary {

	public List<String> findItinerary(List<List<String>> tickets) {
		List<String> res = new ArrayList(); // store possible route

		if (tickets == null || tickets.size() == 0)
			return res;

		HashMap<String, PriorityQueue<String>> graph = buildGraph(tickets);

		dfsIterative(tickets, graph, "JFK", res);
		//dfsRecursive(graph, "JFK", res);
		return res;
	}

	// build graph
	public HashMap<String, PriorityQueue<String>> buildGraph(List<List<String>> tickets) {

		HashMap<String, PriorityQueue<String>> graph = new HashMap();

		for (int i = 0; i < tickets.size(); i++) {
			List<String> edge = tickets.get(i);

			String from = edge.get(0);
			String to = edge.get(1);

			if (!graph.containsKey(from)) {
				PriorityQueue<String> newToList = new PriorityQueue<String>();
				newToList.add(to);
				graph.put(from, newToList);
			} else {
				graph.get(from).add(to);
			}
		}
		return graph;
	}

	// iterative
	public void dfsIterative(List<List<String>> tickets, HashMap<String, PriorityQueue<String>> graph,
			String startAirport, List<String> res) {

		Stack<String> backTrack = new Stack<String>();

		for (int i = 0; i < tickets.size(); i++) {
			
			// we are stuck there could be other potential nodes to be visited
			while (!graph.containsKey(startAirport) || graph.get(startAirport).isEmpty()) {
				backTrack.push(startAirport);
				startAirport = res.remove(res.size() - 1);
			}
			
			res.add(startAirport);
			startAirport = graph.get(startAirport).poll();
		}
		res.add(startAirport);

		while (!backTrack.isEmpty())
			res.add(backTrack.pop());

		return;
	}

	// recursive
	public void dfsRecursive(HashMap<String, PriorityQueue<String>> graph, String startAirport, List<String> res) {
        PriorityQueue<String> destinations = graph.getOrDefault(startAirport, new PriorityQueue<>());
        
        while (!destinations.isEmpty()) {
            String to = destinations.poll();
            dfsRecursive(graph, to, res);
        }
        
        res.add(0, startAirport);
    }
	
	public static void main(String[] args) {
		M_0332_ReconstructItinerary obj = new M_0332_ReconstructItinerary();
		List<List<String>> tickets = new ArrayList<List<String>>();

		tickets.add(new ArrayList(Arrays.asList("MUC", "LHR")));
		tickets.add(new ArrayList(Arrays.asList("JFK", "MUC")));
		tickets.add(new ArrayList(Arrays.asList("SFO", "SJC")));
		tickets.add(new ArrayList(Arrays.asList("LHR", "SFO")));

		System.out.println(obj.findItinerary(tickets));
	}
}
