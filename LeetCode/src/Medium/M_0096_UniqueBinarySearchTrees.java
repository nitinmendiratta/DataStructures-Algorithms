package Medium;
/*
 * https://leetcode.com/problems/unique-binary-search-trees/
 */
public class M_0096_UniqueBinarySearchTrees {

	// DP https://www.youtube.com/watch?v=YDf982Lb84o
	// https://www.geeksforgeeks.org/program-nth-catalan-number/
	public int numTrees(int n) {
		int T[] = new int[n + 1];
		T[0] = 1;
		T[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				T[i] += T[j] * T[i - j - 1];
			}
		}
		return T[n];
	}

	// recursion
	public int numTreesApproach2(int numKeys) {
		if (numKeys <= 1) {
			return (1);
		} else {
			int sum = 0;
			int left, right, root;
			for (root = 1; root <= numKeys; root++) {
				left = numTreesApproach2(root - 1);
				right = numTreesApproach2(numKeys - root);
				sum += left * right;
			}
			return (sum);
		}
	}

	public static void main(String[] args) {
		M_0096_UniqueBinarySearchTrees obj = new M_0096_UniqueBinarySearchTrees();
		System.out.println(obj.numTrees(3));
	}
}
