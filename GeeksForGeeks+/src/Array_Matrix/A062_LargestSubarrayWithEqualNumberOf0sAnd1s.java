package Array_Matrix;
import java.util.HashMap;
/*
 * http://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
 * Time Complexity: O(n)
 * Auxiliary Space: O(n)
 */
public class A062_LargestSubarrayWithEqualNumberOf0sAnd1s {

	private int getSubarray(int [] arr){
		int n = arr.length;
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0;     // Initialize sum of elements
		int max_len = 0; // Initialize result
		int ending_index = -1;
		int start_index = 0;

		for (int i = 0; i < n; i++){
			arr[i] = (arr[i] == 0) ? -1 : 1;
		}

		// Now calculate the max value of j - i such that sumleft[i] = sumleft[j].   
		// The idea is to create a hash table to store indexes of all visited values.   
		// If you see a value again, that it is a case of sumleft[i] = sumleft[j]. Check 
		// if this j-i is more than maxsize. 
		// The optimum size of hash will be max-min+1 as these many different values 
		// of sumleft[i] are possible. Since we use optimum size, we need to shift
		// all values in sumleft[] by min before using them as an index in hash[].
		// Traverse through the given array
		for (int i = 0; i < n; i++){
			// Add current element to sum
			sum += arr[i];

			// To handle sum=0 at last index
			if (sum == 0) {
				max_len = i + 1;
				ending_index = i;
			}

			// If this sum is seen before, then update max_len if required
			if (hM.containsKey(sum)) {
				if (max_len < i - hM.get(sum + n)) 
				{
					max_len = i - hM.get(sum + n);
					ending_index = i;
				}
			} 
			else // Else put this sum in hash table
			hM.put(sum + n, i);
		}

		for (int i = 0; i < n; i++) {
			arr[i] = (arr[i] == -1) ? 0 : 1;
		}

		int end = ending_index - max_len + 1;
		System.out.println(end + " to " + ending_index);

		return max_len;
	}

	public static void main(String[] args) {
		A062_LargestSubarrayWithEqualNumberOf0sAnd1s obj = new A062_LargestSubarrayWithEqualNumberOf0sAnd1s();
		int[] arr = {1, 0, 0, 1, 0, 1, 1};
		int result = obj.getSubarray(arr);
		//for(int i = result[0]; i <= result[1];i++){
			System.out.print(result);
		//}
	}
}
