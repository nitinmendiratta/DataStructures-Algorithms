package Medium;

import java.util.*;

/*
 * https://leetcode.com/problems/course-schedule-ii/
 */
public class M_0210_CourseSchedule2 {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] res = new int[numCourses]; // store possible path

		ArrayList[] graph = new ArrayList[numCourses];
		// Stores the prerequisite course count, basically nodes that have an in-degree,
		// courses which are pre-requisite of some course
		int[] degree = new int[numCourses];
		Queue queue = new LinkedList();
		
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
			}
		}
		int count = numCourses - 1; // keep track of visited courses
		
		while (queue.size() != 0) {
			int course = (int) queue.poll();
			res[count--] = course;
			// visit adj list of each non-preq course
			for (int i = 0; i < graph[course].size(); i++) {
				int pointer = (int) graph[course].get(i);
				degree[pointer]--; // decrease degree of preq course ex: 1->0 here we decrease degree of 0 which
									// was 1.
				if (degree[pointer] == 0) {
					queue.add(pointer);
				}
			}
		}
		if (count == -1)
			return res;
		else
			return new int[] {};
	}

	public static void main(String[] args) {
		M_0210_CourseSchedule2 obj = new M_0210_CourseSchedule2();
		System.out.println(Arrays.toString(obj.findOrder(2, new int[][] { { 1, 0 } })));
		System.out.println(Arrays.toString(obj.findOrder(2, new int[][] { { 1, 0 }, { 0, 1 } })));
		System.out.println(Arrays.toString(obj.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } })));
	}
}
