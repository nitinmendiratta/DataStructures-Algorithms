package Array_Matrix;
import java.util.Arrays;
/*
 * http://www.geeksforgeeks.org/count-triplets-with-sum-smaller-that-a-given-value/
 * Time Complexity is O(n2)
 */
public class A142_CountTripletsWithSumSmallerThanGivenValue {

	public int countTriplets(int arr[], int sum){
		int n = arr.length;
	    // Sort input array
	    Arrays.sort(arr);
	 
	    // Initialize result
	    int ans = 0;
	 
	    // Every iteration of loop counts triplet with
	    // first element as arr[i].
	    for (int i = 0; i < n - 2; i++){
	        // Initialize other two elements as corner elements
	        // of subarray arr[j+1..k]
	        int j = i + 1, k = n - 1;
	 
	        // Use Meet in the Middle concept
	        while (j < k){
	            // If sum of current triplet is more or equal,
	            // move right corner to look for smaller values
	            if (arr[i] + arr[j] + arr[k] >= sum)
	                k--;
	 
	            // Else move left corner
	            else{
	                // This is important. For current i and j, there
	                // can be total k-j third elements.
	                ans += (k - j);
	                j++;
	            }
	        }
	    }
	    return ans;
	}
	public static void main(String[] args) {
		A142_CountTripletsWithSumSmallerThanGivenValue obj = new A142_CountTripletsWithSumSmallerThanGivenValue();
		int arr[] = {5, 1, 3, 4, 7};
	    int sum = 12;
	    System.out.println(obj.countTriplets(arr,sum));
	}
}
