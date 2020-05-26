package Array_Matrix;
import java.util.*;

/*
 * http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 */
public class A103_FindSubarrayWith0Sum {

	public int[] subarray(int[] arr){
		int n = arr.length;
		// Creates an empty hashMap hM
		int[] result = new int[2];
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
		// Initialize sum of elements
		int sum = 0;        
		// Traverse through the given array
		for (int i = 0; i < arr.length; i++){   
			// Add current element to sum
			sum += arr[i];

			// Return true in following cases
			// a) Current element is 0
			// b) sum of elements from 0 to i is 0
			// c) sum is already present in hash map
			if (arr[i] == 0 || sum == 0 || hM.get(sum) != null){
				result[0] = hM.get(sum)+1; 
				result[1] = i;            
				return result;
			}
			// Add sum to hash map
			hM.put(sum, i);
		}    
		// We reach here only when there is no subarray with 0 sum
		return result;
	}        

	public static void main(String[] args) {
		A103_FindSubarrayWith0Sum obj = new A103_FindSubarrayWith0Sum();
		int[] arr = {4, 2, -3, 1, 6};
		int[] result = obj.subarray(arr);
		for(int i = result[0]; i <= result[1];i++){
			System.out.print(arr[i]+",");
		}
	}
}
