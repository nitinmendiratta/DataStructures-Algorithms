package Heap_Hash;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
 * O(n) time
 */
public class Ha11_CheckIfArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK {

	// Returns true if arr[0..n-1] can be divided into pairs
	// with sum divisible by k.
	public boolean canPairs(int arr[], int k){
		int n = arr.length;
		// An odd length array cannot be divided into pairs
		// check if n is odd, if odd return false
		if ((n & 1) == 1)
			return false;

		// Create a frequency array to count occurrences
		// of all remainders when divided by k.
		HashMap<Integer, Integer> freq = new HashMap<Integer, Integer>();

		// Count occurrences of all remainders
		for (int i = 0; i < n; i++){
			System.out.println("arr[i]"+arr[i]+" rem"+arr[i]%k);

			if( freq.containsKey(arr[i]%k)){
				int remCount = (int)freq.get(arr[i]%k);
				System.out.println("remCount"+remCount);
				freq.put(arr[i]%k, ++remCount);
				System.out.println("After updation remCount"+freq.get(arr[i]%k));
			}else{
				freq.put(arr[i]%k, 1);
			}
		}


		// Traverse input array and use freq[] to decide
		// if given array can be divided in pairs
		for (int i = 0; i < n; i++){
			// Remainder of current element
			System.out.println("**************************");
			int rem = arr[i] % k;
			int remCount = freq.get(rem);
			int kMinusRem = freq.get(k - rem) != null?freq.get(k - rem):0;

			// If remainder with current element divides k into two halves.
			if  (2*rem == k){
				// Then there must be even occurrences of
				// such remainder
				if (remCount % 2 != 0)
					return false;
			}

			// If remainder is 0, then there must be two elements with 0 remainder
			else if (rem == 0){
				//check if remcount is odd, if odd return false
				if ((remCount & 1) == 1)           
					return false;
			}        

			// Else number of occurrences of remainder must be equal to number of occurrences of k-remainder
			
			else if (remCount != kMinusRem)
				return false;
		}
		return true;
	}
	public static void main(String[] args) {
		Ha11_CheckIfArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK obj = new Ha11_CheckIfArrayCanBeDividedIntoPairsWhoseSumIsDivisibleByK();
		int arr[] =  {91, 74, 66, 48};
		int k = 10;
		boolean res = obj.canPairs(arr, k);
		System.out.println(res);
	}
}
