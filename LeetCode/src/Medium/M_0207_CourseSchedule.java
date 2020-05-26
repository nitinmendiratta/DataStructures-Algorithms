package Medium;
import java.util.*;
import Helper.*;
/*
 * https://leetcode.com/problems/course-schedule/
 */
public class M_0207_CourseSchedule {

	// BFS
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		ArrayList[] graph = new ArrayList[numCourses];
		 // Stores the prerequisite course count, basically nodes that have an in-degree,
		//courses which are pre-requisite of some course
		int[] degree = new int[numCourses];
		Queue queue = new LinkedList();
		int count = 0;

		for (int i = 0; i < numCourses; i++)
			graph[i] = new ArrayList();

		for (int i = 0; i < prerequisites.length; i++) {
			degree[prerequisites[i][1]]++;
			graph[prerequisites[i][0]].add(prerequisites[i][1]); // create the dependency graph
		}
		// add to queue nodes which are not pre-requisite of any other course
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] == 0) {
				queue.add(i);
				count++;
			}
		}

		while (queue.size() != 0) {
			int course = (int) queue.poll();
			// visit adj list of each non-preq course
			for (int i = 0; i < graph[course].size(); i++) {
				int pointer = (int) graph[course].get(i);
				degree[pointer]--; // decrease degree of preq course ex: 1->0 here we decrease degree of 0 which was 1.
				if (degree[pointer] == 0) {
					queue.add(pointer);
					count++;
				}
			}
		}
		if (count == numCourses)
			return true;
		else
			return false;
	}

	// DFS
	public boolean canFinishApproach2(int numCourses, int[][] prerequisites) {
		if (numCourses == 0 || prerequisites == null || prerequisites.length == 0)
			return true; // ??

		// create the array lists to represent the courses
		List<List<Integer>> courses = new ArrayList<List<Integer>>(numCourses);
		for (int i = 0; i < numCourses; i++) {
			courses.add(new ArrayList<Integer>());
		}

		// create the dependency graph
		for (int i = 0; i < prerequisites.length; i++) {
			courses.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}

		int[] visited = new int[numCourses];

		// dfs visit each course
		for (int i = 0; i < numCourses; i++) {
			if (!dfs(i, courses, visited))
				return false;
		}

		return true;
	}

	// 0 - not visited (whiteSet)
	// 1 - being visited (graySet)
	// 2 - visited (blackSet)
	private boolean dfs(int course, List<List<Integer>> courses, int[] visited) {

		visited[course] = 1; // mark it being visited

		List<Integer> eligibleCourses = courses.get(course); // get its children

		// dfs its children
		for (int i = 0; i < eligibleCourses.size(); i++) {
			int eligibleCourse = eligibleCourses.get(i).intValue();

			if (visited[eligibleCourse] == 1)
				return false; // has been visited while visiting its children - cycle !!!!
			if (visited[eligibleCourse] == 0) { // not visited
				if (!dfs(eligibleCourse, courses, visited))
					return false;
			}

		}

		visited[course] = 2; // mark it done visiting
		return true;
	}

	// Approach3: Kind of DFS
	// https://www.youtube.com/watch?v=rKQaZuoUR4M
	public boolean canFinishApproach3(int numCourses, int[][] prerequisites) {
		Graph graph = new Graph(true); // directed graph
		for (int i = 0; i < prerequisites.length; i++) {
			int[] edge = prerequisites[i];
			int source = edge[0], destination = edge[1];
			graph.addEdge(source, destination);
		}
		graph.printGraph();
		return !hasCycle(graph);
	}

	public boolean hasCycle(Graph graph) {
		Set<GraphNode> whiteSet = new HashSet<>();
		Set<GraphNode> graySet = new HashSet<>();
		Set<GraphNode> blackSet = new HashSet<>();

		for (GraphNode vertex : graph.graph.neighbors) {
			whiteSet.add(vertex);
		}

		while (whiteSet.size() > 0) {
			GraphNode current = whiteSet.iterator().next();
			if (dfs(current, whiteSet, graySet, blackSet)) {
				return true;
			}
		}
		return false;
	}

	private boolean dfs(GraphNode current, Set<GraphNode> whiteSet, Set<GraphNode> graySet, Set<GraphNode> blackSet) {
		// move current to gray set from white set and then explore it.
		moveVertex(current, whiteSet, graySet);
		for (GraphNode neighbor : current.neighbors) {
			// if in black set means already explored so continue.
			if (blackSet.contains(neighbor)) {
				continue;
			}
			// if in gray set then cycle found.
			if (graySet.contains(neighbor)) {
				return true;
			}
			if (dfs(neighbor, whiteSet, graySet, blackSet)) {
				return true;
			}
		}
		// move vertex from gray set to black set when done exploring.
		moveVertex(current, graySet, blackSet);
		return false;
	}

	private void moveVertex(GraphNode vertex, Set<GraphNode> sourceSet, Set<GraphNode> destinationSet) {
		sourceSet.remove(vertex);
		destinationSet.add(vertex);
	}

	public static void main(String[] args) {
		M_0207_CourseSchedule obj = new M_0207_CourseSchedule();
		System.out.println(obj.canFinish(2, new int[][] { { 1, 0 } }));
		System.out.println(obj.canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
	}
}
