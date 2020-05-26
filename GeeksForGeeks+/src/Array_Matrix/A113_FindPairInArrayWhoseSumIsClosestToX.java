package Array_Matrix;
/*
 * http://quiz.geeksforgeeks.org/given-sorted-array-number-x-find-pair-array-whose-sum-closest-x/
 * O(n) time
 * 1) Initialize a variable diff as infinite (Diff is used to store the 
   difference between pair and x).  We need to find the minimum diff.
 * 2) Initialize two index variables l and r in the given sorted array.
       (a) Initialize first to the leftmost index:  l = 0
       (b) Initialize second  the rightmost index:  r = n-1
 * 3) Loop while l < r.
       (a) If  abs(arr[l] + arr[r] - sum) < diff  then 
           update diff and result 
       (b) Else if(arr[l] + arr[r] <  sum )  then l++
       (c) Else r--    
 */
public class A113_FindPairInArrayWhoseSumIsClosestToX {	

	// Prints the pair with sum cloest to x
    public void printClosest(int arr[], int n, int x){
        int res_l=0, res_r=0;  // To store indexes of result pair
  
        // Initialize left and right indexes and difference between
        // pair sum and x
        int l = 0, r = n-1, diff = Integer.MAX_VALUE;
  
        // While there are elements between l and r
        while (r > l){
            // Check if this pair is closer than the closest pair so far
            if (Math.abs(arr[l] + arr[r] - x) < diff){
               res_l = l;
               res_r = r;
               diff = Math.abs(arr[l] + arr[r] - x);
            }
  
            // If this pair has more sum, move to smaller values.
            if (arr[l] + arr[r] > x)
               r--;
            else // Move to larger values
               l++;
        }
  
        System.out.println(" The closest pair is "+arr[res_l]+" and "+ arr[res_r]);
    }
	public static void main(String[] args) {
		A113_FindPairInArrayWhoseSumIsClosestToX obj = new A113_FindPairInArrayWhoseSumIsClosestToX();
		int arr[] =  {10, 22, 28, 29, 30, 40}, x = 54;
        int n = arr.length;
        obj.printClosest(arr, n, x);  
	}
}
