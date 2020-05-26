package Medium;

/*
 * https://leetcode.com/problems/increasing-triplet-subsequence/
 */
public class M_0334_IncreasingTripletSubsequence {

	public boolean increasingTriplet(int[] nums) {
		// start with two largest values, as soon as we find a number bigger than both,
		// while both have been updated, return true.
		int small = Integer.MAX_VALUE, big = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n <= small) {
				small = n;
			} // update small if n is smaller than both
			else if (n <= big) {
				big = n;
			} // update big only if greater than small but smaller than big
			else
				return true; // return if you find a number bigger than both
		}
		return false;
	}

	public static void main(String[] args) {
		M_0334_IncreasingTripletSubsequence obj = new M_0334_IncreasingTripletSubsequence();
		System.out.println(obj.increasingTriplet(new int[] { 1, 2, 3, 4, 5 }));
	}
}
