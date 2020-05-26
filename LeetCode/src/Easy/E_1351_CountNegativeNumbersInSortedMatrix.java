package Easy;
/*
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 */
public class E_1351_CountNegativeNumbersInSortedMatrix {

	// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/discuss/510249/JavaPython-3-2-similar-O(m-%2B-n)-codes-w-brief-explanation-and-analysis.
	// O(m+n)
	public int countNegatives(int[][] grid) {
		int m = grid.length, n = grid[0].length, r = m - 1, c = 0, cnt = 0;
		
		while (r >= 0 && c < n) {
			if (grid[r][c] < 0) {
				--r;
				cnt += n - c; // there are n - c negative numbers in current row.
			}else {
				++c;
			}
		}
		return cnt;
	}

	// my approach
	// O(mlogn)
	public int countNegativesBinarySearch(int[][] grid) {

		int count = 0;

		for(int i = 0; i < grid.length; i++) {
			int[] arr = grid[i];
			count += countNegative(arr);
		}
		return count;
	}

	public int countNegative(int[] arr) {
		int target = 0, start = 0, end = arr.length;

		while (start < end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] > target || target == arr[mid]) {
				start = mid+1;
			}
			else {
				end = mid;
			}
		}
		return arr.length- start;

	}
	public static void main(String[] args) {
		E_1351_CountNegativeNumbersInSortedMatrix obj = new E_1351_CountNegativeNumbersInSortedMatrix();
		//int[][] grid = new int[][] {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		int[][] grid = new int[][] {{3,2},{1,0}};
		System.out.println(obj.countNegatives(grid));
	}
}
