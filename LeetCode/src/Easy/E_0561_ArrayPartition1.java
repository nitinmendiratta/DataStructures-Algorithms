package Easy;
import java.util.*;
/*
 * https://leetcode.com/problems/array-partition-i/
 */
public class E_0561_ArrayPartition1 {

	public int arrayPairSum(int[] nums) {
		Arrays.sort(nums);
		int result = 0;
		for (int i = 0; i < nums.length; i += 2) {
			result += nums[i];
		}
		return result;
	}
	
	public int arrayPairSumApproach2(int[] nums) {
		int[] exist = new int[20001];
		int min = Integer.MAX_VALUE, N = 10000;
		for (int i = 0; i < nums.length; i++) {
			exist[nums[i] + N]++;
			min = Math.min(min, nums[i] + N);
		}
		int sum = 0;
		boolean odd = true;
		for (int i = min; i < exist.length; i++) {
			while (exist[i] > 0) {
				if (odd) {
					sum += i - N;
				}
				odd = !odd;
				exist[i]--;
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		E_0561_ArrayPartition1 obj = new E_0561_ArrayPartition1();
		int[] input = {1,4,3,2};
		System.out.println(obj.arrayPairSum(input));
		System.out.println(obj.arrayPairSumApproach2(input));
	}
}
