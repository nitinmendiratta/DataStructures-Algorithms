package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/minimum-height-trees/
 */
public class M_0310_MinimumHeightTrees {

	// Basically, the idea is to eat up all the leaves at the same time, until one/two leaves are left.
	// https://www.youtube.com/watch?v=Bl9l5cUgTnQ
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1)
			return Collections.singletonList(0);

		List<Set<Integer>> adj = new ArrayList<>(n);
		for (int i = 0; i < n; ++i)
			adj.add(new HashSet<>());
		for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}

		List<Integer> leaves = new ArrayList<>();
		for (int i = 0; i < n; ++i)
			if (adj.get(i).size() == 1)
				leaves.add(i);

		while (n > 2) {
			n -= leaves.size();
			List<Integer> newLeaves = new ArrayList<>();
			for (int i : leaves) {
				int j = adj.get(i).iterator().next();
				adj.get(j).remove(i);
				if (adj.get(j).size() == 1)
					newLeaves.add(j);
			}
			leaves = newLeaves;
		}
		return leaves;
	}

	public static void main(String[] args) {
		M_0310_MinimumHeightTrees obj = new M_0310_MinimumHeightTrees();
		int[][] edges = new int[][] { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		System.out.println(obj.findMinHeightTrees(4, edges));
	}
}
