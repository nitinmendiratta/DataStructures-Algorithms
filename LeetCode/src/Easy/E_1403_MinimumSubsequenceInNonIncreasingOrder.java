package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/minimum-subsequence-in-non-increasing-order/
 */
public class E_1403_MinimumSubsequenceInNonIncreasingOrder {

	// Concept: Let, the sum of all the elements of the array be 'Sum'. Sort the
	// array and start collecting the maximum elements one by one in a list and
	// keeping track of the sum 's' of the integers collected. If total sum minus
	// sum of elements collected (Sum-s) is less than s, then return the list of
	// integers collected.
	// O(nlogn)
	public List<Integer> minSubsequence(int[] nums) {
		Arrays.sort(nums);
		List<Integer> arr = new ArrayList<>();
		long fullSum = 0;
		for (int i : nums)
			fullSum += i;
		
		long halfSum = 0;
		for (int i = nums.length - 1; i >= 0; i--) {
			arr.add(nums[i]);
			halfSum += nums[i];
			if (halfSum > fullSum - halfSum)
				return arr;
		}
		return arr;
	}

	// Using priority queue
	public List<Integer> minSubsequenceApproach2(int[] nums) {
		List<Integer> res = new ArrayList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
		int sub_sum = 0, total_sum = 0;
		for (int n : nums) {
			pq.offer(n);
			total_sum += n;
		}
		while (sub_sum <= total_sum / 2) {
			res.add(pq.peek());
			sub_sum += pq.poll();
		}
		return res;
	}

	// my approach
	public List<Integer> minSubsequenceApproach3(int[] nums) {

		Integer[] numsArray = Arrays.stream(nums) // IntStream
				.boxed() // Stream<Integer>
				.toArray(Integer[]::new);

		Arrays.sort(numsArray, Collections.reverseOrder());

		int len = numsArray.length, i = 1, j = len - 1, leftSum = numsArray[0], rightSum = 0;
		List<Integer> res = new ArrayList();
		res.add(numsArray[0]);

		while (i <= j) {

			if ((rightSum + numsArray[j]) < leftSum) {
				rightSum += numsArray[j];
				j--;
			} else {
				leftSum += numsArray[i];
				res.add(numsArray[i]);
				i++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		E_1403_MinimumSubsequenceInNonIncreasingOrder obj = new E_1403_MinimumSubsequenceInNonIncreasingOrder();
		System.out.println(obj.minSubsequence(new int[] { 4, 3, 10, 9, 8 }));
		System.out.println(obj.minSubsequence(new int[] { 4, 4, 7, 6, 7 }));
		System.out.println(obj.minSubsequence(new int[] { 6 }));
	}
}
