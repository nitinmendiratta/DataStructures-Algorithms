package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 */
public class E_1365_NumbersSmallerThanCurrentNumber {

	// Store the count in a bucket and take the running sum.
	public int[] smallerNumbersThanCurrent(int[] nums) {
		int[] count = new int[101];
		int[] res = new int[nums.length];

		for (int i =0; i < nums.length; i++) {
			count[nums[i]]++;
		}

		for (int i = 1 ; i <= 100; i++) {
			count[i] += count[i-1];    
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				res[i] = 0;
			else 
				res[i] = count[nums[i] - 1];
		}

		return res;        
	}

	// heap
	public int[] smallerNumbersThanCurrentApproach2(int[] nums) {

		int output[] = new int[nums.length];

		Queue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		for(int num: nums) {
			maxHeap.add(num);
		}

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		while(maxHeap.size() > 0) {
			int num = maxHeap.remove();

			while(maxHeap.size() > 0 && maxHeap.peek() == num) {
				maxHeap.remove();
			}

			map.put(num, maxHeap.size());
		}

		for(int i=0;i<nums.length;i++) {
			output[i] = map.get(nums[i]);
		}

		return output;
	}
	
	// using map and sort
	public int[] smallerNumbersThanCurrentApproach3(int[] nums) {
		int[] numsCopy = Arrays.copyOf(nums, nums.length);
		Arrays.sort(numsCopy);
		int[] res = new int[nums.length];
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			if(map.get(numsCopy[i]) == null)
				map.put(numsCopy[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			res[i] = map.get(nums[i]);
		}
		return res;
	}
	public static void main(String[] args) {
		E_1365_NumbersSmallerThanCurrentNumber obj = new E_1365_NumbersSmallerThanCurrentNumber();
		System.out.println(Arrays.toString(obj.smallerNumbersThanCurrent(new int[] {8,1,2,2,3})));
		System.out.println(Arrays.toString(obj.smallerNumbersThanCurrentApproach2(new int[] {8,1,2,2,3})));
		System.out.println(Arrays.toString(obj.smallerNumbersThanCurrentApproach3(new int[] {8,1,2,2,3})));
	}
}
