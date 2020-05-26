package Easy;
/**
 * https://leetcode.com/problems/search-insert-position/
 */
public class E_0035_SearchInsertPosition {

	public int searchInsert(int[] nums, int target) {
		int len = nums.length;

		int start = 0, end = len - 1;
		while(start >= 0 && start < len && end >= 0 && end < len){
			int midIdx = (start + end)/2;
			int midElem = nums[midIdx];
			if(midElem == target){
				return midIdx;
			}else if(target < midElem){
				end  = midIdx - 1;
                if(midIdx == 0 || target > nums[midIdx - 1]){
				    return midIdx;
			    }
			} else if(target > midElem){
				start = midIdx + 1;
                if(midIdx == len - 1 || target < nums[start]){
				    return start;
			    }
			}
		}
		return -1;
	}
	public static void main(String[] args) {
		E_0035_SearchInsertPosition obj = new E_0035_SearchInsertPosition();
		int[] arr = new int[] {1,3,5,6};
		System.out.println("result: "+obj.searchInsert(arr, 5));
	}
}
