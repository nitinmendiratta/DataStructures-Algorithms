package Array_Matrix;
import javax.rmi.ssl.SslRMIClientSocketFactory;

/*
 * http://www.geeksforgeeks.org/subarraysubstring-vs-subsequence-and-programs-to-generate-them/
 */
public class A148_AllPossibleSubarrayAndSubsequence {
	// Prints all subarrays in arr[0..n-1]
	public void subArray(int arr[]){
		int n = arr.length;
	    // Pick starting point
	    for (int i=0; i <n; i++){
	        // Pick ending point
	        for (int j=i; j<n; j++){
	            // Print subarray between current starting
	            // and ending points
	            for (int k=i; k<=j; k++)
	                System.out.print(arr[k] +" ");
	 
	            System.out.println();
	        }
	    }
	}
	
	// NOT WORKING
	public void printSubsequences(int arr[]){
		int n = arr.length;
	    /* Number of subsequences is (2**n -1)*/
	    double opsize = Math.pow(2, n);
	 
	    /* Run from counter 000..1 to 111..1*/
	    for (int counter = 1; counter < opsize; counter++){
	        for (int j = 0; j < n; j++){
	            /* Check if jth bit in the counter is set
	                If set then print jth element from arr[] */
	            //if (counter & (1<<j))
	                System.out.print(arr[j]+" ");
	        }
	        System.out.println();
	    }
	}
	public static void main(String[] args) {
		A148_AllPossibleSubarrayAndSubsequence obj = new A148_AllPossibleSubarrayAndSubsequence();
		int arr[] = {1, 2, 3, 4};
		System.out.println("All Non-empty Subarrays\n");
	    obj.subArray(arr);
	    System.out.println("All Non-empty Subsequences\n");
	    obj.printSubsequences(arr);
	    
	}
}
