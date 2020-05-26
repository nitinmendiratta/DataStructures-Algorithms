package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/find-positive-integer-solution-for-a-given-equation/
 */
class CustomFunction {
	public int f(int x, int y) {
		return x+y;
	}
};
public class E_1237_FindPositiveIntegerSolutionForGivenEquation {


	/*
	 * 	Intuition
		Rephrase the problem:
		Given a matrix, each row and each column is increasing.
		Find all coordinates (i,j) that A[i][j] == z

		Complexity
		In binary search,
		time complexity is O(XlogY) or O(YlogX)

		In this solution,
		time complexity is stable O(X + Y)

		Space is O(X)
	 */
	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
		List<List<Integer>> res = new ArrayList<>();
		int x = 1, y = 1000;
		while (x <= 1000 && y > 0) {
			int val = customfunction.f(x, y);
			if (val > z) --y;
			else if (val < z) ++x;
			else res.add(Arrays.asList(x++, y--));
		}
		return res;
	}

	//Time: O((xlogy), space: O(1) excluding return list.

	public List<List<Integer>> findSolutionBinarySearch(CustomFunction customFunction, int z) {
		List<List<Integer>> ans = new ArrayList<>();
		
		for (int x = 1; x < 1001; ++x) {
			int start = 1, end = 1001;
			
			while (start < end) {
				int mid = (start + end) / 2;
				if (customFunction.f(x, mid) < z) {
					start = mid + 1;
				}else {
					end = mid;
				}
			}
			if (customFunction.f(x, start) == z) {
				ans.add(Arrays.asList(x, start));
			}
		}
		return ans;
	}
}
