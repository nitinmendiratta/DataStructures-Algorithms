package Strings;
/*
 * http://www.geeksforgeeks.org/transform-one-string-to-another-using-minimum-number-of-given-operation/
 * Time Complexity: O(n), 
 * please note that i is always decremented (in while loop and in if), and the for loop starts from n-1 and runs while i >= 0.
 */
public class S051_TransformOneStringToAnother {

	// Function to find minimum number of operations required to transform A to B.
	public int minOps(String A, String B){
	    int m = A.length(), n = B.length();
	 
	     // This parts checks whether conversion is possible or not
	    if (n != m)
	       return -1;
	    int[] count = new int[256];

	    for (int i=0; i<n; i++)   // count characters in A
	       count[B.charAt(i)]++;
	    for (int i=0; i<n; i++)   // subtract count for
	       count[A.charAt(i)]--;         // every character in B
	    for (int i=0; i<256; i++)   // Check if all counts become 0
	      if (count[i] != 0)
	         return -1;
	 
	    // This part calculates the number of operations required
	    int res = 0;
	    for (int i=n-1, j=n-1; i>=0; ){
	        // If there is a mismatch, then keep incrementing
	        // result 'res' until B[j] is not found in A[0..i]
	        while (i>=0 && A.charAt(i) != B.charAt(j)){
	            i--;
	            res++;
	        }
	 
	        // If A[i] and B[j] match
	        if (i >= 0){
	            i--;
	            j--;
	        }
	    }
	    return res;
	}
	
	public static void main(String[] args) {
		S051_TransformOneStringToAnother obj = new S051_TransformOneStringToAnother();
		String A = "EACBD";
	    String B = "EABCD";
	    System.out.println("Minimum number of operations required is " + obj.minOps(A, B));
	}
}
