package Easy;
/*
 * https://leetcode.com/problems/find-pivot-index/
 */
public class E_0724_FindPivotIndex {

	public int pivotIndex(int[] nums) {
		
		int totalSum = 0, leftsum = 0;
        for (int x: nums) totalSum += x;
        for (int i = 0; i < nums.length; ++i) {
        	int rightSum = totalSum - leftsum - nums[i];
            if (leftsum == rightSum) return i;
            leftsum += nums[i];
        }
        return -1;
	}
	public static void main(String[] args) {
		E_0724_FindPivotIndex obj = new E_0724_FindPivotIndex();
		System.out.println(obj.pivotIndex(new int[] {1, 7, 3, 6, 5, 6}));
	}
}
