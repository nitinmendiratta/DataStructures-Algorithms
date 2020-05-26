package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/count-minimum-steps-get-given-desired-array/
 * 
 */
public class A154_CountMinStepsToGetTheGivenDesiredArray {

	// Returns count of minimum operations to covert a
	// zero array to target array with increment and
	// doubling operations.
	// This function computes count by doing reverse
	// steps, i.e., convert target to zero array.
	public int countMinOperations(int target[]){
	    // Initialize result (Count of minimum moves)
	    int result = 0;
	    int n = target.length;
	    // Keep looping while all elements of target
	    // don't become 0.
	    while (true){
	        // To store count of zeroes in current
	        // target array
	        int zero_count = 0;
	 
	        int i;  // To find first odd element
	        for (i=0; i<n; i++){
	            // If odd number found target[i] & 1 will return 1 if its an odd number otherwise 0
	        	
	            if ((target[i] & 1) != 0)
	                break;
	 
	            // If 0, then increment zero_count
	            else if (target[i] == 0)
	                zero_count++;
	        }
	 
	        // All numbers are 0
	        if (zero_count == n)
	          return result;
	 
	        // All numbers are even
	        if (i == n){
	            // Divide the whole array by 2
	            // and increment result
	            for (int j=0; j<n; j++)
	               target[j] = target[j]/2;
	            result++;
	        }
	 
	        // Make all odd numbers even by subtracting
	        // one and increment result.
	        for (int j=i; j<n; j++){
	           if ((target[j] & 1) != 0){
	              target[j]--;
	              result++;
	           }
	        }
	    }
	}
	public static void main(String[] args) {
		A154_CountMinStepsToGetTheGivenDesiredArray obj = new A154_CountMinStepsToGetTheGivenDesiredArray();
		int arr[] = {16, 16, 16};

	    System.out.println("Minimum number of steps required to get the given target array is "+obj.countMinOperations(arr));
	}

}
