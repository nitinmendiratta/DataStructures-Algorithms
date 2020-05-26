package Array_Matrix;
import java.util.*;
/*
 * http://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 */
public class A001_CheckForPairInArrayWithSumx {

	//  If we use Merge Sort or Heap Sort then (-)(nlogn) in worst case.
	// auxiliary space is O(1) for Heap Sort.
	public boolean isSumApproach1(int[] arr, int x){
		Arrays.sort(arr);
		int sum = 0;
		int start = 0;
		int end = arr.length-1;
		
		while(start < end){
			sum = arr[start] + arr[end];
			if(sum == x){
				return true;
			}
			else if(sum < x){
				start++;
			}
			else{
				end--;
			}
		}
		return false;
	}
	
	// This method works in O(n) time. O(n) space
	public boolean isSumApproach2(int[] arr, int target){
		int diff = 0;
		HashSet<Integer> s = new HashSet<Integer>(); 
        for (int i = 0; i < arr.length; ++i) { 
            diff = target - arr[i]; 
  
            // checking for condition 
            if (s.contains(diff)) { 
                System.out.println("Pair with given sum " + target + " is (" + arr[i] + ", " + diff + ")"); 
            } 
            s.add(arr[i]); 
        } 
		return false;
	}
	
	public static void main(String[] args) {
		A001_CheckForPairInArrayWithSumx obj = new A001_CheckForPairInArrayWithSumx();
		int[] arr = {1, 4, 45, 5, 10, 8};
		System.out.println("sum exists:"+obj.isSumApproach1(arr,5));
		obj.isSumApproach2(arr,5);
	}
}
