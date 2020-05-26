package Medium;
import java.util.*;
/*
 * https://leetcode.com/problems/merge-intervals/
 */
public class M_0056_MergeIntervals {
	
	
	// Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
	private class IntervalComparator implements Comparator<int[]> {
		@Override
		public int compare(int[] a, int[] b) {
			return a[0] < b[0] ? -1 : a[0] == b[0] ? 0 : 1;
		}
	}

	public int[][] merge(int[][] intervals) {

		if(intervals.length <= 1){
			return intervals;
		}
		
		Collections.sort(Arrays.asList(intervals), new IntervalComparator());
        LinkedList<int[]> res = new LinkedList<>();
		int[] prevInterval = intervals[0];

		for(int i = 1; i < intervals.length; i++) {

			int[] currInterval = intervals[i];
			
			if(prevInterval[1] >= currInterval[0]){
				// we are in between or beyond
				prevInterval[1] = Math.max(currInterval[1], prevInterval[1]);
			} else {
				// add to list
				res.add(prevInterval);
				prevInterval = currInterval;
			}  
		}

		res.add(prevInterval);
		return res.toArray(new int[res.size()][]);
	}
	public static void main(String[] args) {
		M_0056_MergeIntervals obj = new M_0056_MergeIntervals();
		//int[][] grid = new int[][] {};
		//int[][] grid = new int[][] {{1,3},{2,6},{8,10},{15,18}};
		int[][] grid = new int[][] {{1,4},{4,5}};
		int[][] res = obj.merge(grid);
		for(int i = 0; i < res.length; i++) {
			System.out.println(Arrays.toString(res[i]));
		}
	}
}
