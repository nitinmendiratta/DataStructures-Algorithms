package Easy;
/*
 * https://leetcode.com/problems/binary-search/
 */
public class E_0704_BinarySearch {

	public int search(int[] nums, int target) {
		int len = nums.length, start = 0, end = len-1;

		while(start <= end){
			
			int mid = start + (end-start)/2;
			if(nums[mid] == target){
				return mid;
			}else if(nums[mid] > target){
				end = mid -1;
			}else {
				start = mid+1;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		E_0704_BinarySearch obj = new E_0704_BinarySearch();
		System.out.println(obj.search(new int[] {1, 2, 2, 3, 4}, 2));
	}
}
