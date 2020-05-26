package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/element-appearing-more-than-25-in-sorted-array/
 */
public class E_1287_ElementAppearingMoreThan25SortedArray {

	/*
	 * Since its a sorted array so i wanted to avoid linear search
		Find the element at position n/4
		Perform a binary search to find the first occurrence of that item.
		Perform a binary search to find the last occurrence of that item.
		If last-first+1 > n/4, you have your answer.
		
		Repeat that process for n/2 and 3(n/4)
	 */
	public int findSpecialInteger(int[] arr) {
        int n = arr.length;
        if(n == 1) return arr[0];
        
        List<Integer> list = new ArrayList<>(Arrays.asList(arr[n/4], arr[n/2], arr[(3*n)/4]));
        
        for (int element : list) {
            int f = firstOccurrence(arr, element);
            int l = lastOccurrence(arr, element);
            if(l-f+1 > n/4) {
                return element;
            }
        }
        return -1;
    }

    private int firstOccurrence(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int middle = start + (end - start)/2;
            if(nums[middle] == target && (middle == start || nums[middle-1] < target)) {
                return middle;
            }
            if(target > nums[middle])
                start = middle + 1;
            else
                end = middle;
        }
        return start;
    }

    private int lastOccurrence(int[] nums,int target) {
        int start = 0;
        int end = nums.length-1;
        while(start < end){
            int middle = start + (end - start)/2;
            if(nums[middle] == target && (middle == end || nums[middle+1] > target)) {
                return middle;
            }
            if(target < nums[middle])
                end = middle;
            else
                start = middle + 1;
        }
        return start;

    }
	
    // Approach2
	public int findSpecialIntegerApproach2(int[] arr) {
        int n = arr.length, freq = n / 4;

        for (int i = 0; i < n - freq; i++) {
            if (arr[i] == arr[i + freq]) {
                return arr[i];
            }
        }
        return -1;
    }
	
	// my approach
	public int findSpecialIntegerMyApproach(int[] arr) {
		
		int count = 1;
		for(int i = 0; i < arr.length; i++) {
			
			if(i < arr.length-1 && arr[i] == arr[i+1]) count++;
			else count = 1;
			
			if(count > arr.length/4) return arr[i];
			
		}
		return -1;
    }
	public static void main(String[] args) {
		E_1287_ElementAppearingMoreThan25SortedArray obj = new E_1287_ElementAppearingMoreThan25SortedArray();
		System.out.println(obj.findSpecialInteger(new int[] {1,1}));
		System.out.println(obj.findSpecialInteger(new int[] {1}));
		System.out.println(obj.findSpecialInteger(new int[] {1,2,2,6,6,6,6,7,10}));
	}
}
