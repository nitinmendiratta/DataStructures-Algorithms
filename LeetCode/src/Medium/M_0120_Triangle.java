package Medium;

import java.util.*;
/*
 * https://leetcode.com/problems/triangle/
 */
public class M_0120_Triangle {

	// Approach1: dp bottom up
	public int minimumTotal(List<List<Integer>> triangle) {
		int sz = triangle.size();
		int[] results = new int[sz + 1];

		for (int i = sz - 1; i >= 0; i--) {
			List<Integer> tmp = triangle.get(i);

			for (int j = 0; j < tmp.size(); j++) {
				results[j] = Math.min(results[j], results[j + 1]) + tmp.get(j);
			}
		}
		return results[0];
	}

	// Top down DP
	public int minimumTotalApproach2(List<List<Integer>> triangle) {
		int rows = triangle.size();
		int[] minSum = new int[rows];
		minSum[0] = triangle.get(0).get(0);
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < rows; i++) {
			List<Integer> curr = triangle.get(i);

			for (int j = curr.size() - 1; j >= 0; j--) {
				if (i == 0)
					minSum[j] = curr.get(j);
				else if (j == curr.size() - 1)
					minSum[j] = minSum[j - 1] + curr.get(j);
				else if (j == 0)
					minSum[j] = minSum[j] + curr.get(j);
				else if (i > 0 && j > 0)
					minSum[j] = Math.min(minSum[j], minSum[j - 1]) + curr.get(j);

				if (i == rows - 1) {
					min = Math.min(minSum[j], min);
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		M_0120_Triangle obj = new M_0120_Triangle();

		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> temp = Arrays.asList(2);
		triangle.add(temp);
		temp = Arrays.asList(3, 2);
		triangle.add(temp);
		temp = Arrays.asList(2, 5, 7);
		triangle.add(temp);
		temp = Arrays.asList(4, 1, 8, 3);
		triangle.add(temp);
		System.out.println(obj.minimumTotal(triangle));
		System.out.println(obj.minimumTotalApproach2(triangle));
	}
}
