package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose-sum-closest-x/
 * O(n) time 
 * 1) Initialize a variable diff as infinite (Diff is used to store the 
 		difference between pair and x).  We need to find the minimum diff.
 * 2) Initialize two index variables l and r in the given sorted array.
       (a) Initialize first to the leftmost index in ar1:  l = 0
       (b) Initialize second  the rightmost index in ar2:  r = n-1
 * 3) Loop while l < m and r >= 0
       (a) If  abs(ar1[l] + ar2[r] - sum) < diff  then 
           update diff and result 
       (b) Else if(ar1[l] + ar2[r] <  sum )  then l++
       (c) Else r--    
 * 4) Print the result. 
 */
public class A112_FindClosestPairFrom2SortedArrays {

	// ar1[0..m-1] and ar2[0..n-1] are two given sorted
    // arrays/ and x is given number. This function prints
    // the pair from both arrays such that the sum of the
    // pair is closest to x.
    public void printClosest(int ar1[], int ar2[], int m, int n, int x){
        // Initialize the diff between pair sum and x.
        int diff = Integer.MAX_VALUE;
 
        // res_l and res_r are result indexes from ar1[] and ar2[]
        // respectively
        int res_l = 0, res_r = 0;
 
        // Start from left side of ar1[] and right side of ar2[]
        int l = 0, r = n-1;
        while (l < m && r >= 0){
           // If this pair is closer to x than the previously
           // found closest, then update res_l, res_r and diff
           if (Math.abs(ar1[l] + ar2[r] - x) < diff){
               res_l = l;
               res_r = r;
               diff = Math.abs(ar1[l] + ar2[r] - x);
           }
 
           // If sum of this pair is more than x, move to smaller
           // side
           if (ar1[l] + ar2[r] > x)
               r--;
           else  // move to the greater side
               l++;
        }
 
        // Print the result
        System.out.print("The closest pair is [" + ar1[res_l] +
                         ", " + ar2[res_r] + "]");
    }
    
	public static void main(String[] args) {
		A112_FindClosestPairFrom2SortedArrays ob = new A112_FindClosestPairFrom2SortedArrays();
        int ar1[] = {1, 4, 5, 7};
        int ar2[] = {10, 20, 30, 40};
        int m = ar1.length;
        int n = ar2.length;
        int x = 38;
        ob.printClosest(ar1, ar2, m, n, x);
	}
}
