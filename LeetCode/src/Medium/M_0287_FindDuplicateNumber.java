package Medium;
/*
 * https://leetcode.com/problems/find-the-duplicate-number/
 */
public class M_0287_FindDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int slow = nums[0], fast = nums[0];

		while (true) {
			fast = nums[nums[fast]];
			slow = nums[slow];

			if (fast == slow) {
				int slow2 = nums[0];
				while (slow != slow2) {
					slow = nums[slow];
					slow2 = nums[slow2];
				}
				return slow;
			}
		}
	}

	public static void main(String[] args) {
		M_0287_FindDuplicateNumber obj = new M_0287_FindDuplicateNumber();
		System.out.println(obj.findDuplicate(new int[] { 1, 3, 4, 2, 2 }));
	}

}
