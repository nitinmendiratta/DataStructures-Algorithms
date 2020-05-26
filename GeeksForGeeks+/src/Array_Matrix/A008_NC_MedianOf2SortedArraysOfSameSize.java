package Array_Matrix;
/*
 * http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
 * 
 * Algorithm:

1) Calculate the medians m1 and m2 of the input arrays ar1[] 
   and ar2[] respectively.
2) If m1 and m2 both are equal then we are done.
     return m1 (or m2)
3) If m1 > m2, then median is present in one 
   of the below two subarrays.
    a)  From first element of ar1 to m1 (ar1[0...|_n/2_|])
    b)  From m2 to last element of ar2  (ar2[|_n/2_|...n-1])
4) If m1 < m2, then median is present in one    
   of the below two subarrays.
   a)  From m1 to last element of ar1  (ar1[|_n/2_|...n-1])
   b)  From first element of ar2 to m2 (ar2[0...|_n/2_|])
5) Repeat the above process until size of both the subarrays 
   becomes 2.
6) If size of the two arrays is 2 then use below formula to get 
  the median.
    Median = (max(ar1[0], ar2[0]) + min(ar1[1], ar2[1]))/2
 */

/* This function returns median of ar1[] and ar2[].
Assumptions in this function: Both ar1[] and ar2[] are sorted arrays Both have n elements */
public class A008_NC_MedianOf2SortedArraysOfSameSize {

//	public static double findMedianSortedArrays(int ar1[], int ar2[], int n) {
//		/* return -1  for invalid input */
//	    if (n <= 0)
//	        return -1;
//	    if (n == 1)
//	        return (ar1[0] + ar2[0])/2;
//	    if (n == 2)
//	        return (Math.max(ar1[0], ar2[0]) + Math.min(ar1[1], ar2[1])) / 2;
//	 
//	    int m1 = median(ar1, n); /* get the median of the first array */
//	    int m2 = median(ar2, n); /* get the median of the second array */
//	 
//	    /* If medians are equal then return either m1 or m2 */
//	    if (m1 == m2)
//	        return m1;
//	 
//	    /* if m1 < m2 then median must exist in ar1[m1....] and
//	        ar2[....m2] */
//	    if (m1 < m2){
//	        if (n % 2 == 0)
//	            return getMedian(ar1 + n/2 - 1, ar2, n - n/2 +1);
//	        return getMedian(ar1 + n/2, ar2, n - n/2);
//	    }
//	 
//	    /* if m1 > m2 then median must exist in ar1[....m1] and
//	        ar2[m2...] */
//	    if (n % 2 == 0)
//	        return getMedian(ar2 + n/2 - 1, ar1, n - n/2 + 1);
//	    return getMedian(ar2 + n/2, ar1, n - n/2);
//	}
	 
	/* Function to get median of a sorted array */
	public static int median(int arr[], int n){
	    if (n%2 == 0)
	        return (arr[n/2] + arr[n/2-1])/2;
	    else
	        return arr[n/2];
	}

	public A008_NC_MedianOf2SortedArraysOfSameSize() {
		A008_NC_MedianOf2SortedArraysOfSameSize obj = new A008_NC_MedianOf2SortedArraysOfSameSize();
		int[] a = {1,3,5,7};
		int[] b = {2,4,6,8};
		//double result = obj.findMedianSortedArrays(a,b, a.length);
		//System.out.println("Median is:"+result);
	}

}
