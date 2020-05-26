package Medium;
// https://leetcode.com/problems/container-with-most-water/
// Time complexity : O(n)O(n). Single pass.
// Space complexity : O(1)O(1). Constant space is used.
public class M_0011_ContainerWithMostWater {

	public int maxArea(int[] height) {
		int maxarea = 0, l = 0, r = height.length - 1;
		while (l < r) {
			maxarea = Math.max(maxarea, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r])
				l++;
			else
				r--;
		}
		return maxarea;
	}
	public static void main(String[] args) {
		M_0011_ContainerWithMostWater obj = new M_0011_ContainerWithMostWater();
		int[] input = {1,8,6,2,5,4,8,3,7};
		System.out.println(obj.maxArea(input));
	}
}
