package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/find-the-point-where-a-function-becomes-negative/
 * not that imp ques read it
 */
public class A094_FindPointWhereAMonotonicallyIncreasingFunctionBecomesPositiveFirstTime {
	
	// Let's take an example function as f(x) = x^2 - 10*x - 20
	// Note that f(x) can be any monotonocally increasing function
	int f(int x) { return (x*x - 10*x - 20); }
	 
	// Returns the value x where above function f() becomes positive
	// first time.
	int findFirstPositive(){
	    // When first value itself is positive
	    if (f(0) > 0)
	        return 0;
	 
	    // Find 'high' for binary search by repeated doubling
	    int i = 1;
	    while (f(i) <= 0)
	        i = i*2;
	 
	    //  Call binary search
	    return binarySearch(i/2, i);
	}
	 
	// Searches first positive value of f(i) where low <= i <= high
	int binarySearch(int low, int high){
	    if (high >= low){
	        int mid = low + (high - low)/2; /* mid = (low + high)/2 */
	 
	        // If f(mid) is greater than 0 and one of the following two
	        // conditions is true:
	        // a) mid is equal to low
	        // b) f(mid-1) is negative
	        if (f(mid) > 0 && (mid == low || f(mid-1) <= 0))
	            return mid;
	 
	        // If f(mid) is smaller than or equal to 0
	        if (f(mid) <= 0)
	            return binarySearch((mid + 1), high);
	        else // f(mid) > 0
	            return binarySearch(low, (mid -1));
	    }
	 
	    /* Return -1 if there is no positive value in given range */
	    return -1;
	}
	 
	/* Driver program to check above functions */
	public static void main(String[] args) {
		A094_FindPointWhereAMonotonicallyIncreasingFunctionBecomesPositiveFirstTime obj = new A094_FindPointWhereAMonotonicallyIncreasingFunctionBecomesPositiveFirstTime();
		System.out.println("The value n where f() becomes positive first is: "+obj.findFirstPositive());
	}
}
